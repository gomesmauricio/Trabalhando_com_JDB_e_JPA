package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import conexao.Conexao;
import entidade.Aluno;

public class AlunoDAO {
	
	//1 - Consulta
	public List<Aluno> list() {
		
		//Prepara lita que irá retornar alunos após consultar o banco de dados;
		List<Aluno> alunos = new ArrayList<>();
		
		
		try(Connection conn = Conexao.getConnection()) {
				
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM aluno");
				
			ResultSet rs = pstm.executeQuery();
				
			while (rs.next()) {
				
				//Aluno(int id, String nome, int idade, String estado) 
				Aluno aluno = new Aluno(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getInt("idade"), 
						rs.getString("estado")
					);
				alunos.add(aluno);
			}
			
		} catch (Exception e) {
			
		}
		
		return alunos;	
	}
	
	//Consulta com filtro
	
	public Aluno getById(int id) {
		//Prepara objeto para receber valores do banco de dados.
		Aluno aluno = new Aluno();
		
		try (Connection conn = Conexao.getConnection()){
			//Preparar consulta SQL
			String sql = "SELECT * FROM aluno WHERE id = ?";
			
			//Prepara Statement com os parametro recebidos
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			
			//Executa a cunsulta e armazena o retorno da consulta no objet "rs".
			ResultSet rs = stm.executeQuery();
			
			//Guardar valores retornados da tabela aluno no objeto aluno
			if(rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setEstado(rs.getString("estado"));	
			}
			
		}catch(SQLException e){
			System.out.println("Lista de alunos Falhou!");
			e.printStackTrace();		
		}
		return aluno;
		
	}
	
	//Inserção
	public void create(Aluno aluno) {
		try (Connection conn = Conexao.getConnection()){
			
			//Preparar SQL para inserção de dados do aluno.
			String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?,?,?)";
			
			//Preparar statement com os parametros recebidos
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, aluno.getNome());
			stm.setInt(2, aluno.getIdade());
			stm.setString(3, aluno.getEstado());
			
			//Executa inserção e armazena o numero de liha afetadas
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Inserção bem sucedida " + rowsAffected + "Linha");
		} catch (Exception e) {
			System.out.println("Inserção FALHOU!");
			e.printStackTrace();
		}
	}
	
	//Delete
	public  void delete(int id) {
		
		try (Connection conn = Conexao.getConnection()){
			
			//Prepara SQL para deletar Linha.
			String sql = "DELETE FROM aluno WHERE id = ?";
			
			//Prepara statement com os parametros recebidos
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			
			//Executa delete e armazena o numero de linhas afetadas
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Delete BEM SUCEDIDA! Foi deletada " +rowsAffected+ " Linha");
			
		} catch (SQLException e) {
			System.out.println("Delete FALHOU!");
			e.printStackTrace();
		}
		
	}
	
	//Atualizar
	public void update(Aluno aluno) {
		
		try (Connection conn = Conexao.getConnection()){
			
			//Preparar SQL para atualizar linha
			String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";
			
			//Preparar statement com parametros recebidos
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, aluno.getNome());
			stm.setInt(2, aluno.getIdade());
			stm.setString(3, aluno.getEstado());
			stm.setInt(4, aluno.getId());
			
			//Executa atualização e armazena o numero de linhas afetadas
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Atualização BEM SUCEDIDA! foi atualizada: " + rowsAffected+" linha");
			
		} catch (SQLException e) {
			System.out.println("Atualização FALHOU!");
			e.printStackTrace();
		}
	}
	
	
	

}
