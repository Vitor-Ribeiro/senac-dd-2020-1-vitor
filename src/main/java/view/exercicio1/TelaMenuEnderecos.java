package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuEnderecos {

	private JFrame frmMenuEnderecos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuEnderecos window = new TelaMenuEnderecos();
					window.frmMenuEnderecos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenuEnderecos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuEnderecos = new JFrame();
		frmMenuEnderecos.setBounds(100, 100, 300, 250);
		frmMenuEnderecos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuEnderecos.getContentPane().setLayout(null);
		
		JLabel lblSelecioneOpcao = new JLabel("Selecione a op\u00E7\u00E3o desejada:");
		lblSelecioneOpcao.setBounds(70, 20, 200, 20);
		frmMenuEnderecos.getContentPane().add(lblSelecioneOpcao);
		
		JButton btnCadastrarEndereco = new JButton("Cadastrar Endere\u00E7o");
		btnCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEndereco.main(null);
				frmMenuEnderecos.dispose();
			}
		});
		btnCadastrarEndereco.setBounds(50, 50, 200, 30);
		frmMenuEnderecos.getContentPane().add(btnCadastrarEndereco);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal.main(null);
				frmMenuEnderecos.dispose();
			}
		});
		btnVoltar.setBounds(50, 139, 200, 30);
		frmMenuEnderecos.getContentPane().add(btnVoltar);
	}

}
