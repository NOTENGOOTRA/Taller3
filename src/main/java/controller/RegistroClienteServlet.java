package controller;
import com.taller.taller3.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Cliente;
import model.*;
import model.data.DAO.ClienteDAO;
import model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;


import java.io.IOException;
import java.util.List;

import java.io.IOException;

@WebServlet(name = "RegistroClienteServlet", value = "/registroCliente")
public class RegistroClienteServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ClientesBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/registroCliente.jsp");

        respuesta.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher respuesta = request.getRequestDispatcher("/registroErroneoCliente.jsp");
        if(request.getParameter("correo").length()!=0 && request.getParameter("nombre").length()!=0  &&
                request.getParameter("rut").length()!=0){
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String rut = request.getParameter("rut");
            Cliente cliente = new Cliente(nombre, correo, rut);
            try {
                if(agregarCliente(cliente)){
                    request.setAttribute("cliente",cliente);
                    respuesta = request.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(request,response);
    }

    private boolean agregarCliente(Cliente cliente) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("ClientesBD");
        List<Cliente> clientes = ClienteDAO.obtenerCliente(query,"rut",cliente.getRut());
        if(clientes.size()!=0){
            return false;
        }
        else{
            ClienteDAO.agregarCliente(query,cliente);
            return true;
        }
    }
}
