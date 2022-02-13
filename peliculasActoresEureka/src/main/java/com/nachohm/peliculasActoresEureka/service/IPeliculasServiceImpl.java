package com.nachohm.peliculasActoresEureka.service;

import com.nachohm.peliculasActoresEureka.dao.IActoresDAO;
import com.nachohm.peliculasActoresEureka.dao.IPeliculasDAO;
import com.nachohm.peliculasActoresEureka.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPeliculasServiceImpl implements IPeliculasService {

    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Pelicula> buscarTodasPeliculas() {
        return peliculasDAO.buscarTodas();
    }

    @Override
    public Pelicula buscarPorId(Integer id) {
        return peliculasDAO.buscarPorId(id);
    }

    @Override
    public List<Pelicula> buscarPorTitulo(String titulo) {
        return peliculasDAO.buscarPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPorGenero(String genero) { return peliculasDAO.buscarPorGenero(genero); }

    @Override
    public List<Pelicula> buscarPorAnio(Integer anio) { return peliculasDAO.buscarPorAnio(anio); }

    @Override
    public List<Pelicula> buscarPorDuracion(Integer duracion) { return peliculasDAO.buscarPorDuracion(duracion); }

    @Override
    public List<Pelicula> buscarPorDirector(String director) { return peliculasDAO.buscarPorDirector(director); }

    @Override
    public void guardarPelicula(Pelicula pelicula) { peliculasDAO.guardarPelicula(pelicula); }

    @Override
    public void actualizarPelicula(Pelicula pelicula) { peliculasDAO.actualizarPelicula(pelicula); }

    @Override
    public void eliminarPelicula(Integer id) { peliculasDAO.eliminarPelicula(id); }


}
