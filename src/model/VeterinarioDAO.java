package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class VeterinarioDAO {
	Connection con;
	
	public void adicionar(Veterinario v) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbVeterinario (nomeVeterinario, crmV, loginVeterinario, senhaVeterinario, nivelPermissao, codAdmin) values (?,?,?,?,?,?)");
				   p.setString(1, v.getNomeVeterinario());
				   p.setString(2, v.getCrmv());
				   p.setString(3, v.getLoginVeterinario());
				   p.setString(4, v.getSenhaVeterinario());
				   p.setInt(5, v.getNivelPermissao());
				   p.setInt(6, v.getCodAdmin());				   
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Veterinario> retornaDados() {
		List<Veterinario> vet = new ArrayList<Veterinario>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select v.codVeterinario, v.nomeVeterinario, v.crmV, v.loginVeterinario, a.loginAdmin from tbVeterinario v, tbadmin a WHERE v.codAdmin = a.codAdmin");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Veterinario v = new Veterinario();
				v.setCodVeterinario(rs.getInt("codVeterinario"));
				v.setNomeVeterinario(rs.getString("nomeVeterinario"));
				v.setCrmv(rs.getString("crmV"));
				v.setLoginVeterinario(rs.getString("loginVeterinario"));
				v.setLoginAdmin(rs.getString("loginAdmin"));
				vet.add(v);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar veterinários");
		}		
		return vet;	
	}

	public void atualizar(Veterinario v) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbVeterinario set nomeVeterinario = ?, crmV = ?, loginVeterinario = ?, senhaVeterinario = ?, nivelPermissao = ?, codAdmin = ?  where codVeterinario = ?");
			   	p.setString(1, v.getNomeVeterinario());
			   	p.setString(2, v.getCrmv());
			   	p.setString(3, v.getLoginVeterinario());
			   	p.setString(4, v.getSenhaVeterinario());
			   	p.setInt(5, v.getNivelPermissao());
			   	p.setInt(6, v.getCodAdmin());	
			   	p.setInt(7, v.getCodVeterinario());
			   	p.executeUpdate();
			   	p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public Veterinario pesquisaEspecifica(String crm) {
		Veterinario vet = new Veterinario();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select v.codVeterinario, v.nomeVeterinario, v.crmV, v.loginVeterinario, a.loginAdmin from tbVeterinario v, tbadmin a WHERE v.codAdmin = a.codAdmin and crmV like ?");
			p.setString(1, "%" + crm + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Veterinario v = new Veterinario();
				v.setCodVeterinario(rs.getInt("codVeterinario"));
				v.setNomeVeterinario(rs.getString("nomeVeterinario"));
				v.setCrmv(rs.getString("crmV"));
				v.setLoginVeterinario(rs.getString("loginVeterinario"));
				v.setLoginAdmin(rs.getString("loginAdmin"));
				vet=v;
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return vet;
	}

}