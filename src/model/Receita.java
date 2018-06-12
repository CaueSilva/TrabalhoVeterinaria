package model;

import java.util.*;

public class Receita {
	
	private int codReceita;
	private Veterinario codVeterinario;
	private Pet codPet;
	private Exame codExame;
	private Consulta codConsulta;
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
	public Veterinario getCodVeterinario() {
		return codVeterinario;
	}
	public void setCodVeterinario(Veterinario codVeterinario) {
		this.codVeterinario = codVeterinario;
	}
	public Pet getCodPet() {
		return codPet;
	}
	public void setCodPet(Pet codPet) {
		this.codPet = codPet;
	}
	public Exame getCodExame() {
		return codExame;
	}
	public void setCodExame(Exame codExame) {
		this.codExame = codExame;
	}
	public Consulta getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(Consulta codConsulta) {
		this.codConsulta = codConsulta;
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
