package view;

import controller.ListenerTipoExame;

public class ViewTipoExame extends ViewTipoConsulta {
	
	private ListenerTipoExame listenerExame = new ListenerTipoExame();
	
	public ViewTipoExame(){
		janela.setTitle("Manuten��o de Exames");
		
		lblTipo.setText("Tipo Exame: ");
		
		btnPesquisar.removeActionListener(listener);
		btnSalvar.removeActionListener(listener);
		btnExcluir.removeActionListener(listener);
		
		btnPesquisar.addActionListener(listenerExame);
		btnSalvar.addActionListener(listenerExame);
		btnExcluir.addActionListener(listenerExame);
	}
	
}
