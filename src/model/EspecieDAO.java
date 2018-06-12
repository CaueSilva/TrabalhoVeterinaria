package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conexao;

public class EspecieDAO {
	Connection con;
	
	public void adicionar(Especie e) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbEspecie (descricaoEspecie, codAdmin) values (?,?)");
				   p.setString(1, e.getDescricaoEspecie());
				   p.setInt(2, e.getCodAdmin());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Especie> retornaDados() {
		List<Especie> esp = new ArrayList<Especie>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbEspecie");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Especie e = new Especie();
				e.setCodEspecie(rs.getInt("codEspecie"));
				e.setDescricaoEspecie(rs.getString("descricaoEspecie"));
				e.setCodAdmin(rs.getInt("codAdmin"));
				esp.add(e);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar especies");
		}		
		return esp;	
	}

	public void atualizar(Especie e) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbEspecie set descricaoEspecie = ?, codAdmin = ? where codEspecie = ?");
			  		p.setString(1, e.getDescricaoEspecie());
			  		p.setInt(2, e.getCodAdmin());
			  		p.setInt(3, e.getCodEspecie());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<Especie> pesquisaEspecifica(String desc) {
		List<Especie> esp = new ArrayList<Especie>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbEspecie WHERE descricaoEspecie like ?");
			p.setString(1, "%" + desc + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Especie e = new Especie();
				e.setCodEspecie(rs.getInt("codEspecie"));
				e.setDescricaoEspecie(rs.getString("descricaoEspecie"));
				e.setCodAdmin(rs.getInt("codAdmin"));
				esp.add(e);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return esp;
	}

}
