use Libros
--CREATE DATABASE Libros;

DROP TABLE IF EXISTS Usuarios;

CREATE TABLE Usuarios(
    Id INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(100) NOT NULL,--not null campos obligatorios
    Apellidos VARCHAR(100) NOT NULL,
    Sexo CHAR(1) CHECK (Sexo IN ('H', 'M')) NULL,--check solo perime h o m
    Correo NVARCHAR(150) UNIQUE NOT NULL,--unique = no se perimiten duplicados
    Contraseña NVARCHAR(255) NOT NULL
);

INSERT INTO Usuarios VALUES ('Cristian', 'Suarez Garcia','H', 'cristian@gmail.com','12345');

SELECT * FROM Usuarios;

DROP TABLE IF EXISTS Carrito;

CREATE TABLE Carrito(
    Id INT IDENTITY(1,1),
    libro_id INT NOT NULL,
    usuario_id INT NOT NULL,
    fecha_agregado DATETIME DEFAULT GETDATE(),
    CONSTRAINT PK_Id_Carrito PRIMARY KEY (Id),
    CONSTRAINT FK_Libro_Carrito FOREIGN KEY (libro_id) REFERENCES Libreria(Id), 
    CONSTRAINT FK_Usuario_Carrito FOREIGN KEY (usuario_id) REFERENCES Usuarios(Id)
);

SELECT * FROM Carrito