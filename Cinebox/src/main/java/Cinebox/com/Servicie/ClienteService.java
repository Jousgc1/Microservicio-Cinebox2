package Cinebox.com.Servicie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cinebox.com.Modelo.Cliente;
import Cinebox.com.Repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos los clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Cliente> findById(int id) {
        return clienteRepository.findById(id);
    }

    // Guardar nuevo cliente o actualizar existente
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente por ID
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }
}
