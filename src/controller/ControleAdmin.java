package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Admin;
import model.AdminDAO;

public class ControleAdmin {
	
	private AdminDAO adminDao = new AdminDAO();
	
	public void adiciona(Admin a) throws SQLException {
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
