package com.nachohm.peliculasActoresEureka.dao;

import com.nachohm.peliculasActoresEureka.models.Actores;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IActoresDAO {

    List<Actores> buscarTodosActores();
    List<Actores> buscarPorNombre(String nombre);
    List<Actores> buscarPorNacionalidad(String naciona);
    List<Actores> buscarPorFechaNacimiento(Date fecha);
    List<Actores> buscaActoresPorPeliculaId(Integer id);
    Actores buscarActorPorId(Integer id);
    void guardarActor(Actores actor);
    void actualizarActor(Actores actor);
    void eliminarActor(Integer id);
}
