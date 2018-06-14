package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Pet;
import model.PetDAO;
import model.Tutor;

public class ControlePet implements TableModel {

	private List<Pet> listaPets = new ArrayList<>();
	private List<Pet> listaPesquisados = new ArrayList<>();
	private String[] nomesColunas = { "Nome", "Tutor", "Cor", "Descriçao" };
	private PetDAO petDao = new PetDAO();

	public void adiciona(Pet p) {
		if (!p.getNomePet().equals("")) {
			petDao.adicionar(p);
			JOptionPane.showMessageDialog(null, "Pet " + p.getNomePet() + " adicionado.");
		}
	}

	public List<Pet> buscaPet(String nome) {
		listaPesquisados.clear();
		listaPesquisados = petDao.pesquisaEspecifica(nome);
		for (Pet p : listaPets) {
			if (p.getNomePet().contains(nome)) {
				listaPesquisados.add(p);
			}
		}
		return listaPesquisados;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return String.class;
		} else if (columnIndex == 1) {
			return Tutor.class;
		} else if (columnIndex == 2) {
			return String.class;
		} else if (columnIndex == 3) {
			return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return nomesColunas[columnIndex];
	}

	@Override
	public int getRowCount() {
		return listaPesquisados.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pet p = listaPesquisados.get(rowIndex);
		if (columnIndex == 0) {
			return p.getNomePet();
		} else if (columnIndex == 1) {
			return p.getCodTutor();
		} else if (columnIndex == 2) {
			return p.getCorPeloPet();
		} else if (columnIndex == 3) {
			return p.getDescricaoPet();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

}
