package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleEspecie;
import controller.ControleRaca;
import model.Especie;
import model.Raca;

public class ViewRaca implements ActionListener {

	private JFrame janela = new JFrame("Manutenção de Raças");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodRaca = new JTextField(12);
	private JTextField txtDescricaoEspecie = new JTextField(8);
	private JTextField txtDescricaoRaca = new JTextField(11);
	private JButton btnPesquisaRaca = new JButton("Pesquisar Raça");
	private JButton btnPesquisaEspecie = new JButton("Pesquisar Espécie");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");

	private ControleRaca controle = new ControleRaca();

	public ViewRaca() {
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setSize(367, 160);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setContentPane(pnlPrincipal);

		janela.setLocationRelativeTo(null);

		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);

		pnlPrimario.add(new JLabel("Descrição Raça:"));
		pnlPrimario.add(txtDescricaoRaca);
		pnlPrimario.add(btnPesquisaRaca);
		pnlPrimario.add(new JLabel("Descrição Espécie:"));
		pnlPrimario.add(txtDescricaoEspecie);
		pnlPrimario.add(btnPesquisaEspecie);
		pnlPrimario.add(new JLabel("Código Raça: "));
		pnlPrimario.add(txtCodRaca);
		txtCodRaca.setEditable(false);

		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);

		btnPesquisaRaca.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisaEspecie.addActionListener(this);
	}

	private Raca adicionaEntidade() {
		Raca r = new Raca();
		//r.setCodRaca(Integer.parseInt(txtCodRaca.getText()));
		ControleEspecie controleEspecie = new ControleEspecie();
		Especie e = controleEspecie.busca(txtDescricaoEspecie.getText());
		r.setDescricaoRaca(txtDescricaoRaca.getText());
		r.setDescEspecie(txtDescricaoEspecie.getText());
		r.setCodEspecie(e.getCodEspecie());
		JOptionPane.showMessageDialog(null, "Raça adicionada.");
		return r;
	}
	private void recebeRaca() {
		Raca r = controle.buscaRaca(txtDescricaoRaca.getText());
		ControleEspecie controleEspecie = new ControleEspecie();
		Especie e = controleEspecie.busca(txtDescricaoEspecie.getText());

		if (r != null) {
			txtDescricaoEspecie.setText(e.getDescricaoEspecie());
			txtCodRaca.setText(String.valueOf(r.getCodRaca()));
		}
	}

	private void recebeEspecie() {
		ControleEspecie controleEspecie = new ControleEspecie();
		Especie e = controleEspecie.busca(txtDescricaoEspecie.getText());
		if (e != null) {
			txtDescricaoEspecie.setText(e.getDescricaoEspecie());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.contains("Raça")) {
			recebeRaca();
		} else if (cmd.contains("Espécie")) {
			recebeEspecie();
		} else if (cmd.contains("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (cmd.contains("Cancelar")) {
			janela.dispose();
		}
	}

}
