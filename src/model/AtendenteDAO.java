package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class AtendenteDAO {
	Connection con;
	
	public void adicionar(Atendente a) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbAtendente (nomeAtendente, cpfAtendente, loginAtendente, senhaAtendente, codAdmin, nivelPermissao) values (?,?,?,?,?,?)");
				   p.setString(1, a.getNomeAtendente());
				   p.setString(2, a.getCpfAtendente());
				   p.setString(3, a.getLoginAtendente());
				   p.setString(4, a.getSenhaAtendente());
				   p.setInt(5, a.getCodAdmin());
				   p.setInt(6, a.getNivelPermissao());				   
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Atendente> retornaDados() {
		List<Atendente> atend = new ArrayList<Atendente>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbAtendente");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Atendente a = new Atendente();
				a.setCodAtendente(rs.getInt("codAtendente"));
				a.setNomeAtendente(rs.getString("nomeAtendente"));
				a.setCpfAtendente(rs.getString("cpfAtendente"));
				a.setLoginAtendente(rs.getString("loginAtendente"));
				a.setNivelPermissao(rs.getInt("nivelPermissao"));
				a.setCodAdmin(rs.getInt("codAdmin"));
				atend.add(a);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar atendentes");
		}		
		return atend;	
	}

	public void atualizar(Atendente a) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbAtendente set nomeAtendente = ?, cpfAtendente = ?, loginAtendente = ?, senhaAtendente = ?, codAdmin = ?, nivelPermissao = ? where codAtendente = ?");
				p.setString(1, a.getNomeAtendente());
				p.setString(2, a.getCpfAtendente());
				p.setString(3, a.getLoginAtendente());
				p.setString(4, a.getSenhaAtendente());
				p.setInt(5, a.getCodAdmin());
				p.setInt(6, 1);	
				p.setInt(7, a.getCodAtendente());
				p.executeUpdate();
				p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<Atendente> pesquisaEspecifica(String login) {
		List<Atendente> atend = new ArrayList<Atendente>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbAtendente WHERE loginAtendente like ?");
			p.setString(1, "%" + login + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Atendente a = new Atendente();
				a.setCodAtendente(rs.getInt("codAtendente"));
				a.setNomeAtendente(rs.getString("nomeAtendente"));
				a.setCpfAtendente(rs.getString("cpfAtendente"));
				a.setLoginAtendente(rs.getString("loginAtendente"));
				a.setCodAdmin(rs.getInt("codAdmin"));
				atend.add(a);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return atend;
	}

}

