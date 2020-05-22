/**
 * 
 */
package com.platzi.ereservation.view.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.business.service.ClienteService;
import com.platzi.ereservation.model.Cliente;
import com.platzi.ereservation.view.resource.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase correspondiente al servicio web del cliente
 * 
 * @author GERZON ZAMBRANO
 *
 */

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		// TODO Auto-generated constructor stub
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {

		Cliente cliente = new Cliente();

		cliente.setNombreCli(clienteVo.getNombreCli());
		cliente.setApellidoCli(clienteVo.getApellidoCli());
		cliente.setDireccionCli(clienteVo.getDireccionCli());
		cliente.setEmailCli(clienteVo.getEmailCli());
		cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		cliente.setIdentificacionCli(clienteVo.getIdentificacionCli());

		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);

	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVo) {

		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);

		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setNombreCli(clienteVo.getNombreCli());
			cliente.setApellidoCli(clienteVo.getApellidoCli());
			cliente.setDireccionCli(clienteVo.getDireccionCli());
			cliente.setEmailCli(clienteVo.getEmailCli());
			cliente.setTelefonoCli(clienteVo.getTelefonoCli());
			cliente.setIdentificacionCli(clienteVo.getIdentificacionCli());

		}

		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);

	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void removeCliente(@PathVariable("identificacion") String identificacion) {

		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);

		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Cliente", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente encontrados"),
			@ApiResponse(code = 404, message = "No se encontro ningun cliente") })
	public ResponseEntity<List<Cliente>> findAll() {

		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
