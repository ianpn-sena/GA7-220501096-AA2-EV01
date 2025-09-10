package com.jmteamconsulting.SGPS;

import com.jmteamconsulting.SGPS.controller.DB;
import java.sql.Connection;

public class App {
    /**
     * Punto de entrada de la aplicación.
     * 
     * Configura el acceso a la base de datos MySQL y presenta una interfaz de usuario.
     * 
     * @param args Argumentos de línea de comando. Son ignorados.
     */
    public static void main(String[] args) {
        Connection conexion = DB.getConexion();
        System.getLogger(App.class.getName()).log(System.Logger.Level.INFO, "Conectado exitosamente a la base de datos.");
    }
}
