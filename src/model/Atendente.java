package model;

public class Atendente {
	
	private int codAtendente;
	private int codAdmin;
	private String nomeAtendente;
	private String cpfAtendente;
	private String loginAtendente;
	private String senhaAtendente;
	private int nivelPermissao;
	
	
	public int getCodAtendente() {
		return codAtendente;
	}
	public void setCodAtendente(int codAtendente) {
		this.codAtendente = codAtendente;
	}
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getNomeAtendente() {
		return nomeAtendente;
	}
	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}
	public String getCpfAtendente() {
		return cpfAtendente;
	}
	public void setCpfAtendente(String cpfAtendente) {
		this.cpfAtendente = cpfAtendente;
	}
	public String getLoginAtendente() {
		return loginAtendente;
	}
	public void setLoginAtendente(String loginAtendente) {
		this.loginAtendente = loginAtendente;
	}
	public String getSenhaAtendente() {
		return senhaAtendente;
	}
	public void setSenhaAtendente(String senhaAtendente) {
		this.senhaAtendente = senhaAtendente;
	}
	public int getNivelPermissao() {
		return nivelPermissao;
	}
	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
}
