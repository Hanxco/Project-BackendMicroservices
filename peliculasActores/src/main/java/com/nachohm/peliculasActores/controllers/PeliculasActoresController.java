package com.nachohm.peliculasActores.controllers;

import com.nachohm.peliculasActores.models.Pelicula;
import com.nachohm.peliculasActores.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeliculasActoresController {

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/peliculas/actor/{id}")
    public List<Pelicula> buscarPeliculasPorActor(@PathVariable("id") Integer id) {
        return peliculasService.buscarPeliculasPorActor(id);
    }
}
