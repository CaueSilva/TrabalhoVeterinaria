package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerVeterinario;

public class ViewVeterinario {
	
	private JFrame janela = new JFrame("Manutenção de Veterinários");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodigo = new JTextField(10);
	private JTextField txtNome = new JTextField(18);
	private JTextField txtCRMV = new JTextField(18);
	private JTextField txtLogin = new JTextField(18);
	private JTextField txtSenha = new JTextField(18);
	private JTextField txtPermissao = new JTextField(3);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	
	private ListenerVeterinario listener = new ListenerVeterinario();
	
	public ViewVeterinario() {
		janela.setVisible(true);
		janela.setSize(230, 350);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Veterinário:"));
		pnlPrimario.add(txtCodigo);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Nome: "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("CRMV:"));
		pnlPrimario.add(txtCRMV);
		pnlPrimario.add(new JLabel("Login:"));
		pnlPrimario.add(txtLogin);
		pnlPrimario.add(new JLabel("Senha:"));
		pnlPrimario.add(txtSenha);
		pnlPrimario.add(new JLabel("Permissão:"));
		pnlPrimario.add(txtPermissao);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisar.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
		
	}
	
}
