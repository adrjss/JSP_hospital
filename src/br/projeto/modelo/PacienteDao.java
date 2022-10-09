package br.projeto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.projeto.jdbc.Conexao;

public class PacienteDao {

	public void cadastrar(Paciente paciente) {
		
		Connection con = Conexao.receberConexao();
		
		String sql = "INSERT INTO paciente(nome,idade,genero,convenio,cep) VALUEs(?,?,?,?,?)";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, paciente.getNome());
			preparar.setInt(2, paciente.getIdade());
			preparar.setString(3, paciente.getGenero());
			preparar.setInt(4, paciente.getConvenio());
			preparar.setInt(5, paciente.getCep());
			
			preparar.execute();
			preparar.close();
			
			System.out.println("Paciente cadastrado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Paciente> mostrarTodos(){
		
		Connection con = Conexao.receberConexao();
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		
		String sql = "SELECT * FROM paciente";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				
				Paciente paciente = new Paciente();
				
				paciente.setCodigo(resultado.getInt("codigo"));
				paciente.setNome(resultado.getString("nome"));
				paciente.setIdade(resultado.getInt("idade"));
				paciente.setGenero(resultado.getString("genero"));
				paciente.setConvenio(resultado.getInt("convenio"));
				paciente.setCep(resultado.getInt("cep"));
				
				pacientes.add(paciente);
			}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pacientes;
	}
	
	public void excluir(int codigo) {
		
		Connection con = Conexao.receberConexao();
		
		String sql = "DELETE FROM paciente WHERE codigo = ?";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, codigo);
			
			preparar.execute();
			preparar.close();
			
			System.out.println("Usuario Excluido!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Paciente buscarCodigo(int codigo){
		
		Connection con = Conexao.receberConexao();
		Paciente paciente = null;
		
		String sql = "SELECT * FROM paciente WHERE codigo = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				paciente = new Paciente();

				paciente.setCodigo(resultado.getInt("codigo"));
				paciente.setNome(resultado.getString("nome"));
				paciente.setIdade(resultado.getInt("idade"));
				paciente.setGenero(resultado.getString("genero"));
				paciente.setConvenio(resultado.getInt("convenio"));
				paciente.setCep(resultado.getInt("cep"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public void alterar(Paciente paciente){
		
		Connection con = Conexao.receberConexao();
		
		String sql = "UPDATE paciente SET nome=?,idade=?,genero=?,convenio=?,cep=? WHERE codigo=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, paciente.getNome());
			preparador.setInt(2, paciente.getIdade());
			preparador.setString(3, paciente.getGenero());
			preparador.setInt(4, paciente.getConvenio());
			preparador.setInt(5, paciente.getCep());
			preparador.setInt(6, paciente.getCodigo());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Paciente alterado com sucesso!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}