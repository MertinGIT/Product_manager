package com.prueba.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private int antiguedad;

    private float precio;

    private String imagen;

    private LocalDate fecha;

    public Producto(String nombre, float precio, LocalDate fecha, int antiguedad) {
        this.antiguedad = antiguedad;
        this.fecha = fecha;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Producto(long id, String nombre, float precio, LocalDate fecha, int antiguedad) {
        this.antiguedad = antiguedad;
        this.fecha = fecha;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }



    public int getAntiguedad() {
        return antiguedad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public long getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }
}
