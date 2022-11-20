<%--
  Created by IntelliJ IDEA.
  User: avalo
  Date: 20-11-2022
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro Cliente</title>
</head>
<body>
<h1 class="encabezado"> Registro cliente</h1>
<form action="registroCliente.jsp" method="post">
    <div class="centrado">
        <label> Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <label> Rut:</label>
        <input name="rut" type="text" class="campoTexto">
        <label> Correo:</label>
        <input name="correo" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="enviar" class="boton">
    </div>
</form>

</body>
</html>
