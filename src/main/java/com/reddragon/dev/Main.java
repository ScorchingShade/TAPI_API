package com.reddragon.dev;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.reddragon.dev.guice.GuiceInjector;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
@EnableMongoRepositories
@ComponentScan
public class Main{

    private Vertx vertx;

    @Autowired
    private DeployerVerticle deployerVerticle;

    @Inject
    Injector injector;

    Main(){
        this.vertx=Vertx.vertx();
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void deployer(){
        vertx.deployVerticle(deployerVerticle, ar->{
            if(ar.succeeded()){
                System.out.println("--Vertx application running successfully, verticles deployed...");
            }
            else{
                System.out.println("!!Application startup failed...");
            }
        });
    }

}
