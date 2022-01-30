package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Actores;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActoresService {
    Page<Actores> buscarTodosActores(Pageable pageable);

    List<Actores> buscarListaActores();

    Actores buscarActorPorId(Integer id);
    void guardarActor(Actores actor);
    void eliminarActor(Integer id);
    List<Actores> buscarActoresPorPelicula(Integer peliculaId);
}
