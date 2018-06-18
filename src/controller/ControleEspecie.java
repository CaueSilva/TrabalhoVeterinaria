package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Especie;
import model.EspecieDAO;

public class ControleEspecie {
	
	private EspecieDAO especieDao = new EspecieDAO();
	private List<Especie> listaEspecie = new ArrayList<>();
	
	public void adiciona(Especie especie) throws SQLException {
		if(!especie.getDescricaoEspecie().equals("")) {
			especieDao.adicionar(especie);
			listaEspecie.add(especie);
			JOptionPane.showMessageDialog(null, "Espécie "+especie.getDescricaoEspecie()+" adicionada.");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar espécie.");
		}
	}
	
	public Especie busca(String descricao) {
		Especie e = especieDao.pesquisaEspecifica(descricao);
		return e;
	}
	
	public String[] retornaVetor(){
		String vet[] = new String[listaEspecie.size()];
		int cont = 0;
		for(Especie e : listaEspecie) {
			vet[cont] = e.getDescricaoEspecie();
			cont++;
		}
		return vet;
	}

}
