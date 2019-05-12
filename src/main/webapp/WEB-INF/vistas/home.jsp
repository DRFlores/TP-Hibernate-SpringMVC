<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container text-center">
			<h1>Taller Web 1</h1>
			<h2>Trabajo Práctico: Hibernate | Sprint MVC</h2>
			
			<div class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				
				<form:form action="procesar-operacion" method="POST">		
					
					<select name="operacion" class="form-control">
					  <option value="pasarAMayuscula">Pasar a May&uacute;scula</option>
					  <option value="pasarAMinuscula">Pasar a Min&uacute;scula</option>
					  <option value="invertirOrden">Invertir orden</option>
					  <option value="cantidadDeCaracteres">Cantidad de caracteres</option>
					</select>					
					
					<input name="texto" type="text" id="texto" class="form-control"/>     		  
					
					<button class="btn btn-lg btn-success btn-block" Type="Submit">Aplicar operaci&oacute;n</button>
				</form:form>

			</div>
			
			
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>