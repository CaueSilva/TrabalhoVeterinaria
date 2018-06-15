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

public class ExameDAO {
Connection con;
	
	public void adicionar(Exame e) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbExame (dataSolicitacao, dataExame, horaExame, resultadoExame, precoTotalExame, mortePet, codPet, codAtendente, codTipoConsulta) values (?,?,?,?,?,?,?,?,?)");
				   p.setString(1, e.getDataSolicitacao());
				   p.setString(2, e.getDataExame());
				   p.setString(3, e.getHoraExame());
				   p.setString(4, e.getResultadoExame());
				   p.setString(5, e.getPrecoTotalExame());
				   p.setInt(6, e.getMortePet());
				   p.setInt(7, e.getCodPet());
				   p.setInt(8, e.getCodAtendente());
				   p.setInt(9, e.getCodTipoExame());			   
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Exame> retornaDados() {
		List<Exame> exam = new ArrayList<Exame>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT e.codExame, e.dataSolicitacao, e.dataExame, e.horaExame, e.resultadoExame, e.precoTotalExame, e.mortePet, p.nomePet, a.loginAtendente, te.descricaoTipoExame " + 
					"FROM tbexame e, tbpet p, tbatendente a, tbtipoexame te " + 
					"WHERE e.codPet = p.codPet AND e.codAtendente = a.codAtendente AND e.codTipoExame = te.codTipoExame");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Exame e = new Exame();
				e.setCodExame(rs.getInt("codExame"));
				e.setDataSolicitacao(rs.getString("dataSolicitacao"));
				e.setDataExame(rs.getString("dataExame"));
				e.setHoraExame(rs.getString("horaExame"));
				e.setResultadoExame(rs.getString("resultadoExame"));
				e.setPrecoTotalExame(rs.getString("precoTotalExame"));
				e.setMortePet(rs.getInt("mortePet"));
				e.setNomePet(rs.getString("nomePet"));
				e.setNomeAtendente(rs.getString("loginAtendente"));
				e.setDescTipoExame(rs.getString("descricaoTipoExame"));
				exam.add(e);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException ex) {
			System.out.print("Erro ao listar atendentes");
		}		
		return exam;	
	}

	public void atualizar(Exame e) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbExame set dataSolicitacao = ?, dataExame = ?, horaExame = ?, resultadoExame = ?, precoTotalExame = ?, mortePet = ?, codPet = ?, codAtendente = ?, codTipoConsulta = ? where codExame = ?");
			 	p.setString(1, e.getDataSolicitacao());
			    p.setString(2, e.getDataExame());
			    p.setString(3, e.getHoraExame());
			    p.setString(4, e.getResultadoExame());
			    p.setString(5, e.getPrecoTotalExame());
			    p.setInt(6, e.getMortePet());
			    p.setInt(7, e.getCodPet());
			    p.setInt(8, e.getCodAtendente());
			    p.setInt(9, e.getCodTipoExame());
			    p.setInt(10, e.getCodExame());
				p.executeUpdate();
				p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public Exame pesquisaEspecifica(int cod) {
		Exame exam = new Exame();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT e.codExame, e.dataSolicitacao, e.dataExame, e.horaExame, e.resultadoExame, e.precoTotalExame, e.mortePet, p.nomePet, a.loginAtendente, te.descricaoTipoExame " + 
									 "FROM tbexame e, tbpet p, tbatendente a, tbtipoexame te " + 
								     "WHERE e.codPet = p.codPet AND e.codAtendente = a.codAtendente AND e.codTipoExame = te.codTipoExame AND codExame = ?");
			p.setInt(1, cod);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Exame e = new Exame();
				e.setCodExame(rs.getInt("codExame"));
				e.setDataSolicitacao(rs.getString("dataSolicitacao"));
				e.setDataExame(rs.getString("dataExame"));
				e.setHoraExame(rs.getString("horaExame"));
				e.setResultadoExame(rs.getString("resultadoExame"));
				e.setPrecoTotalExame(rs.getString("precoTotalExame"));
				e.setMortePet(rs.getInt("mortePet"));
				e.setNomePet(rs.getString("nomePet"));
				e.setNomeAtendente(rs.getString("loginAtendente"));
				e.setDescTipoExame(rs.getString("descricaoTipoExame"));
				exam=e;
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return exam;
	}
		
}
