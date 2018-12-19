package es.rando.notas.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.rando.notas.model.Nota;
import es.rando.notas.model.Usuario;
import es.rando.notas.service.NotaSvc;
import es.rando.notas.service.TemaSvc;

@Controller
//@SessionAttributes("sessionUser")
public class Guardar {
	
	private static final String ATT_ITEM = "nota";
	private static final String ATT_LISTA = "lista";
	public static final String ATT_USER = "sessionUser";
	private static final String ATT_USERIDENT = "identidad";
	
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";
	
	private static final String SUCCESS = "nuevanota";
	private static final String ERROR = "error";

	@Autowired
	private TemaSvc temaSvc;

	@Autowired
	private NotaSvc notaSvc;

	@Autowired
	private MessageSource messages;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/*PARA PETICI�N DE MENU:
	 * - PARA PRESENTAR FORMULARIO A RELLENAR PARA GUARDAR NOTA NUEVA*/
	@RequestMapping(value = "/guardar", method = RequestMethod.GET)
	public String vistaNuevaNota(HttpServletRequest request, @ModelAttribute Nota nota, Model model) {
		try {
			//para cargar temas existentes en el desplegable de la vista
			model.addAttribute(ATT_LISTA, temaSvc.findAll());
			Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
    		if (usuario != null) {
    			nota.setUsuario(usuario);
    			model.addAttribute(ATT_USERIDENT, usuario.getApellidos());
			}
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/*PARA PETICI�N DE NUEVANOTA: 
	 * - PARA GUARDAR DATOS NUEVOS 
	 * - O EDITARLOS (cargando en formulario los datos a editar desde Listar.java)*/
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String vistaNuevaNota(@ModelAttribute Nota nota, Model model, Locale locale) {
		try {
			model.addAttribute(ATT_LISTA, temaSvc.findAll());

			if (nota.getIdNota() == null) {//implica que es nuevo registro
				notaSvc.save(nota);
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exitoguardado", null, locale));
			} else {//el registro existe
				notaSvc.update(nota);
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exitoactualizado", null, locale));
			}

			// Limpiar formulario
			model.addAttribute(ATT_ITEM, new Nota());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
