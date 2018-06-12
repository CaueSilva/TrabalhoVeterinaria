package model;

public class MedicamentoReceita {

	private int codMedicamentoReceita;
	private Receita codReceita;
	private Medicamento codMedicamento;
	private String dosagemMedicamento;
	private String intervaloMedicamento;
	private String pedidoReceitado;

	public int getCodMedicamentoReceita() {
		return codMedicamentoReceita;
	}

	public void setCodMedicamentoReceita(int codMedicamentoReceita) {
		this.codMedicamentoReceita = codMedicamentoReceita;
	}

	public Receita getCodReceita() {
		return codReceita;
	}

	public void setCodReceita(Receita codReceita) {
		this.codReceita = codReceita;
	}

	public Medicamento getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(Medicamento codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	public String getDosagemMedicamento() {
		return dosagemMedicamento;
	}

	public void setDosagemMedicamento(String dosagemMedicamento) {
		this.dosagemMedicamento = dosagemMedicamento;
	}

	public String getIntervaloMedicamento() {
		return intervaloMedicamento;
	}

	public void setIntervaloMedicamento(String intervaloMedicamento) {
		this.intervaloMedicamento = intervaloMedicamento;
	}

	public String getPedidoReceitado() {
		return pedidoReceitado;
	}

	public void setPedidoReceitado(String pedidoReceitado) {
		this.pedidoReceitado = pedidoReceitado;
	}

}
