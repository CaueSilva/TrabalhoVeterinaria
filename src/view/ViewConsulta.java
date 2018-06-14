package view;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import controller.ListenerConsulta;

public class ViewConsulta extends View {

	private JRadioButton btnExameS = new JRadioButton("Sim");
	private JRadioButton btnExameN = new JRadioButton("Não");
	private JLabel encaminhamentoExame = new JLabel("Encaminhamento de Exame: ");
	private ListenerConsulta listener = new ListenerConsulta();

	public static void main(String[] args) {
		new ViewConsulta();
	}
	
	public ViewConsulta() {
		setResizable(false);
		setTitle("Manutenção de Consultas");
		lblCodigo.setText("Código Consulta:");
		lblTipo.setText("Tipo Consulta:");
		
		btnPesquisar.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}
	
}
