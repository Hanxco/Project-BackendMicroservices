package com.nachohm.usuariosCriticas.services;

import com.nachohm.usuariosCriticas.dao.IRolesDAO;
import com.nachohm.usuariosCriticas.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    IRolesDAO rolDAO;

    @Override
    public List<Rol> buscarTodos() {
        return rolDAO.buscarTodos();
    }

    @Override
    public Rol buscarRolPorId(Integer idRol) {
        return rolDAO.buscarRolPorId(idRol);
    }

    @Override
    public void guardarRol(Rol rol) {
        rolDAO.guardarRol(rol);
    }

    @Override
    public void eliminarRol(Integer idRol) {
        rolDAO.eliminarRol(idRol);
    }

}
