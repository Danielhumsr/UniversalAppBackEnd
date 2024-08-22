

INSERT INTO USUARIO (ID, USER_NAME, PASWORD, EMAIL, ESTADO) VALUES (default, 'kaksuma', '$2a$10$lmY7BREak9D.tgniyjE84uE139VZkoveWx9omld22qYfDKt9fAojS', 'admin', '1');
INSERT INTO USUARIO (ID, USER_NAME, PASWORD, EMAIL, ESTADO) VALUES (default, 'angee', '$2a$10$lmY7BREak9D.tgniyjE84uE139VZkoveWx9omld22qYfDKt9fAojS', 'admin','1');
INSERT INTO USUARIO (ID, USER_NAME, PASWORD, EMAIL, ESTADO) VALUES (default, 'backtome', '$2a$10$lmY7BREak9D.tgniyjE84uE139VZkoveWx9omld22qYfDKt9fAojS', 'admin','2');
INSERT INTO USUARIO (ID, USER_NAME, PASWORD, EMAIL, ESTADO) VALUES (default, 'daniel', '$2a$10$lmY7BREak9D.tgniyjE84uE139VZkoveWx9omld22qYfDKt9fAojS', 'admin','1');


INSERT INTO MODULOS (ID, NOMBRE_MODULO, DESCRIPCION_MODULO, URL) VALUES (default, 'Gestion de Usuarios', 'Modulo donde se gestionan los usuarios.', '/GestionUsuarios');
INSERT INTO MODULOS (ID, NOMBRE_MODULO, DESCRIPCION_MODULO, URL) VALUES (default, 'Tareas', 'Modulo donde se gestion de tareas.', '/Tareas');
INSERT INTO MODULOS (ID, NOMBRE_MODULO, DESCRIPCION_MODULO, URL) VALUES (default, 'Inventario', 'Modulo donde se gestion de tareas.', '/Inventario');
INSERT INTO MODULOS (ID, NOMBRE_MODULO, DESCRIPCION_MODULO, URL) VALUES (default, 'Citas', 'Modulo donde se gestion Las citas.', '/Citas');


INSERT INTO ESTADO (ID, ESTADO) VALUES (default, 'ACTIVO');
INSERT INTO ESTADO (ID, ESTADO) VALUES (default, 'ELIMINADO');
INSERT INTO ESTADO (ID, ESTADO) VALUES (default, 'DESACTIVADO');


INSERT INTO ROL (ID, NOMBRE_ROL, DESCRIPCION) VALUES (default, 'ADMIN', 'Administrado del modulo');
INSERT INTO ROL (ID, NOMBRE_ROL, DESCRIPCION) VALUES (default, 'MAKER', 'Resgistra informacion en el modulo');
INSERT INTO ROL (ID, NOMBRE_ROL, DESCRIPCION) VALUES (default, 'CHEKER', 'Aprueba la informacion registrada');
INSERT INTO ROL (ID, NOMBRE_ROL, DESCRIPCION) VALUES (default, 'MASTER', 'Registra informacion que es apobada automaticamente');

