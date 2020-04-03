package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import principal.exercicio01.Executavel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuClientes {

	private JFrame frmMenuDeClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuClientes window = new TelaMenuClientes();
					window.frmMenuDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenuClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuDeClientes = new JFrame();
		frmMenuDeClientes.setTitle("Menu de Clientes");
		frmMenuDeClientes.setBounds(100, 100, 300, 340);
		frmMenuDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuDeClientes.getContentPane().setLayout(null);
		
		JLabel lblSelecioneAOpo = new JLabel("Selecione a op\u00E7\u00E3o desejada:");
		lblSelecioneAOpo.setBounds(70, 20, 200, 20);
		frmMenuDeClientes.getContentPane().add(lblSelecioneAOpo);
		
		JButton btnCadastrarNovoCliente = new JButton("Cadastrar Novo Cliente");
		btnCadastrarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente.main(null);
				frmMenuDeClientes.dispose();
			}
		});
		btnCadastrarNovoCliente.setBounds(50, 50, 200, 30);
		frmMenuDeClientes.getContentPane().add(btnCadastrarNovoCliente);
		
		JButton btnExcluirCliente = new JButton("Excluir Cliente");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExclusaoCliente.main(null);
				frmMenuDeClientes.dispose();
			}
		});
		btnExcluirCliente.setBounds(50, 103, 200, 30);
		frmMenuDeClientes.getContentPane().add(btnExcluirCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal.main(null);
				frmMenuDeClientes.dispose();
			}
		});
		btnVoltar.setBounds(50, 250, 200, 30);
		frmMenuDeClientes.getContentPane().add(btnVoltar);
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemClientes.main(null);
				frmMenuDeClientes.dispose();
			}
		});
		btnListarClientes.setBounds(50, 156, 200, 30);
		frmMenuDeClientes.getContentPane().add(btnListarClientes);
	}

}
