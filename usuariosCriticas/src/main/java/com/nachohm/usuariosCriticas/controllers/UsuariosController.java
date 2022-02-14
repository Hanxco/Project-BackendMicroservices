package com.nachohm.usuariosCriticas.controllers;

import com.nachohm.usuariosCriticas.models.Usuario;
import com.nachohm.usuariosCriticas.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;

    @GetMapping("/usuarios")
    public List<Usuario> buscarTodos() {
        return usuariosService.buscarTodos();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable("id") Integer id) {
        return usuariosService.buscarUsuarioPorId(id);
    }

    @GetMapping("/usuarios/correo/{correo}")
    public Usuario buscarUsuarioPorCorreo(@PathVariable("correo") String correo) {
        return usuariosService.buscarUsuarioPorCorreo(correo);
    }

    @GetMapping("/usuarios/login/{correo}/{clave}")
    public Usuario buscarUsuarioPorCorreoConClave(@PathVariable("correo") String correo, @PathVariable("clave") String clave) {
        System.out.println("buscarUsuarioPorCorreoConClave");
        System.out.println("correo => " + correo);
        System.out.println("clave => " + clave);
        return usuariosService.buscarUsuarioPorCorreoClave(correo, clave);
    }

    @GetMapping("/usuarios/nombre/{nombre}")
    public Usuario buscarUsuarioPorNombre(@PathVariable("nombre") String nombre) {
        return usuariosService.buscarUsuarioPorNombre(nombre);
    }

    @PostMapping("/usuarios")
    public void guardarUsuario(@RequestBody Usuario usuario) {
        usuariosService.guardarUsuario(usuario);
    }

    @PutMapping("/usuarios")
    public void actualizarUsuario(@RequestBody Usuario usuario) {
        usuariosService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable("id") Integer id) {
        usuariosService.eliminarUsuario(id);
    }
}
