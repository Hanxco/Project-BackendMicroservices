package com.nachohm.peliculasActores.service;

import com.nachohm.peliculasActores.dao.IActoresDAO;
import com.nachohm.peliculasActores.dao.IPeliculasDAO;
import com.nachohm.peliculasActores.models.Actores;
import com.nachohm.peliculasActores.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPeliculaActorServiceImpl implements IPeliculaActorService {

    @Autowired
    IPeliculasDAO peliculasDAO;

    @Autowired
    IActoresDAO actoresDAO;

    @Override
    public void asignarActorPelicula(Integer peliculaId, Integer actorId) {
        Pelicula pelicula = peliculasDAO.buscarPorId(peliculaId);
        Actores actor = actoresDAO.buscarActorPorId(actorId);
        List<Actores> lstActores = pelicula.getActoreses();
        lstActores.add(actor);
        pelicula.setActoreses(lstActores);
        peliculasDAO.guardarPelicula(pelicula);
    }

    @Override
    public void eliminarActorPelicula(Integer peliculaId, Integer actorId) {
        Pelicula pelicula = peliculasDAO.buscarPorId(peliculaId);
        List<Actores> lstActores = new ArrayList<Actores>();
        for (Actores item : pelicula.getActoreses()) {
            if (item.getId().equals(actorId) == false) {
                lstActores.add(item);
            }
        }
        pelicula.setActoreses(lstActores);
        peliculasDAO.guardarPelicula(pelicula);
    }

    @Override
    public List<Actores> buscarActorPorPelicula(Integer id) { return actoresDAO.buscaActoresPorPeliculaId(id); }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(Integer id) { return peliculasDAO.buscarPeliculaPorActor(id); }

}
