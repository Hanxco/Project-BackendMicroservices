package com.nachohm.usuariosCriticas.dao;

import com.nachohm.usuariosCriticas.models.Critica;


import java.util.List;

public interface ICriticaDAO {

    List<Critica> buscarTodas();

    List<Critica> buscarCriticaPorPelicula(Integer peliculaId);

    Critica buscarCriticaPorId(Integer idCritica);

    List<Critica> buscarCriticaPorNota(Integer nota);

    void guardarCritica(Critica critica);

    void actualizarCritica(Critica critica);

    void eliminarCritica(Integer criticaId);

}
