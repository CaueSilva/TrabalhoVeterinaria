package model;

import java.util.Date;

public class Consulta {
	
	private int codConsulta;
	private int codAtendente;
	private String loginAtendente;
	private int codVeterinario;
	private String nomeVeterinario;
	private int codPet;
	private String nomePet;
	private int codTipoConsulta;
	private String descTipoConsulta;
	public String getLoginAtendente() {
		return loginAtendente;
	}
	public void setLoginAtendente(String loginAtendente) {
		this.loginAtendente = loginAtendente;
	}
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
	public String getDescTipoConsulta() {
		return descTipoConsulta;
	}
	public void setDescTipoConsulta(String descTipoConsulta) {
		this.descTipoConsulta = descTipoConsulta;
	}
	private Date dataMarcacao;
	private Date dataConsulta;
	private Date horaConsulta;
	private int encaminhamentoExame;
	private double precoTotalConsulta;
	private String resultadoConsulta;
	private int mortePet;
	
	
	
	public int getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}
	public int getCodAtendente() {
		return codAtendente;
	}
	public void setCodAtendente(int codAtendente) {
		this.codAtendente = codAtendente;
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
	public int getCodTipoConsulta() {
		return codTipoConsulta;
	}
	public void setCodTipoConsulta(int codTipoConsulta) {
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
	public int getEncaminhamentoExame() {
		return encaminhamentoExame;
	}
	public void setEncaminhamentoExame(int encaminhamentoExame) {
		this.encaminhamentoExame = encaminhamentoExame;
	}
	public double getPrecoTotalConsulta() {
		return precoTotalConsulta;
	}
	public void setPrecoTotalConsulta(double precoTotalConsulta) {
		this.precoTotalConsulta = precoTotalConsulta;
	}
	public String getResultadoConsulta() {
		return resultadoConsulta;
	}
	public void setResultadoConsulta(String resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}
	public int getMortePet() {
		return mortePet;
	}
	public void setMortePet(int mortePet) {
		this.mortePet = mortePet;
	}


}
