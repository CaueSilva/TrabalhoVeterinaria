package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleTipoConsulta;
import model.TipoConsulta;

public class ViewTipoConsulta implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Consultas");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JLabel lblTipo = new JLabel("Nome Consulta:");
	private JTextField txtTipo = new JTextField(10);
	private JLabel lblPreco = new JLabel("Preço:   R$");
	private JTextField txtPreco = new JTextField(8);
	private JLabel lblDescricao = new JLabel("Código:  ");
	private JTextField txtCodigo = new JTextField(8);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private ControleTipoConsulta controle = new ControleTipoConsulta();
	
	public ViewTipoConsulta() {
		janela.setVisible(true);
		janela.setSize(325,130);
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
		pnlPrimario.add(txtCodigo);
		txtCodigo.setEditable(false);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
	private TipoConsulta adicionaEntidade() {
		TipoConsulta t = new TipoConsulta();
		t.setDescricaoTipoConsulta(txtTipo.getText());
		t.setPrecoConsulta(Double.parseDouble(txtPreco.getText()));
		JOptionPane.showMessageDialog(null, "Tipo de Consulta adicionado.");
		return t;
	}
	
	private void recebeEntidade() {
		List<TipoConsulta> lista = controle.pesquisaTipo(txtTipo.getText());
		if(lista != null && lista.size() > 0) {
			TipoConsulta t = lista.get(0);
			txtPreco.setText(String.valueOf(t.getPrecoConsulta()));
			txtCodigo.setText(String.valueOf(t.getCodTipoConsulta()));
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Salvar")) {
			controle.adiciona(adicionaEntidade());
		} else if(cmd.contains("Pesquisar")) {
			recebeEntidade();
		} else if(cmd.contains("Cancelar")) {
			janela.dispose();
		}
	}
	
}
