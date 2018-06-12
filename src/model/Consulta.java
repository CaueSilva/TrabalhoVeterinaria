package model;

import java.util.Date;

public class Consulta {
	
	private int codConsulta;
	private Atendente codAtendente;
	private Veterinario codVeterinario;
	private Pet codPet;
	private TipoConsulta codTipoConsulta;
	private Date dataMarcacao;
	private Date dataConsulta;
	private Date horaConsulta;
	private boolean encaminhamentoExame;
	private float precoTotalConsulta;
	private String resultadoConsulta;
	private boolean mortePet;
	
	
	
	public int getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}
	public Atendente getCodAtendente() {
		return codAtendente;
	}
	public void setCodAtendente(Atendente codAtendente) {
		this.codAtendente = codAtendente;
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
	public TipoConsulta getCodTipoConsulta() {
		return codTipoConsulta;
	}
	public void setCodTipoConsulta(TipoConsulta codTipoConsulta) {
		this.codTipoConsulta = codTipoConsulta;
	}
	public Date getDataMarcacao() {
		return dataMarcacao;
	}
	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public Date getHoraConsulta() {
		return horaConsulta;
	}
	public void setHoraConsulta(Date horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	public boolean isEncaminhamentoExame() {
		return encaminhamentoExame;
	}
	public void setEncaminhamentoExame(boolean encaminhamentoExame) {
		this.encaminhamentoExame = encaminhamentoExame;
	}
	public float getPrecoTotalConsulta() {
		return precoTotalConsulta;
	}
	public void setPrecoTotalConsulta(float precoTotalConsulta) {
		this.precoTotalConsulta = precoTotalConsulta;
	}
	public String getResultadoConsulta() {
		return resultadoConsulta;
	}
	public void setResultadoConsulta(String resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}
	public boolean isMortePet() {
		return mortePet;
	}
	public void setMortePet(boolean mortePet) {
		this.mortePet = mortePet;
	}


}
