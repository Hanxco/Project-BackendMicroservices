package com.nachohm.peliculasActoresEureka.dao;

import com.nachohm.peliculasActoresEureka.models.Actores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IActoresJPA extends JpaRepository<Actores, Integer> {

    List<Actores> findByNombre(String nombre);
    List<Actores> findByNacionalidad(String nacionalidad);
    List<Actores> findByFechaNacimiento(Date fechaNac);

}
