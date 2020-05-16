USE nix;
-- Categorías --
insert into Categoria (nombre) values ('Aperitivos');
insert into Categoria (nombre) values ('Ensaladas');
insert into Categoria (nombre) values ('Entradas');
insert into Categoria (nombre) values ('Guarniciones');
insert into Categoria (nombre) values ('Bebidas');

-- Comida --

-- Aperitivos --
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (1,'Guacamole','Salsa mexicana preparada a base de aguacate y chile verde o chile pimiento',0,30.00,'Aperitivos');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (2,'Papas a la francesa','Papas cortadas en rodajas y freidas en aceite.',0,30.00,'Aperitivos');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (3,'Brocheta de frutas','Bolitas de melón, sandía y plátano en un palo.',0,40.00,'Aperitivos');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (4,'Tabla de quesos','Tabla con diversos quesos para compartir.',0,60.00,'Aperitivos');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (5,'Ensaladilla rusa','Platillo típico con papas y hortalizas.',0,35.00,'Aperitivos');

-- Ensalada --
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (6,'César','Ensalada de lechuga romana y croûtons con jugo de limón, aceite de oliva, huevo, salsa Worcestershire, anchoas, ajo, mostaza de Dijon, queso parmesano y pimienta negra.',0,60.00,'Ensaladas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (7,'Mediterránea','Ensalada con ingredientes característicos de la zona del mediterráneo.',0,55.00,'Ensaladas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (8,'De pollo','Ensalada César con pollo.',0,65.00,'Ensaladas');

-- Entradas -- 
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (9,'Consomé','Clásica receta de consomé de pollo.',0,70.00,'Entradas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (10,'Sopa de fideo','Con pollo.',0,69.00,'Entradas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (11,'Sope sencillo','Con frijoles, lechuga, cebolla y queso',0,36.00,'Entradas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (12,'Tostada sencilla','Con frijoles, lechuga, cebolla y queso',0,50.00,'Entradas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (13,'Queso fundido','160 gramos de queso manchego fundido.',0,80.00,'Entradas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (14,'Quesadilla','Quesadilla de queso.',0,30.00,'Entradas');

-- Guarniciones -- 
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (15,'Pollo con mole','Platillo de pollo con mole. Incluye tortillas.',0,0,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (16,'Fajitas de pollo','Pollo asado a la parrilla cortado en tiras y servido en tortilla de harina.',0,180.00,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (17,'Fajitas de arrachera','Arrachera asada a la parrilla cortada en tiras y servida en tortilla de harina.',0,205.00,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (18,'Gringas','Tortilla de harina rellena de queso, al pastor y piña.',0,95.00,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (19,'Burrito','Tortilla de harina enrollada con carne, queso, frijoles, jitomate y cebolla.',0,100.00,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (20,'Taco de Suadero','Con tortilla hecha a mano, cebolla y cilantro.',0,20.00,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (21,'Taco de Pastor','Con tortilla hecha a mano, cebolla y cilantro.',0,20.00,'Guarniciones');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (22,'Taco de Bistec','Con tortilla hecha a mano, cebolla y cilantro.',0,20.00,'Guarniciones');

-- Bebidas --
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (23,'Agua de horchata','1/2 litro.',0,40.00,'Bebidas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (24,'Agua de jamaica','1/2 litro',0,40.00,'Bebidas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (25,'Refresco','350 mL.',0,30.00,'Bebidas');
insert into Platillo (id_platillo, nombre, descripcion, foto, precio, categoria) values (26,'Limonada','1 litro.',0,45.00,'Bebidas');

-- Clientes --
insert into Usuario (correo, nombre, contraseña) values ('tito@correo.com','Tito','12345678');
insert into Cliente (correo, telefono, calificacion) values ('tito@correo.com','5589675432',0);
insert into Cliente_Direccion (direccion, correo) values ('Av. Paz, 15, Los Pinos, Ciudad de México', 'tito@correo.com');

insert into Usuario (correo, nombre, contraseña) values ('maria@correo.com','Maria','qwertyui');
insert into Cliente (correo, telefono, calificacion) values ('maria@correo.com','5543546789',0);
insert into Cliente_Direccion (direccion, correo) values ('Árbol, 64, Jardín, Ciudad de México', 'maria@correo.com');

-- Administrador --
insert into Usuario (correo, nombre, contraseña) values ('admin@nix.com','Admin','password');
insert into Administrador (correo) values ('admin@nix.com');

-- Repartidores --
insert into Usuario (correo, nombre, contraseña) values ('adrian@correo.com','Adrian','1q2w3e4r');
insert into Repartidor (correo) values ('adrian@correo.com');

insert into Usuario (correo, nombre, contraseña) values ('eduardo@correo.com','Eduardo','r4e3w2q1');
insert into Repartidor (correo) values ('eduardo@correo.com');

insert into Usuario (correo, nombre, contraseña) values ('jessica@correo.com','Jessica','asdfghjk');
insert into Repartidor (correo) values ('jessica@correo.com');

-- Carrito --
insert into Carrito (correo,id_carrito) values ('tito@correo.com',1);
insert into Agregar (correo,id_carrito,id_platillo) values ('tito@correo.com',1,2);
insert into Agregar (correo,id_carrito,id_platillo) values ('tito@correo.com',1,6);
insert into Agregar (correo,id_carrito,id_platillo) values ('tito@correo.com',1,10);
insert into Agregar (correo,id_carrito,id_platillo) values ('tito@correo.com',1,17);
insert into Agregar (correo,id_carrito,id_platillo) values ('tito@correo.com',1,23);

insert into Carrito (correo,id_carrito) values ('maria@correo.com',2);

-- Ordenes --
insert into Orden (id_orden,fecha_entrega,estado,correo_repartidor,correo_cliente) values (1,'2020-07-05','Entregado','jessica@correo.com','tito@correo.com');
insert into Contener (id_platillo,id_orden) values (1,1);
insert into Contener (id_platillo,id_orden) values (9,1);
insert into Contener (id_platillo,id_orden) values (12,1);
insert into Contener (id_platillo,id_orden) values (20,1);
insert into Contener (id_platillo,id_orden) values (21,1);
insert into Contener (id_platillo,id_orden) values (27,1);

insert into Orden (id_orden,fecha_entrega,estado,correo_repartidor,correo_cliente) values (2,'2020-08-08','Lista','adrian@correo.com','tito@correo.com');
insert into Contener (id_platillo,id_orden) values (2,2);
insert into Contener (id_platillo,id_orden) values (8,2);
insert into Contener (id_platillo,id_orden) values (10,2);
insert into Contener (id_platillo,id_orden) values (12,2);
insert into Contener (id_platillo,id_orden) values (15,2);
insert into Contener (id_platillo,id_orden) values (16,2);
insert into Contener (id_platillo,id_orden) values (25,2);