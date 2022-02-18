package com.nachohm.usuariosCriticas.controllers;

import com.nachohm.usuariosCriticas.models.Critica;
import com.nachohm.usuariosCriticas.models.Usuario;
import com.nachohm.usuariosCriticas.services.ICriticaService;
import com.nachohm.usuariosCriticas.services.IUsuariosService;
import com.nachohm.usuariosCriticas.types.CustomLabel_ES;
import com.nachohm.usuariosCriticas.wrappers.ServiceAndSaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class CriticaController {

    @Autowired
    ICriticaService criticaService;
    @Autowired
    IUsuariosService usuariosService;

    @GetMapping("/criticas")
    public List<Critica> buscarTodas() {
        return criticaService.buscarTodasCriticas();
    }

    @GetMapping("/criticas/{id}")
    public Critica buscarCriticaPorId(@PathVariable("id") Integer id) {
        return criticaService.buscarCriticaPorId(id);
    }

    @GetMapping("/criticas/pelicula/{peliculaId}")
    public List<Critica> buscarCriticaPorPelicula(@PathVariable("peliculaId") Integer peliculaId) {
        return criticaService.buscarCriticaPorPelicula(peliculaId);
    }

    @GetMapping("/criticas/pelicula/{peliculaId}/media")
    public Integer buscarMediaCriticaPelicula(@PathVariable("peliculaId") Integer peliculaId) {
        final List<Critica> lstCritica = criticaService.buscarCriticaPorPelicula(peliculaId);
        Integer media = 0;
        if (!lstCritica.isEmpty()) {
            for (Critica critica : lstCritica) {
                media = critica.getNota() + media;
            }
            media = media / lstCritica.size();
        }
        return media;
    }

    @GetMapping("/criticas/nota/{nota}")
    public List<Critica> buscarCriticaPorNota(@PathVariable("nota") Integer nota) {
        return criticaService.buscarCriticaPorNota(nota);
    }

    @PostMapping("/criticas/{usuarioId}")
    public ServiceAndSaveResponse guardarCritica(@RequestBody Critica critica, @PathVariable("usuarioId") Integer usuarioId) {
        System.out.println("guardarCritica");
        ServiceAndSaveResponse service = new ServiceAndSaveResponse();
        Usuario usuario = usuariosService.buscarUsuarioPorId(usuarioId);
        if (usuario == null) {
            service.setCode(400);
            service.setMessage(CustomLabel_ES.crearCritica_usuario_noexiste);
        } else {
            final List<Critica> lstCriticas = usuario.getCriticas();
            System.out.println("lstCriticas");
            System.out.println(lstCriticas);
            java.util.Date date = new java.util.Date();
            critica.setFecha(new Date(date.getTime()));
            lstCriticas.add(critica);
            usuario.setCriticas(lstCriticas);
            criticaService.guardarCritica(critica);
            usuariosService.actualizarUsuario(usuario);
            service.setCode(200);
            service.setMessage(CustomLabel_ES.crearCritica_exito);
        }
        return service;
    }

    @PutMapping("/criticas")
    public ServiceAndSaveResponse actualizarCritica(@RequestBody Critica critica) {
        System.out.println("critica");
        System.out.println(critica);
        final ServiceAndSaveResponse service = new ServiceAndSaveResponse();
        if (criticaService.buscarCriticaPorId(critica.getId()) == null) {
            service.setCode(400);
            service.setMessage(CustomLabel_ES.actualizarCritica_fallo);
        } else {
            service.setCode(200);
            service.setMessage(CustomLabel_ES.actualizarCritica_exito);
            criticaService.actualizarCritica(critica);
        }
        return service;
    }

    @DeleteMapping("/criticas/{id}/usuario/{userId}")
    public ServiceAndSaveResponse eliminarCritica(@PathVariable("id") Integer id, @PathVariable("userId") Integer userId) {
        final ServiceAndSaveResponse service = new ServiceAndSaveResponse();
        if (criticaService.buscarCriticaPorId(id) == null) {
            service.setCode(400);
            service.setMessage(CustomLabel_ES.eliminarCritica_fallo);
        } else {
            List<Critica> lstCritica = new ArrayList<>();
            Usuario usuario = usuariosService.buscarUsuarioPorId(userId);
            if (usuario == null) {
                service.setCode(400);
                service.setMessage(CustomLabel_ES.eliminarCritica_usuario_fallo);
            } else {
                for (Critica critica : usuario.getCriticas()) {
                    if (critica.getId() != id) {
                        lstCritica.add(critica);
                    }
                }
                usuario.setCriticas(lstCritica);
                usuariosService.guardarUsuario(usuario);
                service.setCode(200);
                service.setMessage(CustomLabel_ES.eliminarCritica_exito);
            }
        }
        return service;
    }
}
