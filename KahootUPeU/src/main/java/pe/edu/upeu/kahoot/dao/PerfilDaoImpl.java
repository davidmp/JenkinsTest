/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.kahoot.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.kahoot.SysDataAccess;
import pe.edu.upeu.kahoot.model.Perfil;

/**
 *
 * @author davidmp
 */
@Repository
public class PerfilDaoImpl extends SysDataAccess<Integer, Perfil> implements PerfilDao{
    @SuppressWarnings("unchecked")
    @Override
    public List<Perfil> listarEntidad() { return getListAll();}
    @Override
    public Perfil buscarEntidad(int id) { return getById(id);}
    @Override
    public void guardarEntidad(Perfil perfil) {savev(perfil); }
    @Override
    public void eliminarEntidad(int id) { delete(id);}
    @Override
    public void modificarEntidadId(Perfil perfil) { update(perfil); }
    @Override
    public List<Perfil> listarPorNombre(String nombre) {        
    return (List<Perfil>)sessionFactory.getCurrentSession()
            .createQuery("select a from Perfil a where a.nombre like ?")
            .setString(0, "%"+nombre+"%")
            .list();
    }    
}
