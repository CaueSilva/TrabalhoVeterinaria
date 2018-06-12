package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerReceita implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.contains("Receita")) {
			JOptionPane.showMessageDialog(null, "Pesquisado Receita.");
		} else if (cmd.contains("Pet")) {
			JOptionPane.showMessageDialog(null, "Pesquisado Pet.");
		} else if (cmd.contains("Vet")) {
			JOptionPane.showMessageDialog(null, "Pesquisado Pet.");
		} else if( cmd.contains("Salvar")) {
			JOptionPane.showMessageDialog(null, "Salvado.");
		} else {
			JOptionPane.showMessageDialog(null, "Excluído.");
		}
	}
}
