package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleReceita;
import model.Receita;

public class ViewReceita implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Receitas");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodReceita = new JTextField(8);
	private JTextField txtCodPet = new JTextField(6);
	private JTextField txtCodVet = new JTextField(6);
	private JTextField txtObs = new JTextField(26);
	private JTextField txtEmissao = new JTextField(7);
	private JTextField txtValidade = new JTextField(8);
	private JButton btnPesquisarReceita = new JButton("Pesquisar");
	//private JButton btnPesquisarPet = new JButton("Pesquisar Pet");
	//private JButton btnPesquisarVet = new JButton("Pesquisar Veterinário");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	
	private ControleReceita controle = new ControleReceita();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ViewReceita() {
		janela.setSize(306,200);
		janela.setVisible(true);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		
		txtEmissao.setBounds(0, 0, 15, 15);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Receita: "));
		pnlPrimario.add(txtCodReceita);
		pnlPrimario.add(btnPesquisarReceita);
		pnlPrimario.add(new JLabel("Código Pet:"));
		pnlPrimario.add(txtCodPet);
		//pnlPrimario.add(btnPesquisarPet);
		pnlPrimario.add(new JLabel("Código Vet.:"));
		pnlPrimario.add(txtCodVet);
		//pnlPrimario.add(btnPesquisarVet);
		pnlPrimario.add(new JLabel("Observações: "));
		pnlPrimario.add(txtObs);
		pnlPrimario.add(new JLabel("Emissão:"));
		pnlPrimario.add(txtEmissao);
		pnlPrimario.add(new JLabel("Validade:"));
		pnlPrimario.add(txtValidade);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisarReceita.addActionListener(this);
		//btnPesquisarPet.addActionListener(this);
		//btnPesquisarVet.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
	}

	public Receita adicionarEntidade() throws ParseException {
		Receita r = new Receita();
		r.setCodReceita(Integer.parseInt(txtCodReceita.getText()));
		r.setCodPet(Integer.parseInt(txtCodPet.getText()));
		r.setCodVeterinario(Integer.parseInt(txtCodVet.getText()));
		r.setObsReceita(txtObs.getText());
		r.setDataEmissao(sdf.parse(txtEmissao.getText()));
		r.setDataValidade(sdf.parse(txtValidade.getText()));
		return r;
	}
	
	public void entidadeParaBoundary() {
		List<Receita> lista = controle.buscaReceita(Integer.parseInt(txtCodReceita.getText()));
		if(lista != null && lista.size() > 0) {
			Receita r = lista.get(0);
			txtCodReceita.setText(String.valueOf(r.getCodReceita()));
			txtCodPet.setText(String.valueOf(r.getCodPet()));
			txtCodVet.setText(String.valueOf(r.getCodVeterinario()));
			txtObs.setText(r.getObsReceita());
			txtEmissao.setText(sdf.format(r.getDataEmissao()));
			txtValidade.setText(sdf.format(r.getDataValidade()));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Receita")) {
			
		} else if(cmd.contains("Pet")) {
			
		} else if(cmd.contains("Veterinário")) {
			
		} else if(cmd.contains("Salvar")) {
			try {
				controle.adiciona(adicionarEntidade());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(cmd.contains("Pesquisar")) {
			entidadeParaBoundary();
		} else if(cmd.contains("Excluir")) {
			controle.removeReceita(Integer.parseInt(txtCodReceita.getText()));
		}
	}
}
