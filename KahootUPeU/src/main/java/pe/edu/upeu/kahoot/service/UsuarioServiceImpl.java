/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.kahoot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.kahoot.dao.UsuarioDao;
import pe.edu.upeu.kahoot.model.Usuario;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    public UsuarioDao dao;

    @Override
    public List<Usuario> listarEntidad() {return dao.listarEntidad();}

    @Override
    public Usuario buscarEntidad(int id) {return dao.buscarEntidad(id);}

    @Override
    public void guardarEntidad(Usuario usuario) {dao.guardarEntidad(usuario);}

    @Override
    public void eliminarEntidad(int id) {dao.eliminarEntidad(id);}

    @Override
    public void modificarEntidadId(Usuario usuario) {dao.modificarEntidadId(usuario);}

    @Override
    public List<Usuario> listarPorNombre(String nombre) {return dao.listarPorNombre(nombre);}          
    
    @Override
    public Usuario usuarioLogin(String login, String clave){return dao.usuarioLogin(login, clave);}          
}
