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

import controller.ControleTipoExame;
import model.TipoExame;

public class ViewTipoExame implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Exames");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JLabel lblTipo = new JLabel("Nome Exame: ");
	private JTextField txtTipo = new JTextField(10);
	private JLabel lblPreco = new JLabel("Preço:   R$");
	private JTextField txtPreco = new JTextField(7);
	private JLabel lblDescricao = new JLabel("Código:  ");
	private JTextField txtCodigo = new JTextField(8);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private ControleTipoExame controle = new ControleTipoExame();
	
	public ViewTipoExame(){
		janela.setVisible(true);
		janela.setSize(315,130);
		janela.setContentPane(pnlPrincipal);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
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
	
	private TipoExame adicionaEntidade() {
		TipoExame t = new TipoExame();
		t.setDescricaoTipoExame(txtTipo.getText());
		t.setPrecoExame(txtPreco.getText());
		JOptionPane.showMessageDialog(null, "Tipo de exame adicionado.");
		return t;
	}
	
	private void recebeEntidade() {
		TipoExame t = controle.pesquisaTipo(txtTipo.getText());
		if(t != null) {
			txtPreco.setText(String.valueOf(t.getPrecoExame()));
			txtCodigo.setText(String.valueOf(t.getCodTipoExame()));
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.contains("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(cmd.contains("Pesquisar")) {
			recebeEntidade();
		} else if(cmd.contains("Cancelar")) {
			janela.dispose();
		}
	}
	
}
