package com.nachohm.usuariosCriticas.dao;

import com.nachohm.usuariosCriticas.models.Critica;
import com.nachohm.usuariosCriticas.models.Usuario;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CriticaDAOImpl implements ICriticaDAO {

    @Autowired
    ICriticaJPA criticaJPA;

    @Override
    public List<Critica> buscarTodas() {
        return criticaJPA.findAll();
    }

    @Override
    public List<Critica> buscarCriticaPorPelicula(Integer peliculaId) {
        return criticaJPA.findByPeliculaId(peliculaId);
    }

    @Override
    public Critica buscarCriticaPorId(Integer idCritica) {
        Optional<Critica> optional = criticaJPA.findById(idCritica);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Critica> buscarCriticaPorNota(Integer nota) {
        return criticaJPA.findByNota(nota);
    }

    @Override
    public void guardarCritica(Critica critica) {
        criticaJPA.save(critica);
    }

    @Override
    public void actualizarCritica(Critica critica) {
        criticaJPA.save(critica);
    }

    @Override
    public void eliminarCritica(Integer criticaId) {
        criticaJPA.deleteById(criticaId);
    }
}
