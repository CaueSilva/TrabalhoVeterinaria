package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Medicamento;

public class ControleMedicamento implements TableModel{
	
	private List<Medicamento> listaMedicamento = new ArrayList<>();
	private List<Medicamento> listaPesquisados = new ArrayList<>();
	private String [] nomesColunas = {"Princípio Ativo","Nome", "Tarja"};
	
	public void adiciona(Medicamento medicamento) {
		listaMedicamento.add(medicamento);
	}
	
	public List<Medicamento> busca(String principio) {
		listaPesquisados.clear();
		for(Medicamento m : listaMedicamento) {
			if(m.getPrincipioAtivo().equals(principio)) {
				listaPesquisados.add(m);
			}
		}
		return listaPesquisados;
	}
	
	public void remove(String principio) {
		List<Medicamento> listaRmv = new ArrayList<>();
		for(Medicamento m : listaMedicamento) {
			if(m.getPrincipioAtivo().contains(principio)) {
				listaRmv.add(m);
			}
		} if(!listaRmv.isEmpty()) {
			listaMedicamento.removeAll(listaRmv);
			listaRmv = null;
			JOptionPane.showMessageDialog(null, "Medicamento removido.");
		} else {
			JOptionPane.showMessageDialog(null, "O medicamento não pôde ser removido.");
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
			return String.class;
		} else if(columnIndex == 2) {
			return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 3;
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
		Medicamento m = listaPesquisados.get(rowIndex);
		if(columnIndex == 0) {
			return m.getPrincipioAtivo();
		} else if(columnIndex == 1) {
			return m.getNomeMedicamento();
		} else if(columnIndex == 2) {
			return m.getTarjaMedicamento();
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
