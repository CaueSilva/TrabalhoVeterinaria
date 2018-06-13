package model;

public class Especie {
	
	private int codEspecie;
	private String descricaoEspecie;
	private int codAdmin;
	private String loginAdmin;
	
	
	public String getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	public int getCodEspecie() {
		return codEspecie;
	}
	public void setCodEspecie(int codEspecie) {
		this.codEspecie = codEspecie;
	}
	public String getDescricaoEspecie() {
		return descricaoEspecie;
	}
	public void setDescricaoEspecie(String descricaoEspecie) {
		this.descricaoEspecie = descricaoEspecie;
	}
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}

}
