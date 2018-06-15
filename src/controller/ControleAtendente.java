package controller;

import javax.swing.JOptionPane;

import model.Atendente;
import model.AtendenteDAO;

public class ControleAtendente {
	
	private AtendenteDAO atendenteDao = new AtendenteDAO();
	
	public void adiciona(Atendente a) {
		if(a != null){
			atendenteDao.adicionar(a);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o atendente.");
		}
	}
	
	public Atendente buscaAtendente(String cpf){
		Atendente a = atendenteDao.pesquisaEspecifica(cpf);
		return a;
	}

}
