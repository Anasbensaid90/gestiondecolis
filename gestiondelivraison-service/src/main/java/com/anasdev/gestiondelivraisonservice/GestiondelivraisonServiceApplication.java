package com.anasdev.gestiondelivraisonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestiondelivraisonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestiondelivraisonServiceApplication.class, args);
    }

}
