<%@page import="br.projeto.modelo.Paciente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Paciente</title>
</head>
<body>

<% 	Paciente paciente = (Paciente)request.getAttribute("pacienteRecebido"); %>

	<h1>Alterar dados do Paciente</h1>
	
	<form method='post' action='do.alterarpaciente'>
	
		<label>Codigo: </label>
		<input type='text' name='txtcodigo' value="<%=paciente.getCodigo()%>" readonly><br><br>
		
		<label>Nome: </label>
		<input type='text' name='txtnome' value="<%=paciente.getNome()%>"><br><br>
		
		<label>Idade:</label>
		<input type='text' name='txtidade' value="<%=paciente.getIdade() %>"><br><br>
		
		<label>Gênero: </label>
		<input type='text' name='txtgenero' value="<%=paciente.getGenero() %>"><br><br>
		
		<label>Convênio: </label>	
		<input type='text' name='txtconvenio' value="<%=paciente.getConvenio() %>"><br><br>
		
		<label>CEP: </label>
		<input type='text' name='txtcep' value="<%=paciente.getCep() %>"><br><br>
		
		<input type='submit' value='Alterar'>
		
	</form>
</body>
</html>