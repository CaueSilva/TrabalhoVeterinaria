package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class RacaDAO {
	Connection con;
	
	public void adicionar(Raca r) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbRaca (descricaoRaca, codEspecie, codAdmin) values (?,?,?)");
				   p.setString(1, r.getDescricaoRaca());
				   p.setInt(2, r.getCodEspecie());
				   //p.setInt(3, r.getCodAdmin());
				   p.setInt(3, 1);
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Raca> retornaDados() {
		List<Raca> ra = new ArrayList<Raca>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT r.codRaca, r.descricaoRaca, e.descricaoEspecie, a.loginAdmin FROM tbraca r, tbadmin a, tbespecie e WHERE r.codEspecie = e.codEspecie AND r.codAdmin = a.codAdmin");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Raca r = new Raca();
				r.setCodRaca(rs.getInt("codRaca"));
				r.setDescricaoRaca(rs.getString("descricaoRaca"));
				r.setDescEspecie(rs.getString("descricaoEspecie"));
				r.setLoginAdmin(rs.getString("loginAdmin"));
				ra.add(r);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar ra�as");
		}		
		return ra;	
	}

	public void atualizar(Raca r) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbRaca set descricaoRaca = ?, codEspecie = ?, codAdmin = ? where codRaca = ?");
			 		p.setString(1, r.getDescricaoRaca());
			 		p.setInt(2, r.getCodEspecie());
			 		//p.setInt(3, r.getCodAdmin());
			 		p.setInt(3, 1);
			 		p.setInt(4, r.getCodRaca());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public Raca pesquisaEspecifica(String desc) {
		Raca ra = new Raca();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT r.codRaca, r.descricaoRaca, e.descricaoEspecie, a.loginAdmin FROM tbraca r, tbadmin a, tbespecie e WHERE r.codEspecie = e.codEspecie AND r.codAdmin = a.codAdmin and descricaoRaca like ?");
			p.setString(1, "%" + desc + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Raca r = new Raca();
				r.setCodRaca(rs.getInt("codRaca"));
				r.setDescricaoRaca(rs.getString("descricaoRaca"));
				r.setDescEspecie(rs.getString("descricaoEspecie"));
				r.setLoginAdmin(rs.getString("loginAdmin"));
				ra=r;
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return ra;
	}
	
	public List<Raca> pesquisaPorEspecie(String descEspec) {
		List<Raca> ra = new ArrayList<Raca>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT r.codRaca, r.descricaoRaca, e.descricaoEspecie, a.loginAdmin FROM tbraca r, tbadmin a, tbespecie e WHERE r.codEspecie = e.codEspecie AND r.codAdmin = a.codAdmin and e.descricaoEspecie = ?");
			p.setString(1, descEspec);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Raca r = new Raca();
				r.setCodRaca(rs.getInt("codRaca"));
				r.setDescricaoRaca(rs.getString("descricaoRaca"));
				r.setDescEspecie(rs.getString("descricaoEspecie"));
				r.setLoginAdmin(rs.getString("loginAdmin"));
				ra.add(r);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma ra�a encontrada nessa esp�cie");
		}		
		return ra;
	}
	
}
