package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class AdminDAO{
	Connection con;
	
	public void adicionar(Admin a) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbAdmin (nomeAdmin, loginAdmin, senhaAdmin) values (?,?,?)");
				   p.setString(1, a.getNomeAdmin());
				   p.setString(2, a.getLoginAdmin() );
				   p.setString(3, a.getSenhaAdmin());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Admin> retornaDados() {
		List<Admin> admin = new ArrayList<Admin>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbAdmin");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Admin a = new Admin();
				a.setCodAdmin(rs.getInt("codAdmin"));
				a.setNomeAdmin(rs.getString("nomeAdmin"));
				a.setLoginAdmin(rs.getString("loginAdmin"));
				a.setSenhaAdmin(rs.getString("senhaAdmin"));
				admin.add(a);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar admins");
		}		
		return admin;	
	}

	public void atualizar(Admin a) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbAdmin set nomeAdmin = ?, loginAdmin = ?, senhaAdmin = ? where codAdmin = ?");
				   p.setString(1, a.getNomeAdmin());
				   p.setString(2, a.getLoginAdmin() );
				   p.setString(3, a.getSenhaAdmin());
				   p.setInt(4, a.getCodAdmin());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<Admin> pesquisaEspecifica(String login) {
		List<Admin> admin = new ArrayList<Admin>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbAdmin WHERE loginAdmin like ?");
			p.setString(1, "%" + login + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Admin a = new Admin();
				a.setCodAdmin(rs.getInt("codAdmin"));
				a.setNomeAdmin(rs.getString("nomeAdmin"));
				a.setLoginAdmin(rs.getString("loginAdmin"));
				a.setSenhaAdmin(rs.getString("senhaAdmin"));
				admin.add(a);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return admin;
	}

}
