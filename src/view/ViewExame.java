package view;

import controller.ListenerExame;

public class ViewExame extends View {

	private ListenerExame listener = new ListenerExame();

	public ViewExame() {
		setResizable(false);
		setTitle("Manuten��o de Exames");
		setBounds(100, 100, 520, 620);
		lblCodigo.setText("C�digo Exame:");
		lblTipo.setText("Tipo Exame:");
		lblDisponiveis.setText("Exames Dispon�veis");

		btnPesquisar.addActionListener(listener);
		btnSalvar.setBounds(290, 551, 97, 25);
		btnSalvar.addActionListener(listener);
		btnExcluir.setBounds(393, 551, 97, 25);
		btnExcluir.addActionListener(listener);

		pnlPrincipal.remove(lblEncaminhamento);
		pnlPrincipal.remove(rdbtnEncaminhamentoS);
		pnlPrincipal.remove(rdbtnEncaminhamentoN);
	}

}
