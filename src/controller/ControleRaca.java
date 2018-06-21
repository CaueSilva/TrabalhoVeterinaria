package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Especie;
import model.Raca;
import model.RacaDAO;

public class ControleRaca {

	private RacaDAO racaDao = new RacaDAO();
	private List<Raca> listaRaca = new ArrayList<>();

	public void adiciona(Raca r) throws SQLException {
		if (r != null) {
			racaDao.adicionar(r);
			listaRaca.add(r);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar raça.");
		}
	}

	public Raca buscaRaca(String desc) {
		Raca r = racaDao.pesquisaEspecifica(desc);
		return r;
	}
	
	public String[] retornaVetor(String descricao){
		String vet[] = new String[racaDao.pesquisaPorEspecie(descricao).size()];
		List<Raca> ra = racaDao.pesquisaPorEspecie(descricao);
		int cont = 0;		
		for(Raca r : ra) {
			vet[cont] = r.getDescricaoRaca();
			cont++;
		}
		for(int i=0; i<vet.length;i++) {
			System.out.println(vet[i]);
		}
		return vet;
	}

}
