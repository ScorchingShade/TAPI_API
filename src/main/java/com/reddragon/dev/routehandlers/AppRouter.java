package com.reddragon.dev.routehandlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.reddragon.dev.dao.ReceiptCreateDao;
import com.reddragon.dev.dao.ReceiptDeleteDao;
import com.reddragon.dev.dao.ReceiptReadAllDao;
import com.reddragon.dev.dao.ReceiptReadDao;
import com.reddragon.dev.guice.GuiceInjector;
import com.reddragon.dev.repository.StoreRepo;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author ankush
 * AppRouter is used to route all api calls to respective handlers
 */
@Slf4j
@NoArgsConstructor
public class AppRouter extends AbstractVerticle {

    ResourceBundle bundle = ResourceBundle.getBundle("application");
    int port = Integer.parseInt(bundle.getString("vertx.port"));
    String mongoResponse="";

    public StoreRepo storeRepo;

    public AppRouter(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    @Override
    public void start() throws Exception {
        super.start();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);


        Set<String> allowedHeaders = new HashSet<>();
        allowedHeaders.add("x-requested-with");
        allowedHeaders.add("Access-Control-Allow-Origin");
        allowedHeaders.add("origin");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("accept");
        allowedHeaders.add("X-PINGARUNER");

        Set<HttpMethod> allowedMethods = new HashSet<>();
        allowedMethods.add(HttpMethod.GET);
        allowedMethods.add(HttpMethod.POST);
        allowedMethods.add(HttpMethod.OPTIONS);
        /*
         * these methods aren't necessary for this sample,
         * but you may need them for your projects
         */
        allowedMethods.add(HttpMethod.DELETE);
        allowedMethods.add(HttpMethod.PATCH);
        allowedMethods.add(HttpMethod.PUT);

        router.route().handler(CorsHandler.create("*").allowedHeaders(allowedHeaders).allowedMethods(allowedMethods));



        //Body Handler is needed to fetch the body of a post request.
        router.post("/generate").handler(BodyHandler.create());
        router.post("/generate").handler(this::generateHandler);

        //Handler for read ops
        router.post("/fetchData").handler(BodyHandler.create());
        router.post("/fetchData").handler(this::readHandler);

        //Handler for delete ops
        router.post("/deleteData").handler(BodyHandler.create());
        router.post("/deleteData").handler(this::deleteHandler);

        //Handler for readAll ops
        router.get("/fetchAll").handler(BodyHandler.create());
        router.get("/fetchAll").handler(this::readAllHandler);

        server.requestHandler(router).listen(port);

    }

    /**
     * FetchAll
     * @param routingContext
     */
    private void readAllHandler(RoutingContext routingContext) {
        //this is unnecessarily complicated code, reduce it later. see generate for reference

        HttpServerResponse response = routingContext.response();
        response.setChunked(true);
        response.putHeader("content-type", "text/plain");
        List<String> mongoResponse =new ArrayList<>();

        JsonElement jsonElement = new JsonParser().parse(routingContext.getBodyAsString());

        JsonObject fetchedDocument = jsonElement.getAsJsonObject();

        try {
            Injector injector = Guice.createInjector(new GuiceInjector());
            ReceiptReadAllDao receiptCreateDao = injector.getInstance(ReceiptReadAllDao.class);
            this.mongoResponse=receiptCreateDao.fetchAll(storeRepo).toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.end((this.mongoResponse));
    }

    /***
     * delete using id
     * @param routingContext
     */
    private void deleteHandler(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        response.setChunked(true);
        response.putHeader("content-type", "text/plain");

        JsonElement jsonElement = new JsonParser().parse(routingContext.getBodyAsString());

        JsonObject fetchedDocument = jsonElement.getAsJsonObject();

        String idParam = fetchedDocument.get("id").toString().trim().replaceAll("\"","").replace("[","").replace("]","");
        List<String> idList= new ArrayList<String>(Arrays.asList(idParam.replaceAll("/[/]","").split(",")));



        try {
            Injector injector = Guice.createInjector(new GuiceInjector());
            ReceiptDeleteDao receiptDeleteDao = injector.getInstance(ReceiptDeleteDao.class);
            mongoResponse=receiptDeleteDao.deleteReceiptById(idList, storeRepo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.end("----json fetched ----<<" + mongoResponse);

        response.end(mongoResponse);
    }


    /***
     * using the readHandler to handle get receipt by id api call
     * @param routingContext
     */
    private void readHandler(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        response.setChunked(true);
        response.putHeader("content-type", "text/plain");
        List<String> mongoResponse =new ArrayList<>();

        JsonElement jsonElement = new JsonParser().parse(routingContext.getBodyAsString());

        JsonObject fetchedDocument = jsonElement.getAsJsonObject();

        String idParam = fetchedDocument.get("id").toString().trim().replaceAll("\"","").replace("[","").replace("]","");
        List<String> idList= new ArrayList<String>(Arrays.asList(idParam.replaceAll("/[/]","").split(",")));


        try {
            Injector injector = Guice.createInjector(new GuiceInjector());
            ReceiptReadDao receiptReadDao = injector.getInstance(ReceiptReadDao.class);
            mongoResponse = receiptReadDao.fetchDataById(idList, storeRepo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.end("----json fetched ----<<" + mongoResponse);

        response.end(mongoResponse.toString());
    }


    /***
     * Using the generateHandler to handle generate(upsert) receipt api call
     * @param routingContext
     */
    private void generateHandler(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        response.setChunked(true);
        response.putHeader("content-type", "application/json");
        response.putHeader("'Access-Control-Allow-Origin", "*");
        response.putHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        /*System.out.println("Hello World from Vert.x-Web! " + routingContext.getBodyAsString());*/

        JsonElement jsonElement = new JsonParser().parse(routingContext.getBodyAsString());

        JsonObject fetchedDocument = jsonElement.getAsJsonObject();

        System.out.println(storeRepo.findAll());

        try {
            Injector injector = Guice.createInjector(new GuiceInjector());
            ReceiptCreateDao receiptCreateDao = injector.getInstance(ReceiptCreateDao.class);
            mongoResponse=receiptCreateDao.saveDocumentToMongo(fetchedDocument, storeRepo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.end((mongoResponse));


    }
}
