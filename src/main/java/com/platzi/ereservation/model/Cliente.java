/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Cliente
 * @author GERZON ZAMBRANO
 * La anotación @Data de Lombok interpleta la clase como un pojo y crea internamente los getters and setters y los attributos como privados
 */
@Data
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid" , strategy = "uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	
	//Relación de uno a muchos en un array, un cliente genera varias reservas, pero una reserva pertenece a un cliente
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas;

	
	public Cliente() {

	}
	
	

}
