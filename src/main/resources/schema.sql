CREATE TABLE Coordenadas
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    latitud DECIMAL(5,3),
    longitud DECIMAL(5,3)
);

CREATE TABLE Ubicacion
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    pais VARCHAR(25),
    estado VARCHAR(25),
    ciudad VARCHAR(30),
    municipio VARCHAR(30),
    codigo_Postal INTEGER,
    colonia VARCHAR(15),
    numero_Exterior VARCHAR(15),
    numero_Interior VARCHAR(15),
    id_Coordenadas INTEGER,
    CONSTRAINT fk_coordenadas FOREIGN KEY (id_Coordenadas)
    REFERENCES Coordenadas (id)        
);

CREATE TABLE inmueble
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo_Inmueble VARCHAR(50) NOT NULL,
    estatus_Inmueble VARCHAR(15),
    largo DECIMAL(15,2),
    ancho DECIMAL(15,2),
    precio_X_Metro_Cuadrado VARCHAR(15),
    id_Ubicacion INTEGER,
    CONSTRAINT fk_Ubicacion FOREIGN KEY (id_Ubicacion)
    REFERENCES Ubicacion (id)    
);

