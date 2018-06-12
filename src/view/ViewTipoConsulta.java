package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerTipoConsulta;

public class ViewTipoConsulta {
	
	protected JFrame janela = new JFrame("Manutenção de Consultas");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	protected JLabel lblTipo = new JLabel("Tipo Consulta:");
	private JTextField txtTipo = new JTextField(6);
	protected JLabel lblPreco = new JLabel("Preço:       R$");
	private JTextField txtPreco = new JTextField(12);
	protected JLabel lblDescricao = new JLabel("Descrição:    ");
	private JTextField txtDescricao = new JTextField(12);
	protected JButton btnPesquisar = new JButton("Pesquisar");
	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnExcluir = new JButton("Excluir");
	
	protected ListenerTipoConsulta listener = new ListenerTipoConsulta();
	
	public ViewTipoConsulta() {
		janela.setVisible(true);
		janela.setSize(285,160);
		janela.setContentPane(pnlPrincipal);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(lblTipo);
		pnlPrimario.add(txtTipo);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(lblPreco);
		pnlPrimario.add(txtPreco);
		pnlPrimario.add(lblDescricao);
		pnlPrimario.add(txtDescricao);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisar.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
	}
	
}
