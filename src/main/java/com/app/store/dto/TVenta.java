package com.app.store.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.store.service.util.Constants.OBSERV;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_venta")
public class TVenta {

	@Id
	@SequenceGenerator(name = "sequence_venta", sequenceName = "sq_venta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_venta")
	@Column(name = "venta_iident")
	@Getter @Setter
	private long idVenta;
	
	@Column(name = "clie_iident")
	@Getter @Setter
	private long idCliente;
	
	@Column(name = "venta_fecha")
	@Getter @Setter
	private LocalDateTime fecha;
	
	@Getter @Setter
	private LocalDateTime audit_dfecope;
	
	@Getter @Setter
	private LocalDateTime audit_dfecre;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private OBSERV audit_vobs;
	
	@Getter @Setter
	private String audit_vuser;
	
	@Getter @Setter
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL,
		    fetch = FetchType.LAZY)
	private List<TVentaDetalle> detalle;
}
