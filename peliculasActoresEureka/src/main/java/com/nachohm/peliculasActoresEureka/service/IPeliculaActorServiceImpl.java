package com.nachohm.peliculasActoresEureka.service;

import com.nachohm.peliculasActoresEureka.dao.IActoresDAO;
import com.nachohm.peliculasActoresEureka.dao.IPeliculasDAO;
import com.nachohm.peliculasActoresEureka.models.Actores;
import com.nachohm.peliculasActoresEureka.models.Pelicula;
import com.nachohm.peliculasActoresEureka.types.CustomLabel_ES;
import com.nachohm.peliculasActoresEureka.wrappers.ServiceAndSaveResponse;
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
    public ServiceAndSaveResponse asignarActorPelicula(Integer peliculaId, Integer actorId) {
        Pelicula pelicula = peliculasDAO.buscarPorId(peliculaId);
        Actores actor = actoresDAO.buscarActorPorId(actorId);
        ServiceAndSaveResponse service = new ServiceAndSaveResponse();
        if (actor == null) {
            service.setCode(400);
            service.setMessage(CustomLabel_ES.asignarActor_error_actor_not_found);
        } else {
            service.setCode(200);
            service.setMessage(CustomLabel_ES.asignarActor_sucess);
            List<Actores> lstActores = pelicula.getActoreses();
            lstActores.add(actor);
            pelicula.setActoreses(lstActores);
            peliculasDAO.guardarPelicula(pelicula);
        }
        return service;
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
