package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerRaca implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.equals("Pesquisar")) {
			JOptionPane.showMessageDialog(null, "Pesquisado.");
		} else if(cmd.equals("Salvar")) {
			JOptionPane.showMessageDialog(null, "Salvado.");
		} else {
			JOptionPane.showMessageDialog(null, "Excluído.");
		}
	}
	
}
