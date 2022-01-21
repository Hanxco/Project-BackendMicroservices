package com.nachohm.peliculasActores.dao;

import com.nachohm.peliculasActores.models.Actores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActoresJPA extends JpaRepository<Actores, Integer> {

    List<Actores> findByNombre(String nombre);
    List<Actores> findByNacionalidad(String nacionalidad);

}
