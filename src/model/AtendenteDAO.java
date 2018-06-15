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
				   p.setInt(5, 1);
				   p.setInt(6, 1);				   
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
			p = con.prepareStatement("SELECT atd.codAtendente, atd.nomeAtendente, atd.cpfAtendente, atd.loginAtendente, a.loginAdmin FROM tbatendente atd, tbadmin a WHERE atd.codAdmin = a.loginAdmin");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Atendente a = new Atendente();
				a.setCodAtendente(rs.getInt("codAtendente"));
				a.setNomeAtendente(rs.getString("nomeAtendente"));
				a.setCpfAtendente(rs.getString("cpfAtendente"));
				a.setLoginAtendente(rs.getString("loginAtendente"));
				a.setLoginAdmin(rs.getString("loginAdmin"));
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
				//p.setInt(5, a.getCodAdmin());
				p.setInt(5, 1);
				p.setInt(6, 1);	
				p.setInt(7, a.getCodAtendente());
				p.executeUpdate();
				p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public Atendente pesquisaEspecifica(String login) {
		Atendente atend = new Atendente();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT atd.codAtendente, atd.nomeAtendente, atd.cpfAtendente, atd.loginAtendente, a.loginAdmin FROM tbatendente atd, tbadmin a WHERE atd.codAdmin = a.loginAdmin and loginAtendente like ?");
			p.setString(1, "%" + login + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Atendente a = new Atendente();
				a.setCodAtendente(rs.getInt("codAtendente"));
				a.setNomeAtendente(rs.getString("nomeAtendente"));
				a.setCpfAtendente(rs.getString("cpfAtendente"));
				a.setLoginAtendente(rs.getString("loginAtendente"));
				a.setLoginAdmin(rs.getString("loginAdmin"));
				atend=a;
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

