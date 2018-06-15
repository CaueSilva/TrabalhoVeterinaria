package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Raca;
import model.RacaDAO;

public class ControleRaca {

	private RacaDAO racaDao = new RacaDAO();

	public void adiciona(Raca r) throws SQLException {
		if (r != null) {
			racaDao.adicionar(r);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel adicionar ra�a.");
		}
	}

	public Raca buscaRaca(String desc) {
		Raca r = racaDao.pesquisaEspecifica(desc);
		return r;
	}

}
