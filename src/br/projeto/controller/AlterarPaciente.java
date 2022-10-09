package br.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto.modelo.Paciente;
import br.projeto.modelo.PacienteDao;

@WebServlet("/do.alterarpaciente")
public class AlterarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		PacienteDao pacienteDao = new PacienteDao();
		Paciente paciente = pacienteDao.buscarCodigo(codigo);
		
		request.setAttribute("pacienteRecebido", paciente);
		request.getRequestDispatcher("alterarpaciente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("txtcodigo"));
		String nome = request.getParameter("txtnome");
		int idade = Integer.parseInt(request.getParameter("txtidade"));
		String genero = request.getParameter("txtgenero");
		int convenio = Integer.parseInt(request.getParameter("txtconvenio"));
		int cep = Integer.parseInt(request.getParameter("txtcep"));
		
		Paciente paciente = new Paciente();
		
		paciente.setCodigo(codigo);
		paciente.setNome(nome);
		paciente.setIdade(idade);
		paciente.setGenero(genero);
		paciente.setConvenio(convenio);
		paciente.setCep(cep);
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.alterar(paciente);
		
		response.sendRedirect("http://localhost:8080/ProjetoCRUD/do.mostrarpacientes");
		
	}
}
