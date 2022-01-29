package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Actores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActoresServiceImpl implements IActoresService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8001/actores";

    @Override
    public Page<Actores> buscarTodosActores(Pageable pageable) {
        Actores[] actores = template.getForObject(url, Actores[].class);
        List<Actores> actorList = Arrays.asList(actores);
        System.out.println(actores);
        System.out.println("actorList");
        System.out.println(actorList);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Actores> list;

        if (actorList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, actorList.size());
            list = actorList.subList(startItem, toIndex);
        }

        Page<Actores> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), actorList.size());
        return page;
    }

    @Override
    public Actores buscarActorPorId(Integer id) {
        Actores actor = template.getForObject(url + "/" + id, Actores.class);
        return actor;
    }

    @Override
    public void guardarActor(Actores actor) {
        if (actor.getId() != null && actor.getId() > 0) {
            template.put(url, actor);
        } else {
            actor.setId(0);
            template.postForObject(url, actor, String.class);
        }
    }

    @Override
    public void eliminarActor(Integer id) { template.delete(url + "/" + id); }

    @Override
    public List<Actores> buscarActoresPorPelicula(Integer peliculaId) {
        Actores[] actores = template.getForObject(url + "/pelicula/" + peliculaId, Actores[].class);
        List<Actores> actorList = Arrays.asList(actores);
        System.out.println("actorList");
        System.out.println(actorList);
        return actorList;
    }

}