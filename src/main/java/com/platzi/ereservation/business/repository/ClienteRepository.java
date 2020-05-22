/**
 * 
 */
package com.platzi.ereservation.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Cliente;

/**
 * Interface para definir las operaciones de bases de datos relacionadas con el cliente
 * @author GERZON ZAMBRANO
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	/**
	 * Metodó que obtiene los clientes por su apellido
	 * @param apellidoCli
	 * @return
	 */
	
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	/**
	 * Obtiene un cliente por su identificación 
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacionCli(String identificacionCli);
	
	

}
