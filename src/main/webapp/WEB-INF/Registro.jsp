<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <!-- action= ruta donde enviamos los parametros-->
    <!--method= forma como se envian get y post-->
    <!-- get muestra los paerametros 
    post envia los parametros ocultos
    -->

    <div class="container-fluid">
		<h2>Formulario registro</h2>
		<c:if test="${msgError!=null}">
    		<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
    	</c:if>


	    <div class="card">
		  <div class="card-body">
		    <form action="/registro/usuario" method="post">
		        <label for="nombre" class="form-label">Nombre:</label>
		        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa nombre">
		        <br>
		        <label for="nick" class="form-label">Nick:</label>
		        <input type="text" class="form-control" id="nick" name="nick" placeholder="Ingresa apellido">
		        <br>
		        <label for="correo" class="form-label">Email:</label>
		        <input type="email" class="form-control" id="correo" name="correo" placeholder="Ingrese email">
		        <br>
		        <label for="pass" class="form-label">Password:</label>
		        <input type="password" class="form-control" id="pass" name="pass" placeholder="Ingrese password">
		        <br>
                <label for="pass2" class="form-label">Password2:</label>
		        <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Ingrese password">
		        <br>
		        <input type="submit" class="btn btn-outline-primary btn-lg" value="Enviar">
				<a class="btn btn-primary" href="/registro/login" role="button">Link</a>
			</form>
		  </div>
		</div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>