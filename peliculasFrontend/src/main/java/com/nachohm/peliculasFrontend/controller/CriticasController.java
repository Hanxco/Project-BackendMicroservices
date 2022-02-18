package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Criticas;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.ICriticasService;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import com.nachohm.peliculasFrontend.types.SystemLabels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/criticas")
public class CriticasController {

    @Autowired
    ICriticasService criticasService;
    @Autowired
    IUsuariosService usuariosService;

    @GetMapping("/listado")
    public String listadoCriticas(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.CriticasListado);
        if (session.getPermission()) {
            System.out.println("listadoUsuarios");
            Pageable pageable = PageRequest.of(page, 15);
            Page<Criticas> listado = criticasService.buscarTodas(pageable);
            PageRender<Criticas> pageRender = new PageRender<Criticas>("/usuarios/listado", listado);
            model.addAttribute("listadoCriticas", listado);
            model.addAttribute("page", pageRender);
        }
        return session.getUri();
    }

    @GetMapping("/editar/{id}")
    public String editarCritica(Model model, @PathVariable("id") Integer id) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.FormCriticas);
        if (session.getPermission()) {
            model.addAttribute("titlePage", "Editando critica");
            model.addAttribute("criticas", criticasService.buscarPorId(id));
            model.addAttribute("mode", "edit");
        }
        return session.getUri();
    }


    @PostMapping("/guardar")
    public String guardarCritica(Model model, Criticas critica, RedirectAttributes attributes) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.CriticasListado, true);
        if (session.getPermission()) {
            System.out.println("guardado");
            System.out.println(critica);
            criticasService.actualizarCritica(critica);
            attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        }
        return session.getUri();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCritica(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.CriticasListado, true);
        if (session.getPermission()) {
            criticasService.eliminarCritica(id);
            attributes.addFlashAttribute("msg", "La pelicula ha sido borrada!");
        }
        return session.getUri();
    }

}
