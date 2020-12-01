package com.app.store.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.store.dao.ClienteDao;
import com.app.store.dto.TCliente;
import com.app.store.entity.Cliente;
import com.app.store.service.util.Constants.OBSERV;

@Service
public class ClienteServiceImpl implements IClientService {

	@Autowired
	ClienteDao clienteDao;

	/**
	 * <p> Metodo para registrar la entidad Cliente en la tabla T_CLIENTE
	 * </p>
	 * @author Alonso
	 * @param Objeto Cliente
	 * @return Entidad Cliente registrada en BD
	 */
	@Override
	public Cliente createClient(Cliente cliente) {
		// TODO Auto-generated method stub
		TCliente _t = new TCliente();
		_t.setApellido(cliente.getApellido());
		_t.setNombre(cliente.getNombre());
		_t.setDni(cliente.getDni());
		_t.setEmail(cliente.getEmail());
		_t.setTelefono(cliente.getTelefono());

		_t.setAudit_dfecope(null);
		_t.setAudit_vobs(OBSERV.CREATE);
		_t.setAudit_vuser("ROOT");
		_t.setAudit_dfecre(LocalDateTime.now());
		_t=clienteDao.save(_t);
		
		return setCliente(_t);
	}
	
	/**
	 * <p> Metodo para homologar los valores de la entidad de persistencia(TCliente) con la entidad a retornar por los controladores (cliente)
	 * </p>
	 * @author Alonso
	 * @param Entidad TCliente
	 * @return Entidad Cliente
	 */
	public Cliente setCliente(TCliente t) {
		Cliente t1= new Cliente();
		t1.setApellido(t.getApellido());
		t1.setNombre(t.getNombre());
		t1.setIdCliente(t.getIdCliente());
		t1.setDni(t.getDni());
		t1.setEmail(t.getEmail());
		t1.setTelefono(t.getTelefono());
		return t1;
	}

}
