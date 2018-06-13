package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControleRaca;
import model.Raca;

public class ViewRaca implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Raças");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodRaca = new JTextField(8);
	private JTextField txtCodExpecie = new JTextField(8);
	private JTextField txtDescricao = new JTextField(26);
	private JButton btnPesquisaRaca = new JButton("Pesquisar");
	private JButton btnPesquisaEspecie = new JButton("Pesquisar");
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	
	private ControleRaca controle = new ControleRaca();
	
	public ViewRaca() {
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setSize(307,182);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setContentPane(pnlPrincipal);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Raça:      "));
		pnlPrimario.add(txtCodRaca);
		pnlPrimario.add(btnPesquisaRaca);
		pnlPrimario.add(new JLabel("Código Espécie: "));
		pnlPrimario.add(txtCodExpecie);
		pnlPrimario.add(btnPesquisaEspecie);
		pnlPrimario.add(new JLabel("Descrição:"));
		pnlPrimario.add(txtDescricao);
		
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisaRaca.addActionListener(this);
		btnPesquisaEspecie.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
	}
	
	public Raca adicionaEntidade() {
		Raca r = new Raca();
		r.setCodRaca(Integer.parseInt(txtCodRaca.getText()));
		r.setDescricaoRaca(txtDescricao.getText());
		JOptionPane.showMessageDialog(null, "Raça adicionada.");
		return r;
	}
	
	public void recebeEntidade() {
		List<Raca> lista = controle.buscaRaca(Integer.parseInt(txtCodRaca.getText()));
		if(lista != null && lista.size() > 0) {
			Raca r = lista.get(0);
			txtCodRaca.setText(String.valueOf(r.getCodRaca()));
			txtDescricao.setText(r.getDescricaoRaca());
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.contains("Pesquisar")) {
			recebeEntidade();
		} else if(cmd.contains("Salvar")) {
			controle.adiciona(adicionaEntidade());
		} else if(cmd.contains("Excluir")) {
			controle.removeRaca(Integer.parseInt(txtCodRaca.getText()));
		}
	}

}
