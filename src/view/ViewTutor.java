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

import controller.ControleTutor;
import model.Tutor;

public class ViewTutor implements ActionListener {

	private JFrame janela = new JFrame("Manutenção de Tutores");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtTutor = new JTextField(12);
	private JTextField txtNome = new JTextField(21);
	private JTextField txtCpf = new JTextField(11);
	private JTextField txtRua = new JTextField(25);
	private JTextField txtCep = new JTextField(11);
	private JTextField txtNumero = new JTextField(3);
	private JTextField txtComplemento = new JTextField(11);
	private JTextField txtBairro = new JTextField(10);
	private JTextField txtCidade = new JTextField(10);
	private JTextField txtEstado = new JTextField(8);
	private JTextField txtCelular = new JTextField(10);
	private JTextField txtTelefone = new JTextField(9);
	private JTextField txtEmail = new JTextField(24);
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnPesquisar = new JButton("Pesquisar");

	private ControleTutor controle = new ControleTutor();

	public ViewTutor() {
		janela.setVisible(true);
		janela.setSize(495, 230);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);

		pnlPrimario.add(new JLabel("CPF: "));
		pnlPrimario.add(txtCpf);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Código Tutor:"));
		pnlPrimario.add(txtTutor);
		txtTutor.setEditable(false);
		pnlPrimario.add(new JLabel("Nome Tutor: "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("CEP: "));
		pnlPrimario.add(txtCep);
		pnlPrimario.add(new JLabel("Rua: "));
		pnlPrimario.add(txtRua);
		pnlPrimario.add(new JLabel("Bairro:"));
		pnlPrimario.add(txtBairro);
		pnlPrimario.add(new JLabel("Número:"));
		pnlPrimario.add(txtNumero);
		pnlPrimario.add(new JLabel("Complemento: "));
		pnlPrimario.add(txtComplemento);
		pnlPrimario.add(new JLabel("Cidade:"));
		pnlPrimario.add(txtCidade);
		pnlPrimario.add(new JLabel("Estado:"));
		pnlPrimario.add(txtEstado);
		pnlPrimario.add(new JLabel("Celular: "));
		pnlPrimario.add(txtCelular);
		pnlPrimario.add(new JLabel("Telefone:"));
		pnlPrimario.add(txtTelefone);
		pnlPrimario.add(new JLabel("E-Mail: "));
		pnlPrimario.add(txtEmail);

		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);

		btnPesquisar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnSalvar.addActionListener(this);

	}

	private Tutor adicionaEntidade() {
		Tutor t = new Tutor();
		t.setCpfTutor(txtCpf.getText());
		t.setNomeTutor(txtNome.getText());
		t.setCepTutor(Integer.parseInt(txtCep.getText()));
		t.setRuaTutor(txtRua.getText());
		t.setBairroTutor(txtBairro.getText());
		t.setNumeroTutor(Integer.parseInt(txtNumero.getText()));
		t.setComplementoTutor(txtComplemento.getText());
		t.setCidadeTutor(txtCidade.getText());
		t.setEstadoTutor(txtEstado.getText());
		t.setCelularTutor(Integer.parseInt(txtCelular.getText()));
		t.setTelefoneTutor(Integer.parseInt(txtTelefone.getText()));
		t.setEmailTutor(txtEmail.getText());
		JOptionPane.showMessageDialog(null, "Tutor adicionado.");
		return t;
	}
	

	private void recebeEntidade() {
		Tutor t = controle.buscaTutor(txtCpf.getText());
		if (t != null) {
			txtNome.setText(t.getNomeTutor());
			txtCep.setText(String.valueOf(t.getCepTutor()));
			txtRua.setText(t.getRuaTutor());
			txtBairro.setText(t.getBairroTutor());
			txtNumero.setText(String.valueOf(t.getNumeroTutor()));
			txtComplemento.setText(t.getComplementoTutor());
			txtCidade.setText(t.getCidadeTutor());
			txtEstado.setText(t.getEstadoTutor());
			txtCelular.setText(String.valueOf(t.getCelularTutor()));
			txtTelefone.setText(String.valueOf(t.getTelefoneTutor()));
			txtEmail.setText(t.getEmailTutor());
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.contains("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (cmd.contains("Pesquisar")) {
			recebeEntidade();
		} else if (cmd.equals("Cancelar")) {
			janela.dispose();
		}

	}

}