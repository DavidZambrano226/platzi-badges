/**
 * 
 */
package com.platzi.ereservation.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.ereservation.business.repository.ReservaRepository;
import com.platzi.ereservation.model.Reserva;

/**
 * Define los servicios para las reservas.
 * @author GERZON ZAMBRANO
 *
 */
@Service
public class ReservaService {
	
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		// TODO Auto-generated constructor stub
		this.reservaRepository = reservaRepository;
	}
	
	/**
	 * Metodo para guardar una reserva
	 * @param reserva
	 * @return
	 */
	public Reserva save(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	/**
	 * Metodo para actualizar una reserva
	 * @param reserva
	 * @return
	 */
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	/**
	 * Metodo para eliminar una reserva
	 * @param reserva
	 */
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	/**
	 * Metodo que obtiene las reservas dependiendo de unas fechas de inicio y de fin
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	
	public List<Reserva> findDate(Date fechaInicio, Date fechaSalida){
		
		return this.reservaRepository.findDate(fechaInicio, fechaSalida);
		
	}

}
