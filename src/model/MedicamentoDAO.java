package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class MedicamentoDAO {
	Connection con;
	
	public void adicionar(Medicamento m) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbMedicamento (nomeMedicamento, principioAtivo, tarjaMedicamento) values (?,?,?)");
				   p.setString(1, m.getNomeMedicamento());
				   p.setString(2, m.getPrincipioAtivo());
				   p.setString(3, m.getTarjaMedicamento());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Medicamento> retornaDados() {
		List<Medicamento> med = new ArrayList<Medicamento >();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbMedicamento");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Medicamento m = new Medicamento();
				m.setCodMedicamento(rs.getInt("codMedicamento"));
				m.setNomeMedicamento(rs.getString("nomeMedicamento"));
				m.setPrincipioAtivo(rs.getString("principioAtivo"));
				m.setTarjaMedicamento(rs.getString("tarjaMedicamento"));
				med.add(m);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar medicamentos");
		}		
		return med;	
	}

	public void atualizar(Medicamento m) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbMedicamento set nomeMedicamento = ?, principioAtivo = ?, tarjaMedicamento = ? where codMedicamento = ?");
					p.setString(1, m.getNomeMedicamento());
					p.setString(2, m.getPrincipioAtivo());
					p.setString(3, m.getTarjaMedicamento());
					p.setInt(4, m.getCodMedicamento());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<Medicamento> pesquisaEspecifica(String principio) {
		List<Medicamento> med = new ArrayList<Medicamento>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbMedicamento WHERE principioAtivo like ?");
			p.setString(1, "%" + principio + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Medicamento m = new Medicamento();
				m.setCodMedicamento(rs.getInt("codMedicamento"));
				m.setNomeMedicamento(rs.getString("nomeMedicamento"));
				m.setPrincipioAtivo(rs.getString("principioAtivo"));
				m.setTarjaMedicamento(rs.getString("tarjaMedicamento"));
				med.add(m);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return med;
	}
}
