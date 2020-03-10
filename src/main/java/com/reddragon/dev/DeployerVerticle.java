package com.reddragon.dev;

import com.reddragon.dev.recievers.AppRouter;
import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DeployerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

       vertx.deployVerticle(new AppRouter(), ar->{
           if(ar.succeeded()){
               System.out.println("--Routing to different channels...");
           }
           else{
               System.out.println("--Routing failed, app will be terminated...");
           }
       });
    }
}
