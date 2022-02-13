package com.nachohm.peliculasActoresEureka.service;

import com.nachohm.peliculasActoresEureka.models.Actores;
import com.nachohm.peliculasActoresEureka.models.Pelicula;
import com.nachohm.peliculasActoresEureka.wrappers.ServiceAndSaveResponse;

import java.util.List;

public interface IPeliculaActorService {

    List<Actores> buscarActorPorPelicula(Integer id);
    List<Pelicula> buscarPeliculasPorActor(Integer id);
    ServiceAndSaveResponse asignarActorPelicula(Integer peliculaId, Integer actorId);
    void eliminarActorPelicula(Integer peliculaId, Integer actorId);

}
