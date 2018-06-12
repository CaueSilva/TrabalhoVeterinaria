package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerTutor;

public class ViewTutor {
	
	private JFrame janela = new JFrame("Manutenção de Tutores");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtTutor = new JTextField(12);
	private JTextField txtNome = new JTextField(21);
	private JTextField txtCpf = new JTextField(11);
	private JTextField txtRua = new JTextField(25);
	private JTextField txtCep = new JTextField(10);
	private JTextField txtNumero = new JTextField(3);
	private JTextField txtComplemento = new JTextField(11);
	private JTextField txtBairro = new JTextField(24);
	private JTextField txtCidade = new JTextField(13);
	private JTextField txtEstado = new JTextField(5);
	private JTextField txtCelular = new JTextField(9);
	private JTextField txtTelefone = new JTextField(8);
	private JTextField txtEmail = new JTextField(24);
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Cancelar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private ListenerTutor listener = new ListenerTutor();
	
	public ViewTutor() {
		janela.setVisible(true);
		janela.setSize(340, 305);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Tutor:"));
		pnlPrimario.add(txtTutor);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Nome Tutor: "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("CPF: "));
		pnlPrimario.add(txtCpf);
		pnlPrimario.add(new JLabel("CEP: "));
		pnlPrimario.add(txtCep);
		pnlPrimario.add(new JLabel("Rua: "));
		pnlPrimario.add(txtRua);
		pnlPrimario.add(new JLabel("Número:"));
		pnlPrimario.add(txtNumero);
		pnlPrimario.add(new JLabel("Complemento: "));
		pnlPrimario.add(txtComplemento);
		pnlPrimario.add(new JLabel("Bairro:"));
		pnlPrimario.add(txtBairro);
		pnlPrimario.add(new JLabel("Cidade:"));
		pnlPrimario.add(txtCidade);
		pnlPrimario.add(new JLabel("Estado: "));
		pnlPrimario.add(txtEstado);
		pnlPrimario.add(new JLabel("Celular:"));
		pnlPrimario.add(txtCelular);
		pnlPrimario.add(new JLabel("Telefone: "));
		pnlPrimario.add(txtTelefone);
		pnlPrimario.add(new JLabel("E-Mail:"));
		pnlPrimario.add(txtEmail);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		
	}
	
}
