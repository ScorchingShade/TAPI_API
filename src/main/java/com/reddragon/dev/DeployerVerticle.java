package com.reddragon.dev;

import com.reddragon.dev.recievers.AppRouter;
import com.reddragon.dev.repository.StoreRepo;
import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ankush
 * Deployer verticle to deploy other verticles
 */
@Slf4j
@Component
class DeployerVerticle extends AbstractVerticle {

    //The beans need to be initialized here so that they can be used in deployed verticles
    @Autowired
    public StoreRepo storeRepo;

    @Override
    public void start() throws Exception {
        super.start();

        //Deploying new verticles
       vertx.deployVerticle(new AppRouter(storeRepo), ar->{
           if(ar.succeeded()){
               System.out.println("--Routing to different channels...");
           }
           else{
               System.out.println("--Routing failed, app will be terminated...");
           }
       });
    }
}
