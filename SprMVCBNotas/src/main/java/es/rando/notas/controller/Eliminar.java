package es.rando.notas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestParam;

import es.rando.notas.model.Nota;
import es.rando.notas.service.NotaSvc;
import es.rando.notas.service.TemaSvc;

@Controller
@RequestMapping(value = "/eliminar")
public class Eliminar {

	//para ser usado en la vista...
			private static final String ATT_ITEM = "nota";
			private static final String ATT_LISTA = "lista";
			private static final String ATT_EXITO = "msg";
			private static final String ATT_ERROR = "error";
			//es .jsp, ver mvc-dispatcher-servlet.xml
			private static final String SUCCESS = "listado";
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
			
			@RequestMapping(method=RequestMethod.GET)
		    public String execute(@ModelAttribute Nota nota, @RequestParam int id, Model model, Locale locale) {
				try {					
					notaSvc.delete(notaSvc.findById(id));	
					
					model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exitoguardado", null, locale));
					model.addAttribute(ATT_LISTA, notaSvc.findAll());
					
					return SUCCESS;
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		    }
}
