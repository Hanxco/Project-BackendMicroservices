package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Actores;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/actores")
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/listado")
    public String listadoActores(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 15);
        Page<Actores> listActores = actoresService.buscarTodosActores(pageable);
        PageRender<Actores> pageRender = new PageRender<Actores>("/actores/listado", listActores);
        model.addAttribute("titulo","Listado de todas las peliculas");
        model.addAttribute("listadoActores",listActores);
        model.addAttribute("page",pageRender);
        return"actores/listado";
    }

    @GetMapping("/crear")
    public String crearActor(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        model.addAttribute("titlePage", "Crear una nuevo actor/a");
        model.addAttribute("actor", new Actores());
        model.addAttribute("methodForm", "POST");
        model.addAttribute("mode", "create");
        return "actores/formActor";
    }

    @GetMapping("/editar/{id}")
    public String editarActores(Model model, @PathVariable("id") Integer id) {
        Actores actor = actoresService.buscarActorPorId(id);
        model.addAttribute("titlePage", "Editando actor");
        model.addAttribute("actor", actor);
        model.addAttribute("actorId", id);
        model.addAttribute("methodForm", "PUT");
        model.addAttribute("mode", "edit");
        return "actores/formActor";
    }

    @PostMapping("/guardar")
    public String crearActores(Model model, Actores actorObj, RedirectAttributes attributes) throws ParseException {
        actoresService.guardarActor(actorObj);
        attributes.addFlashAttribute("msg", "El registro se ha guardado!");
        return "redirect:/actores/listado";
    }

    @PutMapping("/guardar")
    public String modificarActores(Model model, Actores actorObj, RedirectAttributes attributes) {
        actoresService.guardarActor(actorObj);
        attributes.addFlashAttribute("msg", "Se ha guardado el registro!");
        return "redirect:/actores/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarActores(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        actoresService.eliminarActor(id);
        attributes.addFlashAttribute("msg", "El actor/a ha sido borrada!");
        return "redirect:/actores/listado";
    }


}
