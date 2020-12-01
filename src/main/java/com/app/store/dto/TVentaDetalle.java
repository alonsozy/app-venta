package com.app.store.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_venta_detalle")
public class TVentaDetalle {

	@Id
	@SequenceGenerator(name = "sequence_venta_detalle", sequenceName = "sq_venta_detalle", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_venta_detalle")
	@Column(name = "ventad_iident")
	@Getter @Setter
	private long idVentaD;
	
	@ManyToOne
	@JoinColumn(name = "venta_iident", nullable = false, updatable = false)
	@Getter @Setter
	private TVenta venta;
	
	@Column(name = "prod_iident")
	@Getter @Setter
	private long idProducto;
}
