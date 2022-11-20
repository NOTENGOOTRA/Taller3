package model.data;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.DataType;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    //Metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    public static void iniciarBD(String registroInventario) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBD(create, registroInventario);
        create = actualizarConexion(connection, registroInventario);
        crearTablaCliente(create);
        crearTablaArticulo(create);
        relacionarTabla(create, "Estudiante", "codigo_carrera", "Carrera");
        DBConnector.closeConnection();
    }

    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBD(DSLContext create, String registroInventario){
        create.createDatabaseIfNotExists(registroInventario).execute();
    }
    private static DSLContext actualizarConexion(Connection connection,String registroInventario){
        DBConnector.closeConnection();
        connection= DBConnector.connection(registroInventario,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }
    private static void crearTablaCliente(DSLContext create){
        create.createTableIfNotExists("Cliente").column("rut",VARCHAR(20))
                .column("nombre",VARCHAR(50))
                .column("correo",VARCHAR(100))
                .constraint(primaryKey("rut")).execute();
    }

    private static void crearTablaArticulo(DSLContext create){
        create.createTableIfNotExists("Articulo").column("codigo_producto",INTEGER)
                .column("nombre",VARCHAR(100))
                .column("tipo_articulo", VARCHAR(100))
                .column("precio", INTEGER)
                .column("peso_kg", INTEGER)
                .constraint(primaryKey("codigo_producto")).execute();
    }
}