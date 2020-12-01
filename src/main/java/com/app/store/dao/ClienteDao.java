package com.app.store.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.store.dto.TCliente;

public interface ClienteDao extends CrudRepository<TCliente, Long> {

}
