package com.nachohm.usuariosCriticas.services;

import com.nachohm.usuariosCriticas.dao.IUsuariosDAO;
import com.nachohm.usuariosCriticas.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

    @Autowired
    IUsuariosDAO usuariosDAO;

    @Override
    public List<Usuario> buscarTodos() {
        return usuariosDAO.buscarTodos();
    }

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        return usuariosDAO.buscarUsuarioPorNombre(nombre);
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return usuariosDAO.buscarUsuarioPorId(idUsuario);
    }

    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        return usuariosDAO.buscarUsuarioPorCorreo(correo);
    }

    @Override
    public Usuario buscarUsuarioPorCorreoClave(String correo, String clave) {
        return usuariosDAO.buscarUsuarioPorCorreoClave(correo, clave);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuariosDAO.guardarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuariosDAO.eliminarUsuario(idUsuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuariosDAO.actualizarUsuario(usuario);
    }

}
