package Cinebox.com.Controller;

import Cinebox.com.Modelo.Funcion;
import Cinebox.com.Servicie.FuncionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionServicio;

    @GetMapping()
    public String listarFunciones(Model model) {
        List<Funcion> funciones = funcionServicio.listarFunciones();
        model.addAttribute("funciones", funciones);
        return "listaFunciones"; // Nombre del template HTML
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearFuncion(Model model) {
        model.addAttribute("funcion", new Funcion());
        return "crearFuncion";
    }

    @PostMapping("/crear")
    public String crearFuncion(@ModelAttribute Funcion funcion) {
        funcionServicio.crearFuncion(funcion);
        return "redirect:/funciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarFuncion(@PathVariable Long id, Model model) {
        Funcion funcion = funcionServicio.obtenerFuncionPorId(id);
        model.addAttribute("funcion", funcion);
        return "editarFuncion";
    }

    @PostMapping("/editar/{id}")
    public String editarFuncion(@PathVariable Long id, @ModelAttribute Funcion funcionActualizada) {
        Funcion funcion = funcionServicio.obtenerFuncionPorId(id);
        if (funcion != null) {
            funcion.setPelicula(funcionActualizada.getPelicula());
            funcion.setFecha(funcionActualizada.getFecha());
            funcion.setHora(funcionActualizada.getHora());
            funcion.setCapacidad(funcionActualizada.getCapacidad());
            funcion.setPrecio(funcionActualizada.getPrecio());
            funcionServicio.actualizarFuncion(funcion);
        }
        return "redirect:/funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFuncion(@PathVariable Long id) {
        funcionServicio.eliminarFuncion(id);
        return "redirect:/funciones";
    }
}
