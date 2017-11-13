/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.entities;

/**
 *
 * @author emmanuel
 */
public class Users {
    private Long id;
    
    private String userName;
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private int edad;
    
    private String image;
    
    private String fechaCreacion;
   
    private short estatus;

    public Users() {
    }

    public Users(Long id, String userName, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String image, String fechaCreacion, short estatus) {
        this.id = id;
        this.userName = userName;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.image = image;
        this.fechaCreacion = fechaCreacion;
        this.estatus = estatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }
    
}
