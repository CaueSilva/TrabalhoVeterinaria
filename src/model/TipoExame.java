package model;

public class TipoExame {
	
	private int codTipoExame;
	private int codAdmin;
	private String descricaoTipoExame;
	private double precoExame;
	
	
	public int getCodTipoExame() {
		return codTipoExame;
	}
	public void setCodTipoExame(int codTipoExame) {
		this.codTipoExame = codTipoExame;
	}
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getDescricaoTipoExame() {
		return descricaoTipoExame;
	}
	public void setDescricaoTipoExame(String descricaoTipoExame) {
		this.descricaoTipoExame = descricaoTipoExame;
	}
	public double getPrecoExame() {
		return precoExame;
	}
	public void setPrecoExame(double precoExame) {
		this.precoExame = precoExame;
	}
	
	

}
