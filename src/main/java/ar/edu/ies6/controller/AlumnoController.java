package ar.edu.ies6.controller;

import ar.edu.ies6.model.Alumno;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlumnoController {
	
	// Declaración de la lista a nivel de clase para que esté disponible en todos los métodos.
    private List<Alumno> listado = new ArrayList<>();
	
	@GetMapping({"/index", "/", "/home", "/alumno"})
	public ModelAndView cargarAlumno() {
		
		Alumno alu = new Alumno ();
		
		alu.setFechaNac(LocalDate.of(1988, 8, 20));
		System.out.println("Edad: "+alu.obtenerEdad());
		
		ModelAndView modelView = new ModelAndView ("index");
		
		modelView.addObject("alumno", alu);
		
		return modelView;	
	}
	
	@PostMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
 	
		// Carga el objeto 'alumno' en la lista 'listado'.
        listado.add(alumno);
		
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		modelView.addObject("listado", listado);
		
		return modelView;	
	}

}
