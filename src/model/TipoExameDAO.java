package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class TipoExameDAO {
Connection con;
	
	public void adicionar(TipoExame te) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("insert into tbTipoExame (descricaoTipoExame, precoExame, codAdmin) values (?,?,?)");
				   p.setString(1, te.getDescricaoTipoExame());
				   p.setDouble(2, te.getPrecoExame());
				   p.setInt(3, te.getCodAdmin());
				   p.executeUpdate();
				   p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}	
	}

	public List<TipoExame> retornaDados() {
		List<TipoExame> te = new ArrayList<TipoExame>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select * from tbTipoExame");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				TipoExame t = new TipoExame();
				t.setCodTipoExame(rs.getInt("codTipoExame"));
				t.setDescricaoTipoExame(rs.getString("descricaoTipoExame"));
				t.setPrecoExame(rs.getDouble("precoExame"));
				t.setCodAdmin(rs.getInt("codAdmin"));
				te.add(t);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			System.out.print("Erro ao listar exames");
		}		
		return te;	
	}

	public void atualizar(TipoExame te) {
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("update tbTipoExame set descricaoTipoExame = ?, precoExame = ?, codAdmin = ? where codTipoExame = ?");
					p.setString(1, te.getDescricaoTipoExame());
					p.setDouble(2, te.getPrecoExame());
					p.setInt(3, te.getCodAdmin());
			 		p.setInt(4, te.getCodTipoExame());
			  		p.executeUpdate();
			  		p.close();
			con = c.fechar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}	
		
	}

	public List<TipoExame> pesquisaEspecifica(String desc) {
		List<TipoExame> te = new ArrayList<TipoExame>();
		Conexao c = new Conexao();
		con = c.abrir();
		PreparedStatement p;
		try {
			p = con.prepareStatement("SELECT * from tbTipoExame WHERE descricaoTipoExame like ?");
			p.setString(1, "%" + desc + "%");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				TipoExame t = new TipoExame();
				t.setCodTipoExame(rs.getInt("codTipoExame"));
				t.setDescricaoTipoExame(rs.getString("descricaoTipoExame"));
				t.setPrecoExame(rs.getDouble("precoExame"));
				t.setCodAdmin(rs.getInt("codAdmin"));
				te.add(t);
			}
		rs.close();
		p.close();
		con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nenhuma dado encontrado");
		}		
		return te;
	}
}
