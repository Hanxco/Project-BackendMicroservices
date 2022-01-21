package com.nachohm.peliculasActores.service;

import com.nachohm.peliculasActores.models.Actores;

import java.util.List;

public interface IActoresService {

    List<Actores> buscarTodosActores();
    List<Actores> buscarActoresPorNombre(String nombre);
    List<Actores> buscarActoresPorNacionalidad(String nacionalidad);
    void guardarActor(Actores actor);
    void actualizarActor(Actores actor);
    void eliminarActor(Integer id);
    List<Actores> buscarActorPorPelicula(Integer id);

}
