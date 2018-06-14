package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class PetDAO {
	Connection con;
	
	public void adicionar(Pet p1) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbPet (nomePet, vacinacaoPet, corPeloPet, descricaoPet, portePet, diaMortePet, horarioMortePet, codTutor, codRaca) values (?,?,?,?,?,?,?,?,?)");
				   p.setString(1, p1.getNomePet());
				   p.setInt(2, p1.getVacinacaoPet());
				   p.setString(3, p1.getCorPeloPet());
				   p.setString(4, p1.getDescricaoPet());
				   p.setString(5, p1.getPortePet());
				   p.setString(6, p1.getDiaMortePet());
				   p.setString(7, p1.getHoraMortePet());
				   p.setInt(8, p1.getCodTutor());
				   p.setInt(9, p1.getCodRaca());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Pet> retornaDados() {
		List<Pet> pet = new ArrayList<Pet >();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT p.codPet, p.nomePet, p.vacinacaoPet, p.corPeloPet, p.descricaoPet, p.portePet, p.diaMortePet, p.horarioMortePet, t.nomeTutor, r.descricaoRaca FROM tbpet p, tbtutor t, tbraca r WHERE p.codTutor = t.codTutor AND p.codRaca = r.codRaca");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Pet p1 = new Pet();
				p1.setCodPet(rs.getInt("codPet"));
				p1.setNomePet(rs.getString("nomePet"));
				p1.setVacinacaoPet(rs.getInt("vacinacaoPet"));
				p1.setCorPeloPet(rs.getString("corPeloPet"));
				p1.setDescricaoPet(rs.getString("descricaoPet"));
				p1.setPortePet(rs.getString("portePet"));
				p1.setDiaMortePet(rs.getString("diaMortePet"));
				p1.setHoraMortePet(rs.getString("horarioMortePet"));
				p1.setNomeTutor(rs.getString("nomeTutor"));
				p1.setDescRaca(rs.getString("descricaoRaca"));
				pet.add(p1);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar medicamentos");
		}		
		return pet;	
	}

	public void atualizar(Pet p1) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbPet set nomePet = ?, vacinacaoPet = ?, corPeloPet = ?, descricaoPet = ?, portePet = ?, diaMortePet = ?, horarioMortePet = ?, codTutor = ?, codRaca = ? where codMedicamento = ?");
					p.setString(1, p1.getNomePet());
					p.setInt(2, p1.getVacinacaoPet());
					p.setString(3, p1.getCorPeloPet());
			   		p.setString(4, p1.getDescricaoPet());
			   		p.setString(5, p1.getPortePet());
			   		p.setString(6, p1.getDiaMortePet());
			   		p.setString(7, p1.getHoraMortePet());
			   		p.setInt(8, p1.getCodTutor());
			   		p.setInt(9, p1.getCodRaca());
			   		p.setInt(10, p1.getCodPet());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<Pet> pesquisaEspecifica(String nome) {
		List<Pet> pet = new ArrayList<Pet>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT p.codPet, p.nomePet, p.vacinacaoPet, p.corPeloPet, p.descricaoPet, p.portePet, p.diaMortePet, p.horarioMortePet, t.nomeTutor, r.descricaoRaca FROM tbpet p, tbtutor t, tbraca r WHERE p.codTutor = t.codTutor AND p.codRaca = r.codRaca AND nomePet like ?");
			p.setString(1, "%" + nome + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Pet p1 = new Pet();
				p1.setCodPet(rs.getInt("codPet"));
				p1.setNomePet(rs.getString("nomePet"));
				p1.setVacinacaoPet(rs.getInt("vacinacaoPet"));
				p1.setCorPeloPet(rs.getString("corPeloPet"));
				p1.setDescricaoPet(rs.getString("descricaoPet"));
				p1.setPortePet(rs.getString("portePet"));
				p1.setDiaMortePet(rs.getString("diaMortePet"));
				p1.setHoraMortePet(rs.getString("horarioMortePet"));
				p1.setNomeTutor(rs.getString("nomeTutor"));
				p1.setDescRaca(rs.getString("descricaoRaca"));
				pet.add(p1);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return pet;
	}
}