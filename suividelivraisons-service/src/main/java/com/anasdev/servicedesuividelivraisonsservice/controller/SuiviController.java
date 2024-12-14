package com.anasdev.servicedesuividelivraisonsservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuiviController {

    @GetMapping("/")
    public String suivi() {
        return "index"; // Retourne le fichier index.html
    }
}
