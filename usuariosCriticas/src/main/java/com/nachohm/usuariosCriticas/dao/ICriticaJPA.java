package com.nachohm.usuariosCriticas.dao;

import com.nachohm.usuariosCriticas.models.Critica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICriticaJPA extends JpaRepository<Critica, Integer>  {

    List<Critica> findByPeliculaId(Integer peliculaId);
    List<Critica> findByNota(Integer nota);
}
