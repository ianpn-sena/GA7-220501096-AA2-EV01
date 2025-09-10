package com.jmteamconsulting.SGPS.controller;

import com.jmteamconsulting.SGPS.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Contiene la lógica de la aplicación con respecto al modelo Usuario y su(s)
 * respectiva(s) vista(s).
 * 
 * @author ianpineda
 */
public class ControladorUsuario {
    /**
     * Inserta un nuevo registro Usuario en la base de datos.
     * 
     * @param usuario Objeto usuario a insertar en la base de datos.
     */
    public static long crearUsuario(Usuario usuario) throws SQLException {
        // Se obtiene referencia a la base de datos que ya debe estar inicializada.
        final Connection conexion = DB.getConexion();
        
        // Se intenta insertar un nuevo registo en la base de datos.
        final String formatoConsulta = "INSERT INTO usuario (numero_documento, email, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, numero_telefono, pais, departamento, ciudad, direccion_linea_1, direccion_linea_2, codigo_zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        final PreparedStatement sentencia = conexion.prepareStatement(formatoConsulta, PreparedStatement.RETURN_GENERATED_KEYS);
        sentencia.setString(1, usuario.getNumeroDocumento());
        sentencia.setString(2, usuario.getEmail());
        sentencia.setString(3, usuario.getPrimerNombre());
        sentencia.setString(4, usuario.getSegundoNombre());
        sentencia.setString(5, usuario.getPrimerApellido());
        sentencia.setString(6, usuario.getSegundoApellido());
        sentencia.setString(7, usuario.getNumeroTelefono());
        sentencia.setString(8, usuario.getPais());
        sentencia.setString(9, usuario.getDepartamento());
        sentencia.setString(10, usuario.getCiudad());
        sentencia.setString(11, usuario.getDireccionLinea1());
        sentencia.setString(12, usuario.getDireccionLinea2());
        sentencia.setString(13, usuario.getCodigoZIP());
        sentencia.execute();
        
        // Se obtiene el ID del registro creado.
        final ResultSet resultados = sentencia.getGeneratedKeys();
        resultados.next();
        
        // Se regresa el ID del registro creado.
        return resultados.getLong(1);
    }
    
    public static void leerUsuario() {
        
    }
    
    public static void actualizarUsuario() {
        
    }
    
    public static void eliminarUsuario() {
        
    }
}
