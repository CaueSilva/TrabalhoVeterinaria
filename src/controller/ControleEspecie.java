package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Especie;

public class ControleEspecie {
	
	private List<Especie> listaEspecie = new ArrayList<>();
	private List<Especie> listaPesquisados = new ArrayList<>();
	
	public void adiciona(Especie especie) {
		listaEspecie.add(especie);
	}
	
	public List<Especie> busca(int cod) {
		listaPesquisados.clear();
		for(Especie e : listaEspecie) {
			if(e.getCodEspecie() == cod) {
				listaPesquisados.add(e);
			}
		}
		return listaPesquisados;
	}
	
	public void remove(int cod) {
		List<Especie> listaRemove = new ArrayList<>();
		for(Especie e : listaEspecie) {
			if(e.getCodEspecie() == cod) {
				JOptionPane.showMessageDialog(null, "Espécie removida.");
				listaRemove.add(e);
			}
		} if (!listaRemove.isEmpty()) {
			listaEspecie.removeAll(listaRemove);
			listaRemove = null;
			JOptionPane.showMessageDialog(null, "Espécie removida.");
		} else {
			JOptionPane.showMessageDialog(null, "Espécie não pôde ser removida.");
		}
	}

}
