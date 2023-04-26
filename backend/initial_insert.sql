
INSERT INTO paises (nombre) VALUES ('Argentina');
INSERT INTO paises (nombre) VALUES ('Colombia');
INSERT INTO paises (nombre) VALUES ('Brasil');


INSERT INTO provincias (nombre, id_pais) VALUES ('Buenos Aires', 1);
INSERT INTO provincias (nombre, id_pais) VALUES ('Córdoba', 1);
INSERT INTO provincias (nombre, id_pais) VALUES ('Chaco', 1);
INSERT INTO provincias (nombre, id_pais) VALUES ('Mendoza', 1);
INSERT INTO provincias (nombre, id_pais) VALUES ('Río Negro', 1);
INSERT INTO provincias (nombre, id_pais) VALUES ('Boyacá', 2);


INSERT INTO ciudades (nombre, id_provincia) VALUES ('La Plata', 1);
INSERT INTO ciudades (nombre, id_provincia) VALUES ('Miraflores', 3);
INSERT INTO ciudades (nombre, id_provincia) VALUES ('Carlos Paz', 2);
INSERT INTO ciudades (nombre, id_provincia) VALUES ('San Carlos de Barloche', 5);
INSERT INTO ciudades (nombre, id_provincia) VALUES ('Buenos Aires', 1);
INSERT INTO ciudades (nombre, id_provincia) VALUES ('Mendoza', 4);
INSERT INTO ciudades (nombre, id_provincia) VALUES ('Córdoba', 2);

INSERT INTO caracteristicas (nombre) VALUES ('Estacionamiento Gratuito');
INSERT INTO caracteristicas (nombre) VALUES ('Apto Mascotas');
INSERT INTO caracteristicas (nombre) VALUES ('Cocina');
INSERT INTO caracteristicas (nombre) VALUES ('Televisor');
INSERT INTO caracteristicas (nombre) VALUES ('Pileta');
INSERT INTO caracteristicas (nombre) VALUES ('Wifi');
INSERT INTO caracteristicas (nombre) VALUES ('Aire acondicionado');

INSERT INTO categorias (titulo, url_imagen) VALUES ('Hoteles', 'https://gestion.pe/resizer/uRBplGmXjuGDj_YLWQF3oFltdQY=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6F4HD5HQ5VAOBEWBC3QOXOWI7U.jpg');
INSERT INTO categorias (titulo, url_imagen) VALUES ('Departamentos', 'https://gestion.pe/resizer/uRBplGmXjuGDj_YLWQF3oFltdQY=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6F4HD5HQ5VAOBEWBC3QOXOWI7U.jpg');
INSERT INTO categorias (titulo, url_imagen) VALUES ('Hostels', 'https://gestion.pe/resizer/uRBplGmXjuGDj_YLWQF3oFltdQY=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6F4HD5HQ5VAOBEWBC3QOXOWI7U.jpg');
INSERT INTO categorias (titulo, url_imagen) VALUES ('Bed and breakfast', 'https://gestion.pe/resizer/uRBplGmXjuGDj_YLWQF3oFltdQY=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6F4HD5HQ5VAOBEWBC3QOXOWI7U.jpg');


INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas)
VALUES ('Design Suites Buenos Aires', 1, 1, 'https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/20460291.jpg?k=bb2512d91936e716c4c1190d5ddd25a6873183755d31f3f9640babbbe7024da4&o=&hp=1', 'A 940 m del centro', 'Este establecimiento está situado a 700 metros de la Plaza de Mayo. Las habitaciones del Design Suites Buenos Aires son amplias y presentan una decoración ... ', 'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas)
VALUES ('Believe Madero Hotel', 1, 1, 'https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/394174406.jpg?k=f0d7e76260e46df30d6504458dc5e6acd4c033068d7b5cef493b2245180ca78c&o=&hp=1', 'A 800 m del centro', 'El Unique Art Madero ocupa un edificio moderno con una decoración de diseño en la moderna zona de San Telmo, en Buenos Aires. Las habitaciones ofrecen vistas panorámicas al renovado paseo marítimo. El Puente de la Mujer está a 1,1 km.', 'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas) 
VALUES ('TPYN Recoleta', 2, 1, 'https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/332854812.jpg?k=8dc9ff4691d529a00631f56ff18058f937f30f24c1082a41e753e641aece9466&o=&hp=1', 'A 500 m del centro', 'El TPYN RECOLETA ofrece alojamiento con WiFi gratuita y balcón en el centro de Buenos Aires, a 1,2 km del teatro Colón y a 1,8 km del Obelisco de Buenos Aires.', 'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas) 
VALUES ('Paseo Qattro', 2, 3, 'https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/225783386.jpg?k=2fa7c95b4afc075189773abddba5b822e1e09244dbc03d0eae216f438ed27f8d&o=&hp=1', 'A 900 m del centro',  
'Situado en pleno centro de Villa Carlos Paz, a 150 metros de la peatonal, cerca de los principales puntos turísticos de la ciudad y a 30 minutos en auto del aeropuerto de la ciudad de Córdoba.', 
'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas) 
VALUES ('Selina Palermo', 3, 1, 'https://a.hwstatic.com/image/upload/f_auto,q_auto,w_1900,h_823,c_limit,e_sharpen,e_improve,e_vibrance:60/v1/propertyimages/2/292135/jm5xs574ylm0kgtod2zx', 'A 200 m del centro', 
'Selina Palermo se encuentra en el barrio de moda de Palermo. Selina es una red de hospitalidad con todo tipo de alojamiento para adaptarse a las necesidades de cada viajero. Explore nuestro ecosistema de habitaciones bellamente diseñadas y prepárese para salir de lo común.', 
'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas) 
VALUES ('Hostel Casa Basilico', 3, 1, 'https://a.hwstatic.com/image/upload/f_auto,q_auto,w_1900,h_823,c_limit,e_sharpen,e_improve,e_vibrance:60/v1/propertyimages/3/312357/yczp79x5okwww3a1qcls', 'A 1.7km del centro', 'Hostel Casa Basilico se encuentra ubicado en uno de los más pintorescos de los cien Barrios Porteños de la Ciudad Autónoma de Buenos Aires.
A metros de la Universidad de Palermo, 1,4 km de Plaza Serrano ...', 'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas) 
VALUES ("Lina's Tango Guesthouse", 4, 1, 'https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/104775082.jpg?k=678ca5db7566d04bcedd726c919462a86ed059b5280db79cd47ddec60c9ae739&o=&hp=1', 'A 200 m del centro',  'Esta casa típica de San Telmo, Buenos Aires, ofrece habitaciones cómodas con baño privado o compartido a solo 200 metros de la avenida 9 de Julio. El alojamiento se encuentra en el distrito histórico y bohemio de San Telmo ...', 
'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');

INSERT INTO productos (titulo, id_categoria, id_ciudad, url_imagen_principal, ubicacion, descripcion, politicas) 
VALUES ('Mariel B&B', 4, 1, 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/54306386.jpg?k=f141bb165286293abfc93d3f33e1852b057f53135da5a31c4eb60dffdc14e258&o=&hp=1', 'A 1km m del centro',  'El Mariel B&B ofrece alojamiento asequible en el distrito de Montserrat, en Buenos Aires, a 400 metros de la avenida de Mayo y a 1 km del Obelisco de Buenos Aires. ',
 'Normas de la casa. Check out 10:00 hs. No se permiten fiestas. No fumar.
Salud y Seguridad. Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus. Detector de humo. Depósito de seguridad.
Política de cancelación. Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.');
 

INSERT INTO imagenes (titulo, url_imagen, id_producto) VALUES ('Living-comedor', 'https://rentaflat.com.ar/wp-content/uploads/2021/12/depto-36-carlos-paz-3.jpg', 3);
INSERT INTO imagenes (titulo, url_imagen, id_producto) VALUES ('Cocina', 'https://rentaflat.com.ar/wp-content/uploads/2021/12/depto-17-carlos-paz-4.jpeg', 3);

INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (1, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (2, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (3, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (4, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (5, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (6, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (7, 7);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 1);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 2);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 3);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 4);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 5);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 6);
INSERT INTO caracteristicas_producto (id_producto, id_caracteristica) VALUES (8, 7);

UPDATE caracteristicas SET url_icono = 'parking' WHERE (id = '1');
UPDATE caracteristicas SET url_icono = 'pet' WHERE (id = '2');
UPDATE caracteristicas SET url_icono = 'kitchen' WHERE (id = '3');
UPDATE caracteristicas SET url_icono = 'tv' WHERE (id = '4');
UPDATE caracteristicas SET url_icono = 'pool' WHERE (id = '5');
UPDATE caracteristicas SET url_icono = 'wifi' WHERE (id = '6');
UPDATE caracteristicas SET url_icono = 'air' WHERE (id = '7');
UPDATE productos SET id_ciudad = '5' WHERE (id = '1');
UPDATE productos SET id_ciudad = '5' WHERE (id = '2');
UPDATE productos SET id_ciudad = '5' WHERE (id = '3');
UPDATE productos SET id_ciudad = '5' WHERE (id = '5');
UPDATE productos SET id_ciudad = '5' WHERE (id = '6');
UPDATE productos SET id_ciudad = '5' WHERE (id = '7');
UPDATE productos SET id_ciudad = '5' WHERE (id = '8');

SELECT * FROM caracteristicas_producto;
SELECT * FROM productos;
SELECT * FROM caracteristicas