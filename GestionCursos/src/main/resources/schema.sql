CREATE TABLE usuario (
	id INT,
	nombreusuario VARCHAR(24),
	password VARCHAR(255),
	nombreapellido VARCHAR(64),
	email VARCHAR(64),
	rol_id INT	
);

CREATE TABLE rol (
	id INT,
	nombre VARCHAR(24)	
);
