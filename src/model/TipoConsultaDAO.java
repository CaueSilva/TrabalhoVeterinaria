package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class TipoConsultaDAO {
	Connection con;
	
	public void adicionar(TipoConsulta tc) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbTipoConsulta (descricaoTipoConsulta, precoConsulta, codAdmin) values (?,?,?)");
				   p.setString(1, tc.getDescricaoTipoConsulta());
				   p.setDouble(2, tc.getPrecoConsulta());
				   p.setInt(3, tc.getCodAdmin());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<TipoConsulta> retornaDados() {
		List<TipoConsulta> tc = new ArrayList<TipoConsulta>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbTipoConsulta");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				TipoConsulta t = new TipoConsulta();
				t.setCodTipoConsulta(rs.getInt("codTipoConsulta"));
				t.setDescricaoTipoConsulta(rs.getString("descricaoTipoConsulta"));
				t.setPrecoConsulta(rs.getDouble("precoConsulta"));
				t.setCodAdmin(rs.getInt("codAdmin"));
				tc.add(t);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar consultas");
		}		
		return tc;	
	}

	public void atualizar(TipoConsulta tc) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbTipoConsulta set descricaoTipoConsulta = ?, precoConsulta = ?, codAdmin = ? where codTipoConsulta = ?");
					p.setString(1, tc.getDescricaoTipoConsulta());
					p.setDouble(2, tc.getPrecoConsulta());
					p.setInt(3, tc.getCodAdmin());
			 		p.setInt(4, tc.getCodTipoConsulta());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<TipoConsulta> pesquisaEspecifica(String desc) {
		List<TipoConsulta> tc = new ArrayList<TipoConsulta>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbTipoConsulta WHERE descricaoTipoConsulta like ?");
			p.setString(1, "%" + desc + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				TipoConsulta t = new TipoConsulta();
				t.setCodTipoConsulta(rs.getInt("codTipoConsulta"));
				t.setDescricaoTipoConsulta(rs.getString("descricaoTipoConsulta"));
				t.setPrecoConsulta(rs.getDouble("precoConsulta"));
				t.setCodAdmin(rs.getInt("codAdmin"));
				tc.add(t);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return tc;
	}
}

