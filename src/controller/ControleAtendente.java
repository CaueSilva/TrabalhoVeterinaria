package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Atendente;

public class ControleAtendente {
	
	private List<Atendente> listaAtendente = new ArrayList<>();
	
	public void adiciona(Atendente a) {
		listaAtendente.add(a);
	}
	
	public List<Atendente> buscaAtendente(String cpf){
		List<Atendente> listaPesquisa = new ArrayList<>();
		for(Atendente a : listaAtendente) {
			if(a.getCpfAtendente().equals(cpf)) {
				listaPesquisa.add(a);
			}
		}
		return listaPesquisa;
	}
	
	public void removeAtendente(String cpf) {
		List<Atendente> listaPesquisa = new ArrayList<>();
		for(Atendente a : listaAtendente) {
			if(a.getCpfAtendente().equals(cpf)) {
				listaPesquisa.add(a);
			}
		}
		if(!listaPesquisa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Atendente removido.");
			listaAtendente.removeAll(listaPesquisa);
			listaPesquisa = null;
		} else {
			JOptionPane.showMessageDialog(null, "Impossível excluir atendente.");
		}
	}

}
