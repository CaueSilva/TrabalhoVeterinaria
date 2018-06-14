package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.ControleExame;
import controller.ControlePet;
import model.Exame;
import model.Pet;
import model.TipoExame;
import model.TipoExameDAO;

public class ViewExame extends View implements ActionListener{

	private ControleExame controle = new ControleExame();
	private ControlePet controlePet = new ControlePet();
	private SimpleDateFormat sdfData = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
	
	public ViewExame() {
		setResizable(false);
		setTitle("Manutenção de Exames");
		setBounds(100, 100, 520, 620);
		lblCodigo.setText("Código Exame:");
		lblTipo.setText("Tipo Exame:");
		lblDisponiveis.setText("Exames Disponíveis");
		txtCodigo.setEditable(false);

		btnPesquisar.addActionListener(this);
		btnSalvar.setBounds(290, 551, 97, 25);
		btnSalvar.addActionListener(this);
		btnCancelar.setBounds(393, 551, 97, 25);
		btnCancelar.addActionListener(this);

		pnlPrincipal.remove(lblEncaminhamento);
		pnlPrincipal.remove(rdbtnEncaminhamentoS);
		pnlPrincipal.remove(rdbtnEncaminhamentoN);
		
		tblPet = new JTable(controlePet);
		tblDisponivel = new JTable(controle);
	}
	
	public Exame adicionaEntidade() {
		Exame e = new Exame();
		TipoExameDAO tipoExameDao = new TipoExameDAO();
		TipoExame tipo = tipoExameDao.pesquisaEspecifica(txtTipo.getText());
		ControlePet control = new ControlePet();
		List<Pet> pet = control.buscaPet(txtPesquisarPet.getText());
		Pet p = pet.get(0);
		
		e.setCodTipoExame(tipo.getCodTipoExame());
		e.setCodPet(p.getCodPet());
		try {
			e.setDataExame(sdfData.parse(txtData.getText()));
			e.setHoraExame(sdfHora.parse(txtHora.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if(rdbtnEncaminhamentoS.isSelected()) {
			e.setMortePet(1);
			try {
				p.setDiaMortePet(sdfData.parse(txtData.getText()));
				p.setHoraMortePet(sdfHora.parse(txtHoraMorte.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} else {
			e.setMortePet(0);
		}
		e.setResultadoExame(txtResultado.getText());
		e.setPrecoTotalExame(Double.parseDouble(txtPreco.getText()));
		tblDisponivel.invalidate();
		tblDisponivel.revalidate();
		tblDisponivel.repaint();
		return e;
	}
	
	public void buscaEntidade() {
		ControlePet controlPet = new ControlePet();
		List<Pet> listaPet = controlPet.buscaPet(txtPesquisarPet.getText());
		if(listaPet != null && listaPet.size() > 0 ){
			tblPet.invalidate();
			tblPet.revalidate();
			tblPet.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Pesquisar")) {
			buscaEntidade();
		} else if(cmd.contains("Salvar")) {
			controle.adiciona(adicionaEntidade());
		} else if(cmd.contains("Cancelar")) {
			dispose();
		}
	}

}
