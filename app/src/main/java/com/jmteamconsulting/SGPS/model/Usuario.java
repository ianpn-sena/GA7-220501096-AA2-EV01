package com.jmteamconsulting.SGPS.model;

/**
 * Definición de modelo Usuario, sin ORM por el momento.
 * 
 * @author ianpineda
 */
class Usuario {
    /*
     * Note que se está usando camelCase aquí, lo cual no coincide 1:1 con
     * los nombres de campos en la base de datos.
     */ 
    private long id;
    private String numeroDocumento;
    private String email;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroTelefono;
    private String pais;
    private String departamento;
    private String ciudad;
    private String direccionLinea1;
    private String direccionLinea2;
    private String codigoZIP;

    void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    void setPais(String pais) {
        this.pais = pais;
    }

    void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    void setDireccionLinea1(String direccionLinea1) {
        this.direccionLinea1 = direccionLinea1;
    }

    void setDireccionLinea2(String direccionLinea2) {
        this.direccionLinea2 = direccionLinea2;
    }

    void setCodigoZIP(String codigoZIP) {
        this.codigoZIP = codigoZIP;
    }

    /**
     * Constructor con solo los campos obligatorios (los que no son "NOT NULL.")
     * 
     * @param numeroDocumento
     * @param email
     * @param primerNombre
     * @param primerApellido
     * @param numeroTelefono
     * @param pais
     * @param departamento
     * @param ciudad
     * @param direccionLinea1 
     */
    Usuario(String numeroDocumento, String email, String primerNombre, String primerApellido, String numeroTelefono, String pais, String departamento, String ciudad, String direccionLinea1) {
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.numeroTelefono = numeroTelefono;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccionLinea1 = direccionLinea1;
    }

    long getId() {
        return id;
    }

    String getNumeroDocumento() {
        return numeroDocumento;
    }

    String getEmail() {
        return email;
    }

    String getPrimerNombre() {
        return primerNombre;
    }

    String getSegundoNombre() {
        return segundoNombre;
    }

    String getPrimerApellido() {
        return primerApellido;
    }

    String getSegundoApellido() {
        return segundoApellido;
    }

    String getNumeroTelefono() {
        return numeroTelefono;
    }

    String getPais() {
        return pais;
    }

    String getDepartamento() {
        return departamento;
    }

    String getCiudad() {
        return ciudad;
    }

    String getDireccionLinea1() {
        return direccionLinea1;
    }

    String getDireccionLinea2() {
        return direccionLinea2;
    }

    String getCodigoZIP() {
        return codigoZIP;
    }
}
