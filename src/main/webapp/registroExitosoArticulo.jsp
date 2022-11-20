<%--
  Created by IntelliJ IDEA.
  User: avalo
  Date: 20-11-2022
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro articulo</title>
</head>
<body>
<h1 class="encabezado"> Registro articulo</h1>
<div class="centrado">
  <p class="subtitulo">Registro exitoso</p> <br>
  <label class="campoTexto"> Articulo : <c:out value="${articulo.getNombre()}"></c:out> </label>
  <br>
  <label class="campoTexto">Codigo Producto : <c:out value="${articulo.getCodigo_producto()}"></c:out></label>
  <a class="boton" href="/RegistroPersonas">Volver</a>
</div>
</body>
</html>
