package com.reddragon.dev.recievers;

import com.reddragon.dev.repository.StoreRepo;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ResourceBundle;

@Slf4j
@NoArgsConstructor
public class AppRouter extends AbstractVerticle {

    ResourceBundle bundle = ResourceBundle.getBundle("application");
    int port = Integer.parseInt(bundle.getString("vertx.port"));

    public StoreRepo storeRepo;

    public AppRouter(StoreRepo storeRepo){
        this.storeRepo=storeRepo;
    }

    @Override
    public void start() throws Exception {
        super.start();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        //Body Handler is needed to fetch the body of a post request.
        router.post("/generate").handler(BodyHandler.create());
        router.post("/generate").handler(this::generateHandler);

        server.requestHandler(router).listen(port);

    }


    private void generateHandler(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        response.setChunked(true);
        response.putHeader("content-type", "text/plain");
        try {
            System.out.println("showing data+++++++++++"+storeRepo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.end("Hello World from Vert.x-Web! " + routingContext.getBodyAsString());
    }
}
