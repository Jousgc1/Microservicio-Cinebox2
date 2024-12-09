package Cinebox.com.Controller;



import Cinebox.com.Modelo.Combo;
import Cinebox.com.Servicie.ComboService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/combos")
public class ComboController {

    private final ComboService comboService;

    @Autowired
    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @GetMapping()
    public String listarCombos(Model model) {
        List<Combo> combos = comboService.FindAllCombo();
        model.addAttribute("combos", combos);
        return "Combo"; // Nombre de la plantilla Thymeleaf para listar combos
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearCombo(Model model) {
        model.addAttribute("combo", new Combo());
        return "crearCombo"; // Nombre de la plantilla Thymeleaf para crear un combo
    }

    @PostMapping("/guardar")
    public String guardarCombo(@ModelAttribute Combo combo) {
        comboService.saveCombo(combo);
        return "redirect:/combos"; // Redirigir a la lista de combos después de guardar
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCombo(@PathVariable Long id, Model model) {
        Combo combo = comboService.findComboById(id).orElseThrow(() -> new IllegalArgumentException("Invalid combo ID: " + id));
        model.addAttribute("combo", combo);
        return "EditarCombo"; // Nombre de la plantilla Thymeleaf para editar un combo
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCombo(@PathVariable Long id, @ModelAttribute Combo combo) {
        combo.setIdCombo(id);  // Asignamos el ID recibido en la URL al objeto Combo
        comboService.saveCombo(combo);  // Guardamos o actualizamos el combo
        return "redirect:/combos";  // Redirigimos a la página de lista de combos
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCombo(@PathVariable Long id) {
        comboService.deleteCombo(id);
        return "redirect:/combos"; // Redirigir a la lista de combos después de eliminar
    }
}
