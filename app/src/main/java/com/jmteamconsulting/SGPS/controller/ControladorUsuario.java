package com.jmteamconsulting.SGPS.controller;

import com.jmteamconsulting.SGPS.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
     * @throws SQLException En caso de haber ocurrido un error SQL.
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
    
    /**
     * Obtiene un registro usuario de la base de datos, por su ID.
     * 
     * @param id El ID del usuario a consultar en la base de datos.
     * @return Objeto Usuario representando los datos del registro obtenido.
     * @throws SQLException En caso de haber ocurrido un error SQL.
     */
    public static Usuario leerUsuario(long id) throws SQLException {
        // Se obtiene referencia a la base de datos que ya debe estar inicializada.
        final Connection conexion = DB.getConexion();
        
        // Se intenta obtener el registro de la base de datos.
        final String formatoConsulta = "SELECT numero_documento, email, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, numero_telefono, pais, departamento, ciudad, direccion_linea_1, direccion_linea_2, codigo_zip FROM usuario WHERE id=?;";
        final PreparedStatement sentencia = conexion.prepareStatement(formatoConsulta);
        final ResultSet resultados;
        
        sentencia.setLong(1, id);
        resultados = sentencia.executeQuery();
        
        // Se comprueba si se pudieron obtener resultados de la consulta.
        if (!resultados.next()) {
            return null;
        }
        
        // Se crea y regresa un objeto Usuario con los resultados obtenidos.
        final Usuario usuario = new Usuario(
            id,
            resultados.getString(1),
            resultados.getString(2),
            resultados.getString(3),
            resultados.getString(4),
            resultados.getString(5),
            resultados.getString(6),
            resultados.getString(7),
            resultados.getString(8),
            resultados.getString(9),
            resultados.getString(10),
            resultados.getString(11),
            resultados.getString(12),
            resultados.getString(13)
        );
        
        return usuario;
    }
    
    /**
     * Lee y regresa todos los usuarios encontrados en la base de datos.
     * 
     * @return Listado de objetos usuario obtenidos en la base de datos. Puede estar vacío o no estarlo.
     * @throws SQLException En caso de encontrar un error SQL.
     */
    public static List<Usuario> leerUsuarios() throws SQLException {
        // Se obtiene referencia a la base de datos que ya debe estar inicializada.
        final Connection conexion = DB.getConexion();
        
        // Se intenta obtener todos los usuarios en la base de datos.
        final String formatoConsulta = "SELECT id, numero_documento, email, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, numero_telefono, pais, departamento, ciudad, direccion_linea_1, direccion_linea_2, codigo_zip FROM usuario;";
        final PreparedStatement sentencia = conexion.prepareStatement(formatoConsulta);
        final ResultSet resultados = sentencia.executeQuery();
        
        /*
         * Se convierte el ResultSet recibido en un listado de usuarios, y se regresa.
         * Note que opté por usar List ya que me pareció más prudente usar una lista que
         * puede ser expandida. Así sólo tengo que recorrer el ResultSet una vez. ES
         * imposible obtener la longitud de un ResultSet sin recorrerlo primero.
         */
        final List<Usuario> usuarios = new ArrayList<>();
        
        while (resultados.next()) {
            usuarios.add(new Usuario(
                resultados.getLong(1),
                resultados.getString(2),
                resultados.getString(3),
                resultados.getString(4),
                resultados.getString(5),
                resultados.getString(6),
                resultados.getString(7),
                resultados.getString(8),
                resultados.getString(9),
                resultados.getString(10),
                resultados.getString(11),
                resultados.getString(12),
                resultados.getString(13),
                resultados.getString(14)
            ));
        }
        
        // Retornamos el listado de usuarios, el cual puede estar vacío pero no null.
        return usuarios;
    }
    
    /**
     * Actualiza los datos de un usuario en la base de datos. El usuario actualizado
     * tendrá el mismo ID del usuario de entrada.
     * 
     * @throws SQLException En caso de encontrar un error SQL.
     */
    public static int actualizarUsuario(Usuario usuario) throws SQLException {
        // Se obtiene referencia a la base de datos que ya debe estar inicializada.
        final Connection conexion = DB.getConexion();
        
        // Se intenta actualizar el registo en la base de datos cuya ID coincida con el usuario de entrada.
        final String formatoConsulta = "UPDATE usuario SET numero_documento=?, email=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, numero_telefono=?, pais=?, departamento=?, ciudad=?, direccion_linea_1=?, direccion_linea_2=?, codigo_zip=? WHERE id=?";
        final PreparedStatement sentencia = conexion.prepareStatement(formatoConsulta);
        final int filasActualizadas;
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
        sentencia.setLong(14, usuario.getId());
        filasActualizadas = sentencia.executeUpdate();
        
        // Se regresa el número de registros actualizados.
        return filasActualizadas;
    }
    
    /**
     * Elimina un registro usuario de la base de datos, usando su ID.
     * 
     * @param id Id numérico del usuario a eliminar; PK.
     * @throws SQLException En caso de ocurrir un error SQL.
     * @return El número de registros eliminados. Es mayor que 0 si se eliminó el usuario especificado.
     */
    public static int eliminarUsuario(long id) throws SQLException {
        // Se obtiene referencia a la base de datos que ya debe estar inicializada.
        final Connection conexion = DB.getConexion();
        
        // Se intenta eliminar el registro de la base de datos.
        final String formatoConsulta = "DELETE FROM usuario WHERE id=?;";
        final PreparedStatement sentencia = conexion.prepareStatement(formatoConsulta);
        sentencia.setLong(1, id);
        return sentencia.executeUpdate();
    }
}
