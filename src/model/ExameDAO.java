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
				   p.setDate(1, (Date) e.getDataSolicitacao());
				   p.setDate(2, (Date) e.getDataExame());
				   p.setDate(3, (Date) e.getHoraExame());
				   p.setString(4, e.getResultadoExame());
				   p.setDouble(5, e.getPrecoTotalExame());
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
			p = con.prepareStatement("select * from tbExame");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Exame e = new Exame();
				e.setCodExame(rs.getInt("codExame"));
				e.setDataSolicitacao(rs.getDate("dataSolicitacao"));
				e.setDataExame(rs.getDate("dataExame"));
				e.setHoraExame(rs.getDate("horaExame"));
				e.setResultadoExame(rs.getString("resultadoExame"));
				e.setPrecoTotalExame(rs.getDouble("precoTotalExame"));
				e.setMortePet(rs.getInt("mortePet"));
				e.setCodPet(rs.getInt("codPet"));
				e.setCodAtendente(rs.getInt("codAtendente"));
				e.setCodTipoExame(rs.getInt("codTipoExame"));
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
			 	p.setDate(1, (Date) e.getDataSolicitacao());
			    p.setDate(2, (Date) e.getDataExame());
			    p.setDate(3, (Date) e.getHoraExame());
			    p.setString(4, e.getResultadoExame());
			    p.setDouble(5, e.getPrecoTotalExame());
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

	public List<Exame> pesquisaEspecifica(int cod) {
		List<Exame> exam = new ArrayList<Exame>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbExame WHERE codExame = ?");
			p.setInt(1, cod);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Exame e = new Exame();
				e.setCodExame(rs.getInt("codExame"));
				e.setDataSolicitacao(rs.getDate("dataSolicitacao"));
				e.setDataExame(rs.getDate("dataExame"));
				e.setHoraExame(rs.getDate("horaExame"));
				e.setResultadoExame(rs.getString("resultadoExame"));
				e.setPrecoTotalExame(rs.getDouble("precoTotalExame"));
				e.setMortePet(rs.getInt("mortePet"));
				e.setCodPet(rs.getInt("codPet"));
				e.setCodAtendente(rs.getInt("codAtendente"));
				e.setCodTipoExame(rs.getInt("codTipoExame"));
				exam.add(e);
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
