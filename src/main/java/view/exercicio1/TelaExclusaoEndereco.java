package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.exercicio1.EnderecoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaExclusaoEndereco {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoEndereco window = new TelaExclusaoEndereco();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExclusaoEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInformeOId = new JLabel("Informe o id: ");
		lblInformeOId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInformeOId.setBounds(78, 66, 101, 31);
		frame.getContentPane().add(lblInformeOId);
		
		textField = new JTextField();
		textField.setBounds(205, 74, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnderecoController controladora = new EnderecoController();
				
				int idSelecionado;
				//controladora.excluir(idSelecionado);
			}
		});
		btnExcluir.setBounds(67, 147, 271, 103);
		frame.getContentPane().add(btnExcluir);
	}
}
