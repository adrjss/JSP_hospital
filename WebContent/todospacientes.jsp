<%@page import="br.projeto.modelo.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar todos os Pacientes</title>
</head>
<% ArrayList<Paciente> pacientes = (ArrayList)request.getAttribute("listaPacientesRecebidos"); %>

<body>
	<h1>Todos os Pacientes</h1>
	
		<a href="cadastrarpaciente.html"><button>Cadastrar Paciente</button></a><br><br>
	
	<table width="80%" border="5" cellspacing="2">
		<thead>
			<tr bgcolor="white" style="color:red">
				<th>Código</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Genêro</th>
				<th>Convênio</th>
				<th>Cep</th>
				<th colspan="2">EDITAR</th>
			</tr>
		</thead>

		<tbody>
			
			<% for(Paciente paciente:pacientes){ %>
			<tr>
				<td><%=paciente.getCodigo() %></td>
				<td><%=paciente.getNome() %></td>
				<td><%=paciente.getIdade() %></td>
				<td><%=paciente.getGenero() %></td>
				<td><%=paciente.getConvenio() %></td>
				<td><%=paciente.getCep() %></td>
				<td><a href="do.excluirpaciente?codigo=<%=paciente.getCodigo() %>">Excluir</a></td>
				<td><a href="do.alterarpaciente?codigo=<%=paciente.getCodigo() %>">Alterar</a></td>
			</tr>
			<%} %>
	
		</tbody>
	</table>
	
</body>
</html>