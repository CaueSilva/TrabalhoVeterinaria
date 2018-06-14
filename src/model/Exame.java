package model;

import java.util.Date;

public class Exame {
	
	private int codExame;
	private int codAtendente;
	private String nomeAtendente;
	private int codPet;
	private String nomePet;
	private int codTipoExame;
	private String descTipoExame;
	public String getNomeAtendente() {
		return nomeAtendente;
	}
	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}
	public String getDescTipoExame() {
		return descTipoExame;
	}
	public void setDescTipoExame(String descTipoExame) {
		this.descTipoExame = descTipoExame;
	}
	private Date dataSolicitacao;
	private Date dataExame;
	private Date horaExame;
	private String resultadoExame;
	private double precoTotalExame;
	private int mortePet;
	
	public int getCodExame() {
		return codExame;
	}
	public void setCodExame(int codExame) {
		this.codExame = codExame;
	}
	public int getCodAtendente() {
		return codAtendente;
	}
	public void setCodAtendente(int codAtendente) {
		this.codAtendente = codAtendente;
	}
	public int getCodPet() {
		return codPet;
	}
	public void setCodPet(int codPet) {
		this.codPet = codPet;
	}
	public int getCodTipoExame() {
		return codTipoExame;
	}
	public void setCodTipoExame(int codTipoExame) {
		this.codTipoExame = codTipoExame;
	}
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public Date getHoraExame() {
		return horaExame;
	}
	public void setHoraExame(Date horaExame) {
		this.horaExame = horaExame;
	}
	public String getResultadoExame() {
		return resultadoExame;
	}
	public void setResultadoExame(String resultadoExame) {
		this.resultadoExame = resultadoExame;
	}
	public double getPrecoTotalExame() {
		return precoTotalExame;
	}
	public void setPrecoTotalExame(double precoTotalExame) {
		this.precoTotalExame = precoTotalExame;
	}
	public int getMortePet() {
		return mortePet;
	}
	public void setMortePet(int mortePet) {
		this.mortePet = mortePet;
	}
	//public List<Veterinario> getVeterinario() {
		//return veterinario;
	//}
	//public void setVeterinario(List<Veterinario> veterinario) {
		//this.veterinario = veterinario;
	//}
	
	

}
