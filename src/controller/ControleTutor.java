package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Tutor;

public class ControleTutor {
	
	List<Tutor> listaTutor = new ArrayList<>();
	
	public void adiciona(Tutor t) {
		listaTutor.add(t);
	}
	
	public List<Tutor> buscaTutor(String cpf){
		List<Tutor> lista = new ArrayList<>();
		for(Tutor t : listaTutor) {
			if(t.getCpfTutor().equals(cpf)) {
				lista.add(t);
			}
		}
		return lista;
	}
	
	public void remove(String cpf) {
		List<Tutor> lista = new ArrayList<>();
		for(Tutor t : listaTutor) {
			if(t.getCpfTutor().equals(cpf)) {
				lista.add(t);
			}
		}
		if(!lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tutor removido.");
			listaTutor.removeAll(lista);
			lista = null;
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível remover o tutor.");
		}
	}
	
}
