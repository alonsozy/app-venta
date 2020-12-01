CREATE TABLE public.t_producto
(
  prod_iident bigint NOT NULL,
  prod_name character varying(50),
  prod_lastname numeric(5,4),
  CONSTRAINT pk_user_id PRIMARY KEY (prod_iident)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public.t_cliente
(
  clie_iident bigint NOT NULL,
  clie_nombre character varying(50),
  clie_apellido character varying(80),
  clie_dni character varying(8),
  clie_telefono character varying(15),
  clie_email character varying(80),
  clie_estado character(1),
  audit_dfecope timestamp without time zone,
  audit_dfecre timestamp without time zone,
  audit_vobs character varying(255),
  audit_vuser character varying(255),
  CONSTRAINT pk_clie_id PRIMARY KEY (clie_iident)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE public.t_venta
(
  venta_iident bigint NOT NULL,
  clie_iident bigint,
  prod_lastname numeric(5,4),
  venta_fecha timestamp without time zone,
  audit_dfecope timestamp without time zone,
  audit_dfecre timestamp without time zone,
  audit_vobs character varying(255),
  audit_vuser character varying(255),
  CONSTRAINT pk_venta_id PRIMARY KEY (venta_iident)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public.t_venta_detalle
(
  ventad_iident bigint NOT NULL,
  venta_iident bigint,
  prod_iident bigint,
  audit_dfecope timestamp without time zone,
  audit_dfecre timestamp without time zone,
  audit_vobs character varying(255),
  audit_vuser character varying(255),
  CONSTRAINT pk_venta_detalle_id PRIMARY KEY (ventad_iident)
)
WITH (
  OIDS=FALSE
);