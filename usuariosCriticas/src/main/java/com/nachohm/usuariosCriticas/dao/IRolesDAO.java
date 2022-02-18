package com.nachohm.usuariosCriticas.dao;

import com.nachohm.usuariosCriticas.models.Rol;

import java.util.List;

public interface IRolesDAO {

    List<Rol> buscarTodos();

    Rol buscarRolPorId(Integer idRol);

    void guardarRol(Rol rol);

    void eliminarRol(Integer idRol);

}
