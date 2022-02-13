package com.nachohm.peliculasActoresEureka.dao;

import com.nachohm.peliculasActoresEureka.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTitulo(String titulo);
    List<Pelicula> findByGenero(String genero);
    List<Pelicula> findByAnio(Integer anio);
    List<Pelicula> findByDuracion(Integer duracion);
    List<Pelicula> findByDireccion(String direccion);

}
