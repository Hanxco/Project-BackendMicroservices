package com.nachohm.peliculasActores.controllers;

import com.nachohm.peliculasActores.models.Actores;
import com.nachohm.peliculasActores.models.Pelicula;
import com.nachohm.peliculasActores.service.IActoresService;
import com.nachohm.peliculasActores.service.IPeliculaActorService;
import com.nachohm.peliculasActores.service.IPeliculasService;
import com.nachohm.peliculasActores.wrappers.ServiceAndSaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculasActoresController {

    @Autowired
    IPeliculaActorService peliculaActorService;

    @GetMapping("/peliculas/actor/{id}")
    public List<Pelicula> buscarPeliculasPorActor(@PathVariable("id") Integer id) { return peliculaActorService.buscarPeliculasPorActor(id); }

    @GetMapping("/actores/pelicula/{id}")
    public List<Actores> buscarActoresPeliculaId(@PathVariable("id") Integer id) { return peliculaActorService.buscarActorPorPelicula(id); }

    @PutMapping("/peliculas/{peliculaId}/actor/{id}")
    public ResponseEntity asignarActorPelicula(@PathVariable("peliculaId") Integer peliculaId,
                                     @PathVariable("id") Integer id) {
        ServiceAndSaveResponse service =  peliculaActorService.asignarActorPelicula(peliculaId, id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(service);
    }

    @DeleteMapping("/peliculas/{peliculaId}/actor/{id}")
    public void borrarActorPelicula(@PathVariable("peliculaId") Integer peliculaId,
                                    @PathVariable("id") Integer id) {
        peliculaActorService.eliminarActorPelicula(peliculaId, id);
    }
}
