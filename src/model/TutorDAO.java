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

public class TutorDAO {
Connection con;
	
	public void adicionar(Tutor t) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbTutor (nomeTutor, cpfTutor, ruaTutor, cepTutor, numeroTutor, complementoTutor, bairroTutor, cidadeTutor, estadoTutor, celularTutor, telefoneTutor, emailTutor) values (?,?,?,?,?,?,?,?,?,?,?,?)");
				   p.setString(1, t.getNomeTutor());
				   p.setString(2, t.getCpfTutor());
				   p.setString(3, t.getRuaTutor());
				   p.setInt(4, t.getCepTutor());
				   p.setInt(5, t.getNumeroTutor());
				   p.setString(6, t.getComplementoTutor());
				   p.setString(7, t.getBairroTutor());
				   p.setString(8, t.getCidadeTutor());
				   p.setString(9, t.getEstadoTutor());
				   p.setInt(10, t.getCelularTutor());
				   p.setInt(11, t.getTelefoneTutor());
				   p.setString(12, t.getEmailTutor());	   
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Tutor> retornaDados() {
		List<Tutor> tut = new ArrayList<Tutor>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbTutor");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Tutor t = new Tutor();
				t.setCodTutor(rs.getInt("codTutor"));
				t.setNomeTutor(rs.getString("nomeTutor"));
				t.setCpfTutor(rs.getString("cpfTutor"));
				t.setRuaTutor(rs.getString("ruaTutor"));
				t.setCepTutor(rs.getInt("cepTutor"));
				t.setNumeroTutor(rs.getInt("numeroTutor"));
				t.setComplementoTutor(rs.getString("complementoTutor"));
				t.setBairroTutor(rs.getString("bairroTutor"));
				t.setCidadeTutor(rs.getString("cidadeTutor"));
				t.setEstadoTutor(rs.getString("estadoTutor"));
				t.setCelularTutor(rs.getInt("celularTutor"));
				t.setTelefoneTutor(rs.getInt("telefoneTutor"));
				t.setEmailTutor(rs.getString("emailTutor" ));
				tut.add(t);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar atendentes");
		}		
		return tut;	
	}

	public void atualizar(Tutor t) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbTutor set nomeTutor = ?, cpfTutor = ?, ruaTutor = ?, cepTutor = ?, numeroTutor = ?, complementoTutor = ?, bairroTutor = ?, cidadeTutor = ?, estadoTutor = ?, celularTutor = ?, telefoneTutor = ?, emailTutor = ? where codExame = ?");
				p.setString(1, t.getNomeTutor());
				p.setString(2, t.getCpfTutor());
				p.setString(3, t.getRuaTutor());
				p.setInt(4, t.getCepTutor());
				p.setInt(5, t.getNumeroTutor());
				p.setString(6, t.getComplementoTutor());
				p.setString(7, t.getBairroTutor());
				p.setString(8, t.getCidadeTutor());
				p.setString(9, t.getEstadoTutor());
				p.setInt(10, t.getCelularTutor());
			   	p.setInt(11, t.getTelefoneTutor());
			   	p.setString(12, t.getEmailTutor());	
			   	p.setInt(13, t.getCodTutor());
			   	p.executeUpdate();
				p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public Tutor pesquisaEspecifica(String cpf) {
		Tutor tut = new Tutor();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbTutor WHERE cpfTutor like ?");
			p.setString(1, "%" + cpf + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Tutor t = new Tutor();
				t.setCodTutor(rs.getInt("codTutor"));
				t.setNomeTutor(rs.getString("nomeTutor"));
				t.setCpfTutor(rs.getString("cpfTutor"));
				t.setRuaTutor(rs.getString("ruaTutor"));
				t.setCepTutor(rs.getInt("cepTutor"));
				t.setNumeroTutor(rs.getInt("numeroTutor"));
				t.setComplementoTutor(rs.getString("complementoTutor"));
				t.setBairroTutor(rs.getString("bairroTutor"));
				t.setCidadeTutor(rs.getString("cidadeTutor"));
				t.setEstadoTutor(rs.getString("estadoTutor"));
				t.setCelularTutor(rs.getInt("celularTutor"));
				t.setTelefoneTutor(rs.getInt("telefoneTutor"));
				t.setEmailTutor(rs.getString("emailTutor" ));
				tut = t;
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return tut;
	}

}