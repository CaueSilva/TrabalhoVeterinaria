package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class VeterinarioExameDAO {
Connection con;
	
	public void adicionar(VeterinarioExame v) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbVeterinarioExame (codExame, codVeterinario) values (?,?)");
				   p.setInt(1, v.getCodExame());
				   p.setInt(2, v.getCodVeterinario());				   
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<VeterinarioExame> retornaDados() {
		List<VeterinarioExame> vet = new ArrayList<VeterinarioExame>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT e.codExame, v.nomeVeterinario, v.crmV FROM tbveterinarioexame ve, tbveterinario v, tbexame e WHERE ve.codExame = e.codExame AND ve.codVeterinario = v.codVeterinario");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				VeterinarioExame v = new VeterinarioExame();
				v.setCodExame(rs.getInt("codExame"));
				v.setNomeVeterinario(rs.getString("nomeVeterinario"));
				v.setCrmv(rs.getString("crmV"));
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

	public void atualizar(VeterinarioExame v) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbVeterinarioExame set codExame = ?, codVeterinario = ? where codExame = ?, codVeterinario = ?");
				p.setInt(1, v.getCodExame());
			    p.setInt(2, v.getCodVeterinario());
			    p.setInt(3, v.getCodExame());
			    p.setInt(4, v.getCodVeterinario());
			   	p.executeUpdate();
			   	p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<VeterinarioExame> pesquisaEspecifica(int codExame) {
		List<VeterinarioExame> vet = new  ArrayList<VeterinarioExame>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT e.codExame, v.nomeVeterinario, v.crmV FROM tbveterinarioexame ve, tbveterinario v, tbexame e WHERE ve.codExame = e.codExame AND ve.codVeterinario = v.codVeterinario AND codExame like ?");
			p.setInt(1, codExame);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				VeterinarioExame v = new VeterinarioExame();
				v.setCodExame(rs.getInt("codExame"));
				v.setNomeVeterinario(rs.getString("nomeVeterinario"));
				v.setCrmv(rs.getString("crmV"));
				vet.add(v);
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
