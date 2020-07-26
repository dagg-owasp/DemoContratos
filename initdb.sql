/* Create Database */
CREATE DATABASE democontratos OWNER postgres;
\c democontratos;
/* Create Tables */
CREATE TABLE usuario
(
	id integer NOT NULL,
	nombre character varying(50) NOT NULL,
	clave character varying(255) NOT NULL,
	CONSTRAINT "PK_usuario" PRIMARY KEY (id)
);
/* Create users */
INSERT INTO usuario(id, nombre, clave) VALUES (1, 'david', '$2y$12$F2HuSwRHPYUlFdIOjKAJBuOINQon78rCdBybIGwWsVLrHn7Ie.sJW');

