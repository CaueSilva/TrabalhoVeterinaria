package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.ControleExame;
import controller.ControlePet;
import model.Exame;
import model.Pet;
import model.TipoExame;
import model.TipoExameDAO;

public class ViewExame extends View implements ActionListener {

	private ControleExame controle = new ControleExame();
	private ControlePet controlePet = new ControlePet();

	public ViewExame() {
		setResizable(false);
		setTitle("Manutenção de Exames");
		setBounds(100, 100, 520, 620);
		lblCodigo.setText("Código Exame:");
		lblTipo.setText("Tipo Exame:");
		lblDisponiveis.setText("Exames Disponíveis");
		
		cmbExame = new JComboBox<String>(controle.retornaVetor());
		
		btnPesquisarPet.addActionListener(this);
		btnSalvar.setBounds(290, 551, 97, 25);
		btnSalvar.addActionListener(this);
		btnCancelar.setBounds(393, 551, 97, 25);
		btnCancelar.addActionListener(this);
		btnPesquisarExame.addActionListener(this);

		pnlPrincipal.remove(lblEncaminhamento);
		pnlPrincipal.remove(rdbtnEncaminhamentoS);
		pnlPrincipal.remove(rdbtnEncaminhamentoN);

		tblPet = new JTable(controlePet);
		tblDisponivel = new JTable(controle);

		this.setLocationRelativeTo(null);
	}

	private Exame adicionaEntidade() {
		Exame e = new Exame();
		TipoExameDAO tipoExameDao = new TipoExameDAO();
		TipoExame tipo = tipoExameDao.pesquisaEspecifica(cmbExame.getSelectedItem().toString());
		ControlePet control = new ControlePet();
		List<Pet> pet = control.buscaPet(txtNomePet.getText());
		Pet p = pet.get(0);

		e.setCodTipoExame(tipo.getCodTipoExame());
		e.setCodPet(p.getCodPet());
		e.setDataExame(txtData.getText());
		e.setHoraExame(txtHora.getText());
		if (rdbtnEncaminhamentoS.isSelected()) {
			e.setMortePet(1);
			p.setDiaMortePet(txtData.getText());
			p.setHoraMortePet(txtHoraMorte.getText());
		} else {
			e.setMortePet(0);
		}
		e.setResultadoExame(txtResultado.getText());
		e.setPrecoTotalExame(txtPreco.getText());
		tblDisponivel.invalidate();
		tblDisponivel.revalidate();
		tblDisponivel.repaint();
		return e;
	}

	private void recebePet() {
		ControlePet controlPet = new ControlePet();
		List<Pet> listaPet = controlPet.buscaPet(txtNomePet.getText());
		if (listaPet != null && listaPet.size() > 0) {
			tblPet.invalidate();
			tblPet.revalidate();
			tblPet.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	private void recebeExame() {
		ControleExame controleExame = new ControleExame();
		Exame e = controleExame.buscaExame(Integer.parseInt(txtCodigo.getText()));
		ControlePet controlePet = new ControlePet();
		List<Pet> listaPet = controlePet.buscaPet(txtNomePet.getText());
		Pet p = listaPet.get(0);
		
		if(e != null) {
			cmbExame.setSelectedItem(e.getDescTipoExame());
			txtNomePet.setText(e.getNomePet());
			txtData.setText(e.getDataExame());
			txtHora.setText(e.getHoraExame());
			if(e.getMortePet() == 0) {
				rdbtnMorteN.setSelected(true);
			} else {
				rdbtnMorteS.setEnabled(true);
				txtHoraMorte.setText(p.getHoraMortePet());
			}
			txtResultado.setText(e.getResultadoExame());
			txtPreco.setText(String.valueOf(e.getPrecoTotalExame()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Pet")) {
			recebePet();
		} else if(cmd.contains("Exame")){
			recebeExame();
		} else if(cmd.contains("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if(cmd.contains("Cancelar")) {
			dispose();
		}
	}

}
