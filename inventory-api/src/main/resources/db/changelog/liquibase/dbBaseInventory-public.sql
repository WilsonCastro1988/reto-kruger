-- public.aplicacion definition

-- Drop table

-- DROP TABLE public.aplicacion;

CREATE TABLE public.aplicacion (
	id_aplicacion int4 NOT NULL,
	activo_aplicacion bool NULL,
	banner_aplicacion varchar(255) NULL,
	descripcion_aplicacion varchar(255) NULL,
	icono_aplicacion varchar(255) NULL,
	nombre_aplicacion varchar(255) NULL,
	url_aplicacion varchar(255) NULL,
	CONSTRAINT aplicacion_pkey PRIMARY KEY (id_aplicacion)
);


-- public.perfil definition

-- Drop table

-- DROP TABLE public.perfil;

CREATE TABLE public.perfil (
	id_perfil int4 NOT NULL,
	activo_perfil bool NULL,
	descripcion_perfil varchar(255) NULL,
	nombre_perfil varchar(255) NULL,
	CONSTRAINT perfil_pkey PRIMARY KEY (id_perfil)
);


-- public.usuario definition

-- Drop table

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario (
	nombre_usuario varchar(255) NOT NULL,
	activo_usuario bool NULL,
	apellidos_usuario varchar(255) NULL,
	dni_usuario varchar(255) NULL,
	email varchar(255) NULL,
	email_personal_usuario varchar(255) NULL,
	fa_usuario bool NULL,
	fecha_actualizacion_usuario timestamp NULL,
	fecha_creacion_usuario timestamp NULL,
	foto_usuario varchar(255) NULL,
	intentos_usuario int4 NULL,
	nombres_usuario varchar(255) NULL,
	"password" varchar(255) NULL,
	tipo2fa_usuario varchar(255) NULL,
	tipo_dni_usuario varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (nombre_usuario)
);


-- public.menu definition

-- Drop table

-- DROP TABLE public.menu;

CREATE TABLE public.menu (
	id_menu int4 NOT NULL,
	activo_menu bool NULL,
	aperturado_menu bool NULL,
	descripcion_menu varchar(255) NULL,
	fecha_apertura_menu timestamp NULL,
	fecha_cierre_menu timestamp NULL,
	icono_menu varchar(255) NULL,
	iconopos_menu varchar(255) NULL,
	id_aplicaciones int4 NULL,
	id_menu_padre int4 NULL,
	label_menu varchar(255) NULL,
	nombre_menu varchar(255) NULL,
	orden_menu int4 NULL,
	tipo_menu varchar(255) NULL,
	url_menu varchar(255) NULL,
	id_aplicacion int4 NULL,
	men_id_menu int4 NULL,
	CONSTRAINT menu_pkey PRIMARY KEY (id_menu),
	CONSTRAINT fkcu6c5p4o4871w1mh7e426lgsc FOREIGN KEY (id_aplicacion) REFERENCES public.aplicacion(id_aplicacion),
	CONSTRAINT fks7vdaa2m5ji0fh3w6l7m9bcn0 FOREIGN KEY (men_id_menu) REFERENCES public.menu(id_menu)
);


-- public.usuario_perfil definition

-- Drop table

-- DROP TABLE public.usuario_perfil;

CREATE TABLE public.usuario_perfil (
	id_perfil int4 NOT NULL,
	nombre_usuario varchar(255) NOT NULL,
	activo_perfil_usuario bool NULL,
	CONSTRAINT usuario_perfil_pkey PRIMARY KEY (id_perfil, nombre_usuario),
	CONSTRAINT fk3cxlmf5q4y8mllkos025n9px8 FOREIGN KEY (id_perfil) REFERENCES public.perfil(id_perfil),
	CONSTRAINT fks7jkkv0j929bqlqsxko97ele4 FOREIGN KEY (nombre_usuario) REFERENCES public.usuario(nombre_usuario)
);


-- public.autorizacion definition

-- Drop table

-- DROP TABLE public.autorizacion;

CREATE TABLE public.autorizacion (
	id_autorizacion int4 NOT NULL,
	activo_autorizacion bool NULL,
	id_menus int4 NULL,
	id_perfiles int4 NULL,
	permisos_autorizacion varchar(255) NULL,
	id_menu int4 NULL,
	id_perfil int4 NULL,
	CONSTRAINT autorizacion_pkey PRIMARY KEY (id_autorizacion),
	CONSTRAINT fk3vvh5nfs5gbbpu1i4n2kx5t2 FOREIGN KEY (id_perfil) REFERENCES public.perfil(id_perfil),
	CONSTRAINT fkiv5yfucctnibmm0o75ob0yd2u FOREIGN KEY (id_menu) REFERENCES public.menu(id_menu)
);