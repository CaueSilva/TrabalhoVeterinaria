package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.TipoConsulta;
import model.TipoConsultaDAO;

public class ControleTipoConsulta {
	
	private TipoConsultaDAO tipoConsultaDao = new TipoConsultaDAO();
	
	public void adiciona(TipoConsulta t) throws SQLException {
		if(t != null) {
			tipoConsultaDao.adicionar(t);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o tipo de consulta.");
		}
	}
	
	public TipoConsulta pesquisaTipo(String tipo) {
		TipoConsulta t = tipoConsultaDao.pesquisaEspecifica(tipo);
		return t;
	}
	
}
