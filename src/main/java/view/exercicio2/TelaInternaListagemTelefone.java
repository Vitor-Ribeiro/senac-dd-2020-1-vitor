package view.exercicio2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.vo.exercicio1.Telefone;
import view.exercicio1.TelaListagemTelefone;

public class TelaInternaListagemTelefone extends JInternalFrame {

	private JPanel contentPane;
	private ArrayList<Telefone> telefones;
	private String[] nomeColunas = { "C�digo Pa�s", "DDD", "Numero", "Ativo", "Movel", "Dono" };
	private JTable tblTelefones;

	private void limparTabela() {
		tblTelefones.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));
	}

	private void atualizarTabela() {
		limparTabela();
		DefaultTableModel model = (DefaultTableModel) tblTelefones.getModel();
		for (Telefone telefone : telefones) {
			Object[] novaLinha = new Object[6];

			novaLinha[0] = telefone.getCodigoPais();
			novaLinha[1] = telefone.getDdd();
			novaLinha[2] = telefone.getNumero();
			if (telefone.isAtivo()) {
				novaLinha[3] = true;
			} else {
				novaLinha[3] = false;
			}
			if (telefone.isMovel()) {
				novaLinha[4] = true;
			} else {
				novaLinha[4] = false;
			}
			if (telefone.getDono().getId() == 0) {
				novaLinha[5] = "N�o possui";
			} else {
				novaLinha[5] = telefone.getDono().getNome();

			}

			model.addRow(novaLinha);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemTelefone frame = new TelaListagemTelefone();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInternaListagemTelefone() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 54, 504, 125);
		contentPane.add(panel);

		tblTelefones = new JTable();
		panel.add(tblTelefones);

		JLabel lblListagem = new JLabel("Listagem de Telefones");
		lblListagem.setBounds(183, 25, 129, 16);
		contentPane.add(lblListagem);

		JButton btnListar = new JButton("Listar");

		btnListar.setBounds(196, 231, 97, 25);
		contentPane.add(btnListar);
	}

}
