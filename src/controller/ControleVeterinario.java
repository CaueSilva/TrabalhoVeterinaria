package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Veterinario;
import model.VeterinarioDAO;

public class ControleVeterinario {
	
	private VeterinarioDAO vetDao = new VeterinarioDAO();
	
	public void adiciona(Veterinario v) throws SQLException {
		if(!v.getCrmv().equals("")) {
			vetDao.adicionar(v);
			JOptionPane.showMessageDialog(null, "Veterinário adicionado.");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o veterinário.");
		}
	}
	
	public Veterinario buscaVeterinario(String crmv){
		Veterinario v = vetDao.pesquisaEspecifica(crmv);
		return v;
	}
	
}
