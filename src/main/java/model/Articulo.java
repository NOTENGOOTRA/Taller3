package model;

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

}
