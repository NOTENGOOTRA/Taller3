package model.data.DAO;

import model.Articulo;

import model.Cliente;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class ArticuloDAO {
    public static void agregarArticulo(DSLContext query, Articulo articulo) {
        Table tablaArticulo = table(name("Articulo"));
        Field[] columnas = tablaArticulo.fields("codigo_producto","nombre", "tipo_articulo", "precio", "peso_kg");
        query.insertInto(tablaArticulo, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5])
                .values()
                .execute();
    }
}