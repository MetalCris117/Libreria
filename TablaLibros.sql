DROP TABLE IF EXISTS Libreria;

CREATE TABLE Libreria(
    Id INT PRIMARY KEY IDENTITY(1,1),
	Titulo VARCHAR(150) NOT NULL,
	Autor VARCHAR(100) NOT NULL,
	AnioPublicacion INT,
    Genero VARCHAR(100),
	Portada VARBINARY(MAX)
);

SELECT * FROM Libreria

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Genero,Portada)
SELECT 
    'Narnia',
    'C. S. Lewis',
	1950,
	'Fantasia',
    BulkColumn 
FROM OPENROWSET(BULK 'F:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\portada_Narnia.png', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Genero,Portada)
SELECT 
    'Codigo Da Vinci',
    'Dan Brown',
	2003,
	'Novela',
    BulkColumn 
FROM OPENROWSET(BULK 'F:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\codigoDaVinci.jpg', SINGLE_BLOB) AS Imagen;
