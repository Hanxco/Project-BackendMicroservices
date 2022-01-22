package com.nachohm.peliculasActores.controllers;

import com.nachohm.peliculasActores.models.Actores;
import com.nachohm.peliculasActores.models.Pelicula;
import com.nachohm.peliculasActores.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/actores")
    public List<Actores> buscarTodosActores() { return actoresService.buscarTodosActores(); }

    @GetMapping("/actores/{id}")
    public Actores buscarActorPorId(@PathVariable("id") Integer id) { return actoresService.buscarActorPorId(id); }

    @GetMapping("/actores/nacionalidad/{nacionalidad}")
    public List<Actores> buscarActorNacionalidad(@PathVariable("nacionalidad") String nacionalidad) { return actoresService.buscarActoresPorNacionalidad(nacionalidad); }

    @GetMapping("/actores/nombre/{nombre}")
    public List<Actores> buscarActorNombre(@PathVariable("nombre") String nombre) { return actoresService.buscarActoresPorNombre(nombre); }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actores actor) { actoresService.guardarActor(actor); }

    @PutMapping("/actores")
    public void actualizarActor(@RequestBody Actores actor) { actoresService.actualizarActor(actor); }

    @DeleteMapping("/actores/{id}")
    public void eliminarActor(@PathVariable("id") Integer id) { actoresService.eliminarActor(id); }

}
