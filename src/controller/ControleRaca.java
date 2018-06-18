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
		String vet[] = new String[listaRaca.size()];
		ControleEspecie controlEspecie = new ControleEspecie();
		int cont = 0;
		Especie e = controlEspecie.busca(descricao);
		for(Raca r : listaRaca) {
			if(r.getCodEspecie() == e.getCodEspecie()) {
				vet[cont] = r.getDescricaoRaca();
				cont++;
			}
		}
		return vet;
	}

}
