package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Raca;
import model.RacaDAO;

public class ControleRaca {

	private List<Raca> listaRaca = new ArrayList<>();
	private RacaDAO racaDao = new RacaDAO();

	public void adiciona(Raca r) {
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

	public void removeRaca(int cod) {
		List<Raca> listaPesquisa = new ArrayList<>();
		for (Raca r : listaRaca) {
			if (r.getCodRaca() == cod) {
				listaPesquisa.add(r);
			}
		}
		if (!listaPesquisa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ra�a exclu�da.");
			listaRaca.removeAll(listaPesquisa);
			listaPesquisa = null;
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel excluir a ra�a.");
		}
	}

}
