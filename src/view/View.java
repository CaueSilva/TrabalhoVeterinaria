package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControleExame;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel pnlPrincipal;
	protected JLabel lblCodigo = new JLabel("Código:");
	protected JTextField txtCodigo = new JTextField();
	protected JLabel lblTipo = new JLabel("Tipo:");
	protected JComboBox<String> cmbExame;
	protected JLabel lblPesquisarPet = new JLabel("Pesquisar Pet (Nome):");
	protected JTextField txtNomePet = new JTextField();

	protected JTable tblPet;
	protected JLabel lblData = new JLabel("Data:");
	protected JFormattedTextField txtData = new JFormattedTextField(mascaraData("##/##/####"));
	protected JLabel lblHora = new JLabel("Hora:");
	protected JFormattedTextField txtHora = new JFormattedTextField(mascaraHora("##:##"));
	protected JLabel lblMortePet = new JLabel("Morte Pet:");
	protected JRadioButton rdbtnMorteS = new JRadioButton("Sim");
	protected JRadioButton rdbtnMorteN = new JRadioButton("Não");
	protected JLabel lblResultado = new JLabel("Resultado:");
	protected JTextField txtResultado = new JTextField();
	protected JLabel lblDisponiveis = new JLabel("Dispon\u00EDveis:");
	protected JTable tblDisponivel;
	protected JLabel lblPreco = new JLabel("Preço: R$");
	protected JTextField txtPreco = new JTextField();
	protected JLabel lblHoraMorte = new JLabel("Hora Morte:");
	protected JFormattedTextField txtHoraMorte = new JFormattedTextField(mascaraHora("##:##"));
	protected JScrollPane scrollDisponiveis = new JScrollPane();
	protected JScrollPane scrollPet = new JScrollPane();
	protected JButton btnPesquisarPet = new JButton("Pesquisar Pet");
	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnCancelar = new JButton("Cancelar");
	protected JRadioButton rdbtnEncaminhamentoS = new JRadioButton("Sim");
	protected JRadioButton rdbtnEncaminhamentoN = new JRadioButton("Não");;
	protected JLabel lblEncaminhamento = new JLabel("Encaminhamento Exame:");
	protected JButton btnPesquisarExame = new JButton("Pesquisar Exame");
	private ControleExame controle = new ControleExame();
	// Método necessário para construir a View
	/**
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { View frame = new View();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	public View() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 665);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);

		lblCodigo.setBounds(12, 13, 116, 16);
		pnlPrincipal.add(lblCodigo);

		txtCodigo.setBounds(162, 10, 116, 22);
		pnlPrincipal.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblTipo.setBounds(12, 42, 116, 16);
		pnlPrincipal.add(lblTipo);
		
		cmbExame = new JComboBox<String>(controle.retornaVetor());
		cmbExame.setBounds(162, 39, 116, 22);
		pnlPrincipal.add(cmbExame);

		lblPesquisarPet.setBounds(12, 74, 138, 16);
		pnlPrincipal.add(lblPesquisarPet);

		txtNomePet.setBounds(162, 71, 116, 22);
		pnlPrincipal.add(txtNomePet);
		txtNomePet.setColumns(10);

		btnPesquisarPet.setBounds(290, 70, 138, 25);
		pnlPrincipal.add(btnPesquisarPet);

		scrollPet.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPet.setBounds(12, 106, 478, 97);
		scrollPet.setViewportView(tblPet);
		pnlPrincipal.add(scrollPet);

		lblData.setBounds(12, 211, 56, 16);
		pnlPrincipal.add(lblData);

		txtData.setBounds(98, 211, 116, 22);
		pnlPrincipal.add(txtData);
		txtData.setColumns(10);

		lblHora.setBounds(226, 211, 56, 16);
		pnlPrincipal.add(lblHora);

		txtHora.setBounds(300, 211, 116, 22);
		pnlPrincipal.add(txtHora);
		txtHora.setColumns(10);

		lblMortePet.setBounds(12, 246, 74, 16);
		pnlPrincipal.add(lblMortePet);

		rdbtnMorteS.setBounds(98, 242, 64, 25);
		pnlPrincipal.add(rdbtnMorteS);

		rdbtnMorteN.setBounds(162, 242, 64, 25);
		pnlPrincipal.add(rdbtnMorteN);

		ButtonGroup bgMorte = new ButtonGroup();
		bgMorte.add(rdbtnMorteS);
		bgMorte.add(rdbtnMorteN);

		lblResultado.setBounds(12, 312, 74, 16);
		pnlPrincipal.add(lblResultado);

		txtResultado.setBounds(12, 338, 478, 61);
		pnlPrincipal.add(txtResultado);
		txtResultado.setColumns(10);

		lblDisponiveis.setBounds(12, 412, 138, 16);
		pnlPrincipal.add(lblDisponiveis);

		scrollDisponiveis.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDisponiveis.setBounds(12, 441, 478, 97);
		scrollDisponiveis.setViewportView(tblDisponivel);
		pnlPrincipal.add(scrollDisponiveis);

		lblPreco.setBounds(12, 551, 64, 16);
		pnlPrincipal.add(lblPreco);

		txtPreco.setBounds(88, 551, 116, 22);
		pnlPrincipal.add(txtPreco);
		txtPreco.setColumns(10);

		btnSalvar.setBounds(290, 592, 97, 25);
		pnlPrincipal.add(btnSalvar);

		btnCancelar.setBounds(393, 592, 97, 25);
		pnlPrincipal.add(btnCancelar);

		lblHoraMorte.setBounds(12, 283, 74, 16);
		pnlPrincipal.add(lblHoraMorte);

		txtHoraMorte.setBounds(98, 280, 116, 22);
		pnlPrincipal.add(txtHoraMorte);
		txtHoraMorte.setColumns(10);

		lblEncaminhamento.setBounds(12, 596, 150, 16);
		pnlPrincipal.add(lblEncaminhamento);

		rdbtnEncaminhamentoS.setBounds(170, 592, 56, 25);
		pnlPrincipal.add(rdbtnEncaminhamentoS);

		rdbtnEncaminhamentoN.setBounds(226, 592, 64, 25);
		pnlPrincipal.add(rdbtnEncaminhamentoN);

		ButtonGroup bgEncaminhamento = new ButtonGroup();
		bgEncaminhamento.add(rdbtnEncaminhamentoS);
		bgEncaminhamento.add(rdbtnEncaminhamentoN);

		btnPesquisarExame.setBounds(290, 9, 138, 25);
		pnlPrincipal.add(btnPesquisarExame);

	}

	protected MaskFormatter mascaraData(String mascara) {
		MaskFormatter mask = new MaskFormatter();
		try {
			mask.setMask(mascara); // Atribui a mascara
			mask.setPlaceholderCharacter(' '); // Caracter para preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return mask;
	}
	
	protected MaskFormatter mascaraHora(String mascara) {
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
