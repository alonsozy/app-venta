package com.app.store.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.store.service.util.Constants.OBSERV;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_cliente")
public class TCliente {

	@Id
	@SequenceGenerator(name = "sequence_cliente", sequenceName = "sq_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cliente")
	@Column(name = "clie_iident")
	@Getter @Setter
	private long idCliente;
	
	@Column(name = "clie_nombre")
	@Getter @Setter
	private String nombre;
	
	@Column(name = "clie_apellido")
	@Getter @Setter
	private String apellido;
	
	@Column(name = "clie_dni")
	@Getter @Setter
	private String dni;
	
	@Column(name = "clie_telefono")
	@Getter @Setter
	private String telefono;
	
	@Column(name = "clie_email")
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private LocalDateTime audit_dfecope;
	
	@Getter @Setter
	private LocalDateTime audit_dfecre;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private OBSERV audit_vobs;
	
	@Getter @Setter
	private String audit_vuser;
	
	public TCliente() {
	}
}
