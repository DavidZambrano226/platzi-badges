/**
 * 
 */
package com.platzi.ereservation.business.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.model.Reserva;

/**
 * Interface para definir las operaciones de bases de datos relacionadas con las reservas
 * @author GERZON ZAMBRANO
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

	/**
	 * Consultas en lenguaje JPQL donde se obtienen las reservas por un rango de fechas predeterminadas
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	@Query("Select r from Reserva r where r.fechaIngresoRes =: fechaInicio and r.fechaSalidaRes =: fechaSalida")
	public List<Reserva> findDate(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);
	
}
