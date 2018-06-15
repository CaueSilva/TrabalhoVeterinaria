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

import com.sun.javafx.scene.control.ControlAcceleratorSupport;

import controller.ControleAtendente;
import model.Admin;
import model.AdminDAO;
import model.Atendente;

public class ViewAtendente implements ActionListener {
	
	private JFrame janela = new JFrame("Manuten��o de Atendentes");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodigo = new JTextField(9);
	private JTextField txtNome = new JTextField(15);
	private JTextField txtCPF = new JTextField(7);
	private JTextField txtLogin = new JTextField(12);
	private JTextField txtSenha = new JTextField(12);
	private JTextField txtPermissao = new JTextField(3);
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
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("C�digo Atendente:"));
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
		pnlPrimario.add(new JLabel("Permiss�o:"));
		pnlPrimario.add(txtPermissao);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	private Atendente adicionaEntidade() {
		Atendente atendente = new Atendente();
		AdminDAO ad = new AdminDAO();
		Admin a = ad.pesquisaEspecifica(String.valueOf(atendente.getCodAdmin()));
		
		atendente.setCodAdmin(a.getCodAdmin());
		atendente.setCpfAtendente(txtCPF.getText());
		atendente.setNomeAtendente(txtNome.getText());
		atendente.setLoginAtendente(txtLogin.getText());
		atendente.setSenhaAtendente(txtSenha.getText());
		atendente.setNivelPermissao(Integer.parseInt(txtPermissao.getText()));
		JOptionPane.showMessageDialog(null, "Atendente salvo.");
		return atendente;
	}
	
	private void recebeEntidade() {
		List<Atendente> lista = controle.buscaAtendente(txtCPF.getText());
		if(lista != null && lista.size() > 0) {
			Atendente a = lista.get(0);
			txtCPF.setText(a.getCpfAtendente());
			txtNome.setText(a.getNomeAtendente());
			txtLogin.setText(a.getLoginAtendente());
			txtSenha.setText(a.getSenhaAtendente());
			txtPermissao.setText(String.valueOf(a.getNivelPermissao()));
		} else {
			JOptionPane.showMessageDialog(null, "A busca n�o retornou resultados.");
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
