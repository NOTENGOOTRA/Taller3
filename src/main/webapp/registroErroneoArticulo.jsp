<%--
  Created by IntelliJ IDEA.
  User: avalo
  Date: 20-11-2022
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro articulo</title>
</head>
<body>
<h1 class="encabezado"> Registro articulo</h1>
<h2 class="subtitulo">Datos erroneos</h2>
<form action="registroArticulo" method="post">
  <div class="centrado">
    <label> Nombre:</label>
    <input name="nombre" type="text" class="campoTexto">
    <label> Tipo Articulo:</label>
    <input name="tipo_articulo" type="text" class="campoTexto">
    <label> Peso (kg):</label>
    <input name="peso_kg" type="number" class="campoTexto">
    <label> Precio:</label>
    <input name="precio" type="number" class="campoTexto">
    <label> Codigo Producto:</label>
    <input name="codigo_producto" type="number" class="campoTexto">
    <br><br>
    <input class="boton" type="submit" value="enviar">
  </div>
</form>
</body>
</html>
