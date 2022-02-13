package com.nachohm.peliculasActoresEureka.dao;

import com.nachohm.peliculasActoresEureka.models.Actores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class IActoresDAOImpl implements IActoresDAO {

    @Autowired
    IActoresJPA actoresJPA;
    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Actores> buscarTodosActores() { return actoresJPA.findAll(); }

    @Override
    public List<Actores> buscarPorNombre(String nombre) { return actoresJPA.findByNombre(nombre); }

    @Override
    public List<Actores> buscarPorNacionalidad(String naciona) { return actoresJPA.findByNacionalidad(naciona); }

    @Override
    public List<Actores> buscarPorFechaNacimiento(Date fecha) { return actoresJPA.findByFechaNacimiento(fecha); }

    @Override
    public void guardarActor(Actores actor) { actoresJPA.save(actor); }

    @Override
    public void actualizarActor(Actores actor) { actoresJPA.save(actor); }

    @Override
    public void eliminarActor(Integer id) { actoresJPA.deleteById(id); }

    @Override
    public List<Actores> buscaActoresPorPeliculaId(Integer id) { return peliculasJPA.findById(id).get().getActoreses(); }

    @Override
    public Actores buscarActorPorId(Integer id) {
        Optional<Actores> actores = actoresJPA.findById(id);
        if (actores.isPresent()) {
            return actores.get();
        }
        return null;
    }

}
