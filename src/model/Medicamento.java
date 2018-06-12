package model;

public class Medicamento {
	
	private int codMedicamento;
	private String nomeMedicamento;
	private String principioAtivo;
	private String tarjaMedicamento;
	
	//private List<Receita> receita = new ArrayList<>();
	
	
	public int getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	public String getPrincipioAtivo() {
		return principioAtivo;
	}
	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}
	public String getTarjaMedicamento() {
		return tarjaMedicamento;
	}
	public void setTarjaMedicamento(String tarjaMedicamento) {
		this.tarjaMedicamento = tarjaMedicamento;
	}
	//public List<Receita> getReceita() {
		//return receita;
	//}
	//public void setReceita(List<Receita> receita) {
		//this.receita = receita;
	//}
	
	
	

}
