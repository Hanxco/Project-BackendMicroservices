package com.nachohm.peliculasFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @GetMapping(value = {"/", "/home", ""})
    public String homePage(Model model) {
        return "index";
    }

}
