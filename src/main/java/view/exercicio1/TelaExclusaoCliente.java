package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.exercicio1.ClienteController;
import model.dao.exercicio01.ClienteDAO;
import model.entity.exercicio01.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExclusaoCliente extends JFrame {

	private JPanel contentPane;
	private ClienteDAO dao = new ClienteDAO();
	private JComboBox cbClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoCliente frame = new TelaExclusaoCliente();
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
	public TelaExclusaoCliente() {
		setTitle("Exclus\u00E3o de clientes");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecionarCliente = new JLabel("Selecione o cliente ");
		lblSelecionarCliente.setBounds(10, 44, 121, 14);
		ClienteController controller = new ClienteController();
		contentPane.add(lblSelecionarCliente);
		
		cbClientes = new JComboBox(controller.listarTodosOsClientes().toArray());
		cbClientes.setBounds(141, 38, 225, 27);
		contentPane.add(cbClientes);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controladora = new ClienteController();

				String mensagem = controladora.excluir((Cliente) cbClientes.getSelectedItem());
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnExcluir.setBounds(27, 107, 150, 68);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuClientes.main(null);
				dispose();
			}
		});
		btnVoltar.setBounds(213, 107, 153, 68);
		contentPane.add(btnVoltar);
	}
}
