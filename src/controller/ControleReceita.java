package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Receita;

public class ControleReceita {
	
	private List<Receita> listaReceita = new ArrayList<>();
	
	public void adiciona(Receita r) {
		listaReceita.add(r);
	}
	
	public List<Receita> buscaReceita(int cod) {
		List<Receita> listaPesquisados = new ArrayList<>();
		for(Receita r : listaReceita) {
			if(r.getCodReceita() == cod) {
				listaPesquisados.add(r);
			}
		}
		return listaPesquisados;
	}
	
	public void removeReceita(int cod) {
		List<Receita> listaRmv = new ArrayList<>();
		for(Receita r : listaReceita) {
			if(r.getCodReceita() == cod) {
				listaRmv.add(r);
			}
		}
		if(!listaRmv.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Receita removida.");
			listaReceita.removeAll(listaRmv);
			listaRmv = null;
		}
	}
	
}
