package model;

import java.util.*;

public class Receita {
	
	private int codReceita;
	private int codVeterinario;
	private String nomeVeterinario;
	private int codPet;
	private String nomePet;
	private String obsReceita;
	private String dataEmissao;
	private String dataValidade;
	
	public String getNomeVeterinario() {
		return nomeVeterinario;
	}
	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}
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
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
}
