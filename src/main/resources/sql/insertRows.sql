INSERT INTO cuentas (email, contraseña, rol, usuario) VALUES ('virgo09@gmail.com', '123456', 'rol_cliente' ,'Virgo09');
INSERT INTO cuentas (email, contraseña, rol, usuario) VALUES ('mariawater@gmail.com', 'watermelon', 'rol_cliente', 'MariaPoMo');
INSERT INTO cuentas (email, contraseña, rol, usuario) VALUES ('torrezno34@gmail.com', 'aguacate47', 'rol_cliente', 'Torrezno34');
INSERT INTO cuentas (email, contraseña, rol, usuario) VALUES ('HotelNH@gmail.com', 'nhreus', 'rol_empresa', 'HotelNH');
INSERT INTO cuentas (email, contraseña, rol, usuario) VALUES ('hotelgaudi@gmail.com', 'hotelgaudi', 'rol_empresa', 'HotelGaudi');


INSERT INTO reservas (codigo, fecha_entrada, fecha_salida, importe_reserva, id_cliente, id_hotel) VALUES ('10A', '2022-02-02', '2022-02-04', 170, 1, 2);
INSERT INTO reservas (codigo, fecha_entrada, fecha_salida, importe_reserva, id_cliente, id_hotel) VALUES ('10B', '2022-02-04', '2022-02-06', 140, 2, 1);
INSERT INTO reservas (codigo, fecha_entrada, fecha_salida, importe_reserva, id_cliente, id_hotel) VALUES ('10C', '2022-02-05', '2022-02-06', 170, 3, 2);


INSERT INTO clientes (nombre, apellido, dni, id_cuenta) VALUES ('Manuel', 'Sanchez', '3995841P', 1);
INSERT INTO clientes (nombre, apellido, dni, id_cuenta) VALUES ('Maria', 'Pomo', '39901457X', 2);
INSERT INTO clientes (nombre, apellido, dni, id_cuenta) VALUES ('Martín', 'Calero', '39956854E', 3);


INSERT INTO empresas (codigo_empresa, nombre, id_cuenta) VALUES ('08899784B', 'Hotels NH', 4);
INSERT INTO empresas (codigo_empresa, nombre, id_cuenta) VALUES ('08874524V', 'Hotel Gaudi', 5);

INSERT INTO hoteles (nombre, categoria, poblacion, ubicacion, precio, id_empresa) VALUES ('Hotel NH Ciutat de Reus', '4 estrellas', 'Reus','(1.114531 41.161336) ', 85, 1);
INSERT INTO hoteles (nombre, categoria, poblacion, ubicacion, precio, id_empresa) VALUES ('Hotel Gaudi', '3 estrellas', 'Reus', '(1.108789 41.152797)', 70, 2);