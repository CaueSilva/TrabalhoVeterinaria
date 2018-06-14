package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Admin;
import model.AdminDAO;

public class ControleAdmin {
	
	private AdminDAO adminDao = new AdminDAO();
	
	public void adiciona(Admin a) {
		if(!a.getLoginAdmin().equals("")) {
			adminDao.adicionar(a);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o administrador.");
		}
	}
	
	public Admin busca(String login) {
		Admin a = adminDao.pesquisaEspecifica(login);
		return a;
	}

}
