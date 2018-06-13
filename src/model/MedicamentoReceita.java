package model;

public class MedicamentoReceita {
	private int codReceita;
	private int codMedicamento;
	private String dosagemMedicamento;
	private String intervaloMedicamento;
	private String periodoMedicamento;

	public int getCodReceita() {
		return codReceita;
	}

	public void setCodReceita(int codReceita) {
		this.codReceita = codReceita;
	}

	public int getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
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

	public String getPeriodoMedicamentoo() {
		return periodoMedicamento;
	}

	public void setPeriodoMedicamento(String periodoMedicamento) {
		this.periodoMedicamento = periodoMedicamento;
	}

}
