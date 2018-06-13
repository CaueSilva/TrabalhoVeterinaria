package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.TipoConsulta;

public class ControleTipoConsulta {
	
	List<TipoConsulta> listaTipoConsulta = new ArrayList<>();
	
	public void adiciona(TipoConsulta t) {
		listaTipoConsulta.add(t);
	}
	
	public List<TipoConsulta> pesquisaTipo(String tipo) {
		List<TipoConsulta> lista = new ArrayList<>();
		for(TipoConsulta t : listaTipoConsulta) {
			if(t.getDescricaoTipoConsulta().equals(tipo)) {
				lista.add(t);
			}
		}
		return lista;
	}
	
	public void remove(String tipo) {
		List<TipoConsulta> lista = new ArrayList<>();
		for(TipoConsulta t : listaTipoConsulta) {
			if(t.getDescricaoTipoConsulta().equals(tipo)) {
				lista.add(t);
			}
		}
		if(!lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tipo de consulta rmeovido.");
			listaTipoConsulta.removeAll(lista);
			lista = null;
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível remover o tipo de consulta informado.");
		}
	}
	
}
