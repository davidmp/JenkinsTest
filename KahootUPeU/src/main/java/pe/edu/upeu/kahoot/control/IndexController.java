/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.kahoot.control;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.kahoot.model.Perfil;
import pe.edu.upeu.kahoot.model.Usuario;
import pe.edu.upeu.kahoot.service.PerfilService;
import pe.edu.upeu.kahoot.service.UsuarioService;


/**
 *
 * @author davidmp
 */
@Controller
public class IndexController {
    @Autowired
    MessageSource mesagesource;
    
    @Autowired
    PerfilService servicioPerfil;
    
    @Autowired
    UsuarioService servicioUsuario;    

    @GetMapping("/prueba")
    public ModelAndView userForm(Locale locale, Model model) {
            List<Perfil> lista=servicioPerfil.listarEntidad();
            for(Perfil perfil : lista) {
                System.out.println("Ver: "+perfil.getNombre());
             }            
            model.addAttribute("users", lista);
            return new ModelAndView("index");
    }
    
    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public ModelAndView principalLogin(ModelMap model) {                      
        return new ModelAndView("login");
    }    
    
    @RequestMapping(value = {"/validar" }, method = RequestMethod.POST)
    public ModelAndView principalPaginaValidar(ModelMap model, HttpServletRequest r) {
        Usuario lista=null;
        String usuario=r.getParameter("usuario");
        String clave=r.getParameter("clave");
        lista=servicioUsuario.usuarioLogin(usuario, clave);
        Map<String, Object> modelo=new HashMap<String, Object> ();
        modelo.put("ListaUsuario", lista);       
        if(lista!=null){
        return new ModelAndView(new RedirectView("listUsuario"));
        }else{
        return new ModelAndView("login", modelo);
        }        
    }
    
	@RequestMapping(value = {"/listUsuario"}, method = RequestMethod.GET)
	public ModelAndView listUsuario(ModelMap model) {
            List<Usuario> lista=servicioUsuario.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaUsuario", lista);
            modelo.put("saludo", "Hola amigos");            
            System.out.println("Holassssssssss");
            return new ModelAndView("usuario/mainUsuario", modelo);
	}
    

}
