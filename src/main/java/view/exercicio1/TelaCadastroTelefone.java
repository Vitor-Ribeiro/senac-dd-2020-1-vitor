package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.exercicio1.TelefoneController;
import model.dao.exercicio01.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaCadastroTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtDdd;
	private JTextField txtCodigoPais;
	private JTextField txtNumero;
	private JComboBox cbDono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone frame = new TelaCadastroTelefone();
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
	public TelaCadastroTelefone() {
		setTitle("Cadastramento de Telefones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(10, 60, 56, 14);
		contentPane.add(lblDdd);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(76, 57, 86, 20);
		contentPane.add(txtDdd);
		txtDdd.setColumns(10);
		
		JLabel lblCodigoPais = new JLabel("CodigoPais:");
		lblCodigoPais.setBounds(5, 11, 73, 14);
		contentPane.add(lblCodigoPais);
		
		txtCodigoPais = new JTextField();
		txtCodigoPais.setBounds(76, 8, 86, 20);
		contentPane.add(txtCodigoPais);
		txtCodigoPais.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setBounds(10, 100, 56, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(76, 97, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblAtivo = new JLabel("Ativo:");
		lblAtivo.setBounds(207, 11, 35, 14);
		contentPane.add(lblAtivo);
		
		JLabel lblMovel = new JLabel("Movel:");
		lblMovel.setBounds(207, 60, 42, 14);
		contentPane.add(lblMovel);
		
		ClienteDAO dao = new ClienteDAO();
		cbDono = new JComboBox(dao.consultarTodos().toArray());
		cbDono.setBounds(249, 94, 265, 27);
		contentPane.add(cbDono);
		
		final JRadioButton rdbtnAtivo = new JRadioButton("Telefone \u00E9 Ativo");
		rdbtnAtivo.setBounds(249, 7, 109, 23);
		rdbtnAtivo.setSelected(true);
		contentPane.add(rdbtnAtivo);
		
		final JRadioButton rdbtnMovel = new JRadioButton("Telefone \u00E9 Movel");
		rdbtnMovel.setBounds(249, 56, 126, 23);
		rdbtnMovel.setSelected(true);
		contentPane.add(rdbtnMovel);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = "";
				
				TelefoneController controller = new TelefoneController();
				mensagem += controller.validarCodigoPais(txtCodigoPais.getText());
				mensagem += controller.validarDdd(txtDdd.getText());
				mensagem += controller.validarNumero(txtNumero.getText());
				mensagem += controller.validarNumeroObrigatorio(txtNumero.getText());
				if(mensagem.isEmpty()) {
					controller.salvarTelefone(cbDono.getSelectedItem(),txtCodigoPais.getText(), txtDdd.getText(), txtNumero.getText(), rdbtnAtivo.isSelected(), rdbtnMovel.isSelected());
				}
								
			}
		});
		btnSalvar.setBounds(151, 170, 155, 63);
		contentPane.add(btnSalvar);
		
	
		
		JLabel lblDono = new JLabel("Dono:");
		lblDono.setBounds(207, 100, 35, 14);
		contentPane.add(lblDono);
		
		
	}

	
}
