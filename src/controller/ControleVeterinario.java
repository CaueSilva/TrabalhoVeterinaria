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
			JOptionPane.showMessageDialog(null, "Veterin�rio adicionado.");
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel adicionar o veterin�rio.");
		}
	}
	
	public Veterinario buscaVeterinario(String crmv){
		Veterinario v = vetDao.pesquisaEspecifica(crmv);
		return v;
	}
	
}
