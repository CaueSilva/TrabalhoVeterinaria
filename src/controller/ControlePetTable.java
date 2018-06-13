package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Pet;
import model.Tutor;

public class ControlePetTable implements TableModel {
	
	private List<Pet> listaPet = new ArrayList<>();
	private String [] nomesColunas = {"Nome", "Tutor", "Cor Pelo", "Descriçao"};
	
	public void adiciona(Pet p) {
		listaPet.add(p);
	}
	
	public void remove(Pet p) {
		List<Pet> listRemove = new ArrayList<>();
		for(Pet pet : listaPet) {
			if(pet.getNomePet().equals(p.getNomePet()) && pet.getCodPet() == p.getCodPet()){
				listRemove.add(pet);
			}
		}
		if(!listRemove.isEmpty()) {
			listaPet.removeAll(listRemove);
			listRemove = null;
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível remover o pet.");
		}
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == 0) {
			return String.class;
		} else if(columnIndex == 1) {
			return Tutor.class;
		} else if(columnIndex == 2) {
			return String.class;
		} else if(columnIndex == 3) {
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
		return listaPet.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pet p = listaPet.get(rowIndex);
		if(columnIndex == 0) {
			return p.getNomePet();
		} else if(columnIndex == 1) {
			return p.getCodTutor();
		} else if(columnIndex == 2) {
			return p.getCorPeloPet();
		} else if(columnIndex == 3) {
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
