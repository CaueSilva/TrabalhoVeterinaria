package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Exame;
import model.ExameDAO;

public class ControleExame implements TableModel{
	
	private String [] nomesColunas = {"Data", "Hora", "Pet", "Tipo Exame"};
	private ExameDAO exameDao = new ExameDAO();
	private List<Exame> listaExames = new ArrayList<>();
	
	public void adiciona(Exame e) {
		if(e != null) {
			exameDao.adicionar(e);
			listaExames.add(e);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar exame.");
		}
	}
	
	public Exame buscaExame(int cod) {
		Exame lista = exameDao.pesquisaEspecifica(cod);
		return lista;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == 0) {
			return Date.class;
		} else if(columnIndex == 1) {
			return Date.class;
		} else if(columnIndex == 2) {
			return Integer.class;
		} else if(columnIndex == 3) {
			return Integer.class;
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
		return listaExames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Exame e = listaExames.get(rowIndex);
		if(columnIndex == 0) {
			return e.getDataExame();
		} else if(columnIndex == 1) {
			return e.getHoraExame();
		} else if(columnIndex == 2) {
			return e.getCodPet();
		} else if(columnIndex == 3) {
			return e.getCodTipoExame();
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
