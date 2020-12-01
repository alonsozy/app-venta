package com.app.store.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.store.dto.TVenta;

public interface VentaDao extends CrudRepository<TVenta, Long> {

	@Query("SELECT t FROM TVenta t where t.idVenta = :id ")
	Optional<TVenta> findVentaById(Long id);
}
