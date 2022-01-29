package com.nachohm.peliculasActores.service;

import com.nachohm.peliculasActores.dao.IActoresDAO;
import com.nachohm.peliculasActores.models.Actores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class IActoresServiceImpl implements IActoresService {

    @Autowired
    IActoresDAO actoresDAO;

    @Override
    public List<Actores> buscarTodosActores() {
        return actoresDAO.buscarTodosActores();
    }

    @Override
    public Actores buscarActorPorId(Integer id) { return actoresDAO.buscarActorPorId(id); }

    @Override
    public List<Actores> buscarActoresPorNombre(String nombre) { return actoresDAO.buscarPorNombre(nombre); }

    @Override
    public List<Actores> buscarActoresPorNacionalidad(String nacionalidad) { return actoresDAO.buscarPorNacionalidad(nacionalidad); }

    @Override
    public void guardarActor(Actores actor) { actoresDAO.guardarActor(actor); }

    @Override
    public void actualizarActor(Actores actor) { actoresDAO.actualizarActor(actor); }

    @Override
    public void eliminarActor(Integer id) { actoresDAO.eliminarActor(id); }

    @Override
    public List<Actores> buscarActoresPorFechaNac(Date fechaNac) { return actoresDAO.buscarPorFechaNacimiento(fechaNac); }


}
