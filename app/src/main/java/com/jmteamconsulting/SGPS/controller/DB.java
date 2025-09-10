package com.jmteamconsulting.SGPS.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Properties;

/**
 * Maneja la conectividad con la base de datos MySQL.
 * 
 * Usando como referencia lo visto en clase, y, también documentación oficial
 * de MySQL:
 * 
 * https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-connect-drivermanager.html
 * 
 * @author ianpineda
 */
public class DB {
    // Solo existe una instancia en la aplicación entera.
    private static Connection conexion;
    
    /**
     * Inicializa DB.conexion en caso de estar null.
     * 
     * Los datos sensibles de conexión con la base de datos son almacenados
     * en un archivo local db.properties que no está registrado ni almacenado
     * en ningún sistema de control de versiones. Es esencial que este archivo
     * exista para poder establecer una conexión con la base de datos.
     * 
     * @throws SQLException En caso de no poder inicializar la conexion.
     */
    private static void inicializarConexionSiNoExiste() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, MissingResourceException {
        if (conexion != null) {
            return;
        }
        
        // Primero se determina la ruta del archivo db.properties.
        final String directorioActual = System.getProperty("user.dir");
        final Path rutaActual = Paths.get(directorioActual);
        final Path rutaPropertiesDB = rutaActual.getParent().resolve("db.properties");
        final File archivoPropertiesDB = rutaPropertiesDB.toFile();
        
        // Se lee el archivo de propiedades de la base de datos de la ruta obtenida anteriormente.
        final Properties dbProperties = new Properties();
        final InputStream lectorDeArchivoProperties = new FileInputStream(archivoPropertiesDB);
        dbProperties.load(lectorDeArchivoProperties);
        
        // Se leen las propiedades necesaria del archivo db.properties.
        final String hostname = (String) dbProperties.get("db_hostname");
        final String puerto = (String) dbProperties.get("db_puerto");
        final String usuario = (String) dbProperties.get("db_usuario");
        final String password = (String) dbProperties.get("db_password");
        final String nombre = (String) dbProperties.get("db_nombre");
        
        if (hostname == null || hostname.trim().equals("")) {
            throw new MissingResourceException("El archivo db.properties no contiene la propiedad 'db_hostname'", dbProperties.getClass().getName(), "db_hostname");
        } else if (puerto == null || puerto.trim().equals("")) {
            throw new MissingResourceException("El archivo db.properties no contiene la propiedad 'db_puerto'", dbProperties.getClass().getName(), "db_puerto");
        } else if (usuario == null || usuario.trim().equals("")) {
            throw new MissingResourceException("El archivo db.properties no contiene la propiedad 'db_usuerio'", dbProperties.getClass().getName(), "db_usuerio");
        } else if (password == null || password.trim().equals("")) {
            throw new MissingResourceException("El archivo db.properties no contiene la propiedad 'db_hostname'", dbProperties.getClass().getName(), "db_password");
        } else if (nombre == null || nombre.trim().equals("")) {
            throw new MissingResourceException("El archivo db.properties no contiene la propiedad 'db_nombre'", dbProperties.getClass().getName(), "db_nombre");
        }
        
        /*
         * Tomado de la documentación de MySQL Connector/J.
         * Previene errores con ciertas implementaciones problemáticas de Java.
         * Puede arrojar varios tipos de excepciones manejadas externamente.
         */
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        // Se preparan los parámetros de conexión en forma de una URL JDBC.
        final String formatoURL = "jdbc:mysql://%s:%s/%s";
        final String URL = String.format(
            // String de formato
            formatoURL,
                
            // Parámetros usados para llenar el formato
            hostname,
            puerto,
            nombre
        );
        
        // Se intenta establacer una conexión con la base de datos.
        DB.conexion = DriverManager.getConnection(URL, usuario, password);
    }
    
    /**
     * Obtiene una instancia de DB.conexion. Note que el valor de retorno de
     * este método puede ser null si la conexión no pudo ser inicializada.
     * 
     * @return Connection si se pudo establecer una conexión, de lo contrario, null.
     */
    public static Connection getConexion() {
        // Se intenta inicializar la conexión con la base de datos, manejando errores conocidos.
        try {
            inicializarConexionSiNoExiste();
        } catch (SQLException ex) {
            System.getLogger(DB.class.getName()).log(System.Logger.Level.ERROR, "Error conectando a base de datos MySQL", ex);
            System.exit(6);
        } catch (IOException ex) {
            System.getLogger(DB.class.getName()).log(System.Logger.Level.ERROR, "Error leyendo archivo db.properties", ex);
            System.exit(1);
        } catch (ClassNotFoundException ex) {
            System.getLogger(DB.class.getName()).log(System.Logger.Level.ERROR, "Error encontrando la clase del driver de la base de datos MySQL", ex);
            System.exit(3);
        } catch (InstantiationException ex) {
            System.getLogger(DB.class.getName()).log(System.Logger.Level.ERROR, "Error instanciando la clase del driver de la base de datos MySQL", ex);
            System.exit(5);
        } catch (IllegalAccessException ex) {
            System.getLogger(DB.class.getName()).log(System.Logger.Level.ERROR, "Error accediendo a la clase del driver de la base de datos MySQL", ex);
            System.exit(4);
        } catch (MissingResourceException ex) {
            System.getLogger(DB.class.getName()).log(System.Logger.Level.ERROR, "Error leyendo propiedad de db.properties", ex);
            System.exit(2);
        }
        
        // Conexion inicializada exitosamente. Se regresa una referencia válida.
        return conexion;
    }
}
