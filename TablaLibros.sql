DROP TABLE IF EXISTS Libreria;

CREATE TABLE Libreria(
    Id INT PRIMARY KEY IDENTITY(1,1),
	Titulo VARCHAR(150) NOT NULL,
	Autor VARCHAR(100) NOT NULL,
	AnioPublicacion INT NOT NULL,
	Editorial VARCHAR(250) NOT NULL,
    Genero VARCHAR(100) NOT NULL,
	Presio FLOAT NOT NULL,
	Existencias INT,
	Portada VARBINARY(MAX)
);

SELECT * FROM Libreria

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias,Portada)
SELECT 
    'Narnia: El león la bruja y el ropero',
    'C. S. Lewis',
	1950,
	'Grupo Nelson',
	'Fantasía',
	221.22,
	15,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\portada_Narnia.png', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'Codigo Da Vinci',
    'Dan Brown',
	2017,
	'Planeta',
	'Novela',
	388,
	10,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\codigoDaVinci.jpg', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'Harry Potter: La piedra filosofal',
    'J.K. Rowling',
	1999,
	'Salamandra Infantil Y Juvenil',
	'Fantasía',
	450.44,
	50,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\harry_potter1.jpg', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'El principito',
    'Antoine de Saint-Exupéry',
	1943,
	'Penguin Random House Grupo Editorial',
	'Fábula',
	120,
	60,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\elPrincipito.jpg', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'Histroria de dos ciudades',
    'Charles Dickens',
	1859,
	'Alba Editorial',
	'Novela',
	620,
	30,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\histroriaDeDosC.jpg', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'Sueño en el pabellón rojo',
    'Cao Xueqin',
	2018,
	'Galaxia Gutenberg',
	'Novela',
	329,
	50,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\pabellonRojo.jpg', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'Alicia en el país de las maravillas',
    'Lewis Carroll',
	2019,
	'Editorial Edelvives',
	'Fantasía',
	880.50,
	10,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\alicia.jpg', SINGLE_BLOB) AS Imagen;

INSERT INTO Libreria (Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada)
SELECT 
    'Ella',
    'H. Rider Haggard',
	2020,
	'SAGA Egmont',
	'Romance',
	130,
	27,
    BulkColumn 
FROM OPENROWSET(BULK 'E:\Mis archivos\Personal\Javafx_cons\libros\src\main\resources\imagenes\ella.jpg', SINGLE_BLOB) AS Imagen;
