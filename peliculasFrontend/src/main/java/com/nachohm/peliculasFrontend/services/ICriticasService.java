package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Criticas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICriticasService {

    Page<Criticas> buscarTodas(Pageable pageable);
    Criticas buscarPorId(Integer id);
    void actualizarCritica(Criticas critica);
    void eliminarCritica(Integer id);
}
