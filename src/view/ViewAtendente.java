package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleAtendente;
import model.Atendente;

public class ViewAtendente implements ActionListener {
	
	private JFrame janela = new JFrame("Manutenção de Atendentes");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodigo = new JTextField(9);
	private JTextField txtNome = new JTextField(15);
	private JTextField txtCPF = new JTextField(7);
	private JTextField txtLogin = new JTextField(12);
	private JTextField txtSenha = new JTextField(12);
	private JTextField txtPermissao = new JTextField(5);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private ControleAtendente controle = new ControleAtendente();
	
	public ViewAtendente() {
		janela.setSize(228,235);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		janela.setLocationRelativeTo(null);
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Atendente:"));
		pnlPrimario.add(txtCodigo);
		txtCodigo.setEditable(false);
		pnlPrimario.add(new JLabel("CPF:"));
		pnlPrimario.add(txtCPF);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Nome:"));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("Login: "));
		pnlPrimario.add(txtLogin);
		pnlPrimario.add(new JLabel("Senha:"));
		pnlPrimario.add(txtSenha);
		pnlPrimario.add(new JLabel("Permissão:"));
		pnlPrimario.add(txtPermissao);
		txtPermissao.setText("Atendente");
		txtPermissao.setEditable(false);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}

	private Atendente adicionaEntidade() {
		Atendente atendente = new Atendente();
		atendente.setCpfAtendente(txtCPF.getText());
		atendente.setNomeAtendente(txtNome.getText());
		atendente.setLoginAtendente(txtLogin.getText());
		atendente.setSenhaAtendente(txtSenha.getText());
		JOptionPane.showMessageDialog(null, "Atendente salvo.");
		return atendente;
	}
	
	private void recebeEntidade() {
		Atendente a = controle.buscaAtendente(txtCPF.getText());
		if(a != null) {
			txtCPF.setText(a.getCpfAtendente());
			txtNome.setText(a.getNomeAtendente());
			txtLogin.setText(a.getLoginAtendente());
			txtSenha.setText(a.getSenhaAtendente());
			txtPermissao.setText(String.valueOf(a.getNivelPermissao()));
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if(cmd.contains("Pesquisar")) {
			recebeEntidade();
		} else if(cmd.contains("Cancelar")) {
			janela.dispose();
		}
	}
}
