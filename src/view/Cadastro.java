package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Atxy2k.CustomTextField.RestrictedTextField;
import controller.Controller;
import controller.Endereco;
import model.Cliente;

@SuppressWarnings("serial")
public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JPanel panelAlterar;
	private JPanel panel;
	
	private JTextField txtNome;
	
	private JLabel lblCep;
	private JTextField txtCEP;
	
	private JTextField txtNumero;
	private JLabel lblNumero;
	
	private JLabel lblRuaavenida;
	private JTextField txtLogradouro;
	
	private JLabel lblBairro;
	private JTextField txtBairro;
	
	private JLabel lblCidade;
	private JTextField txtCidade;
	
	private JTextField txtUF;
	private JLabel lblUf;
	
	private JTable table;
	private JTextField txtSearch;

	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Cadastro() {
		setResizable(false);
		setTitle("Cadastro");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelAlterar = new JPanel();
		panelAlterar.setBackground(Color.DARK_GRAY);
		panelAlterar.setBounds(505, 26, 87, 52);
		contentPane.add(panelAlterar);
		panelAlterar.setLayout(null);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deletarCliente();

			}
		});

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atualizarCliente();

			}
		});
		btnAtualizar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAtualizar.setBorder(null);
		btnAtualizar.setBounds(0, 27, 87, 23);
		panelAlterar.add(btnAtualizar);
		btnDeletar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnDeletar.setBorder(null);
		btnDeletar.setBounds(0, 0, 87, 23);
		panelAlterar.add(btnDeletar);
		
		panelAlterar.hide();

		JLabel lblnome = new JLabel("Nome");
		lblnome.setForeground(Color.WHITE);
		lblnome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnome.setBounds(10, 11, 43, 14);
		contentPane.add(lblnome);

		txtNome = new JTextField();
		txtNome.setBounds(10, 26, 336, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setForeground(Color.WHITE);
		lblCep.setBounds(356, 11, 43, 14);
		contentPane.add(lblCep);

		txtCEP = new JTextField();
		txtCEP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (txtCEP.getText().length() >= 8) {

					buscarCep();

				}

			}
		});
		txtCEP.setColumns(10);
		txtCEP.setBounds(356, 26, 61, 20);
		contentPane.add(txtCEP);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(427, 26, 53, 20);
		contentPane.add(txtNumero);

		lblNumero = new JLabel("Numero");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(427, 11, 53, 14);
		contentPane.add(lblNumero);

		lblRuaavenida = new JLabel("Rua/Avenida");
		lblRuaavenida.setForeground(Color.WHITE);
		lblRuaavenida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRuaavenida.setBounds(10, 49, 74, 14);
		contentPane.add(lblRuaavenida);

		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(10, 64, 210, 20);
		contentPane.add(txtLogradouro);

		lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setBounds(229, 49, 111, 14);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(229, 64, 111, 20);
		contentPane.add(txtBairro);

		lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(350, 49, 74, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(350, 64, 98, 20);
		contentPane.add(txtCidade);

		txtUF = new JTextField();
		txtUF.setColumns(10);
		txtUF.setBounds(454, 64, 26, 20);
		contentPane.add(txtUF);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUf.setForeground(Color.WHITE);
		lblUf.setBounds(454, 49, 20, 14);
		contentPane.add(lblUf);

		JButton btLimpar = new JButton("Limpar");
		btLimpar.setBorder(null);
		btLimpar.setFont(new Font("Dialog", Font.BOLD, 12));
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cleanFields();
				refreshTB();

			}
		});
		btLimpar.setBounds(505, 81, 87, 23);
		contentPane.add(btLimpar);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "CEP", "Numero", "Rua/Av.", "Bairro", "Cidade", "UF" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);

		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadFields();

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				loadFields();

			}
		});

		scrollPane.setBounds(10, 122, 594, 228);
		contentPane.add(scrollPane);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				cleanFields();
				refreshTB();

			}

		});

		txtSearch.setColumns(10);
		txtSearch.setBounds(54, 97, 163, 20);
		contentPane.add(txtSearch);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar.setBounds(10, 98, 43, 14);
		contentPane.add(lblBuscar);

		TableColumn colID = table.getColumnModel().getColumn(0);
		TableColumn colUF = table.getColumnModel().getColumn(7);

		TableColumn colnome = table.getColumnModel().getColumn(1);
		TableColumn colcep = table.getColumnModel().getColumn(2);
		TableColumn colnum = table.getColumnModel().getColumn(3);

		colID.setPreferredWidth(15);
		colnome.setPreferredWidth(135);
		colcep.setPreferredWidth(50);
		colnum.setPreferredWidth(40);
		colUF.setPreferredWidth(17);

		refreshTB();

		// Atx2k

		RestrictedTextField vcep = new RestrictedTextField(txtCEP);
		vcep.setOnlyNums(true);
		vcep.setLimit(8);

		RestrictedTextField vuf = new RestrictedTextField(txtUF);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(640, 134, 87, 23);
		contentPane.add(panel);
		panel.setLayout(null);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				salvarCliente();

			}
		});
		btnSalvar.setBounds(505, 55, 87, 23);
		contentPane.add(btnSalvar);
		btnSalvar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalvar.setBorder(null);

		vuf.setOnlyText(true);
		vuf.setLimit(2);

	}

	/**
	 * Methods.
	 */
	
	public void deletarCliente() {

		int confirm = JOptionPane.showConfirmDialog(null,
				"Deseja apagar o cliente " + table.getValueAt(table.getSelectedRow(), 1), "Aviso",
				JOptionPane.YES_NO_OPTION);

		if (confirm == 0) { // The ISSUE is here

			Cliente cliente = new Cliente();
			Controller banco = new Controller();

			cliente.setId((int) table.getValueAt(table.getSelectedRow(), 0));

			banco.deletarCadastro(cliente);

			cleanFields();
			refreshTB();

		}

	}

	public void atualizarCliente() {

		boolean status;
		Cliente cliente = new Cliente();
		Controller banco = new Controller();

		cliente.setId((int) table.getValueAt(table.getSelectedRow(), 0));

		cliente.setNome(txtNome.getText());
		cliente.setCep(txtCEP.getText());
		cliente.setNumero(txtNumero.getText());
		cliente.setLogradouro(txtLogradouro.getText());
		cliente.setBairro(txtBairro.getText());
		cliente.setCidade(txtCidade.getText());
		cliente.setUf(txtUF.getText());

		status = banco.updateCadastro(cliente);

		if (status) {

			cleanFields();
			refreshTB();
			JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + "  foi atulizado", "Cadastro",
					JOptionPane.INFORMATION_MESSAGE);

		} else {

			JOptionPane.showMessageDialog(null, "ERRO ao tentar atualizar o cliente " + cliente.getNome(), "ERRO",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public void salvarCliente() {

		Cliente cliente = new Cliente();
		Controller banco = new Controller();
		Boolean status;

		cliente.setNome(txtNome.getText());
		cliente.setCep(txtCEP.getText());
		cliente.setNumero(txtNumero.getText());
		cliente.setLogradouro(txtLogradouro.getText());
		cliente.setBairro(txtBairro.getText());
		cliente.setCidade(txtCidade.getText());
		cliente.setUf(txtUF.getText());

		status = banco.addCastro(cliente);

		refreshTB();

		if (status) {

			cleanFields();

			JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " salvo no banco de dados", "Cadastro",
					JOptionPane.INFORMATION_MESSAGE);

		} else {

			JOptionPane.showMessageDialog(null,
					"ERRO ao tentar salvar o cliente " + cliente.getNome() + " no banco de dados", "Cadastro",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public void cleanFields() {

		txtNome.setText("");
		txtCEP.setText("");
		txtNumero.setText("");
		txtLogradouro.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtUF.setText("");

		txtCEP.setBackground(Color.white);

		panelAlterar.hide();
		panel.show();

	}

	public void loadFields() {

		if (table.getSelectedRow() != -1) {

			txtNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			txtCEP.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			txtNumero.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			txtLogradouro.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			txtBairro.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			txtCidade.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
			txtUF.setText(table.getValueAt(table.getSelectedRow(), 7).toString());

			panelAlterar.show();
			panel.hide();

		} 

	}

	public void refreshTB() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		modelo.setNumRows(0);

		Controller banco = new Controller();

		for (Cliente c : banco.buscarClientes(txtSearch.getText())) {

			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCep(), c.getNumero(), c.getLogradouro(),
					c.getBairro(), c.getCidade(), c.getUf() });

		}

	}

	public void buscarCep() {

		Endereco tesCEP = new Endereco();

		if (tesCEP.testCep(txtCEP.getText())) {

			Endereco endereco = tesCEP.GetEndereco(txtCEP.getText());

			txtCidade.setText(endereco.getCidade());
			txtUF.setText(endereco.getUf());
			txtBairro.setText(endereco.getBairro());
			txtLogradouro.setText(endereco.getTipoLogradouro() + " " + endereco.getLogradouro());

			txtCEP.setBackground(Color.white);

		} else {

			txtCEP.setBackground(Color.red);

		}

	}
}
