package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class MedicamentoReceitaDAO {
Connection con;
	
	public void adicionar(MedicamentoReceita m) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbMedicamentoReceita  (dosagemMedicamento, intervaloMedicamento, periodoMedicamento, codMedicamento, codReceita) values (?,?,?,?,?)");
				   p.setString(1, m.getDosagemMedicamento());
				   p.setString(2, m.getIntervaloMedicamento());
				   p.setString(3, m.getPeriodoMedicamentoo());
				   p.setInt(4, m.getCodMedicamento());
				   p.setInt(5, m.getCodReceita());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<MedicamentoReceita> retornaDados() {
		List<MedicamentoReceita> med = new ArrayList<MedicamentoReceita>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select mr.dosagemMedicamento, mr.intervaloMedicamento, mr.periodoMedicamento, m.nomeMedicamento, r.codReceita " + 
					"from tbmedicamentoreceita mr, tbmedicamento m, tbreceita " + 
					"WHERE mr.codMedicamento = m.codMedicamento AND mr.codReceita = r.codReceita");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				MedicamentoReceita m = new MedicamentoReceita();
				m.setDosagemMedicamento(rs.getString("dosagemMedicamento"));
				m.setIntervaloMedicamento(rs.getString("intervaloMedicamento"));
				m.setPeriodoMedicamento(rs.getString("periodoMedicamento"));
				m.setNomeMedicamento(rs.getString("nomeMedicamento"));
				m.setCodReceita(rs.getInt("codReceita"));
				med.add(m);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar medicamentos da receita");
		}		
		return med;	
	}

	public void atualizar(MedicamentoReceita m) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbMedicamentoReceita set dosagemMedicamento = ?, intervaloMedicamento = ?, periodoMedicamento = ?, codMedicamento = ? where codReceita = ?");
			p.setString(1, m.getDosagemMedicamento());
			   		p.setString(2, m.getIntervaloMedicamento());
			   		p.setString(3, m.getPeriodoMedicamentoo());
			   		p.setInt(4, m.getCodMedicamento());
			   		p.setInt(5, m.getCodReceita());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<MedicamentoReceita> pesquisaEspecifica(int codReceita) {
		List<MedicamentoReceita> med = new ArrayList<MedicamentoReceita>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select mr.dosagemMedicamento, mr.intervaloMedicamento, mr.periodoMedicamento, m.nomeMedicamento, r.codReceita " + 
					"from tbmedicamentoreceita mr, tbmedicamento m, tbreceita " + 
					"WHERE mr.codMedicamento = m.codMedicamento AND mr.codReceita = r.codReceita AND principioAtivo = ?");
			p.setInt(1, codReceita);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				MedicamentoReceita m = new MedicamentoReceita();
				m.setDosagemMedicamento(rs.getString("dosagemMedicamento"));
				m.setIntervaloMedicamento(rs.getString("intervaloMedicamento"));
				m.setPeriodoMedicamento(rs.getString("periodoMedicamento"));
				m.setNomeMedicamento(rs.getString("nomeMedicamento"));
				m.setCodReceita(rs.getInt("codReceita"));
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
