package model;

public class TipoConsulta {
	
	private int codTipoConsulta;
	private int codAdmin;
	private String loginAdmin;
	private String descricaoTipoConsulta;
	private String precoConsulta;
	
	
	public String getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}	
	public int getCodTipoConsulta() {
		return codTipoConsulta;
	}
	public void setCodTipoConsulta(int codTipoConsulta) {
		this.codTipoConsulta = codTipoConsulta;
	}
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getDescricaoTipoConsulta() {
		return descricaoTipoConsulta;
	}
	public void setDescricaoTipoConsulta(String descricaoTipoConsulta) {
		this.descricaoTipoConsulta = descricaoTipoConsulta;
	}
	public String getPrecoConsulta() {
		return precoConsulta;
	}
	public void setPrecoConsulta(String precoConsulta) {
		this.precoConsulta = precoConsulta;
	}
	
	

}
