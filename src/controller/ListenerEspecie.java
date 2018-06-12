package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ViewEspecie;

public class ListenerEspecie implements ActionListener{
	
	private ViewEspecie e;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.equals("Pesquisar")){
			e.entityToBoundary();
		} else if(cmd.equals("Salvar")) {
			e.addBoundaryToEntity();
		} else {
			JOptionPane.showMessageDialog(null, "Excluído.");
		}
	}

}
