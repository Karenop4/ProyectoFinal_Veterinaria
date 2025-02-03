CREATE TABLE vet_citas (
    cita_id              NUMBER(5) NOT NULL,
    cita_fecha           TIMESTAMP(0) NOT NULL,
    cita_estado          VARCHAR2(1) NOT NULL,
    vet_mascotas_masc_id NUMBER(5) NOT NULL,
    vet_personas_per_id  NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vet_citas.cita_id IS
    'Codigo Unico de la cita';

COMMENT ON COLUMN vet_citas.cita_fecha IS
    'Fecha agendada para la cita';

COMMENT ON COLUMN vet_citas.cita_estado IS
    'el estado de la cita será activo ''A'' o cancelada ''C''';

ALTER TABLE vet_citas ADD CONSTRAINT vet_citas_pk PRIMARY KEY ( cita_id );

CREATE TABLE vet_detalles_fac (
    facd_id                   NUMBER(5) NOT NULL,
    facd_cantidad             NUMBER(3) NOT NULL,
    facd_subtotal             NUMBER(5, 2) NOT NULL,
    facd_valoriva             NUMBER(5, 2) NOT NULL,
    fac_total                 NUMBER(6, 2) NOT NULL,
    facd_precios              NUMBER(5, 2) NOT NULL,
    vet_servicios_serv_codigo NUMBER(5) NOT NULL,
    vet_facturas_fac_id       NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vet_detalles_fac.facd_id IS
    'Codigo Unico del detalle de factura';

COMMENT ON COLUMN vet_detalles_fac.facd_cantidad IS
    'Cantidad facturada de los servicios';

COMMENT ON COLUMN vet_detalles_fac.facd_subtotal IS
    'Subtotal por la cantidad de  servicios o productos, precio unitario x cantidad';

COMMENT ON COLUMN vet_detalles_fac.facd_valoriva IS
    'Valor del IVA aplicado total del servicio';

COMMENT ON COLUMN vet_detalles_fac.fac_total IS
    'Total a pagar por el servicio';

COMMENT ON COLUMN vet_detalles_fac.facd_precios IS
    'Precio por el servicio otorgado (individualmente)';

ALTER TABLE vet_detalles_fac ADD CONSTRAINT vet_detalles_fac_pk PRIMARY KEY ( facd_id );

CREATE TABLE vet_facturas (
    fac_id              NUMBER(5) NOT NULL,
    fac_fecha           DATE NOT NULL,
    fac_subtotal        NUMBER(5, 2) NOT NULL,
    fac_totaliva        NUMBER(5, 2) NOT NULL,
    fac_total           NUMBER(6, 2) NOT NULL,
    vet_usuarios_us_id  NUMBER(5) NOT NULL,
    vet_personas_per_id NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vet_facturas.fac_id IS
    'Codigo Unico de la factura';

COMMENT ON COLUMN vet_facturas.fac_fecha IS
    'Fecha de emision de la factura';

COMMENT ON COLUMN vet_facturas.fac_subtotal IS
    'Subtotal de la factura';

COMMENT ON COLUMN vet_facturas.fac_totaliva IS
    'Valor total del IVA a pagar';

COMMENT ON COLUMN vet_facturas.fac_total IS
    'Total a pagar';

ALTER TABLE vet_facturas ADD CONSTRAINT vet_facturas_pk PRIMARY KEY ( fac_id );

CREATE TABLE vet_mascotas (
    masc_id                    NUMBER(5) NOT NULL,
    masc_nombre                VARCHAR2(50) NOT NULL,
    vet_personas_per_id        NUMBER(5) NOT NULL,
    vet_tiposmascotas_tipom_id VARCHAR2(5) NOT NULL
);

COMMENT ON COLUMN vet_mascotas.masc_id IS
    'Codigo Unico de la mascota';

COMMENT ON COLUMN vet_mascotas.masc_nombre IS
    'Nombre(s) de la mascota';

ALTER TABLE vet_mascotas ADD CONSTRAINT vet_mascotas_pk PRIMARY KEY ( masc_id );

CREATE TABLE vet_personas (
    per_id          NUMBER(5) NOT NULL,
    per_cedula      VARCHAR2(10) NOT NULL,
    per_nombre      VARCHAR2(50) NOT NULL,
    per_apellido    VARCHAR2(50) NOT NULL,
    per_direccion   VARCHAR2(100) NOT NULL,
    per_telefono    VARCHAR2(10) NOT NULL,
    per_correo      VARCHAR2(100) NOT NULL,
    per_coe         CHAR(1) NOT NULL,
    per_empleadoaov CHAR(1),
    per_estado      CHAR(1) NOT NULL
);

COMMENT ON COLUMN vet_personas.per_id IS
    'Codigo Unico de la persona';

COMMENT ON COLUMN vet_personas.per_cedula IS
    'Cedula de la persona';

COMMENT ON COLUMN vet_personas.per_nombre IS
    'Nombre(s) de la persona';

COMMENT ON COLUMN vet_personas.per_apellido IS
    'Apellido(s) de la persona';

COMMENT ON COLUMN vet_personas.per_direccion IS
    'Direccion de domicilio de la persona';

COMMENT ON COLUMN vet_personas.per_telefono IS
    'Numero de contacto de la persona';

COMMENT ON COLUMN vet_personas.per_correo IS
    'Correo electronico de la persona';

COMMENT ON COLUMN vet_personas.per_coe IS
    'C si es cliente o E si es empleado';

COMMENT ON COLUMN vet_personas.per_empleadoaov IS
    'A si es un empleado que brinda atencion al cliente o V si es veterinario';

COMMENT ON COLUMN vet_personas.per_estado IS
    'A si está activo o I si esta inactivo';

ALTER TABLE vet_personas ADD CONSTRAINT vet_personas_pk PRIMARY KEY ( per_id );

CREATE TABLE vet_razas (
    raza_id                    VARCHAR2(5) NOT NULL,
    raza_nombre                VARCHAR2(20) NOT NULL,
    vet_tiposmascotas_tipom_id VARCHAR2(5) NOT NULL
);

COMMENT ON COLUMN vet_razas.raza_id IS
    'Codigo unico de la raza';

COMMENT ON COLUMN vet_razas.raza_nombre IS
    'Raza de la mascota';

ALTER TABLE vet_razas ADD CONSTRAINT vet_razas_pk PRIMARY KEY ( raza_id );

CREATE TABLE vet_servicios (
    serv_codigo NUMBER(5) NOT NULL,
    serv_nombre VARCHAR2(50) NOT NULL,
    serv_precio NUMBER(5, 2) NOT NULL,
    serv_estado CHAR(1) NOT NULL,
    serv_iva    CHAR(1) NOT NULL
);

COMMENT ON COLUMN vet_servicios.serv_codigo IS
    'Codigo Unico del servicio';

COMMENT ON COLUMN vet_servicios.serv_nombre IS
    'Nombre del servicio';

COMMENT ON COLUMN vet_servicios.serv_precio IS
    'Precio del servicio';

COMMENT ON COLUMN vet_servicios.serv_estado IS
    'A si está activo o I si esta inactivo';

COMMENT ON COLUMN vet_servicios.serv_iva IS
    'S si posee IVA o N en caso contrario';

ALTER TABLE vet_servicios ADD CONSTRAINT vet_servicios_pk PRIMARY KEY ( serv_codigo );

CREATE TABLE vet_tiposmascotas (
    tipom_id     VARCHAR2(5) NOT NULL,
    tipom_nombre VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN vet_tiposmascotas.tipom_id IS
    'Codigo unico del tipo de mascota';

COMMENT ON COLUMN vet_tiposmascotas.tipom_nombre IS
    'Nombre del tipo de mascota (Perro, gato, hamster, tortuga, etc)';

ALTER TABLE vet_tiposmascotas ADD CONSTRAINT vet_tiposmascotas_pk PRIMARY KEY ( tipom_id );

CREATE TABLE vet_usuarios (
    us_id               NUMBER(5) NOT NULL,
    us_usuario          VARCHAR2(10) NOT NULL,
    us_contrasenia      VARCHAR2(10) NOT NULL,
    us_tipo             CHAR(1) NOT NULL,
    vet_personas_per_id NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vet_usuarios.us_id IS
    'Codigo Unico del usuario';

COMMENT ON COLUMN vet_usuarios.us_usuario IS
    'Usuario (longitud max. de 10 caracteres)';

COMMENT ON COLUMN vet_usuarios.us_contrasenia IS
    'Contraseña del usuario (longitud max. de 10 caracteres)';

COMMENT ON COLUMN vet_usuarios.us_tipo IS
    'G si es un usuario  general o A si es un usaurio  administrativo';

CREATE UNIQUE INDEX vet_usuarios__idx ON
    vet_usuarios (
        vet_personas_per_id
    ASC );

ALTER TABLE vet_usuarios ADD CONSTRAINT vet_usuarios_pk PRIMARY KEY ( us_id );

ALTER TABLE vet_citas
    ADD CONSTRAINT vet_citas_vet_mascotas_fk FOREIGN KEY ( vet_mascotas_masc_id )
        REFERENCES vet_mascotas ( masc_id );

ALTER TABLE vet_citas
    ADD CONSTRAINT vet_citas_vet_personas_fk FOREIGN KEY ( vet_personas_per_id )
        REFERENCES vet_personas ( per_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE vet_detalles_fac
    ADD CONSTRAINT vet_detalles_fac_vet_facturas_fk FOREIGN KEY ( vet_facturas_fac_id )
        REFERENCES vet_facturas ( fac_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE vet_detalles_fac
    ADD CONSTRAINT vet_detalles_fac_vet_servicios_fk FOREIGN KEY ( vet_servicios_serv_codigo )
        REFERENCES vet_servicios ( serv_codigo );

ALTER TABLE vet_facturas
    ADD CONSTRAINT vet_facturas_vet_personas_fk FOREIGN KEY ( vet_personas_per_id )
        REFERENCES vet_personas ( per_id );

ALTER TABLE vet_facturas
    ADD CONSTRAINT vet_facturas_vet_usuarios_fk FOREIGN KEY ( vet_usuarios_us_id )
        REFERENCES vet_usuarios ( us_id );

ALTER TABLE vet_mascotas
    ADD CONSTRAINT vet_mascotas_vet_personas_fk FOREIGN KEY ( vet_personas_per_id )
        REFERENCES vet_personas ( per_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE vet_mascotas
    ADD CONSTRAINT vet_mascotas_vet_tiposmascotas_fk FOREIGN KEY ( vet_tiposmascotas_tipom_id )
        REFERENCES vet_tiposmascotas ( tipom_id );

ALTER TABLE vet_razas
    ADD CONSTRAINT vet_razas_vet_tiposmascotas_fk FOREIGN KEY ( vet_tiposmascotas_tipom_id )
        REFERENCES vet_tiposmascotas ( tipom_id );

ALTER TABLE vet_usuarios
    ADD CONSTRAINT vet_usuarios_vet_personas_fk FOREIGN KEY ( vet_personas_per_id )
        REFERENCES vet_personas ( per_id );
        
        
INSERT INTO vet_personas VALUES (1,'0150741742', 'Karen', 'Ortiz', 'El Valle', '0994441682', 'karenorpe2004@gmail.com', 'C', '', 'A');
commit;
SELECT * FROM vet_personas;