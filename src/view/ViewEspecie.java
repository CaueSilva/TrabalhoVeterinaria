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

import controller.ControleEspecie;
import model.Admin;
import model.AdminDAO;
import model.Especie;

public class ViewEspecie implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Espécies");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodEspecie = new JTextField(6);
	private JTextField txtLogin = new JTextField(8);
	private JTextField txtDescricao = new JTextField(8);
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private ControleEspecie controle = new ControleEspecie();
	
	public ViewEspecie() {
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(277,160);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Descrição:  "));
		pnlPrimario.add(txtDescricao);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Login Admin.:"));
		pnlPrimario.add(txtLogin);
		pnlPrimario.add(new JLabel("Código Espécie:  "));
		pnlPrimario.add(txtCodEspecie);
		txtCodEspecie.setEditable(false);
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
	private Especie adicionaEntidade() {
		Especie e = new Especie();
		AdminDAO adminDao = new AdminDAO();
		Admin a = adminDao.pesquisaEspecifica(txtLogin.getText());
		
		e.setLoginAdmin(a.getLoginAdmin());
		e.setDescricaoEspecie(txtDescricao.getText());
		return e;
	}
	
	private void recebeEntidade() {
		Especie e = controle.busca(txtDescricao.getText());
		if(e != null) {
			txtCodEspecie.setText(String.valueOf(e.getCodEspecie()));
			txtLogin.setText(e.getLoginAdmin());
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.equals("Pesquisar")){
			recebeEntidade();
		} else if(cmd.equals("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			janela.dispose();
		}
	}
	
}
