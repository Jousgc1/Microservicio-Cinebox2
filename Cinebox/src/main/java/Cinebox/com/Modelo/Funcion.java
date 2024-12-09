package Cinebox.com.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "funciones")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcion")
    private Long idFuncion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula", nullable = false, foreignKey = @ForeignKey(name = "fk_funcion_pelicula"))
    private Pelicula pelicula;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "precio", nullable = false)
    private double precio;

    // Constructor sin argumentos
    public Funcion() {
    }

    public Funcion(Long idFuncion, Pelicula pelicula, LocalDate fecha, LocalTime hora, int capacidad, double precio) {
        this.idFuncion = idFuncion;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    // Getters y Setters

    public Long getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Long idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Funcion [idFuncion=" + idFuncion + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora +
                ", capacidad=" + capacidad + ", precio=" + precio + "]";
    }
}
