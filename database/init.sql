CREATE SEQUENCE public.sq_cliente
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  CREATE SEQUENCE public.sq_producto
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


  CREATE SEQUENCE public.sq_venta
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  CREATE SEQUENCE public.sq_venta_detalle
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
  -- Table: public.t_cliente

-- DROP TABLE public.t_cliente;

CREATE TABLE public.t_cliente
(
  clie_iident bigint NOT NULL,
  clie_apellido character varying(255),
  audit_dfecope timestamp without time zone,
  audit_dfecre timestamp without time zone,
  audit_vobs character varying(255),
  audit_vuser character varying(255),
  clie_dni character varying(255),
  clie_email character varying(255),
  clie_nombre character varying(255),
  clie_telefono character varying(255),
  CONSTRAINT t_cliente_pkey PRIMARY KEY (clie_iident)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.t_cliente
  OWNER TO postgres;
  
  
-- Table: public.t_producto

-- DROP TABLE public.t_producto;

CREATE TABLE public.t_producto
(
  prod_iident bigint NOT NULL,
  prod_name character varying(50),
  prod_price numeric(5,4),
  CONSTRAINT pk_user_id PRIMARY KEY (prod_iident)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.t_producto
  OWNER TO postgres;
  
-- Table: public.t_venta

-- DROP TABLE public.t_venta;

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
ALTER TABLE public.t_venta
  OWNER TO postgres;
  
-- Table: public.t_venta_detalle

-- DROP TABLE public.t_venta_detalle;

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
ALTER TABLE public.t_venta_detalle
  OWNER TO postgres;
 