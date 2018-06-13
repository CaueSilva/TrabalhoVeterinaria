package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Raca;

public class ControleRaca {
	
	List<Raca> listaRaca = new ArrayList<>();
	
	public void adiciona(Raca r) {
		listaRaca.add(r);
	}
	
	public List<Raca> buscaRaca(int cod){
		List<Raca> listaPesquisa = new ArrayList<>();
		for(Raca r : listaRaca) {
			if(r.getCodRaca() == cod) {
				listaPesquisa.add(r);
			}
		}
		return listaPesquisa;
	}
	
	public void removeRaca(int cod) {
		List<Raca> listaPesquisa = new ArrayList<>();
		for(Raca r : listaRaca) {
			if(r.getCodRaca() == cod) {
				listaPesquisa.add(r);
			}
		}
		if(!listaPesquisa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Raça excluída.");
			listaRaca.removeAll(listaPesquisa);
			listaPesquisa = null;
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível excluir a raça.");
		}
	}
	
}
