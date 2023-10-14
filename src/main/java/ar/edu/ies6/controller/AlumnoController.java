package ar.edu.ies6.controller;

import ar.edu.ies6.model.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlumnoController {
	
	@GetMapping({"/index", "/", "/home", "/alumno"})
	public ModelAndView cargarAlumno() {
		
		Alumno alu = new Alumno ();
		
		ModelAndView modelView = new ModelAndView ("index");
		
		modelView.addObject("alumno", alu);
		
		return modelView;
		
	}

}
