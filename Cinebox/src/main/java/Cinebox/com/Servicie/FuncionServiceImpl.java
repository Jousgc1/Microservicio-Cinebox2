package Cinebox.com.Servicie;

import Cinebox.com.Modelo.Funcion;
import Cinebox.com.Repository.FuncionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionRepository funcionRepositorio;

    @Override
    public List<Funcion> listarFunciones() {
        return funcionRepositorio.findAll();
    }

    @Override
    public Funcion obtenerFuncionPorId(Long id) {
        return funcionRepositorio.findById(id).orElse(null);
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return funcionRepositorio.save(funcion);
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) {
        return funcionRepositorio.save(funcion);
    }

    @Override
    public void eliminarFuncion(Long id) {
        funcionRepositorio.deleteById(id);
    }
}
