package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Pet;

// JTable será implementado aqui?
// Se sim, como pegar o RowCount (getRowCount) e o RowIndex (getValueat)?

public class JTableController implements TableModel {

	private String[] nomes = { "ID", "Nome", "Peso", "Preço", "Validade", "Tipo" };
	private List<Pet> listaPesquisados = new ArrayList<>();

	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return Long.class;
		} else if (columnIndex == 1) {
			return String.class;
		} else if (columnIndex == 2) {
			return Float.class;
		} else if (columnIndex == 3) {
			return Float.class;
		} else if (columnIndex == 4) {
			return Date.class;
		} else if (columnIndex == 5) {
			return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return listaPesquisados.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return nomes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pet p = listaPesquisados.get(rowIndex);
		if (columnIndex == 0) {
			return p.getNomePet();
		} else if (columnIndex == 1) {
			return p.getDescricaoPet();
		} else if (columnIndex == 2) {
			return p.getCodRaca();
		} else if (columnIndex == 3) {
			return p.getPortePet();
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
