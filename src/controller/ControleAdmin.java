package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Admin;

public class ControleAdmin {
	
	List<Admin> listaAdmin = new ArrayList<>();
	
	public void adiciona(Admin a) {
		listaAdmin.add(a);
	}
	
	public List<Admin> busca(int cod) {
		List<Admin> listaPesquisados = new ArrayList<>();
		for(Admin a : listaAdmin) {
			if(a.getCodAdmin() == cod) {
				listaPesquisados.add(a);
			}
		}
		return listaPesquisados;
	}
	
	public void remove(int codigo) {
		List<Admin> lista = new ArrayList<>();
		for(Admin a : listaAdmin) {
			if(a.getCodAdmin() == codigo) {
				lista.add(a);
			}
		}
		if(!lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Administrador removido.");
			listaAdmin.removeAll(lista);
			lista = null;
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível remover administrador.");
		}
	}

}
