# GA7-220501096-AA2-EV01

Implementación sencilla de un módulo del proyecto individual que estoy desarrollando para el curso Análisis y Desarrollo de Software del SENA.

Los datos críticos tales como el hostname, puerto, usuario y contraseña de la base de datos MySQL deben ser colocados en el archivo `db.properties`, el cual intencionalmente no es rastreado por Git así que no hace parte de este repositorio.

## Entorno

* IDE: Apache NetBeans versión 27 (Flatpak, Linux)
* Java: 21.0.8+2 (Temurin, Linux)
* MySQL: 8.0.43 (Communitiy, Linux)

## Ejemplo de `db.properties`

```
db_hostname=localhost
db_puerto=3306
db_usuario=root
db_password=abc123
db_nombre=mi_tabla
```

## DDL (SQL) de Prueba

```
CREATE TABLE `usuario` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `numero_documento` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `primer_nombre` varchar(100) NOT NULL,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `primer_apellido` varchar(100) NOT NULL,
  `segundo_apellido` varchar(100) DEFAULT NULL,
  `numero_telefono` varchar(100) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `departamento` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `direccion_linea_1` varchar(100) NOT NULL,
  `direccion_linea_2` varchar(100) DEFAULT NULL,
  `codigo_zip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_numero_documento_unique` (`numero_documento`),
  UNIQUE KEY `usuario_email_unique` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```