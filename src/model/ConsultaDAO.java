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

public class ConsultaDAO {
	Connection con;
	
	public void adicionar(Consulta c1) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbConsulta (dataMarcacao, dataConsulta, horaConsulta, encaminhamentoExame, precoTotalConsulta, resultadoConsulta, mortePet, codPet, codVeterinario, codAtendente, codTipoConsulta) values (?,?,?,?,?,?,?,?,?,?,?)");
				   p.setDate(1, (Date) c1.getDataMarcacao());
				   p.setDate(2, (Date) c1.getDataConsulta());
				   p.setDate(3, (Date) c1.getHoraConsulta());
				   p.setInt(4, c1.getEncaminhamentoExame());
				   p.setDouble(5, c1.getPrecoTotalConsulta());
				   p.setString(6, c1.getResultadoConsulta());
				   p.setInt(7, c1.getMortePet());
				   p.setInt(8, c1.getCodPet());
				   p.setInt(9, c1.getCodVeterinario());
				   p.setInt(10, c1.getCodAtendente());
				   p.setInt(11, c1.getCodTipoConsulta());			   
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<Consulta> retornaDados() {
		List<Consulta> cons = new ArrayList<Consulta>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbConsulta");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Consulta c1 = new Consulta();
				c1.setCodConsulta(rs.getInt("codConsulta"));
				c1.setDataMarcacao(rs.getDate("dataMarcacao"));
				c1.setDataConsulta(rs.getDate("dataConsulta"));
				c1.setHoraConsulta(rs.getDate("horaConsulta"));
				c1.setEncaminhamentoExame(rs.getInt("encaminhamentoExame"));
				c1.setPrecoTotalConsulta(rs.getDouble("precoTotalConsulta"));
				c1.setResultadoConsulta(rs.getString("resultadoConsulta"));
				c1.setMortePet(rs.getInt("mortePet"));
				c1.setCodPet(rs.getInt("codPet"));
				c1.setCodVeterinario(rs.getInt("codVeterinario"));
				c1.setCodAtendente(rs.getInt("codAtendente"));
				c1.setCodTipoConsulta(rs.getInt("codTipoConsulta"));
				cons.add(c1);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar atendentes");
		}		
		return cons;	
	}

	public void atualizar(Consulta c1) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbConsulta set dataMarcacao = ?, dataConsulta = ?, horaConsulta = ?, encaminhamentoExame = ?, precoTotalConsulta = ?, resultadoConsulta = ?, mortePet = ?, codPet = ?, codVeterinario = ?, codAtendente = ?, codTipoConsulta = ? where codConsulta = ?");
			 	p.setDate(1, (Date) c1.getDataMarcacao());
			    p.setDate(2, (Date) c1.getDataConsulta());
			    p.setDate(3, (Date) c1.getHoraConsulta());
			    p.setInt(4, c1.getEncaminhamentoExame());
			    p.setDouble(5, c1.getPrecoTotalConsulta());
			    p.setString(6, c1.getResultadoConsulta());
			    p.setInt(7, c1.getMortePet());
			    p.setInt(8, c1.getCodPet());
			    p.setInt(9, c1.getCodVeterinario());
			    p.setInt(10, c1.getCodAtendente());
			    p.setInt(11, c1.getCodTipoConsulta());
			    p.setInt(12, c1.getCodConsulta());
				p.executeUpdate();
				p.close();
			con = c.fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<Consulta> pesquisaEspecifica(int cod) {
		List<Consulta> cons = new ArrayList<Consulta>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbConsulta WHERE loginAtendente = ?");
			p.setInt(1, cod);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Consulta c1 = new Consulta();
				c1.setCodConsulta(rs.getInt("codConsulta"));
				c1.setDataMarcacao(rs.getDate("dataMarcacao"));
				c1.setDataConsulta(rs.getDate("dataConsulta"));
				c1.setHoraConsulta(rs.getDate("horaConsulta"));
				c1.setEncaminhamentoExame(rs.getInt("encaminhamentoExame"));
				c1.setPrecoTotalConsulta(rs.getDouble("precoTotalConsulta"));
				c1.setResultadoConsulta(rs.getString("resultadoConsulta"));
				c1.setMortePet(rs.getInt("mortePet"));
				c1.setCodPet(rs.getInt("codPet"));
				c1.setCodVeterinario(rs.getInt("codVeterinario"));
				c1.setCodAtendente(rs.getInt("codAtendente"));
				c1.setCodTipoConsulta(rs.getInt("codTipoConsulta"));
				cons.add(c1);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return cons;
	}

}