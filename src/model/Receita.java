package model;

import java.util.*;

public class Receita {
	
	private int codReceita;
	private int codVeterinario;
	private int codPet;
	private String obsReceita;
	private Date dataEmissao;
	private Date dataValidade;
	
	//private List<Medicamento> medicamento = new ArrayList<>();
	
	public int getCodReceita() {
		return codReceita;
	}
	public void setCodReceita(int codReceita) {
		this.codReceita = codReceita;
	}
	public int getCodVeterinario() {
		return codVeterinario;
	}
	public void setCodVeterinario(int codVeterinario) {
		this.codVeterinario = codVeterinario;
	}
	public int getCodPet() {
		return codPet;
	}
	public void setCodPet(int codPet) {
		this.codPet = codPet;
	}
	public String getObsReceita() {
		return obsReceita;
	}
	public void setObsReceita(String obsReceita) {
		this.obsReceita = obsReceita;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	//public List<Medicamento> getMedicamento() {
		//return medicamento;
	//}
	//public void setMedicamento(List<Medicamento> medicamento) {
		//this.medicamento = medicamento;
	//}

	
}
