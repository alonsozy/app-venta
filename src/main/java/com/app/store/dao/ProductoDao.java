package com.app.store.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.store.dto.TProducto;

public interface ProductoDao extends CrudRepository<TProducto, Long> {

	List<TProducto> findByEstado(boolean estado);
	
	@Query("SELECT t FROM TProducto t where t.idProducto = :id and t.estado= :estado")  
	Optional<TProducto> findProdById(Long id, boolean estado);
	
}
