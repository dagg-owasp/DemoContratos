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
INSERT INTO usuario(id, nombre, clave) VALUES (1, 'david', '$2y$12$F2HuSwRHPYUlFdIOjKAJBuOINQon78rCdBybIGwWsVLrHn7Ie.sJW'); 
INSERT INTO usuario(id, nombre, clave) VALUES (2, 'jessica', '$2y$12$40ZcsxPAZTGGydOfm0JJs.Kp.P4jLBjd3ycmmyELa3gpXyzmPpsym');
INSERT INTO usuario(id, nombre, clave) VALUES (3, 'juan', '$2y$12$CTvYGPu5roYXcmXN.UjjGutKnZpS/mprJNPjoypU9rqa1CUozpG4.');

