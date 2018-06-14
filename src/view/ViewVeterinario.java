package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleVeterinario;
import model.Admin;
import model.AdminDAO;
import model.Veterinario;

public class ViewVeterinario implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Veterinários");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodigo = new JTextField(8);
	private JTextField txtNome = new JTextField(14);
	private JTextField txtCRMV = new JTextField(6);
	private JTextField txtLogin = new JTextField(12);
	private JTextField txtSenha = new JTextField(12);
	private JTextField txtPermissao = new JTextField(3);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private ControleVeterinario controle = new ControleVeterinario();

	public ViewVeterinario() {
		janela.setVisible(true);
		janela.setSize(230, 230);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("CRMV:"));
		pnlPrimario.add(txtCRMV);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Código Veterinário:"));
		pnlPrimario.add(txtCodigo);
		txtCodigo.setEditable(false);
		pnlPrimario.add(new JLabel("Nome: "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("Login:  "));
		pnlPrimario.add(txtLogin);
		pnlPrimario.add(new JLabel("Senha:"));
		pnlPrimario.add(txtSenha);
		pnlPrimario.add(new JLabel("Permissão:"));
		pnlPrimario.add(txtPermissao);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}
	
	public Veterinario adicionaEntidade() {
		Veterinario v = new Veterinario();
		AdminDAO ad = new AdminDAO();
		Admin a = ad.pesquisaEspecifica(String.valueOf(v.getCodAdmin()));
		
		v.setCrmv(txtCRMV.getText());
		v.setCodAdmin(a.getCodAdmin());
		v.setNomeVeterinario(txtNome.getText());
		v.setLoginVeterinario(txtLogin.getText());
		v.setSenhaVeterinario(txtSenha.getText());
		v.setNivelPermissao(Integer.parseInt(txtPermissao.getText()));
		return v;
	}
	
	public void recebeEntidade() {
		Veterinario v = controle.buscaVeterinario(txtCRMV.getText());
		if(v != null) {
			txtCodigo.setText(String.valueOf(v.getCodVeterinario()));
			txtNome.setText(v.getNomeVeterinario());
			txtLogin.setText(v.getLoginVeterinario());
			txtSenha.setText(v.getSenhaVeterinario());
			txtPermissao.setText(String.valueOf(v.getNivelPermissao()));
		} else {
			JOptionPane.showMessageDialog(null,"A busca não retornou resultados.");
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
