# GA7-220501096-AA2-EV01

Implementación sencilla de un módulo del proyecto individual que estoy desarrollando para el curso Análisis y Desarrollo de Software del SENA.

Los datos críticos tales como el hostname, puerto, usuario y contraseña de la base de datos MySQL deben ser colocados en el archivo `db.properties`, el cual intencionalmente no es rastreado por Git así que no hace parte de este repositorio.

## Ejemplo de `db.properties`

```db_hostname=localhost
db_puerto=3306
db_usuario=root
db_password=abc123
db_nombre=mi_table```

## Entorno

* IDE: Apache NetBeans versión 27 (Flatpak, Linux)
* Java: 21.0.8+2 (Temurin, Linux)
* MySQL: 8.0.43 (Communitiy, Linux)