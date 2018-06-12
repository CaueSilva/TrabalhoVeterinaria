package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ListenerPet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ViewPet extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField txtNomePet = new JTextField();
	private JTable tblPesquisarPet = new JTable();
	
	private JTextField txtCodigo = new JTextField();
	private JScrollPane scrollPesquisarPet = new JScrollPane();
	
	private JTextField txtTutor = new JTextField();
	private JTextField txtRaca = new JTextField();
	private JTextField txtEspecie = new JTextField();
	private JRadioButton rdbtnVacinacaoS = new JRadioButton("Sim");
	private JRadioButton rdbtnVacinacaoN = new JRadioButton("Não");
	private JTextField txtCor = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtDataMorte = new JTextField();
	private JTextField txtHoraMorte = new JTextField();
	private JTable tblPetsCadastrados = new JTable();
	private JScrollPane scrollPets = new JScrollPane();
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private ListenerPet listener = new ListenerPet();

	public ViewPet() {
		setResizable(false);
		setTitle("Manutenção de Pets");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 630);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomePet = new JLabel("Nome Pet:");
		lblNomePet.setBounds(12, 13, 66, 16);
		contentPane.add(lblNomePet);
		
		txtNomePet.setBounds(85, 10, 116, 22);
		contentPane.add(txtNomePet);
		txtNomePet.setColumns(10);
		
		scrollPesquisarPet.setBounds(12, 42, 438, 97);
		contentPane.add(scrollPesquisarPet);
		
		scrollPesquisarPet.setViewportView(tblPesquisarPet);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(12, 152, 56, 16);
		contentPane.add(lblCdigo);
		
		txtCodigo.setBounds(85, 152, 72, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(169, 152, 39, 16);
		contentPane.add(lblTutor);
		
		txtTutor.setBounds(215, 152, 235, 22);
		contentPane.add(txtTutor);
		txtTutor.setColumns(10);
		
		JLabel lblRaca = new JLabel("Raça:");
		lblRaca.setBounds(12, 196, 39, 16);
		contentPane.add(lblRaca);
		
		txtRaca.setBounds(85, 196, 100, 22);
		contentPane.add(txtRaca);
		txtRaca.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Espécie:");
		lblEspecie.setBounds(215, 196, 56, 16);
		contentPane.add(lblEspecie);
		
		txtEspecie.setBounds(283, 196, 116, 22);
		contentPane.add(txtEspecie);
		txtEspecie.setColumns(10);
		
		JLabel lblVacinado = new JLabel("Vacinado:");
		lblVacinado.setBounds(12, 241, 66, 16);
		contentPane.add(lblVacinado);
		
		rdbtnVacinacaoS.setBounds(85, 237, 66, 25);
		contentPane.add(rdbtnVacinacaoS);
		
		rdbtnVacinacaoN.setBounds(155, 237, 66, 25);
		contentPane.add(rdbtnVacinacaoN);
		
		ButtonGroup bgVacinacao = new ButtonGroup();
		bgVacinacao.add(rdbtnVacinacaoS);
		bgVacinacao.add(rdbtnVacinacaoN);
		
		JLabel lblCor = new JLabel("Cor Pelo:");
		lblCor.setBounds(12, 284, 56, 16);
		contentPane.add(lblCor);
		
		txtCor.setBounds(85, 284, 116, 22);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(12, 325, 66, 16);
		contentPane.add(lblDescricao);
		
		txtDescricao.setBounds(85, 325, 365, 22);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblDataMorte = new JLabel("Data Morte:");
		lblDataMorte.setBounds(12, 364, 72, 16);
		contentPane.add(lblDataMorte);
		
		JLabel lblHoraMorte =  new JLabel("Hora Morte:");
		lblHoraMorte.setBounds(12, 393, 72, 16);
		contentPane.add(lblHoraMorte);
		
		txtDataMorte.setEditable(false);
		txtDataMorte.setBounds(85, 360, 116, 22);
		contentPane.add(txtDataMorte);
		txtDataMorte.setColumns(10);
		
		txtHoraMorte.setEditable(false);
		txtHoraMorte.setBounds(85, 393, 116, 22);
		contentPane.add(txtHoraMorte);
		txtHoraMorte.setColumns(10);
		
		JLabel lblPetsCadastrados = new JLabel("Pets Cadastrados:");
		lblPetsCadastrados.setBounds(12, 431, 116, 16);
		contentPane.add(lblPetsCadastrados);
		
		scrollPets.setBounds(12, 460, 438, 80);
		contentPane.add(scrollPets);
		
		scrollPets.setViewportView(tblPetsCadastrados);
		
		btnSalvar.setBounds(243, 550, 97, 25);
		contentPane.add(btnSalvar);
		
		btnExcluir.setBounds(353, 550, 97, 25);
		contentPane.add(btnExcluir);
		
		btnPesquisar.setBounds(215, 9, 97, 25);
		contentPane.add(btnPesquisar);
		
		btnPesquisar.addActionListener(listener);
		btnSalvar.addActionListener(listener);
		btnExcluir.addActionListener(listener);
		
	}
}
