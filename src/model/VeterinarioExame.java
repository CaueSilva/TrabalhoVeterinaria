package model;

public class VeterinarioExame {
	
	private int codExame;
	private int codVeterinario;
	private String nomeVeterinario;
	private String crmv;
	
	
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
	public int getCodExame() {
		return codExame;
	}
	public void setCodExame(int codExame) {
		this.codExame = codExame;
	}
	public int getCodVeterinario() {
		return codVeterinario;
	}
	public void setCodVeterinario(int codVeterinario) {
		this.codVeterinario = codVeterinario;
	}
	
	
}