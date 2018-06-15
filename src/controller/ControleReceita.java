package controller;

import javax.swing.JOptionPane;

import model.Receita;
import model.ReceitaDAO;

public class ControleReceita {
	
	private ReceitaDAO receitaDao = new ReceitaDAO();
	
	public void adiciona(Receita r) {
		if(r != null) {
			receitaDao.adicionar(r);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel adicionar a ra�a.");
		}
	}
	
	public Receita buscaReceita(int cod) {
		Receita r = receitaDao.pesquisaEspecifica(cod);
		return r;
	}
	
}
