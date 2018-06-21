package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import controller.ControleConsulta;
import controller.ControlePet;
import model.Consulta;
import model.Pet;
import model.TipoConsulta;
import model.TipoConsultaDAO;

public class ViewConsulta extends JFrame implements ActionListener{
	
	public JPanel pnlPrincipal;
	protected JTextField txtCodigo = new JTextField();
	protected JComboBox<String> cmbConsulta;
	protected JTextField txtNomePet = new JTextField();

	private ControleConsulta controle = new ControleConsulta();
	private ControlePet controlePet = new ControlePet();
	protected JTable tblPet = new JTable(controlePet);
	protected JTable tblDisponivel = new JTable(controle);
	
	protected JFormattedTextField txtData = new JFormattedTextField(mascaraData("##/##/####"));
	protected JFormattedTextField txtHora = new JFormattedTextField(mascaraHora("##:##"));
	protected JRadioButton rdbtnMorteS = new JRadioButton("Sim");
	protected JRadioButton rdbtnMorteN = new JRadioButton("Não");
	protected JTextField txtResultado = new JTextField();
	protected JTextField txtPreco = new JTextField();
	protected JFormattedTextField txtHoraMorte = new JFormattedTextField(mascaraHora("##:##"));
	protected JScrollPane scrollDisponiveis = new JScrollPane();
	protected JScrollPane scrollPet = new JScrollPane();
	protected JButton btnPesquisarPet = new JButton("Pesquisar Pet");
	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnCancelar = new JButton("Cancelar");
	protected JRadioButton rdbtnEncaminhamentoS = new JRadioButton("Sim");
	protected JRadioButton rdbtnEncaminhamentoN = new JRadioButton("Não");;
	protected JLabel lblEncaminhamento = new JLabel("Encaminhamento Exame:");
	private final JButton btnPesquisarConsulta = new JButton("Pesquisar Consulta");
	
	public ViewConsulta() {
		setTitle("Manutenção de Consultas");
		setVisible(true);
		setResizable(false);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 665);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);

		this.setLocationRelativeTo(null);
		pnlPrincipal.setLayout(null);
		
		pnlPrincipal.add(new JLabel("Código:")).setBounds(12, 13, 116, 16);
		
		txtCodigo.setBounds(162, 10, 116, 22);
		pnlPrincipal.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Tipo Consulta:")).setBounds(12, 42, 116, 16);
		
		
		//System.out.println(controle.retornaVetor().toString());
		cmbConsulta = new JComboBox<String>(controle.retornaVetor());
		cmbConsulta.setBounds(162, 39, 116, 22);
		pnlPrincipal.add(cmbConsulta);
		
		pnlPrincipal.add(new JLabel("Pesquisar Pet (Nome):")).setBounds(12, 74, 138, 16);
		
		txtNomePet.setBounds(162, 71, 116, 22);
		pnlPrincipal.add(txtNomePet);
		txtNomePet.setColumns(10);
		
		btnPesquisarPet.setBounds(290, 70, 141, 25);
		pnlPrincipal.add(btnPesquisarPet);
		
		scrollPet.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPet.setBounds(12, 106, 478, 97);
		scrollPet.setViewportView(tblPet);
		pnlPrincipal.add(scrollPet);
		
		pnlPrincipal.add(new JLabel("Data:")).setBounds(12, 211, 56, 16);
		
		txtData.setBounds(98, 211, 116, 22);
		pnlPrincipal.add(txtData);
		txtData.setColumns(10);
		
		pnlPrincipal.add(new JLabel("Hora:")).setBounds(226, 211, 56, 16);
		
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
		scrollDisponiveis.setViewportView(tblDisponivel);
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
		
		btnPesquisarConsulta.setBounds(290, 9, 141, 25);
		pnlPrincipal.add(btnPesquisarConsulta);
		
		btnPesquisarPet.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisarConsulta.addActionListener(this);
	}
	
	private Consulta adicionaEntidade() {
		Consulta c = new Consulta();
		TipoConsultaDAO tipoConsultaDao = new TipoConsultaDAO();
		TipoConsulta tipo = tipoConsultaDao.pesquisaEspecifica(cmbConsulta.getSelectedItem().toString());
		ControlePet control = new ControlePet();
		List<Pet> pet = control.buscaPet(txtNomePet.getText());
		Pet p = pet.get(0);
		
		c.setCodTipoConsulta(tipo.getCodTipoConsulta());
		c.setCodPet(p.getCodPet());
		c.setDataConsulta(txtData.getText());
		c.setHoraConsulta(txtHora.getText());
		if(rdbtnEncaminhamentoS.isSelected()) {
			c.setMortePet(1);
			p.setDiaMortePet(txtData.getText());
			p.setHoraMortePet(txtHoraMorte.getText());
		} else {
			c.setMortePet(0);
		}
		c.setResultadoConsulta(txtResultado.getText());
		c.setPrecoTotalConsulta(txtPreco.getText());
		return c;
	}
	
	private void recebePet() {
		ControlePet controlPet = new ControlePet();
		List<Pet> listaPet = controlPet.buscaPet(txtNomePet.getText());
		if(listaPet != null && listaPet.size() > 0 ){
			tblPet.invalidate();
			tblPet.revalidate();
			tblPet.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "A busca não retornou resultados.");
		}
	}
	
	private void recebeConsulta() {
		ControleConsulta controleConsulta = new ControleConsulta();
		Consulta c = controleConsulta.buscaConsulta(txtCodigo.getColumns());
		ControlePet controlePet = new ControlePet();
		List<Pet> listaPet = controlePet.buscaPet(c.getNomePet());
		Pet p = listaPet.get(0);
		
		if(c != null) {
			cmbConsulta.setSelectedItem(String.valueOf(c.getCodTipoConsulta()));
			txtNomePet.setText(c.getNomePet());
			txtData.setValue(c.getDataConsulta());
			txtHora.setValue(c.getHoraConsulta());
			if(c.getMortePet() == 0) {
				rdbtnMorteN.setSelected(true);
			} else {
				rdbtnMorteS.setSelected(true);
				txtHoraMorte.setText(p.getHoraMortePet());;
			}
			txtResultado.setText(c.getResultadoConsulta());
			txtPreco.setText(String.valueOf(c.getPrecoTotalConsulta()));
			if(c.getEncaminhamentoExame() == 0) {
				rdbtnEncaminhamentoN.setSelected(true);
			} else {
				rdbtnEncaminhamentoS.setSelected(true);
			}
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
		} else if(cmd.contains("Pet")) {
			recebePet();
		} else if(cmd.contains("Consulta"))	{
			recebeConsulta();
		} else if(cmd.contains("Cancelar")) {
			dispose();
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
	
	private MaskFormatter mascaraHora(String mascara) {
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
