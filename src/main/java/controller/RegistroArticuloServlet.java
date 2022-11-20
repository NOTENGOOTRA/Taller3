package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Articulo;
import model.Cliente;
import model.data.DAO.ArticuloDAO;
import model.data.DAO.ClienteDAO;
import model.data.DBGenerator;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistroArticuloServlet", value = "/registroArticulo")
public class RegistroArticuloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ArticulosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/registroArticulo.jsp");

        respuesta.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher respuesta = request.getRequestDispatcher("/registroErroneoArticulo.jsp");
        if(request.getParameter("codigo_producto").length()!=0 && request.getParameter("nombre").length()!=0  &&
                request.getParameter("tipo_articulo").length()!=0 && request.getParameter("precio").length()!=0 && request.getParameter("peso_kg").length()!=0){
            String codigo_producto = request.getParameter("codigo_producto");
            String nombre = request.getParameter("nombre");
            int tipo_articulo = Integer.parseInt(request.getParameter("tipo_articulo"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            int peso_kg = Integer.parseInt(request.getParameter("peso_kg"));
            Articulo articulo = new Articulo(codigo_producto,nombre,tipo_articulo,precio,peso_kg);
            try {
                if(agregarArticulo(articulo)){
                    request.setAttribute("articulo",articulo);
                    respuesta = request.getRequestDispatcher("/registroExitosoArticulo.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(request,response);
    }

    private boolean agregarArticulo(Articulo articulo) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("ArticulosBD");
        List<Articulo> articulos = ArticuloDAO.obtenerArticulo(query,"codigo_producto",articulo.getCodigo_producto());
        if(articulos.size()!=0){
            return false;
        }
        else{
           ArticuloDAO.agregarArticulo(query,articulo);
            return true;
        }
    }
}
