package controller;

import javax.swing.JOptionPane;

import model.Especie;
import model.EspecieDAO;

public class ControleEspecie {
	
	private EspecieDAO especieDao = new EspecieDAO();
	
	public void adiciona(Especie especie) {
		if(!especie.getDescricaoEspecie().equals("")) {
			especieDao.adicionar(especie);
			JOptionPane.showMessageDialog(null, "Esp�cie "+especie.getDescricaoEspecie()+" adicionada.");
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel salvar esp�cie.");
		}
	}
	
	public Especie busca(String descricao) {
		Especie e = especieDao.pesquisaEspecifica(descricao);
		return e;
	}

}
