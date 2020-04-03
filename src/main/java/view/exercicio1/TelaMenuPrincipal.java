package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuPrincipal {

	private JFrame frmMenuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipal window = new TelaMenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 350, 210);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel lblSelecioneAOpo = new JLabel("Selecione a op\u00E7\u00E3o desejada:");
		lblSelecioneAOpo.setBounds(90, 14, 180, 15);
		frmMenuPrincipal.getContentPane().add(lblSelecioneAOpo);
		
		JButton btnMenuDeClientes = new JButton("Menu de Clientes");
		btnMenuDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuClientes.main(null);
				frmMenuPrincipal.dispose();
			}
		});
		btnMenuDeClientes.setBounds(80, 40, 180, 30);
		frmMenuPrincipal.getContentPane().add(btnMenuDeClientes);
		
		JButton btnMenuDeTelefones = new JButton("Menu de Telefones");
		btnMenuDeTelefones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuTelefones.main(null);
				frmMenuPrincipal.dispose();
			}
		});
		btnMenuDeTelefones.setBounds(80, 80, 180, 30);
		frmMenuPrincipal.getContentPane().add(btnMenuDeTelefones);
		
		JButton btnMenuDeEndereos = new JButton("Menu de Endere\u00E7os");
		btnMenuDeEndereos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuEnderecos.main(null);
				frmMenuPrincipal.dispose();
			}
		});
		btnMenuDeEndereos.setBounds(80, 120, 180, 30);
		frmMenuPrincipal.getContentPane().add(btnMenuDeEndereos);
	}
}
