package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerRaca;

public class ViewRaca {
	
	private JFrame janela = new JFrame("Manutenção de Raças");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodRaca = new JTextField(8);
	private JTextField txtCodExpecie = new JTextField(8);
	private JTextField txtDescricao = new JTextField(26);
	private JButton btnPesquisaRaca = new JButton("Pesquisar");
	private JButton btnPesquisaEspecie = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	
	private ListenerRaca listener = new ListenerRaca();
	
	public ViewRaca() {
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setSize(307,182);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setContentPane(pnlPrincipal);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Raça:      "));
		pnlPrimario.add(txtCodRaca);
		pnlPrimario.add(btnPesquisaRaca);
		pnlPrimario.add(new JLabel("Código Espécie: "));
		pnlPrimario.add(txtCodExpecie);
		pnlPrimario.add(btnPesquisaEspecie);
		pnlPrimario.add(new JLabel("Descrição:"));
		pnlPrimario.add(txtDescricao);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisaRaca.addActionListener(listener);
		btnPesquisaEspecie.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
		
	}

}
