package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerConsulta implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.equals("Pesquisar")) {
			JOptionPane.showMessageDialog(null,"Pesquisado.");
		}else if(cmd.equals("Salvar")) {
			JOptionPane.showMessageDialog(null,"Salvo.");
		} else if(cmd.equals("Excluir")) {
			JOptionPane.showMessageDialog(null,"Exclu�do.");
		}
	}

}
