package es.rando.notas.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.rando.notas.interceptor.LoginInterceptor;
import es.rando.notas.model.Nota;
import es.rando.notas.model.Usuario;
import es.rando.notas.service.NotaSvc;
import es.rando.notas.service.UsuarioSvc;

@Controller
@SessionAttributes("sessionUser")
public class Login {
	
	private static final String ATT_ERROR = "error";
	private static final String ATT_UNLOGIN = "msg";
	private static final String ATT_TEMAS = "temas";
	private static final String ATT_TITULOS = "titulos";
	private static final String ATT_VALORES = "valores";

	private static final String SUCCESS = "menu";
	private static final String UNSUCCESS = "index";
	private static final String ERROR = "error";
	
	@Autowired
	private UsuarioSvc usuarioSvc;
	
	@Autowired
	private NotaSvc notaSvc;
	
	@Autowired
	private MessageSource messages;

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String execute(@ModelAttribute Nota nota, @ModelAttribute Usuario usuario, Model model, @RequestParam("user") String user, @RequestParam("pass") String pass, Locale locale) {
		
		try {		
			if (usuarioSvc.findByApodoClave(user, pass)) {	
				
				usuario = usuarioSvc.findByUserPass(user, pass);				
				model.addAttribute(LoginInterceptor.ATT_USER, usuario);	
				
				//TODO...	
				model.addAttribute(ATT_TEMAS, notaSvc.findByNotasUsuario(usuario.getIdUsuario()));	

				return SUCCESS;
			}
			else {				
				model.addAttribute(ATT_UNLOGIN, messages.getMessage("mensaje.nologin", null, locale));
				return UNSUCCESS;
			}
			
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}	
	}
	
}
