package com.nachohm.peliculasActores.service;

import com.nachohm.peliculasActores.models.Actores;
import com.nachohm.peliculasActores.models.Pelicula;

import java.util.List;

public interface IPeliculaActorService {

    List<Actores> buscarActorPorPelicula(Integer id);
    List<Pelicula> buscarPeliculasPorActor(Integer id);
    void asignarActorPelicula(Integer peliculaId, Integer actorId);
    void eliminarActorPelicula(Integer peliculaId, Integer actorId);

}
