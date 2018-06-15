package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import controller.ControleMedicamento;
import model.Medicamento;

public class ViewMedicamento implements ActionListener {

	private ControleMedicamento control = new ControleMedicamento();

	private JFrame janela = new JFrame("Manutenção de Medicamentos");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCod = new JTextField(11);
	private JTextField txtNome = new JTextField(13);
	private JTextField txtPrincipio = new JTextField(24);
	private JTable tblMedicamento = new JTable(control);
	private JScrollPane scroll = new JScrollPane();
	private JTextField txtTarja = new JTextField(18);
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");

	public ViewMedicamento() {
		scroll.getViewport().add(tblMedicamento);

		janela.setVisible(true);
		janela.setSize(470, 590);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setContentPane(pnlPrincipal);
		janela.setResizable(false);

		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);

		pnlPrimario.add(new JLabel("Princípio Ativo:"));
		pnlPrimario.add(txtPrincipio);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(scroll);
		pnlPrimario.add(new JLabel("Código Medicamento: "));
		pnlPrimario.add(txtCod);
		txtCod.setEditable(false);
		pnlPrimario.add(new JLabel(" Nome: "));
		pnlPrimario.add(txtNome);
		pnlPrimario.add(new JLabel("Tarja: "));
		pnlPrimario.add(txtTarja);

		pnlSecundario.setSize(150, 150);
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);

		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	private Medicamento adicionaEntidade() {
		Medicamento m = new Medicamento();
		m.setPrincipioAtivo(txtPrincipio.getText());
		m.setNomeMedicamento(txtNome.getText());
		m.setTarjaMedicamento(txtTarja.getText());
		JOptionPane.showMessageDialog(null, "Medicamento salvo.");
		return m;
	}

	private void recebeEntidade() {
		List<Medicamento> lista = control.busca(txtPrincipio.getText());
		if (lista != null && lista.size() > 0) {
			Medicamento m = lista.get(0);
			txtCod.setText(String.valueOf(m.getCodMedicamento()));
			txtNome.setText(m.getNomeMedicamento());
			txtTarja.setText(m.getTarjaMedicamento());
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
		tblMedicamento.invalidate();
		tblMedicamento.revalidate();
		tblMedicamento.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Pesquisar")) {
			recebeEntidade();
		} else if (cmd.equals("Salvar")) {
			try {
				control.adiciona(adicionaEntidade());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Cancelar")) {
			janela.dispose();
		}
	}

}
