package Cinebox.com.Servicie;

import java.util.List;


import Cinebox.com.Modelo.Funcion;


public interface FuncionService {
	
	

	
	    List<Funcion> listarFunciones();
	    Funcion obtenerFuncionPorId(Long id);
	    Funcion crearFuncion(Funcion funcion);
	    Funcion actualizarFuncion(Funcion funcion);
	    void eliminarFuncion(Long id);



}
