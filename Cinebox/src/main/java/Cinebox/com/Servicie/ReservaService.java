package Cinebox.com.Servicie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cinebox.com.Modelo.Reserva;
import Cinebox.com.Repository.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public boolean verificarDisponibilidadAsientos(Long idFuncion, int asientosSolicitados) {
        // Aquí puedes agregar la lógica para verificar si hay suficientes asientos disponibles
        return true; // Lógica de ejemplo
    }
}
