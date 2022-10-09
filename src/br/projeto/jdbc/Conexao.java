package br.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Conexao {
	
	public static Connection receberConexao() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
			System.out.println("Banco de Dados Conectado com Sucesso!");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Erro ao Conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		
		return con;
		
	}
}