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

import controller.ControleAdmin;
import model.Admin;

public class ViewAdmin implements ActionListener {
	
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
	
	private ControleAdmin controle = new ControleAdmin();
	
	public static void main(String[] args) {
		new ViewAdmin();
	}
	
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
		txtCod.setEditable(false);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Nome:  "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("Login:   "));
		pnlPrimario.add(txtLogin);
		pnlPrimario.add(new JLabel("Senha: "));
		pnlPrimario.add(txtSenha);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnExcluir.addActionListener(this);
	}

	public Admin adicionarEntidade() {
		Admin a = new Admin();
		a.setCodAdmin(Integer.parseInt(txtCod.getText()));
		a.setNomeAdmin(txtNome.getText());
		a.setLoginAdmin(txtLogin.getText());
		a.setSenhaAdmin(txtSenha.getText());
		JOptionPane.showMessageDialog(null, "Administrador adicionado.");
		return a;
	}
	
	public void entidadeParaTela() {
		List<Admin> lista = controle.busca(Integer.parseInt(txtCod.getText()));
		if(lista != null && lista.size() > 0) {
			Admin a = lista.get(0);
			txtCod.setText(String.valueOf(a.getCodAdmin()));
			txtNome.setText(a.getNomeAdmin());
			txtLogin.setText(a.getLoginAdmin());
			txtSenha.setText(a.getSenhaAdmin());
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.contains("Salvar")) {
			controle.adiciona(adicionarEntidade());
		} else if(cmd.contains("Pesquisar")) {
			entidadeParaTela();
		} else if(cmd.contains("Excluir")) {
			controle.remove(Integer.parseInt(txtCod.getText()));
		}
	}
}
