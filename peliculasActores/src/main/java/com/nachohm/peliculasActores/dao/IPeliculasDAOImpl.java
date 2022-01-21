package com.nachohm.peliculasActores.dao;

import com.nachohm.peliculasActores.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IPeliculasDAOImpl implements IPeliculasDAO {

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculasJPA.findAll();
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


}
