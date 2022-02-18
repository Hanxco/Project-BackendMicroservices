package com.nachohm.usuariosCriticas.services;

import com.nachohm.usuariosCriticas.dao.ICriticaDAO;
import com.nachohm.usuariosCriticas.models.Critica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticaServiceImpl implements ICriticaService {

    @Autowired
    ICriticaDAO criticaDAO;

    @Override
    public List<Critica> buscarTodasCriticas() {
        return criticaDAO.buscarTodas();
    }

    @Override
    public List<Critica> buscarCriticaPorPelicula(Integer peliculaId) {
        return criticaDAO.buscarCriticaPorPelicula(peliculaId);
    }

    @Override
    public Critica buscarCriticaPorId(Integer criticaId) {
        return criticaDAO.buscarCriticaPorId(criticaId);
    }

    @Override
    public List<Critica> buscarCriticaPorNota(Integer nota) {
        return criticaDAO.buscarCriticaPorNota(nota);
    }

    @Override
    public void guardarCritica(Critica critica) {
        criticaDAO.guardarCritica(critica);
    }

    @Override
    public void eliminarCritica(Integer criticaId) {
        criticaDAO.eliminarCritica(criticaId);
    }

    @Override
    public void actualizarCritica(Critica critica) {
        criticaDAO.actualizarCritica(critica);
    }
}
