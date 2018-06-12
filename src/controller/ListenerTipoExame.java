package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerTipoExame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Pesquisar")) {
			JOptionPane.showMessageDialog(null, "Pesquisado.");
		} else if(cmd.equals("Salvar")) {
			JOptionPane.showMessageDialog(null, "Salvado.");
		} else {
			JOptionPane.showMessageDialog(null, "Excluído.");
		}
	}

}
