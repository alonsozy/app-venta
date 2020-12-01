package com.app.store.dto;

import java.math.BigDecimal;
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
@Table(name = "t_producto")
public class TProducto {

	@Id
	@SequenceGenerator(name = "sequence_producto", sequenceName = "sq_producto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_producto")
	@Column(name = "prod_iident")
	@Getter @Setter
	private long idProducto;
	
	@Column(name = "prod_name")
	@Getter @Setter
	private String nombre;
	
	@Column(name = "prod_price")
	@Getter @Setter
	private BigDecimal precio;
	
	@Column(name = "prod_status")
	@Getter @Setter
	private Boolean estado;
	
	@Getter @Setter
	private LocalDateTime audit_dfecope;
	
	@Getter @Setter
	private LocalDateTime audit_dfecre;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private OBSERV audit_vobs;
	
	@Getter @Setter
	private String audit_vuser;
	
	
}
