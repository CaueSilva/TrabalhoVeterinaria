package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.TipoExame;

public class ControleTipoExame {
	
	List<TipoExame> listaTipoExame = new ArrayList<>();
	
	public void adiciona(TipoExame t) {
		listaTipoExame.add(t);
	}
	
	public List<TipoExame> pesquisaTipo(String tipo){
		List<TipoExame> lista = new ArrayList<>();
		for(TipoExame t : listaTipoExame) {
			if(t.getDescricaoTipoExame().equals(tipo)) {
				lista.add(t);
			}
		}
		return lista;
	}
	
	public void remove(String tipo) {
		List<TipoExame> lista = new ArrayList<>();
		for(TipoExame t : listaTipoExame) {
			if(t.getDescricaoTipoExame().equals(tipo)) {
				lista.add(t);
			}
		}
		if(!lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tipo de Exame removido.");
			listaTipoExame.removeAll(lista);
			lista = null;
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível remover o tipo de exame.");
		}
	}

}
