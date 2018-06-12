package model;

import java.util.*;

public class Exame {
	
	private int codExame;
	private Atendente codAtendente;
	private Pet codPet;
	private TipoExame codTipoExame;
	private Date dataSolicitacao;
	private Date dataExame;
	private Date horaExame;
	private String resultadoExame;
	private float precoTotalExame;
	private boolean mortePet;
	
	//private List<Veterinario> veterinario = new ArrayList<>();
	
	public int getCodExame() {
		return codExame;
	}
	public void setCodExame(int codExame) {
		this.codExame = codExame;
	}
	public Atendente getCodAtendente() {
		return codAtendente;
	}
	public void setCodAtendente(Atendente codAtendente) {
		this.codAtendente = codAtendente;
	}
	public Pet getCodPet() {
		return codPet;
	}
	public void setCodPet(Pet codPet) {
		this.codPet = codPet;
	}
	public TipoExame getCodTipoExame() {
		return codTipoExame;
	}
	public void setCodTipoExame(TipoExame codTipoExame) {
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
	public float getPrecoTotalExame() {
		return precoTotalExame;
	}
	public void setPrecoTotalExame(float precoTotalExame) {
		this.precoTotalExame = precoTotalExame;
	}
	public boolean isMortePet() {
		return mortePet;
	}
	public void setMortePet(boolean mortePet) {
		this.mortePet = mortePet;
	}
	//public List<Veterinario> getVeterinario() {
		//return veterinario;
	//}
	//public void setVeterinario(List<Veterinario> veterinario) {
		//this.veterinario = veterinario;
	//}
	
	

}
