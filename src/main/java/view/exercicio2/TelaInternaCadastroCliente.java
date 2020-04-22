package view.exercicio2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;

public class TelaInternaCadastroCliente extends JInternalFrame {

	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private EnderecoController enderecoController;
	private ClienteController clienteController;
	private JTextField txtCpf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaCadastroCliente frame = new TelaInternaCadastroCliente();
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
	public TelaInternaCadastroCliente() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(24, 109, 71, 16);
		contentPane.add(lblSobrenome);

		txtNome = new JTextField();
		txtNome.setBounds(97, 46, 160, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel label = new JLabel("Nome:");
		label.setBounds(24, 49, 38, 16);
		contentPane.add(label);

		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(97, 106, 160, 22);
		contentPane.add(txtSobrenome);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(287, 49, 25, 16);
		contentPane.add(lblCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(287, 109, 56, 16);
		contentPane.add(lblTelefone);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(24, 156, 58, 16);
		contentPane.add(lblEndereco);

		
		final JComboBox cbEndereco = new JComboBox();
		cbEndereco.setBounds(97, 153, 439, 22);
		contentPane.add(cbEndereco);
		

		final JComboBox cbTelefones = new JComboBox();
		cbTelefones.setBounds(376, 106, 160, 22);
		contentPane.add(cbTelefones);

		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setBounds(234, 196, 97, 25);
		contentPane.add(btnCadastrar);

		txtCpf = new JTextField();
		txtCpf.setBounds(373, 46, 160, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
	}

}
