package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.TipoExame;
import model.TipoExameDAO;

public class ControleTipoExame {
	
	private TipoExameDAO tipoExameDao = new TipoExameDAO();
	
	public void adiciona(TipoExame t) throws SQLException {
		if(t != null) {
			tipoExameDao.adicionar(t);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o tipo de exame.");
		}
	}
	
	public TipoExame pesquisaTipo(String tipo){
		TipoExame t = tipoExameDao.pesquisaEspecifica(tipo);
		return t;
	}

}
