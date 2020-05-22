/**
 * 
 */
package com.platzi.ereservation.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.business.repository.ClienteRepository;
import com.platzi.ereservation.model.Cliente;

/**
 * Define los servicios de cliente
 * 
 * @author GERZON ZAMBRANO
 *
 */

@Service
@Transactional(readOnly = true)
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;

	}

	/**
	 * Metodo para guardar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Metodo que actualiza un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Metodo para eliminar un cliente
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	/**
	 * Obtiene un cliente por su identificación
	 * 
	 * @param identificacionCli
	 * @return
	 */
	
	public Cliente findByIdentificacion(String identificacionCli) {
		return this.clienteRepository.findByIdentificacionCli(identificacionCli);
	}
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
}
