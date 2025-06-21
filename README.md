DROP DATABASE IF EXISTS servicio_peliculas;
CREATE DATABASE servicio_peliculas;
USE servicio_peliculas;

CREATE TABLE pelicula (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR (50) NOT NULL,
    disponible BOOLEAN NOT NULL
);

INSERT INTO pelicula VALUES (0, "Spiderman 1", 1);
INSERT INTO pelicula VALUES (0, "Rio 1", 1);
INSERT INTO pelicula VALUES (0, "Rio 2", 1);
INSERT INTO pelicula VALUES (0, "Spiderman 2", 1);
INSERT INTO pelicula VALUES (0, "Mulan 1", 1);
INSERT INTO pelicula VALUES (0, "Lilo Y Stitch", 0);
INSERT INTO pelicula VALUES (0, "Como entrenar a tu dragon", 0);
INSERT INTO pelicula VALUES (0, "Pixels", 0);
INSERT INTO pelicula VALUES (0, "Minecraft The Movie", 0);
INSERT INTO pelicula VALUES (0, "Garfield", 0);

SELECT * FROM pelicula;
