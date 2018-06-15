package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Atendente;
import model.AtendenteDAO;

public class ControleAtendente {
	
	private AtendenteDAO atendenteDao = new AtendenteDAO();
	
	public void adiciona(Atendente a) throws SQLException {
		if(a != null){
			atendenteDao.adicionar(a);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel adicionar o atendente.");
		}
	}
	
	public Atendente buscaAtendente(String cpf){
		Atendente a = atendenteDao.pesquisaEspecifica(cpf);
		return a;
	}

}
