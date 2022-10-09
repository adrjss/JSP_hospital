package br.projeto.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto.modelo.Paciente;
import br.projeto.modelo.PacienteDao;

@WebServlet("/do.mostrarpacientes")
public class MostrarPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PacienteDao pacienteDao = new PacienteDao();
		ArrayList<Paciente> pacientesRecebidos = pacienteDao.mostrarTodos();
		
		request.setAttribute("listaPacientesRecebidos", pacientesRecebidos);
		request.getRequestDispatcher("todospacientes.jsp").forward(request, response);
	}

}
