package com.nachohm.peliculasActoresEureka.service;

import com.nachohm.peliculasActoresEureka.models.Actores;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IActoresService {

    List<Actores> buscarTodosActores();
    Actores buscarActorPorId(Integer id);
    List<Actores> buscarActoresPorNombre(String nombre);
    List<Actores> buscarActoresPorNacionalidad(String nacionalidad);
    void guardarActor(Actores actor);
    void actualizarActor(Actores actor);
    void eliminarActor(Integer id);
    List<Actores> buscarActoresPorFechaNac(Date fechaNac);
}
