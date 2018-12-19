package es.rando.notas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.rando.notas.model.Usuario;
import es.rando.notas.service.NotaSvc;

@Controller
public class Listar {

	private static final String ATT_ERROR = "error";
	private static final String ATT_LISTA = "lista";
	public static final String ATT_USER = "sessionUser";
	private static final String ATT_USERIDENT = "identidad";
	
	private static final String SUCCESS = "listado";
	private static final String ERROR = "error";
	
	@Autowired
	private NotaSvc notaSvc;
	
	@RequestMapping(value="/listar", method=RequestMethod.POST)//, @RequestParam("grupo") String radio
    public String execute(HttpServletRequest request, Model model){
    	try {
    		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
    		if (usuario != null) {
    			model.addAttribute(ATT_USERIDENT, usuario.getApellidos());
    			model.addAttribute(ATT_LISTA, notaSvc.findAll());
			}
    		
//    		switch (radio) {
//    		
//			case "tema":	model.addAttribute(ATT_LISTA, notaSvc.findByNotasUsuario(usuario.getIdUsuario()));							
//				break;
//			case "titulo":	model.addAttribute(ATT_LISTA, notaSvc.findByNotasUsuario(usuario.getIdUsuario()));
//				break;
//			case "valor":	model.addAttribute(ATT_LISTA, notaSvc.findByNotasUsuario(usuario.getIdUsuario()));
//				break;
//
//			default:	model.addAttribute(ATT_LISTA, notaSvc.findAll());
//				break;
//			}
						
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }		
}
