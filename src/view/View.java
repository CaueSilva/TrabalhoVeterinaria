package view;

import controller.JTableController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel pnlPrincipal;
	protected JLabel lblCodigo = new JLabel("Código:");
	protected JTextField txtCodigo = new JTextField();
	protected JLabel lblTipo = new JLabel("Tipo:");
	protected JTextField txtTipo = new JTextField();
	protected JLabel lblPesquisarPet = new JLabel("Pesquisar Pet (Nome):");
	protected JTextField txtPesquisarPet = new JTextField();
	protected JTableController control = new JTableController();
	 
	protected JTable tblPet = new JTable(control);
	protected JLabel lblData = new JLabel("Data:");
	protected JTextField txtData = new JTextField();
	protected JLabel lblHora = new JLabel("Hora:");
	protected JTextField txtHora = new JTextField();
	protected JLabel lblMortePet = new JLabel("Morte Pet:");
	protected JRadioButton rdbtnMorteS = new JRadioButton("Sim");
	protected JRadioButton rdbtnMorteN = new JRadioButton("Não");
	protected JLabel lblDataMorte = new JLabel("Data Morte:");
	protected JTextField txtDataMorte = new JTextField();
	protected JLabel lblResultado = new JLabel("Resultado:");
	protected JTextField txtResultado = new JTextField();
	protected JLabel lblDisponiveis = new JLabel("Dispon\u00EDveis:");
	protected JTable tblDisponivel = new JTable(control);
	protected JLabel lblPreco = new JLabel("Preço: R$");
	protected JTextField txtPreco = new JTextField();
	protected JLabel lblHoraMorte = new JLabel("Hora Morte:");
	protected JTextField txtHoraMorte = new JTextField();
	protected JScrollPane scrollDisponiveis = new JScrollPane();
	protected JScrollPane scrollPet = new JScrollPane();
	protected JButton btnPesquisar = new JButton("Pesquisar");
	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnExcluir = new JButton("Excluir");
	protected JRadioButton rdbtnEncaminhamentoS = new JRadioButton("Sim");
	protected JRadioButton rdbtnEncaminhamentoN = new JRadioButton("Não");;
	protected JLabel lblEncaminhamento = new JLabel("Encaminhamento Exame:");
	
	//Método necessário para construir a View
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		
		txtTipo.setBounds(162, 39, 116, 22);
		pnlPrincipal.add(txtTipo);
		txtTipo.setColumns(10);
		
		lblPesquisarPet.setBounds(12, 74, 138, 16);
		pnlPrincipal.add(lblPesquisarPet);
		
		txtPesquisarPet.setBounds(162, 71, 116, 22);
		pnlPrincipal.add(txtPesquisarPet);
		txtPesquisarPet.setColumns(10);
		
		btnPesquisar.setBounds(290, 70, 97, 25);
		pnlPrincipal.add(btnPesquisar);
		
		scrollPet.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPet.setBounds(12, 106, 478, 97);
		pnlPrincipal.add(scrollPet);
		
		scrollPet.setViewportView(tblPet);
		
		lblData.setBounds(12, 211, 56, 16);
		pnlPrincipal.add(lblData);
		
		txtData.setBounds(98, 211, 116, 22);
		pnlPrincipal.add(txtData);
		txtData.setColumns(10);
		
		lblHora.setBounds(226, 211, 56, 16);
		pnlPrincipal.add(lblHora);
		
		txtHora = new JTextField();
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
		
		lblDataMorte.setBounds(12, 279, 74, 16);
		pnlPrincipal.add(lblDataMorte);
		
		txtDataMorte.setBounds(98, 279, 116, 22);
		pnlPrincipal.add(txtDataMorte);
		txtDataMorte.setColumns(10);
		
		lblResultado.setBounds(12, 312, 74, 16);
		pnlPrincipal.add(lblResultado);
		
		txtResultado.setBounds(12, 338, 478, 61);
		pnlPrincipal.add(txtResultado);
		txtResultado.setColumns(10);
		
		lblDisponiveis.setBounds(12, 412, 138, 16);
		pnlPrincipal.add(lblDisponiveis);
		
		scrollDisponiveis.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDisponiveis.setBounds(12, 441, 478, 97);
		pnlPrincipal.add(scrollDisponiveis);
		
		scrollDisponiveis.setViewportView(tblDisponivel);
		
		lblPreco.setBounds(12, 551, 64, 16);
		pnlPrincipal.add(lblPreco);
		
		txtPreco.setBounds(88, 551, 116, 22);
		pnlPrincipal.add(txtPreco);
		txtPreco.setColumns(10);
		
		btnSalvar.setBounds(290, 592, 97, 25);
		pnlPrincipal.add(btnSalvar);
		
		btnExcluir.setBounds(393, 592, 97, 25);
		pnlPrincipal.add(btnExcluir);
		
		lblHoraMorte.setBounds(226, 279, 74, 16);
		pnlPrincipal.add(lblHoraMorte);
		
		txtHoraMorte.setBounds(300, 279, 116, 22);
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
		
	}
}
