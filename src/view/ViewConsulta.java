package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controller.ControleConsulta;
import controller.ControlePet;
import model.Consulta;
import model.Pet;
import model.TipoConsulta;
import model.TipoConsultaDAO;

public class ViewConsulta extends JFrame implements ActionListener{
	
	public JPanel pnlPrincipal;
	protected JTextField txtCodigo = new JTextField();
	protected JTextField txtTipo = new JTextField();
	protected JTextField txtPesquisarPet = new JTextField();

	private ControleConsulta controle = new ControleConsulta();
	private ControlePet controlePet = new ControlePet();
	protected JTable tblPet = new JTable(controlePet);
	protected JTable tblDisponivel = new JTable(controle);
	
	protected JTextField txtData = new JTextField();
	protected JTextField txtHora = new JTextField();
	protected JRadioButton rdbtnMorteS = new JRadioButton("Sim");
	protected JRadioButton rdbtnMorteN = new JRadioButton("Não");
	protected JTextField txtResultado = new JTextField();
	protected JTextField txtPreco = new JTextField();
	protected JTextField txtHoraMorte = new JTextField();
	protected JScrollPane scrollDisponiveis = new JScrollPane();
	protected JScrollPane scrollPet = new JScrollPane();
	protected JButton btnPesquisar = new JButton("Pesquisar");
	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnCancelar = new JButton("Cancelar");
	protected JRadioButton rdbtnEncaminhamentoS = new JRadioButton("Sim");
	protected JRadioButton rdbtnEncaminhamentoN = new JRadioButton("Não");;
	protected JLabel lblEncaminhamento = new JLabel("Encaminhamento Exame:");

	private SimpleDateFormat sdfData = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
	
	
	public static void main(String[] args) {
		new ViewConsulta();
	}
	
	public ViewConsulta() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 665);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		
		pnlPrincipal.add(new JLabel("Código:")).setBounds(12, 13, 116, 16);
		
		txtCodigo.setBounds(162, 10, 116, 22);
		pnlPrincipal.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Tipo Consulta:")).setBounds(12, 42, 116, 16);
		
		txtTipo.setBounds(162, 39, 116, 22);
		pnlPrincipal.add(txtTipo);
		txtTipo.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Pesquisar Pet (Nome):")).setBounds(12, 74, 138, 16);
		
		txtPesquisarPet.setBounds(162, 71, 116, 22);
		pnlPrincipal.add(txtPesquisarPet);
		txtPesquisarPet.setColumns(10);
		
		btnPesquisar.setBounds(290, 70, 97, 25);
		pnlPrincipal.add(btnPesquisar);
		
		scrollPet.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPet.setBounds(12, 106, 478, 97);
		scrollPet.getViewport().add(tblPet);
		pnlPrincipal.add(scrollPet);
		
		pnlPrincipal.add(new JLabel("Data:")).setBounds(12, 211, 56, 16);
		
		txtData.setBounds(98, 211, 116, 22);
		pnlPrincipal.add(txtData);
		txtData.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Hora:")).setBounds(226, 211, 56, 16);
		
		txtHora = new JTextField();
		txtHora.setBounds(300, 211, 116, 22);
		pnlPrincipal.add(txtHora);
		txtHora.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Morte Pet:")).setBounds(12, 246, 74, 16);
		
		rdbtnMorteS.setBounds(98, 242, 64, 25);
		pnlPrincipal.add(rdbtnMorteS);
		
		rdbtnMorteN.setBounds(162, 242, 64, 25);
		pnlPrincipal.add(rdbtnMorteN);
		
		ButtonGroup bgMorte = new ButtonGroup();
		bgMorte.add(rdbtnMorteS);
		bgMorte.add(rdbtnMorteN);
		
		pnlPrincipal.add(new JLabel("Resultado:")).setBounds(12, 312, 74, 16);
		
		txtResultado.setBounds(12, 338, 478, 61);
		pnlPrincipal.add(txtResultado);
		txtResultado.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Consultas disponíveis:")).setBounds(12, 412, 138, 16);
		
		scrollDisponiveis.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDisponiveis.setBounds(12, 441, 478, 97);
		scrollDisponiveis.getViewport().add(tblDisponivel);
		pnlPrincipal.add(scrollDisponiveis);
		
		pnlPrincipal.add(new JLabel("Preço: R$")).setBounds(12, 551, 64, 16);
		
		txtPreco.setBounds(88, 551, 116, 22);
		pnlPrincipal.add(txtPreco);
		txtPreco.setColumns(10);
		
		btnSalvar.setBounds(290, 592, 97, 25);
		pnlPrincipal.add(btnSalvar);
		
		btnCancelar.setBounds(393, 592, 97, 25);
		pnlPrincipal.add(btnCancelar);
		
		pnlPrincipal.add(new JLabel("Hora Morte:")).setBounds(12, 283, 74, 16);
		
		txtHoraMorte.setBounds(98, 280, 116, 22);
		pnlPrincipal.add(txtHoraMorte);
		txtHoraMorte.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Encaminhamento Exame:")).setBounds(12, 596, 150, 16);
		
		rdbtnEncaminhamentoS.setBounds(170, 592, 56, 25);
		pnlPrincipal.add(rdbtnEncaminhamentoS);
		
		rdbtnEncaminhamentoN.setBounds(226, 592, 64, 25);
		pnlPrincipal.add(rdbtnEncaminhamentoN);
		
		ButtonGroup bgEncaminhamento = new ButtonGroup();
		bgEncaminhamento.add(rdbtnEncaminhamentoS);
		bgEncaminhamento.add(rdbtnEncaminhamentoN);
		
		txtCodigo.setEditable(false);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}
	
	public Consulta adicionaEntidade() {
		Consulta c = new Consulta();
		TipoConsultaDAO tipoConsultaDao = new TipoConsultaDAO();
		TipoConsulta tipo = tipoConsultaDao.pesquisaEspecifica(txtTipo.getText());
		ControlePet control = new ControlePet();
		List<Pet> pet = control.buscaPet(txtPesquisarPet.getText());
		Pet p = pet.get(0);
		
		c.setCodTipoConsulta(tipo.getCodTipoConsulta());
		c.setCodPet(p.getCodPet());
		try {
			c.setDataConsulta(sdfData.parse(txtData.getText()));
			c.setHoraConsulta(sdfHora.parse(txtHora.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if(rdbtnEncaminhamentoS.isSelected()) {
			c.setMortePet(1);
			try {
				p.setDiaMortePet(sdfData.parse(txtData.getText()));
				p.setHoraMortePet(sdfHora.parse(txtHoraMorte.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} else {
			c.setMortePet(0);
		}
		c.setResultadoConsulta(txtResultado.getText());
		c.setPrecoTotalConsulta(Double.parseDouble(txtPreco.getText()));
		return c;
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
		if(cmd.contains("Salvar")) {
			adicionaEntidade();
			tblDisponivel.invalidate();
			tblDisponivel.revalidate();
			tblDisponivel.repaint();
		} else if(cmd.contains("Pesquisar")) {
			buscaEntidade();
		} else if(cmd.contains("Cancelar")) {
			dispose();
		}
		
	}
	
}
