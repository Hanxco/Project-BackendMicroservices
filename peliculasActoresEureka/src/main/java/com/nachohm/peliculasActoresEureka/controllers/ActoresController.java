package com.nachohm.peliculasActoresEureka.controllers;

import com.nachohm.peliculasActoresEureka.models.Actores;
import com.nachohm.peliculasActoresEureka.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
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

    @GetMapping("/actores/fechaNacimiento/{fechaNac}")
    public List<Actores> buscarActorNacimiento(@PathVariable("fechaNac") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date fechaNac) {
        return actoresService.buscarActoresPorFechaNac(fechaNac);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actores actor) {
        System.out.println("guardarActor actor");
        System.out.println(actor);
        actoresService.guardarActor(actor);
    }

    @PutMapping("/actores")
    public void actualizarActor(@RequestBody Actores actor) {
        System.out.println("actualizarActor actor");
        System.out.println(actor);
        actoresService.actualizarActor(actor);
    }

    @DeleteMapping("/actores/{id}")
    public void eliminarActor(@PathVariable("id") Integer id) { actoresService.eliminarActor(id); }

}
