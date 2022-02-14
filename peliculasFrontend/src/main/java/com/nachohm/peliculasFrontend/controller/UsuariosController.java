package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Rol;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.services.IRolesService;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;
    @Autowired
    IRolesService rolesService;

    @PostMapping("/registrar")
    public String registro(Model model, Usuario usuario, RedirectAttributes attributes) {
        System.out.println("registro");
        System.out.println(usuario);
        usuario.setEnable(true);
        Rol rol = rolesService.buscarRolPorId(2);
        //usuario.setRoles(Arrays.asList(rol));
        System.out.println(rol);
        System.out.println(usuario);

        usuariosService.guardarUsuario(usuario);
        attributes.addFlashAttribute("msg", "Los datos del registro fueron guardados!");
        return "redirect:/login";
    }

    @GetMapping("/registrar")
    public String nuevoRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "registro";
    }
}
