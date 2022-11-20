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
    <title>Registro Cliente</title>
</head>
<body>
<h1 class="encabezado"> Registro cliente</h1>
<div class="centrado">
  <p class="subtitulo">Registro exitoso</p> <br>
  <label class="campoTexto"> Cliente : <c:out value="${cliente.getNombre()}"></c:out> </label>
  <br>
  <label class="campoTexto">Rut : <c:out value="${cliente.getRut()}"></c:out></label>
  <a class="boton" href="/registroCliente">Volver</a>
</div>
</body>
</html>
