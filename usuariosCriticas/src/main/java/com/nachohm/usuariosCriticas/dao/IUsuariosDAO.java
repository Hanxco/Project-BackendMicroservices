package com.nachohm.usuariosCriticas.dao;

import com.nachohm.usuariosCriticas.models.Usuario;

import java.util.List;

public interface IUsuariosDAO {

    List<Usuario> buscarTodos();

    Usuario buscarUsuarioPorId(Integer idUsuario);

    Usuario buscarUsuarioPorNombre(String nombre);

    Usuario buscarUsuarioPorCorreo(String correo);

    Usuario buscarUsuarioPorCorreoClave(String correo, String clave);

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Integer idUsuario);

    void actualizarUsuario(Usuario usuario);

}
