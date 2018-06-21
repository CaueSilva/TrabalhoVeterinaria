package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControlePet;
import controller.ControleReceita;
import controller.ControleVeterinario;
import model.Pet;
import model.Receita;
import model.Veterinario;
import model.VeterinarioDAO;

public class ViewReceita implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Receitas");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodReceita = new JTextField(8);
	private JTextField txtNomePet = new JTextField(9);
	private JTextField txtCrmvVet = new JTextField(8);
	private JTextField txtObs = new JTextField(26);
	private JFormattedTextField txtEmissao = new JFormattedTextField(mascaraData("##/##/####"));
	private JFormattedTextField txtValidade = new JFormattedTextField(mascaraData("##/##/####"));
	private JButton btnPesquisarReceita = new JButton("Pesquisar");
	private JButton btnPesquisarPet = new JButton("Pesquisar Pet");
	private JButton btnPesquisarVet = new JButton("Pesquisar Vet.");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private ControleReceita controle = new ControleReceita();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ViewReceita() {
		janela.setSize(306,235);
		janela.setVisible(true);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);	
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Receita: "));
		pnlPrimario.add(txtCodReceita);
		pnlPrimario.add(btnPesquisarReceita);
		pnlPrimario.add(new JLabel("Nome Pet:"));
		pnlPrimario.add(txtNomePet);
		pnlPrimario.add(btnPesquisarPet);
		pnlPrimario.add(new JLabel("CRMV Vet.: "));
		pnlPrimario.add(txtCrmvVet);
		pnlPrimario.add(btnPesquisarVet);
		pnlPrimario.add(new JLabel("Observações: "));
		pnlPrimario.add(txtObs);
		pnlPrimario.add(new JLabel("Emissão:"));
		pnlPrimario.add(txtEmissao);
		txtEmissao.setColumns(6);
		pnlPrimario.add(new JLabel("Validade:"));
		pnlPrimario.add(txtValidade);
		txtValidade.setColumns(6);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnCancelar);
		
		btnPesquisarReceita.addActionListener(this);
		btnPesquisarPet.addActionListener(this);
		btnPesquisarVet.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}

	private Receita adicionaEntidade() {
		Receita r = new Receita();
		r.setCodReceita(Integer.parseInt(txtCodReceita.getText()));
		r.setCodPet(Integer.parseInt(txtNomePet.getText()));
		r.setCodVeterinario(Integer.parseInt(txtCrmvVet.getText()));
		r.setObsReceita(txtObs.getText());
		r.setDataEmissao(txtEmissao.getText());
		r.setDataValidade(txtValidade.getText());
		return r;
	}
	
	private void recebeReceita() {
		Receita r = controle.buscaReceita(Integer.parseInt(txtCodReceita.getText()));
		if(r != null) {
			ControleVeterinario controleVet = new ControleVeterinario();
			Veterinario v = controleVet.buscaVeterinario(txtCrmvVet.getText());
			
			txtCodReceita.setText(String.valueOf(r.getCodReceita()));
			txtNomePet.setText(r.getNomePet());
			txtCrmvVet.setText(v.getCrmv());
			txtObs.setText(r.getObsReceita());
			txtEmissao.setText(sdf.format(r.getDataEmissao()));
			txtValidade.setText(sdf.format(r.getDataValidade()));
		}
	}
	
	private void recebePet() {
		ControlePet controlePet = new ControlePet();
		List<Pet> lista = controlePet.buscaPet(txtNomePet.getText());
		if(lista != null && lista.size() > 0) {
			JOptionPane.showMessageDialog(null, "O pet está cadastrado.");
		}
	}
	private void recebeVet() {
		ControleVeterinario controleVet = new ControleVeterinario();
		Veterinario v = controleVet.buscaVeterinario(txtCrmvVet.getText());
		if(v != null) {
			JOptionPane.showMessageDialog(null, "O veterinário está cadastrado.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Pet")) {
			recebePet();
		} else if(cmd.contains("Vet")) {
			recebeVet();
		} else if(cmd.contains("Salvar")) {
				try {
					controle.adiciona(adicionaEntidade());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		} else if(cmd.equals("Pesquisar")) {
			recebeReceita();
		} else if(cmd.contains("Cancelar")) {
			janela.dispose();
		}
	}
	
	private MaskFormatter mascaraData(String mascara) {
		MaskFormatter mask = new MaskFormatter();
		try {
			mask.setMask(mascara);
			mask.setPlaceholderCharacter(' ');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mask;
	}
}
