package model;

public class VeterinarioExame {
	
	private int codVeterinarioExame;
	private Exame codExame;
	private Veterinario codVeterinario;
	
	
	public int getCodVeterinarioExame() {
		return codVeterinarioExame;
	}
	public void setCodVeterinarioExame(int codVeterinarioExame) {
		this.codVeterinarioExame = codVeterinarioExame;
	}
	public Exame getCodExame() {
		return codExame;
	}
	public void setCodExame(Exame codExame) {
		this.codExame = codExame;
	}
	public Veterinario getCodVeterinario() {
		return codVeterinario;
	}
	public void setCodVeterinario(Veterinario codVeterinario) {
		this.codVeterinario = codVeterinario;
	}
	
	
}