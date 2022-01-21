package com.nachohm.peliculasActores.dao;

import com.nachohm.peliculasActores.models.Actores;
import com.nachohm.peliculasActores.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IPeliculasDAOImpl implements IPeliculasDAO {

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Pelicula> buscarTodas() { return peliculasJPA.findAll(); }

    @Override
    public Pelicula buscarPorId(Integer id) {
        Optional<Pelicula> pelicula = peliculasJPA.findById(id);
        if (pelicula.isPresent()) {
            return pelicula.get();
        }
        return null;
    }

    @Override
    public List<Pelicula> buscarPorTitulo(String titulo) {
        List<Pelicula> list = peliculasJPA.findByTitulo(titulo);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Pelicula> buscarPorGenero(String genero) {
        List<Pelicula> list = peliculasJPA.findByGenero(genero);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Pelicula> buscarPorAnio(Integer anio) {
        List<Pelicula> list = peliculasJPA.findByAnio(anio);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Pelicula> buscarPorDuracion(Integer duracion) {
        List<Pelicula> list = peliculasJPA.findByDuracion(duracion);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Pelicula> buscarPorDirector(String director) {
        List<Pelicula> list = peliculasJPA.findByDireccion(director);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) { peliculasJPA.save(pelicula); }

    @Override
    public void actualizarPelicula(Pelicula pelicula) { peliculasJPA.save(pelicula); }

    @Override
    public void eliminarPelicula(Integer id) { peliculasJPA.deleteById(id); }

    @Override
    public List<Pelicula> buscarPeliculaPorActor(Integer actorId) {
        List<Pelicula> lstPeliculas = new ArrayList<Pelicula>();
        for (Pelicula item : peliculasJPA.findAll()) {
            for (Actores actor : item.getActoreses()) {
                if (actor.getId().equals(actorId)) {
                    lstPeliculas.add(item);
                    item.setActoreses(null);
                }
            }
        }
        return lstPeliculas;
    }

}
