package Cinebox.com.Modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

	    @Id
	    @Column(name="id_reserva")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idReserva;

	    @ManyToOne
	    @JoinColumn(name = "id_cliente", nullable = false)
	    private Cliente cliente;

	    @ManyToOne
	    @JoinColumn(name = "id_funcion", nullable = false)
	    private Funcion funcion;

	    @Column(name = "cantidad_boletos", nullable = false)
	    private int cantidadBoletos;

	    @Column(name = "total", nullable = false)
	    private BigDecimal total;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_pelicula")
	    private Pelicula pelicula;

	    @Column(name = "fecha_reserva", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    private Timestamp fechaReserva;

		

	
		
		
		   public Long getIdReserva() {
			return idReserva;
		}



		public void setIdReserva(Long idReserva) {
			this.idReserva = idReserva;
		}



		public Cliente getCliente() {
			return cliente;
		}



		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}



		public Funcion getFuncion() {
			return funcion;
		}



		public void setFuncion(Funcion funcion) {
			this.funcion = funcion;
		}



		public int getCantidadBoletos() {
			return cantidadBoletos;
		}



		public void setCantidadBoletos(int cantidadBoletos) {
			this.cantidadBoletos = cantidadBoletos;
		}



		public BigDecimal getTotal() {
			return total;
		}



		public void setTotal(BigDecimal total) {
			this.total = total;
		}



		public Pelicula getPelicula() {
			return pelicula;
		}



		public void setPelicula(Pelicula pelicula) {
			this.pelicula = pelicula;
		}



		public Timestamp getFechaReserva() {
			return fechaReserva;
		}



		public void setFechaReserva(Timestamp fechaReserva) {
			this.fechaReserva = fechaReserva;
		}



		public Reserva() {
		    }

		

		public Reserva(Long idReserva, Cliente cliente, Funcion funcion, int cantidadBoletos, BigDecimal total,
				Timestamp fechaReserva) {
			super();
			this.idReserva = idReserva;
			this.cliente = cliente;
			this.funcion = funcion;
			this.cantidadBoletos = cantidadBoletos;
			this.total = total;
			this.fechaReserva = fechaReserva;
		}
		
		
		@Override
		public String toString() {
			return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", funcion=" + funcion
					+ ", cantidadBoletos=" + cantidadBoletos + ", total=" + total + ", fechaReserva=" + fechaReserva
					+ "]";
		}
	
		

		

	    
	    
	    
	
	
}
