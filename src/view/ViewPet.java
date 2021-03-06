package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.mysql.fabric.xmlrpc.base.Array;

import controller.ControleEspecie;
import controller.ControlePet;
import controller.ControlePetTable;
import controller.ControleRaca;
import controller.ControleTutor;
import model.Especie;
import model.Pet;
import model.Raca;
import model.Tutor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ViewPet extends JFrame implements ActionListener {

	private JPanel contentPane = new JPanel();
	private JTextField txtNomePet = new JTextField();
	private ControlePet controle = new ControlePet();
	private JTable tblPesquisa = new JTable(controle);
	private JScrollPane scrollPesquisa = new JScrollPane();

	private JTextField txtCodigo = new JTextField();
	private JTextField txtCpfTutor = new JTextField();
	private JComboBox <String> cmbEspecie;
	private JComboBox <String> cmbRaca;
	private JRadioButton rdbtnVacinacaoS = new JRadioButton("Sim");
	private JRadioButton rdbtnVacinacaoN = new JRadioButton("N�o");
	private JTextField txtCor = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtDataMorte = new JTextField();
	private JTextField txtHoraMorte = new JTextField();

	private ControlePetTable controlePets = new ControlePetTable();
	private JTable tblPets = new JTable(controlePets);
	private JScrollPane scrollPets = new JScrollPane();

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnPesquisarTutor = new JButton("Pesquisar Tutor");

	public ViewPet() {
		ControleEspecie controleEspecie = new ControleEspecie();
		ControleRaca controleRaca = new ControleRaca();
		
		cmbEspecie = new JComboBox<String>(controleEspecie.retornaVetor());
		//cmbRaca = new JComboBox<String>();
		//if(cmbEspecie.getSelectedIndex() > 0) {
		if(cmbEspecie.getSelectedItem()!=null) {
			cmbRaca = new JComboBox<String>();
			cmbRaca.setEnabled(true);
			String s = cmbEspecie.getSelectedItem().toString();
			System.out.print(s);
			cmbRaca = new JComboBox<String>(controleRaca.retornaVetor(s));
			//cmbEspecie = new JComboBox<String>(controleEspecie.retornaVetor());
			//cmbRaca = new JComboBox<String>(controleRaca.retornaVetor(cmbEspecie.getSelectedItem().toString()));
		}else {
			cmbRaca = new JComboBox<String>();
			cmbRaca.setEnabled(false);
		}
		
		setVisible(true);
		setResizable(false);
		setTitle("Manuten��o de Pets");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 465, 630);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomePet = new JLabel("Nome Pet:");
		lblNomePet.setBounds(12, 13, 66, 16);
		contentPane.add(lblNomePet);

		txtNomePet.setBounds(85, 10, 116, 22);
		contentPane.add(txtNomePet);
		txtNomePet.setColumns(10);
		scrollPesquisa.setViewportView(tblPesquisa);
		contentPane.add(scrollPesquisa);
		scrollPesquisa.setBounds(12, 42, 438, 97);

		JLabel lblCdigo = new JLabel("C�digo:");
		lblCdigo.setBounds(12, 152, 56, 16);
		contentPane.add(lblCdigo);

		txtCodigo.setBounds(85, 152, 72, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setEditable(false);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(169, 152, 39, 16);
		contentPane.add(lblTutor);

		txtCpfTutor.setBounds(215, 152, 100, 22);
		contentPane.add(txtCpfTutor);
		txtCpfTutor.setColumns(10);

		JLabel lblRaca = new JLabel("Esp�cie:");
		lblRaca.setBounds(12, 196, 39, 16);
		contentPane.add(lblRaca);
		
		cmbEspecie.setBounds(85, 196, 100, 22);
		contentPane.add(cmbEspecie);
		
		JLabel lblEspecie = new JLabel("Ra�a:");
		lblEspecie.setBounds(215, 196, 56, 16);
		contentPane.add(lblEspecie);
		cmbRaca.setBounds(283, 196, 116, 22);
		contentPane.add(cmbRaca);
		//cmbRaca.setEnabled(false);
		
		
		
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

		JLabel lblDescricao = new JLabel("Descri��o:");
		lblDescricao.setBounds(12, 325, 66, 16);
		contentPane.add(lblDescricao);

		txtDescricao.setBounds(85, 325, 365, 22);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblDataMorte = new JLabel("Data Morte:");
		lblDataMorte.setBounds(12, 364, 72, 16);
		contentPane.add(lblDataMorte);

		JLabel lblHoraMorte = new JLabel("Hora Morte:");
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
		scrollPets.setViewportView(tblPets);
		contentPane.add(scrollPets);
		scrollPets.setBounds(12, 460, 438, 80);

		btnSalvar.setBounds(243, 550, 97, 25);
		contentPane.add(btnSalvar);

		btnCancelar.setBounds(353, 550, 97, 25);
		contentPane.add(btnCancelar);

		btnPesquisar.setBounds(215, 9, 97, 25);
		contentPane.add(btnPesquisar);

		btnPesquisarTutor.setBounds(327, 152, 123, 25);
		contentPane.add(btnPesquisarTutor);

		btnPesquisar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisarTutor.addActionListener(this);

		this.setLocationRelativeTo(null);
		//Table listener
		tblPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblPesquisa.getSelectedRow();
				TableModel model = tblPesquisa.getModel();
				List<Pet> lista = controle.buscaPet(model.getValueAt(i, 1).toString());
				Pet p = lista.get(0);
				ControleTutor controleTutor = new ControleTutor();
				Tutor t = controleTutor.buscaTutor(model.getValueAt(i, 2).toString());
				
				txtCodigo.setText(String.valueOf(p.getCodPet()));
				txtCpfTutor.setText(t.getCpfTutor());
				
			}
		});
		
	}

	private Pet adicionaEntidade() {
		Pet p = new Pet();
		ControleTutor controleTutor = new ControleTutor();
		ControleRaca controleRaca = new ControleRaca();
		Tutor t = controleTutor.buscaTutor(txtCpfTutor.getText());
		Raca r = controleRaca.buscaRaca(cmbRaca.getSelectedItem().toString());
		
		p.setNomePet(txtNomePet.getText());
		p.setCodTutor(t.getCodTutor());
		p.setCodRaca(r.getCodRaca());
		if (rdbtnVacinacaoS.isSelected()) {
			p.setVacinacaoPet(1);
		} else {
			p.setVacinacaoPet(0);
		}
		p.setCorPeloPet(txtCor.getText());
		p.setDescricaoPet(txtDescricao.getText());
		controlePets.adiciona(p);
		return p;
	}

	private void recebeEntidade() {
		List<Pet> lista = controle.buscaPet(txtNomePet.getText());
		ControleTutor controleTutor = new ControleTutor();
		Tutor t = controleTutor.buscaTutor(txtCpfTutor.getText());
		if (!lista.isEmpty() && lista.size() > 0) {
			Pet p = lista.get(0);
			txtNomePet.setText(p.getNomePet());
			txtCodigo.setText(String.valueOf(p.getCodPet()));
			txtCpfTutor.setText(String.valueOf(t.getCpfTutor()));
			if (p.getVacinacaoPet() == 1) {
				rdbtnVacinacaoS.setSelected(true);
				rdbtnVacinacaoN.setSelected(false);
			} else {
				rdbtnVacinacaoN.setSelected(true);
				rdbtnVacinacaoS.setSelected(false);
			}
			txtCor.setText(p.getCorPeloPet());
			txtDescricao.setText(p.getDescricaoPet());
			tblPesquisa.invalidate();
			tblPesquisa.revalidate();
			tblPesquisa.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "A busca n�o retornou resultados.");
		}
	}

	public void pesquisaTutor() {
		ControleTutor controleTutor = new ControleTutor();
		Tutor t = controleTutor.buscaTutor(txtCpfTutor.getText());
		if(t != null) {
			JOptionPane.showMessageDialog(null, "O tutor est� cadastrado.");
		} else {
			JOptionPane.showMessageDialog(null, "O tutor n�o est� cadastrado.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Pesquisar")) {
			recebeEntidade();
		} else if (cmd.contains("Tutor")) {
			pesquisaTutor();
		} else if (cmd.equals("Salvar")) {
			try {
				controle.adiciona(adicionaEntidade());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			tblPets.invalidate();
			tblPets.revalidate();
			tblPets.repaint();
		} else if (cmd.equals("Cancelar")) {
			dispose();
		}
	}
}
