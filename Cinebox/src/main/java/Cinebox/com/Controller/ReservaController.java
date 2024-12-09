package Cinebox.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Cinebox.com.Modelo.Reserva;
import Cinebox.com.Servicie.ReservaService;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/total")
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaService.findAll();
        model.addAttribute("reservas", reservas);
        return "Reserva"; // Vista Thymeleaf para listar reservas
    }

    @GetMapping("/crear")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "CrearReserva"; // Vista Thymeleaf para crear una reserva
    }

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Reserva reserva = reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));
        model.addAttribute("reserva", reserva);
        return "reservas/editar"; // Vista Thymeleaf para editar una reserva
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarReserva(@PathVariable("id") Long id, @ModelAttribute("reserva") Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable("id") Long id) {
        reservaService.deleteById(id);
        return "redirect:/reservas";
    }
}
