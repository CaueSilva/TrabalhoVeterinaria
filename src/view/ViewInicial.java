package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ListenerMain;

public class ViewInicial extends JFrame {

	private static String [] nomesBotoes = {"Manter Pets", "Manter Tutores", "Manter Veterinários",
			"Manter Consultas", "Manter Exames", "Manter Raças", "Manter Espécies", "Manter Atendentes",
			"Manter Tipo de Consulta", "Manter Tipo de Exame", "Manter Medicamentos", "Manter Receitas",
			"Manter Administrador", "Sair"};
	private ListenerMain listener = new ListenerMain();
	private JPanel pnlBotoes = new JPanel(new GridLayout(5, 3, 5, 5));

	public ViewInicial() {
		setTitle("Sistema de Gestão Veterinária");
		setResizable(false);
		setSize(550,750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(pnlBotoes);
		for (int i = 0 ; i < 14 ; i ++) {
			JButton btn = new JButton(nomesBotoes[i]);
			btn.addActionListener(listener);
			pnlBotoes.add(btn);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new ViewInicial();
	}

}
