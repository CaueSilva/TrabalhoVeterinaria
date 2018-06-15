package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Consulta;
import model.ConsultaDAO;

public class ControleConsulta implements TableModel {
	
	private String [] nomesColunas = {"Data", "Hora", "Pet", "Tipo Consulta"};
	private ConsultaDAO consultaDao = new ConsultaDAO();
	private List<Consulta> listaConsulta = new ArrayList<>();
	
	public void adiciona(Consulta c) throws SQLException {
		consultaDao.adicionar(c);
		listaConsulta.add(c);
	}
	
	public Consulta buscaConsulta(int cod) {
		Consulta lista = consultaDao.pesquisaEspecifica(cod);
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
			return String.class;
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
		return listaConsulta.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Consulta c = listaConsulta.get(rowIndex);
		if(columnIndex == 0) {
			return c.getDataConsulta();
		} else if(columnIndex == 1) {
			return c.getHoraConsulta();
		} else if(columnIndex == 2) {
			return c.getCodPet();
		} else if(columnIndex == 3) {
			return c.getCodTipoConsulta();
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
