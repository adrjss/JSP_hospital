package br.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto.modelo.PacienteDao;

@WebServlet("/do.excluirpaciente")
public class ExcluirPaciente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.excluir(codigo);
		
		response.sendRedirect("http://localhost:8080/ProjetoCRUD/do.mostrarpacientes");
	}
}
