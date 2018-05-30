package com.example.miguel_rojas.appmundial.Entidades;

import java.io.Serializable;

public class PersonajesVo implements Serializable {
    private String nombre;
    private String info;
    private String descripcion;
    private int imagenId;
    private int imagenDetalle;

    public PersonajesVo(String nombre, String info, String descripcion , int imagenId, int imagenDetalle) {
        this.nombre = nombre;
        this.info = info;
        this.imagenId = imagenId;
        this.imagenDetalle=imagenDetalle;
        this.descripcion=descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
    }


    }
