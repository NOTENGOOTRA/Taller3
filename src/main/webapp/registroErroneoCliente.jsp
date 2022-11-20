<%--
  Created by IntelliJ IDEA.
  User: avalo
  Date: 20-11-2022
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro cliente</title>
</head>
<body>
<h1 class="encabezado"> Registro cliente</h1>
<h2 class="subtitulo">Datos erroneos</h2>
<form action="registroCliente" method="post">
  <div class="centrado">
    <label> Nombre:</label>
    <input name="nombre" type="text" class="campoTexto">
    <label> Rut:</label>
    <input name="rut" type="text" class="campoTexto">
    <label> Correo:</label>
    <input name="correo" type="number" class="campoTexto">
    <br><br>
    <input class="boton" type="submit" value="enviar">
  </div>
</form>
</body>
</html>
