/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la entidad de bd de reserva
 * @author GERZON ZAMBRANO
 *
 */
@Data
@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid" , strategy = "uuid2")
	private String idRes;
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	
	//relaciones
	@ManyToOne
	@JoinColumn(name = "idCli") //nombre de la foreign key con la que se une a la clase padre
	private Cliente cliente;
	
	
}
