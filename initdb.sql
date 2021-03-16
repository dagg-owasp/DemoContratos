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
/* Create users 
	User with id=1 gets admin role
	The rest of the users get regular user 
*/
INSERT INTO usuario(id, nombre, clave) VALUES (1, 'david',   '$2y$12$JeTSpQvTUh..XOZFZ1Ol8O0Ux6uERfDIHJMhTeueB16I3o.Q6I6ZW'); 
INSERT INTO usuario(id, nombre, clave) VALUES (2, 'jessica', '$2y$12$Y2m7Z4KGWbFZWl5yYjZsTO04I1hlCMzYE/KnB1i5sfX3OgW2DOe/W');
INSERT INTO usuario(id, nombre, clave) VALUES (3, 'juan',    '$2y$12$aEGuWnnXbr39C6okvTX9pOZHywJ60Y/Aos2Esw1OOJsS/clDo5K.G');

