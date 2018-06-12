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

import controller.ControleEspecie;
//import controller.ListenerEspecie;
import model.Especie;

public class ViewEspecie implements ActionListener{
	
	private JFrame janela = new JFrame("Manutenção de Espécies");
	private JPanel pnlPrincipal = new JPanel(new BorderLayout());
	private JPanel pnlPrimario = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pnlSecundario = new JPanel(new FlowLayout());
	private JTextField txtCodEspecie = new JTextField(8);
	private JTextField txtDescricao = new JTextField(15);
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private ControleEspecie control = new ControleEspecie();
	//private ListenerEspecie listener = new ListenerEspecie();
		
	public ViewEspecie() {
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setContentPane(pnlPrincipal);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(202,182);
		
		pnlPrincipal.add(pnlPrimario, BorderLayout.CENTER);
		pnlPrincipal.add(pnlSecundario, BorderLayout.SOUTH);
		
		pnlPrimario.add(new JLabel("Código Espécie:  "));
		pnlPrimario.add(txtCodEspecie);
		pnlPrimario.add(btnPesquisar);
		pnlPrimario.add(new JLabel("Descrição:    "));
		pnlPrimario.add(txtDescricao);
		pnlSecundario.add(btnSalvar);
		pnlSecundario.add(btnExcluir);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnExcluir.addActionListener(this);
	}
	
	public Especie addBoundaryToEntity() {
		Especie e = new Especie();
		e.setCodEspecie(Integer.parseInt(txtCodEspecie.getText()));
		e.setDescricaoEspecie(txtDescricao.getText());
		control.adiciona(e);
		JOptionPane.showMessageDialog(null, "Espécie salva.");
		return e;
	}
	
	public void removeBoundaryToEntity() {
		Especie e = new Especie();
		control.remove(e.getCodEspecie());
	}
	
	public void entityToBoundary() {
		List<Especie> lista = control.busca(Integer.parseInt(txtCodEspecie.getText()));
		if (lista != null && lista.size() > 0) {
			Especie e = lista.get(0);
			txtDescricao.setText(e.getDescricaoEspecie());
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if(cmd.equals("Pesquisar")){
			entityToBoundary();
		} else if(cmd.equals("Salvar")) {
			addBoundaryToEntity();
		} else {
			removeBoundaryToEntity();
		}
	}
	
}
