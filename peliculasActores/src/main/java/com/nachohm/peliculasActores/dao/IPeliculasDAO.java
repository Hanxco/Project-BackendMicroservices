package com.nachohm.peliculasActores.dao;

import com.nachohm.peliculasActores.models.Pelicula;

import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodas();
    List<Pelicula> buscarPorTitulo(String titulo);
    List<Pelicula> buscarPorGenero(String genero);
    List<Pelicula> buscarPorAnio(Integer anio);
    List<Pelicula> buscarPorDuracion(Integer duracion);
    List<Pelicula> buscarPorDirector(String director);
    void guardarPelicula(Pelicula pelicula);

    void actualizarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer id);
}
