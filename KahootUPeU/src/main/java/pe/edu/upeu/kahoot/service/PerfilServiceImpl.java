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
import pe.edu.upeu.kahoot.dao.PerfilDao;
import pe.edu.upeu.kahoot.model.Perfil;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class PerfilServiceImpl implements PerfilService{
    
    @Autowired
    public PerfilDao dao;

    @Override
    public List<Perfil> listarEntidad() {return dao.listarEntidad();}

    @Override
    public Perfil buscarEntidad(int id) {return dao.buscarEntidad(id);}

    @Override
    public void guardarEntidad(Perfil perfil) {dao.guardarEntidad(perfil);}

    @Override
    public void eliminarEntidad(int id) {dao.eliminarEntidad(id);}

    @Override
    public void modificarEntidadId(Perfil perfil) {dao.modificarEntidadId(perfil);}

    @Override
    public List<Perfil> listarPorNombre(String nombre) {return dao.listarPorNombre(nombre);}      
}
