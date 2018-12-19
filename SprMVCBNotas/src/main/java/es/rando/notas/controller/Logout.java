package es.rando.notas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("sessionUser")
@RequestMapping(value = "/logout")
public class Logout {
	
	private static final String INICIO = "index";
	
	@RequestMapping(method=RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus){
		//Destrucción de la sesión
		sessionStatus.setComplete();
		//Hace un redirect, para completar el cierre de sesión
		return INICIO;
	}
    
}
