/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.kahoot.dao;

import java.util.List;
import pe.edu.upeu.kahoot.model.Perfil;

/**
 *
 * @author davidmp
 */
public interface PerfilDao {
    public List<Perfil> listarEntidad();
    public Perfil buscarEntidad(int id);
    public void guardarEntidad(Perfil perfil);
    public void eliminarEntidad(int id);
    public void modificarEntidadId(Perfil perfil);
    public List<Perfil> listarPorNombre(String nombre);     
}
