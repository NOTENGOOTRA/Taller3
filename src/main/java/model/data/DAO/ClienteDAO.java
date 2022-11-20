package model.data.DAO;

import model.Articulo;
import model.Cliente;

import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class ClienteDAO {
    public static void agregarCliente(DSLContext query, Cliente cliente) {
        Table tablaCliente = table(name("Cliente"));
        Field[] columnas = tablaCliente.fields("nombre", "rut", "correo");
        query.insertInto(tablaCliente, columnas[0], columnas[1], columnas[2])
                .values(cliente.getNombre(), cliente.getRut(), cliente.getCorreo())
                .execute();
    }

    public static List obtenerCliente(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Cliente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaClientes(resultados);
    }
    public static List obtenerClientes(DSLContext query){
        Result resultados = query.select().from(DSL.table("Cliente")).fetch();
        return obtenerListaClientes(resultados);
    }

    private static List obtenerListaClientes(Result resultados){
        List<Cliente> clientes= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"nombre");
            String nombre = (String) resultados.getValue(fila,"rut");
            String correo = (String) resultados.getValue(fila,"correo");
            clientes.add(new Cliente(nombre,rut,correo));
        }
        return clientes;
    }
}
