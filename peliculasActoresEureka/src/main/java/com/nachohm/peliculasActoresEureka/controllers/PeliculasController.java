package com.nachohm.peliculasActoresEureka.controllers;

import com.nachohm.peliculasActoresEureka.models.Pelicula;
import com.nachohm.peliculasActoresEureka.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodasPeliculas() { return peliculasService.buscarTodasPeliculas(); }

    @GetMapping("/peliculas/{id}")
    public Pelicula buscarPeliculaById(@PathVariable("id") Integer id) { return peliculasService.buscarPorId(id); }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculaPorTitulo(@PathVariable("titulo") String titulo) { return peliculasService.buscarPorTitulo(titulo); }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula> buscarPeliculaPorGenero(@PathVariable("genero") String genero) { return peliculasService.buscarPorGenero(genero); }

    @GetMapping("/peliculas/anio/{anio}")
    public List<Pelicula> buscarPeliculaPorAnio(@PathVariable("anio") Integer anio) { return peliculasService.buscarPorAnio(anio); }

    @GetMapping("/peliculas/duracion/{duracion}")
    public List<Pelicula> buscarPeliculasPorDuracion(@PathVariable("duracion") Integer duracion) { return peliculasService.buscarPorDuracion(duracion); }

    @GetMapping("/peliculas/director/{director}")
    public List<Pelicula> buscarPeliculasPorDuracion(@PathVariable("director") String director) { return peliculasService.buscarPorDirector(director); }

    @PostMapping("/peliculas")
    public void guardarPelicula(@RequestBody Pelicula pelicula) { peliculasService.guardarPelicula(pelicula); }

    @PutMapping("/peliculas")
    public void actualizarPelicula(@RequestBody Pelicula pelicula) { peliculasService.actualizarPelicula(pelicula); }

    @DeleteMapping("/peliculas/{id}")
    public void eliminarPelicula(@PathVariable("id") Integer id) { peliculasService.eliminarPelicula(id); }

}
