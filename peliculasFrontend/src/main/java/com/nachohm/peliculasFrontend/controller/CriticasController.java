package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Criticas;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.ICriticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/criticas")
public class CriticasController {

    @Autowired
    ICriticasService criticasService;

    @GetMapping("/listado")
    public String listadoCriticas(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        System.out.println("listadoUsuarios");
        Pageable pageable = PageRequest.of(page, 5);
        Page<Criticas> listado = criticasService.buscarTodas(pageable);
        PageRender<Criticas> pageRender = new PageRender<Criticas>("/usuarios/listado", listado);
        model.addAttribute("listadoCriticas", listado);
        model.addAttribute("page", pageRender);
        return "criticas/listado";
    }

    @PostMapping("/criticas/{usuarioId}")
    public String crearCritica(Model model, @PathVariable("usuarioId") Integer id, Criticas critica) {
        System.out.println("crearCritica");
        System.out.println(id);
        System.out.println(critica);
        return "/";
    }

}
