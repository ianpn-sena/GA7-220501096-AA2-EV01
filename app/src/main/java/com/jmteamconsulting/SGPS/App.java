package com.jmteamconsulting.SGPS;

import com.jmteamconsulting.SGPS.controller.DB;
import com.jmteamconsulting.SGPS.view.PanelRaiz;
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
        /*
         * La siguiente referencia no es usada, pero, se intenta conectar a la
         * base de datos. La aplicación termina con un código de estado distinto
         * a 1 si ocurrieron errores.
         *
         * Si no ocurrieron errores, entonces la base de datos quedará inicializada
         * por el resto de la ejecución de este programa y no tendrá que ser
         * inicializada nuevamente en esta ejecución. Se puede obtener una
         * referencia a la instancia con su método DB.getConexion().
         */
        Connection conexion = DB.getConexion();
        System.getLogger(App.class.getName()).log(System.Logger.Level.INFO, "Conectado exitosamente a la base de datos.");
        
        // Si se pudo conectar a la base de datos, entonces se mutra la GUI.
        PanelRaiz.main(args);
    }
}
