package com.reddragon.dev;

import com.reddragon.dev.model.ReceiptModel;
import com.reddragon.dev.repository.StoreRepo;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
    private StoreRepo storeRepo;

    @Autowired
    private DeployerVerticle deployerVerticle;

    Main(){
        this.vertx=Vertx.vertx();
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @PostConstruct
    public void deployer(){
        vertx.deployVerticle(new DeployerVerticle(), ar->{
            if(ar.succeeded()){
                System.out.println("--Vertx application running successfully, verticles deployed...");
            }
            else{
                System.out.println("!!Application startup failed...");
            }
        });
    }

}
