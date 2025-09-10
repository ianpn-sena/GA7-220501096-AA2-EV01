package com.jmteamconsulting.SGPS.model;

/**
 * Definición de modelo Usuario, sin ORM por el momento.
 * 
 * @author ianpineda
 */
public class Usuario {
    /*
     * Note que se está usando camelCase aquí, lo cual no coincide 1:1 con
     * los nombres de campos en la base de datos.
     */ 
    private Long id;
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
        this.numeroDocumento = numeroDocumento == null ? null : (numeroDocumento.trim().equals("") ? null : numeroDocumento.trim());
    }

    void setEmail(String email) {
        this.email = email == null ? null : (email.trim().equals("") ? null : email.trim());
    }

    void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre == null ? null : (primerNombre.trim().equals("") ? null : primerNombre.trim());
    }

    void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre == null ? null : (segundoNombre.trim().equals("") ? null : segundoNombre.trim());
    }

    void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido == null ? null : (primerApellido.trim().equals("") ? null : primerApellido.trim());
    }

    void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido == null ? null : (segundoApellido.trim().equals("") ? null : segundoApellido.trim());
    }

    void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono == null ? null : (numeroTelefono.trim().equals("") ? null : numeroTelefono.trim());
    }

    void setPais(String pais) {
        this.pais = pais == null ? null : (pais.trim().equals("") ? null : pais.trim());
    }

    void setDepartamento(String departamento) {
        this.departamento = departamento == null ? null : (departamento.trim().equals("") ? null : departamento.trim());
    }

    void setCiudad(String ciudad) {
        this.ciudad = ciudad == null ? null : (ciudad.trim().equals("") ? null : ciudad.trim());
    }

    void setDireccionLinea1(String direccionLinea1) {
        this.direccionLinea1 = direccionLinea1 == null ? null : (direccionLinea1.trim().equals("") ? null : direccionLinea1.trim());
    }

    void setDireccionLinea2(String direccionLinea2) {
        this.direccionLinea2 = direccionLinea2 == null ? null : (direccionLinea2.trim().equals("") ? null : direccionLinea2.trim());
    }

    void setCodigoZIP(String codigoZIP) {
        this.codigoZIP = codigoZIP == null ? null : (codigoZIP.trim().equals("") ? null : codigoZIP.trim());
    }

    /**
     * Constructor con todos los campos se Usuario.
     * 
     * Note que es perfectamente válido pasar valores null como argumentos, sin
     * embargo, algunos campos podrían causar problemas con la base de datos.
     * Aun así, es deseable usar null en algunos campos, tal como en id, dependiendo
     * de la operación que se busca realizar con Usuario.
     * 
     * Note también que los nombres de estos campos no coinciden 1:1 con los
     * nombres usados en atributos de la base de datos.
     * 
     * @param id
     * @param numeroDocumento
     * @param email
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param numeroTelefono
     * @param pais
     * @param departamento
     * @param ciudad
     * @param direccionLinea1
     * @param direccionLinea2
     * @param codigoZIP
     */
    public Usuario(Long id, String numeroDocumento, String email, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String numeroTelefono, String pais, String departamento, String ciudad, String direccionLinea1, String direccionLinea2, String codigoZIP) {
        this.id = id;
        this.numeroDocumento = numeroDocumento == null ? null : (numeroDocumento.trim().equals("") ? null : numeroDocumento.trim());
        this.email = email == null ? null : (email.trim().equals("") ? null : email.trim());
        this.primerNombre = primerNombre == null ? null : (primerNombre.trim().equals("") ? null : primerNombre.trim());
        this.segundoNombre = segundoNombre == null ? null : (segundoNombre.trim().equals("") ? null : segundoNombre.trim());
        this.primerApellido = primerApellido == null ? null : (primerApellido.trim().equals("") ? null : primerApellido.trim());
        this.segundoApellido = segundoApellido == null ? null : (segundoApellido.trim().equals("") ? null : segundoApellido.trim());
        this.numeroTelefono = numeroTelefono == null ? null : (numeroTelefono.trim().equals("") ? null : numeroTelefono.trim());
        this.pais = pais == null ? null : (pais.trim().equals("") ? null : pais.trim());
        this.departamento = departamento == null ? null : (departamento.trim().equals("") ? null : departamento.trim());
        this.ciudad = ciudad == null ? null : (ciudad.trim().equals("") ? null : ciudad.trim());
        this.direccionLinea1 = direccionLinea1 == null ? null : (direccionLinea1.trim().equals("") ? null : direccionLinea1.trim());
        this.direccionLinea2 = direccionLinea2 == null ? null : (direccionLinea2.trim().equals("") ? null : direccionLinea2.trim());
        this.codigoZIP = codigoZIP == null ? null : (codigoZIP.trim().equals("") ? null : codigoZIP.trim());
    }
    
    public Long getId() {
        return id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getPais() {
        return pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccionLinea1() {
        return direccionLinea1;
    }

    public String getDireccionLinea2() {
        return direccionLinea2;
    }

    public String getCodigoZIP() {
        return codigoZIP;
    }
}
