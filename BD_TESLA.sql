CREATE DATABASE BD_Tesla;
USE BD_Tesla;

CREATE TABLE Vehículo (
    id_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50),
    anio_vehiculo INT,
    tipo_batería VARCHAR(50),
    precio DECIMAL(10, 2),
    autonomia INT
);

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(50),
    apellido_cliente VARCHAR(50),
    correo_electronico VARCHAR(100),
    direccion VARCHAR(150),
    telefono VARCHAR(20)
);

CREATE TABLE Orden (
    id_orden INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_vehiculo INT,
    fecha_orden DATE,
    cantidad INT,
    estado_orden VARCHAR(50),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_vehiculo) REFERENCES Vehículo(id_vehiculo)
);

CREATE TABLE Servicio (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    tipo_servicio VARCHAR(50),
    costo DECIMAL(10, 2),
    id_vehiculo INT,
    fecha_servicio DATE,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehículo(id_vehiculo)
);

CREATE TABLE Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empleado VARCHAR(50),
    apellido_empleado VARCHAR(50),
    cargo VARCHAR(50),
    salario DECIMAL(10, 2),
    fecha_contratacion DATE
);

INSERT INTO Vehículo (modelo, anio_vehiculo, tipo_batería, precio, autonomia)
VALUES 
('Model S', 2023, 'Batería de iones de litio', 79999.99, 600),
('Model 3', 2024, 'Batería de iones de litio', 39999.99, 500),
('Model X', 2022, 'Batería de iones de litio', 89999.99, 550),
('Model Y', 2023, 'Batería de iones de litio', 49999.99, 520),
('Cybertruck', 2024, 'Batería de iones de litio', 69999.99, 650),
('Roadster', 2023, 'Batería de iones de litio', 99999.99, 1000),
('Semi', 2023, 'Batería de iones de litio', 150000.00, 800),
('Model X Plaid', 2023, 'Batería de iones de litio', 129999.99, 600);

INSERT INTO Cliente (nombre_cliente, apellido_cliente, correo_electronico, direccion, telefono)
VALUES 
('Juan', 'Perez', 'juan.perez@example.com', 'Calle 123', '555-1234'),
('Maria', 'Lopez', 'maria.lopez@example.com', 'Avenida 456', '555-5678'),
('Carlos', 'Martinez', 'carlos.martinez@example.com', 'Calle 789', '555-9876'),
('Ana', 'Garcia', 'ana.garcia@example.com', 'Calle 321', '555-6543'),
('Luis', 'Fernandez', 'luis.fernandez@example.com', 'Avenida 987', '555-8765'),
('Sofia', 'Diaz', 'sofia.diaz@example.com', 'Calle 456', '555-4321'),
('Pedro', 'Gomez', 'pedro.gomez@example.com', 'Avenida 654', '555-7654'),
('Lucia', 'Torres', 'lucia.torres@example.com', 'Calle 135', '555-2468');

INSERT INTO Orden (id_cliente, id_vehiculo, fecha_orden, cantidad, estado_orden)
VALUES 
(1, 1, '2024-01-10', 1, 'En proceso'),
(2, 2, '2024-02-15', 1, 'Completada'),
(3, 3, '2024-03-20', 2, 'Cancelada'),
(4, 4, '2024-04-25', 1, 'En proceso'),
(5, 5, '2024-05-30', 1, 'Completada'),
(6, 6, '2024-06-05', 1, 'En proceso'),
(7, 7, '2024-07-10', 2, 'Cancelada'),
(8, 8, '2024-08-15', 1, 'Completada');

INSERT INTO Servicio (tipo_servicio, costo, id_vehiculo, fecha_servicio)
VALUES 
('Mantenimiento preventivo', 500.00, 1, '2024-01-15'),
('Cambio de batería', 10000.00, 2, '2024-02-20'),
('Revisión de frenos', 300.00, 3, '2024-03-25'),
('Cambio de llantas', 800.00, 4, '2024-04-30'),
('Ajuste de software', 1000.00, 5, '2024-05-05'),
('Revisión general', 400.00, 6, '2024-06-10'),
('Actualización del sistema', 1500.00, 7, '2024-07-15'),
('Limpieza completa', 200.00, 8, '2024-08-20');

INSERT INTO Empleado (nombre_empleado, apellido_empleado, cargo, salario, fecha_contratacion)
VALUES 
('Miguel', 'Rodriguez', 'Técnico', 3500.00, '2022-01-01'),
('Laura', 'Mendoza', 'Ingeniera', 5000.00, '2021-02-15'),
('Andres', 'Vega', 'Gerente', 7500.00, '2020-03-10'),
('Carla', 'Castro', 'Secretaria', 2500.00, '2019-04-20'),
('Ricardo', 'Flores', 'Vendedor', 4000.00, '2022-05-25'),
('Elena', 'Morales', 'Desarrolladora', 6000.00, '2020-06-30'),
('Diego', 'Rios', 'Contador', 4500.00, '2021-07-05'),
('Marta', 'Luna', 'Diseñadora', 5500.00, '2022-08-10');
