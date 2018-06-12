package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlePet;
import controller.ControlePetTable;
import controller.ListenerPet;
import model.Pet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ViewPet extends JFrame implements ActionListener{
	
	private JFrame janela = new JFrame();
	private JPanel contentPane = new JPanel();
	private JTextField txtNomePet = new JTextField();
	private ControlePet controle = new ControlePet();
	/**private JTable tblPesquisarPet = new JTable(controle);
	private JScrollPane scrollPesquisarPet = new JScrollPane();
	*/
	private JTable tblPesquisa = new JTable(controle);
	private JScrollPane scrollPesquisa = new JScrollPane();
	
	private JTextField txtCodigo = new JTextField();
	private JTextField txtTutor = new JTextField();
	private JTextField txtRaca = new JTextField();
	private JTextField txtEspecie = new JTextField();
	private JRadioButton rdbtnVacinacaoS = new JRadioButton("Sim");
	private JRadioButton rdbtnVacinacaoN = new JRadioButton("Não");
	private JTextField txtCor = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtDataMorte = new JTextField();
	private JTextField txtHoraMorte = new JTextField();
	
	private ControlePetTable controlePets = new ControlePetTable();
	/**private JTable tblPetsCadastrados = new JTable(controlePets);
	private JScrollPane scrollPets = new JScrollPane();
	*/
	private JTable tblCadastrados = new JTable(controlePets);
	private JScrollPane scrollCadastrados = new JScrollPane();
	
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	/**public static void main(String[] args) {
		new ViewPet();
	}*/

	public ViewPet() {
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setTitle("Manutenção de Pets");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setBounds(100, 100, 480, 630);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomePet = new JLabel("Nome Pet:");
		lblNomePet.setBounds(12, 13, 66, 16);
		contentPane.add(lblNomePet);
		
		txtNomePet.setBounds(85, 10, 116, 22);
		contentPane.add(txtNomePet);
		txtNomePet.setColumns(10);
		
		scrollPesquisa.getViewport().add(tblPesquisa);
		scrollPesquisa.setBounds(12, 42, 438, 97);
		contentPane.add(scrollPesquisa);
		
		/**
		scrollPesquisarPet.setBounds(12, 42, 438, 97);
		scrollPesquisarPet.getViewport().add(tblPesquisarPet);
		contentPane.add(scrollPesquisarPet);
		*/
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
		
		scrollCadastrados.getViewport().add(tblCadastrados);
		scrollCadastrados.setBounds(12, 460, 438, 80);
		contentPane.add(scrollCadastrados);
		
		/**scrollPets.setBounds(12, 460, 438, 80);
		scrollPets.getViewport().add(tblPetsCadastrados);
		contentPane.add(scrollPets);
		*/
		btnSalvar.setBounds(243, 550, 97, 25);
		contentPane.add(btnSalvar);
		
		btnExcluir.setBounds(353, 550, 97, 25);
		contentPane.add(btnExcluir);
		
		btnPesquisar.setBounds(215, 9, 97, 25);
		contentPane.add(btnPesquisar);
		
		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
	}
	//Nome, código (int), tutor(int), raça(int), 
	public Pet adicionarEntidade() {
		Pet p = new Pet();
		p.setNomePet(txtNomePet.getText());
		p.setCodPet(Integer.parseInt(txtCodigo.getText()));
		//p.setCodTutor(txtTutor.getText());
		//p.setCodRaca(txtRaca.getText());
		//p.set espécie???
		if(rdbtnVacinacaoS != null) {
			p.setVacinacaoPet(true);
		} else {
			p.setVacinacaoPet(false);
		}
		p.setCorPeloPet(txtCor.getText());
		p.setDescricaoPet(txtDescricao.getText());
		return p;
	}
	
	public void trazerEntidade() {
		List<Pet> lista = controle.buscaPet(txtNomePet.getText());
		if(!lista.isEmpty() && lista.size() > 0) {
			Pet p = lista.get(0);
			txtNomePet.setText(p.getNomePet());
			txtCodigo.setText(String.valueOf(p.getCodPet()));
			if(p.isVacinacaoPet()) {
				rdbtnVacinacaoS.setSelected(true);
				rdbtnVacinacaoN.setSelected(false);
			} else {
				rdbtnVacinacaoN.setSelected(true);
				rdbtnVacinacaoS.setSelected(false);
			}
			txtCor.setText(p.getCorPeloPet());
			txtDescricao.setText(p.getDescricaoPet());
		}
	}
	
	public Pet removeEntidade() {
		Pet p = new Pet();
		p.setNomePet(txtNomePet.getText());
		p.setCodPet(Integer.parseInt(txtCodigo.getText()));
		//p.setCodTutor(txtTutor.getText());
		//p.setCodRaca(txtRaca.getText());
		//p.set espécie???
		if(rdbtnVacinacaoS != null) {
			p.setVacinacaoPet(true);
		} else {
			p.setVacinacaoPet(false);
		}
		p.setCorPeloPet(txtCor.getText());
		p.setDescricaoPet(txtDescricao.getText());
		return p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Pesquisar")) {
			trazerEntidade();
		} else if(cmd.equals("Salvar")) {
			controle.adiciona(adicionarEntidade());
		} else if(cmd.equals("Excluir")) {
			controle.remove(removeEntidade());
		}
	}
}
