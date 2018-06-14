package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class ReceitaDAO {
	Connection con;
	
	public void adicionar(Receita r) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbReceita (obsReceita , dataEmissao, dataValidade, codPet, codVeterinario) values (?,?,?,?,?)");
				   p.setString(1, r.getObsReceita());
				   p.setString(2, r.getDataEmissao());
				   p.setString(3, r.getDataValidade());
				   p.setInt(4, r.getCodPet());
				   p.setInt(5, r.getCodVeterinario());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Receita> retornaDados() {
		List<Receita> rec = new ArrayList<Receita>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT r.codReceita, r.obsReceita, r.dataEmissao, r.dataValidade, p.nomePet, v.nomeVeterinario FROM tbreceita r, tbpet p, tbveterinario v WHERE r.codPet = p.codPet AND r.codVeterinario = v.codVeterinario");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Receita r = new Receita();
				r.setCodReceita(rs.getInt("codReceita"));
				r.setObsReceita(rs.getString("obsReceita"));
				r.setDataEmissao(rs.getString("dataEmissao"));
				r.setDataValidade(rs.getString("dataValidade"));
				r.setNomePet(rs.getString("nomePet"));
				r.setNomeVeterinario(rs.getString("nomeVeterinario"));
				rec.add(r);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar medicamentos");
		}		
		return rec;	
	}

	public void atualizar(Receita r) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbReceita set obsReceita = ?, dataEmissao = ?, dataValidade = ?, codPet = ?, codVeterinario = ? where codReceita = ?");
					p.setString(1, r.getObsReceita());
			   		p.setString(2, r.getDataEmissao());
			   		p.setString(3, r.getDataValidade());
			   		p.setInt(4, r.getCodPet());
			   		p.setInt(5, r.getCodVeterinario());
			   		p.setInt(6, r.getCodReceita());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public Receita pesquisaEspecifica(int codReceita) {
		Receita rec = new Receita();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT r.codReceita, r.obsReceita, r.dataEmissao, r.dataValidade, p.nomePet, v.nomeVeterinario FROM tbreceita r, tbpet p, tbveterinario v WHERE r.codPet = p.codPet AND r.codVeterinario = v.codVeterinario AND codReceita = ?");
			p.setInt(1, codReceita);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Receita r = new Receita();
				r.setCodReceita(rs.getInt("codReceita"));
				r.setObsReceita(rs.getString("obsReceita"));
				r.setDataEmissao(rs.getString("dataEmissao"));
				r.setDataValidade(rs.getString("dataValidade"));
				r.setNomePet(rs.getString("nomePet"));
				r.setNomeVeterinario(rs.getString("nomeVeterinario"));
				rec=r;
			}			
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return rec;
	}
}
