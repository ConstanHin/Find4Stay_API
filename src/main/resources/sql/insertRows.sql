INSERT INTO cuenta (usuario, contraseña, email, rol) VALUES ('Virgo09', '123456', 'virgo09@gmail.com', 2);
INSERT INTO cuenta (usuario, contraseña, email, id_rol) VALUES ('MariaPoMo', 'watermelon', 'mariawater@gmail.com', 2);
INSERT INTO cuenta (usuario, contraseña, email, id_rol) VALUES ('Torrezno34', 'aguacate47', 'torrezno34@gmail.com', 2);
INSERT INTO cuenta (usuario, contraseña, email, id_rol) VALUES ('HotelNH', 'nhreus', 'HotelNH@gmail.com', 3);
INSERT INTO cuenta (usuario, contraseña, email, id_rol) VALUES ('HotelGaudi', 'hotelgaudi', 'hotelgaudi@gmail.com', 3);

INSERT INTO empresa (codigo_empresa, nombre, id_cuenta) VALUES ('08899784B', 'Hotels NH', 4);
INSERT INTO empresa (codigo_empresa, nombre, id_cuenta) VALUES ('08874524V', 'Hotel Gaudi', 5);

INSERT INTO cliente (nombre, apellido, dni, id_cuenta) VALUES ('Manuel', 'Sanchez', '3995841P', 1);
INSERT INTO cliente (nombre, apellido, dni, id_cuenta) VALUES ('Maria', 'Pomo', '39901457X', 2);
INSERT INTO cliente (nombre, apellido, dni, id_cuenta) VALUES ('Martín', 'Calero', '39956854E', 3);

INSERT INTO hotel (nombre_hotel, categoria, poblacion, ubicacion_geografica, precio_noche, id_empresa) VALUES ('Hotel NH Ciutat de Reus', '4 estrellas', 'Reus','(1.114531 41.161336) ', 85, 1);
INSERT INTO hotel (nombre_hotel, categoria, poblacion, ubicacion_geografica, precio_noche, id_empresa) VALUES ('Hotel Gaudi', '3 estrellas', 'Reus', '(1.108789 41.152797)', 70, 2);

INSERT INTO reservar (codigo, fecha_entrada, fecha_salida, importe_reserva, id_cliente, id_hotel) VALUES ('10A', '2022-02-02', '2022-02-04', 170, 1, 2);
INSERT INTO reservar (codigo, fecha_entrada, fecha_salida, importe_reserva, id_cliente, id_hotel) VALUES ('10B', '2022-02-04', '2022-02-06', 140, 2, 1);
INSERT INTO reservar (codigo, fecha_entrada, fecha_salida, importe_reserva, id_cliente, id_hotel) VALUES ('10C', '2022-02-05', '2022-02-06', 170, 3, 2);