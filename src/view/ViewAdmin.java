package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerAdmin;

public class ViewAdmin {
	
	private JFrame janela = new JFrame("Manutenção de Administradores");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCod = new JTextField(8);
	private JTextField txtNome = new JTextField(15);
	private JTextField txtLogin = new JTextField(15);
	private JTextField txtSenha = new JTextField(15);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	
	private ListenerAdmin listener = new ListenerAdmin();
	
	public ViewAdmin() {
		janela.setVisible(true);
		janela.setSize(250,190);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código:"));
		pnlPrimario.add(txtCod);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Nome:  "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("Login:   "));
		pnlPrimario.add(txtLogin);
		pnlPrimario.add(new JLabel("Senha: "));
		pnlPrimario.add(txtSenha);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisar.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
	}
}
