package model;

public class Articulo {
    String nombre, tipo_articulo;
    int peso_kg, precio;

    public Articulo(String nombre, String tipo_articulo, int peso_kg, int precio) {
        this.nombre = nombre;
        this.tipo_articulo = tipo_articulo;
        this.peso_kg = peso_kg;
        this.precio = precio;
    }

}
