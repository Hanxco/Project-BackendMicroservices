package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Criticas;
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
public class CriticasServiceImpl implements ICriticasService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8002/criticas/";

    @Override
    public Page<Criticas> buscarTodas(Pageable pageable) {
        Criticas[] criticas = template.getForObject(url, Criticas[].class);
        List<Criticas> criticasList = Arrays.asList(criticas);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Criticas> list;

        if (criticasList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, criticasList.size());
            list = criticasList.subList(startItem, toIndex);
        }

        Page<Criticas> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), criticasList.size());
        return page;
    }

    @Override
    public Criticas buscarPorId(Integer id) {
        Criticas critica = template.getForObject(url + id, Criticas.class);
        return critica;
    }

    @Override
    public void actualizarCritica(Criticas critica) {
        template.put(url, critica, String.class);
    }

    @Override
    public void eliminarCritica(Integer id) {
        template.delete(url + "/" + id);
    }
}
