package controller;

import javax.swing.JOptionPane;

import model.Especie;
import model.EspecieDAO;

public class ControleEspecie {
	
	private EspecieDAO especieDao = new EspecieDAO();
	
	public void adiciona(Especie especie) {
		if(!especie.getDescricaoEspecie().equals("")) {
			especieDao.adicionar(especie);
			JOptionPane.showMessageDialog(null, "Espécie "+especie.getDescricaoEspecie()+" adicionada.");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar espécie.");
		}
	}
	
	public Especie busca(String descricao) {
		Especie e = especieDao.pesquisaEspecifica(descricao);
		return e;
	}

}
