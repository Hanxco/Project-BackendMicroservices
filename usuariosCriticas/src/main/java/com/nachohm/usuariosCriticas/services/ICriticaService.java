package com.nachohm.usuariosCriticas.services;

import com.nachohm.usuariosCriticas.models.Critica;

import java.util.List;

public interface ICriticaService {

    List<Critica> buscarTodasCriticas();

    List<Critica> buscarCriticaPorPelicula(Integer peliculaId);

    Critica buscarCriticaPorId(Integer criticaId);

    List<Critica> buscarCriticaPorNota(Integer nota);

    void guardarCritica(Critica critica);

    void eliminarCritica(Integer criticaId);

    void actualizarCritica(Critica critica);
}
