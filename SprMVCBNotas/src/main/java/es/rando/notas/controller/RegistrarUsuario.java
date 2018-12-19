package es.rando.notas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.rando.notas.model.Usuario;
import es.rando.notas.service.UsuarioSvc;

@Controller
@RequestMapping(value = "/registrar")
public class RegistrarUsuario {

	private static final String ATT_USER = "usuario";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";
	private static final String MSG_ERROR = "usuario.registro.error";
	
	private static final String SUCCESS = "index";
	private static final String UNSUCCESS = "registrouser";
	private static final String ERROR = "error";
	
	@Autowired
	private UsuarioSvc usuarioSvc;

	@Autowired
	private MessageSource messages;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String haciaFormNuevoUsuario(@ModelAttribute Usuario usuario, Model model) {
		try {	
			return UNSUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarNuevoUsuario(@Valid Usuario usuario, BindingResult result, Model model, @RequestParam("dni") String dni, @RequestParam("email") String email, @RequestParam("apodoUsuario") String apodoUsuario, Locale locale) {
		try {
			if(result.hasErrors()) {
				//model.addAttribute(ATT_USER, new Usuario());
				return UNSUCCESS;
			}
			
			//comprobar que usuario nuevo no existe ni por dni, ni email, ni apodo,...	
			if(usuarioSvc.findByDni(dni) || usuarioSvc.findByEmail(email) || usuarioSvc.findByApodo(apodoUsuario)) {
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.noregitrado", null, locale));
				model.addAttribute(ATT_USER, new Usuario());
				return UNSUCCESS;
			}
			else {	
				usuarioSvc.save(usuario);
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.regitrado", null, locale));				
			}
						
			return SUCCESS;		
		} catch (Exception e) {
			result.reject(MSG_ERROR);
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
