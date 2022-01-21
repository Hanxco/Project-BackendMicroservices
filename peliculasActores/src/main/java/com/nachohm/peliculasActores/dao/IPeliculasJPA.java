package com.nachohm.peliculasActores.dao;

import com.nachohm.peliculasActores.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTitulo(String titulo);
    List<Pelicula> findByGenero(String genero);
    List<Pelicula> findByAnio(Integer anio);
    List<Pelicula> findByDuracion(Integer duracion);
    List<Pelicula> findByDireccion(String direccion);

}
