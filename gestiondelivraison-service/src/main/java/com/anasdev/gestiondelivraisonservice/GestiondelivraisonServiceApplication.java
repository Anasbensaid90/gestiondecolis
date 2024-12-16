package com.anasdev.gestiondelivraisonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {
        "com.anasdev.gestiondelivraisonservice.model",
        "com.anasdev.gestiondecolisservice.model"
})
public class GestiondelivraisonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestiondelivraisonServiceApplication.class, args);
    }

}
