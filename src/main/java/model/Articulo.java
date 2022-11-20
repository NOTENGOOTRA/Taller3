package model;

import org.jooq.Row6;

public class Articulo {
    String nombre, tipo_articulo;
    int precio, codigo_producto;
    double peso_kg;

    public Articulo(String nombre, String tipo_articulo, double peso_kg, int precio, int codigo_producto) {
        this.nombre = nombre;
        this.tipo_articulo = tipo_articulo;
        this.peso_kg = peso_kg;
        this.precio = precio;
        this.codigo_producto = codigo_producto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_articulo() {
        return tipo_articulo;
    }

    public void setTipo_articulo(String tipo_articulo) {
        this.tipo_articulo = tipo_articulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Row6 getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }
}
