/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.kahoot.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.kahoot.SysDataAccess;
import pe.edu.upeu.kahoot.model.Usuario;

/**
 *
 * @author davidmp
 */
@Repository
public class UsuarioDaoImpl extends SysDataAccess<Integer, Usuario> implements UsuarioDao{
    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> listarEntidad() { return getListAll();}
    @Override
    public Usuario buscarEntidad(int id) { return getById(id);}
    @Override
    public void guardarEntidad(Usuario usuario) {savev(usuario); }
    @Override
    public void eliminarEntidad(int id) { delete(id);}
    @Override
    public void modificarEntidadId(Usuario usuario) { update(usuario); }
    @Override
    
    public List<Usuario> listarPorNombre(String nombre) {        
    return (List<Usuario>)sessionFactory.getCurrentSession()
            .createQuery("select a from Usuario a where a.idPersona.nombre like ?")
            .setString(0, "%"+nombre+"%")
            .list();
    }        
    
    public Usuario usuarioLogin(String login, String clave){
    return (Usuario)sessionFactory.getCurrentSession()
            .createQuery("select a from Usuario a where a.idPersona.usuario=? and a.idPersona.clave=? ")        
            .setString(0, login)
            .setString(1, clave)
            .uniqueResult();
    }    
}
