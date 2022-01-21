package com.nachohm.peliculasActores.dao;

import com.nachohm.peliculasActores.models.Actores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IActoresDAOImpl implements IActoresDAO {

    @Autowired
    IActoresJPA actoresJPA;

    @Override
    public List<Actores> buscarTodosActores() { return actoresJPA.findAll(); }

    @Override
    public List<Actores> buscarPorNombre(String nombre) { return actoresJPA.findByNombre(nombre); }

    @Override
    public List<Actores> buscarPorNacionalidad(String naciona) { return actoresJPA.findByNacionalidad(naciona); }

    @Override
    public void guardarActor(Actores actor) { actoresJPA.save(actor); }

    @Override
    public void actualizarActor(Actores actor) { actoresJPA.save(actor); }

    @Override
    public void eliminarActor(Integer id) { actoresJPA.deleteById(id); }

}
