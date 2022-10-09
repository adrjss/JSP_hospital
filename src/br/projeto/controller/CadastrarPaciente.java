package br.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto.modelo.Paciente;
import br.projeto.modelo.PacienteDao;

@WebServlet("/do.cadastrarpaciente")
public class CadastrarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtnome");
		int idade = Integer.parseInt(request.getParameter("txtidade"));
		String genero = request.getParameter("txtgenero");
		int convenio = Integer.parseInt(request.getParameter("txtconvenio"));
		int cep = Integer.parseInt(request.getParameter("txtcep"));
		
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setIdade(idade);
		paciente.setConvenio(convenio);
		paciente.setGenero(genero);
		paciente.setCep(cep);
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.cadastrar(paciente);
		
		response.sendRedirect("http://localhost:8080/ProjetoCRUD/do.mostrarpacientes");
		
	}
}
