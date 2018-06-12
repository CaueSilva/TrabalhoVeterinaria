package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerReceita;

public class ViewReceita {
	
	private JFrame janela = new JFrame("Manutenção de Receitas");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodReceita = new JTextField(10);
	private JTextField txtCodPet = new JTextField(12);
	private JTextField txtCodVet = new JTextField(12);
	private JTextField txtObs = new JTextField(24);
	private JTextField txtEmissao = new JTextField(8);
	private JTextField txtValidade = new JTextField(8);
	private JButton btnPesquisarReceita = new JButton("Pesquisar");
	private JButton btnPesquisarPet = new JButton("Pesquisar");
	private JButton btnPesquisarVet = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Pesquisar");
	private JButton btnExcluir = new JButton("Pesquisar");
	
	private ListenerReceita listener = new ListenerReceita();
	
	public ViewReceita() {
		janela.setSize(320,220);
		janela.setVisible(true);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		
		txtEmissao.setBounds(0, 0, 15, 15);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Receita:"));
		pnlPrimario.add(txtCodReceita);
		pnlPrimario.add(btnPesquisarReceita);
		pnlPrimario.add(new JLabel("Código Pet: "));
		pnlPrimario.add(txtCodPet);
		pnlPrimario.add(btnPesquisarPet);
		pnlPrimario.add(new JLabel("Código Vet.:"));
		pnlPrimario.add(txtCodVet);
		pnlPrimario.add(btnPesquisarVet);
		pnlPrimario.add(new JLabel("Obs.: "));
		pnlPrimario.add(txtObs);
		pnlPrimario.add(new JLabel("Emissão:"));
		pnlPrimario.add(txtEmissao);
		pnlPrimario.add(new JLabel("Validade:"));
		pnlPrimario.add(txtValidade);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisarReceita.addActionListener(listener);
		btnPesquisarPet.addActionListener(listener);
		btnPesquisarVet.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
		
	}
}
