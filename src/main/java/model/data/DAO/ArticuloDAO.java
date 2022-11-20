package model.data.DAO;

import model.Articulo;

import model.Cliente;
import org.jooq.*;
import org.jooq.impl.DSL;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class ArticuloDAO {
    public static void agregarArticulo(DSLContext query, Articulo articulo) {
        Table tablaArticulo = table(name("Articulo"));
        Field[] columnas = tablaArticulo.fields("codigo_producto","nombre", "tipo_articulo", "precio", "peso_kg");
        query.insertInto(tablaArticulo, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values( articulo.getCodigo_producto(), articulo.getNombre(),articulo.getTipo_articulo(),articulo.getPrecio(),articulo.getPeso_kg())
                .execute();
    }

    public static List obtenerArticulo(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Articulo")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArticulos(resultados);
    }
    public static List obtenerArticulos(DSLContext query){
        Result resultados = query.select().from(DSL.table("Articulo")).fetch();
        return obtenerListaArticulos(resultados);
    }

    private static List obtenerListaArticulos(Result resultados){
        List<Articulo> articulos= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            int codigo_producto = (Integer) resultados.getValue(fila,"codigo_producto");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String tipo_articulo = (String) resultados.getValue(fila,"tipo articulo");
            int precio = (Integer) resultados.getValue(fila, "precio");
            int peso_kg = (Integer) resultados.getValue(fila, "peso kg");
            articulos.add(new Articulo(nombre,tipo_articulo,peso_kg,precio,codigo_producto));
        }
        return articulos;
    }
}
