package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.dao.exercicio01.ClienteDAO;
import model.dao.exercicio01.EnderecoDAO;
import model.dao.exercicio01.TelefoneDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JComboBox cbEndereco;
	private JTextField txtSobrenome;
	ClienteDAO dao = new ClienteDAO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Cadastramento de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 33, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("cpf:");
		lblCpf.setBounds(26, 87, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEndereco = new JLabel("endereco:");
		lblEndereco.setBounds(198, 87, 67, 14);
		contentPane.add(lblEndereco);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(88, 84, 86, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(88, 30, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		EnderecoDAO dao = new EnderecoDAO();
		cbEndereco = new JComboBox(dao.consultarTodos().toArray());
		cbEndereco.setBounds(256, 81, 515, 27);
		contentPane.add(cbEndereco);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO dao = new ClienteDAO();
				dao.salvar(txtNome.getText(), txtSobrenome.getText(),(String) cbEndereco.getSelectedItem(), txtCpf.getText());
			}
		});
		btnSalvar.setBounds(139, 173, 140, 77);
		contentPane.add(btnSalvar);
		
		
		
		
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(198, 33, 67, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(275, 30, 86, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
	}

}
