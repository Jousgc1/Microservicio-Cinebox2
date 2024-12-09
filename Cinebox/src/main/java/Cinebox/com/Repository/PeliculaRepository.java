package Cinebox.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Cinebox.com.Modelo.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
