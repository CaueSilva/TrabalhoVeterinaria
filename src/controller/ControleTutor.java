package controller;

import javax.swing.JOptionPane;

import model.Tutor;
import model.TutorDAO;

public class ControleTutor {

	private TutorDAO tutorDao = new TutorDAO();

	public void adiciona(Tutor t) {
		if (t != null) {
			tutorDao.adicionar(t);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar tutor.");
		}
	}

	public Tutor buscaTutor(String cpf) {
		Tutor t = tutorDao.pesquisaEspecifica(cpf);
		return t;
	}

}
