package model;

import java.util.*;

public class Veterinario {
	
	private int codVeterinario;
	private int codAdmin;
	private String loginAdmin;
	private String nomeVeterinario;
	private String crmv;
	private String loginVeterinario;
	private String senhaVeterinario;
	private int nivelPermissao;	

	public String getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	public int getCodVeterinario() {
		return codVeterinario;
	}
	public void setCodVeterinario(int codVeterinario) {
		this.codVeterinario = codVeterinario;
	}
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getNomeVeterinario() {
		return nomeVeterinario;
	}
	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}
	public String getCrmv() {
		return crmv;
	}
	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}
	public String getLoginVeterinario() {
		return loginVeterinario;
	}
	public void setLoginVeterinario(String loginVeterinario) {
		this.loginVeterinario = loginVeterinario;
	}
	public String getSenhaVeterinario() {
		return senhaVeterinario;
	}
	public void setSenhaVeterinario(String senhaVeterinario) {
		this.senhaVeterinario = senhaVeterinario;
	}
	public int getNivelPermissao() {
		return nivelPermissao;
	}
	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

}
