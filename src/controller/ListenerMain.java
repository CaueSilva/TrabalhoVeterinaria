package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ViewAdmin;
import view.ViewAtendente;
import view.ViewConsulta;
import view.ViewEspecie;
import view.ViewExame;
import view.ViewMedicamento;
import view.ViewPet;
import view.ViewRaca;
import view.ViewReceita;
import view.ViewTipoConsulta;
import view.ViewTipoExame;
import view.ViewTutor;
import view.ViewVeterinario;

public class ListenerMain implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.contains("Pets")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ViewPet frame = new ViewPet();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else if (cmd.contains("Tutores")) {
			new ViewTutor(); 
		} else if (cmd.contains("Veterinários")) {
			new ViewVeterinario();
		} else if (cmd.contains("Atendentes")) {
			new ViewAtendente();
		} else if (cmd.equals("Manter Consultas")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ViewConsulta frame = new ViewConsulta();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else if (cmd.equals("Manter Exames")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ViewExame frame = new ViewExame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else if (cmd.contains("Raças")) {
			new ViewRaca();
		} else if (cmd.contains("Espécies")) {
			new ViewEspecie();
		} else if (cmd.contains("Tipo de Consulta")) {
			new ViewTipoConsulta();
		} else if (cmd.contains("Tipo de Exame")) {
			new ViewTipoExame();
		} else if (cmd.contains("Receita")) {
			new ViewReceita();
		} else if(cmd.contains("Admin")) {
			new ViewAdmin();
		} else if (cmd.contains("Medicamento")) {
			new ViewMedicamento();
		} else {
			System.exit(0);
		}
	}

}
