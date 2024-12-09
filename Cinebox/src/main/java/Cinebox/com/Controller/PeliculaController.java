package Cinebox.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cinebox.com.Modelo.Pelicula;
import Cinebox.com.Servicie.PeliculaService;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;
    
    
    
    @GetMapping("/cinebox")
	public String getMethodName(Model model) {
    	 List<Pelicula> peliculas = peliculaService.listarPeliculas();
         model.addAttribute("peliculas", peliculas);
		return "Inicio";
	}

    @GetMapping()
    public String listarPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "peliculas";  // Nombre del template HTML
    }
    
    
    @GetMapping("/crear")
    public String mostrarFormularioCrearCombo(Model model){
    	model.addAttribute("pelicula",new Pelicula());
    	return "crearPelicula";
    	
    }
    
    @PostMapping("/crear")
    public String crearPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.crearPelicula(pelicula);
        return "redirect:/peliculas"; // Redirigir al listado de películas
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id){
    	peliculaService.eliminarPelicula(id);
    	return "redirect:/peliculas";
    	
    }
    
    
    
    
    
}
