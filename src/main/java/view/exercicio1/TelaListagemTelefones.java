package view.exercicio1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.exercicio1.TelefoneController;
import model.entity.exercicio01.Telefone;

public class TelaListagemTelefones {

	private JFrame frmListagemTelefones;
	private JTable tblTelefones;
	private ArrayList<Telefone> telefones;
	private String[] nomesColunas = { "Código País", "DDD", "Número", "Móvel", "Ativo", "ID Cliente" };
	private JButton btnVoltar;

	private void limparTabelaTelefones() {
		tblTelefones.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaClientes() {
		limparTabelaTelefones();
		DefaultTableModel model = (DefaultTableModel) tblTelefones.getModel();

		for (Telefone t : telefones) {

			Object[] novaLinhaDaTabela = new Object[6];
			novaLinhaDaTabela[0] = t.getCodigoPais();
			novaLinhaDaTabela[1] = t.getDdd();
			novaLinhaDaTabela[2] = t.getNumero();
			novaLinhaDaTabela[3] = t.isMovel();
			novaLinhaDaTabela[4] = t.isAtivo();
			novaLinhaDaTabela[5] = t.getDono().getId();

			model.addRow(novaLinhaDaTabela);
		}

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemTelefones window = new TelaListagemTelefones();
					window.frmListagemTelefones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemTelefones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListagemTelefones = new JFrame();
		frmListagemTelefones.setTitle("Listagem de Telefones");
		frmListagemTelefones.setBounds(100, 100, 700, 520);
		frmListagemTelefones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListagemTelefones.getContentPane().setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controller = new TelefoneController();
				telefones = controller.listarTodosOsTelefones();

				atualizarTabelaClientes();
			}
		});
		btnBuscar.setBounds(200, 30, 120, 30);
		frmListagemTelefones.getContentPane().add(btnBuscar);

		tblTelefones = new JTable();
		tblTelefones.setBounds(25, 70, 650, 400);
		frmListagemTelefones.getContentPane().add(tblTelefones);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuTelefones.main(null);
				frmListagemTelefones.dispose();
			}
		});
		btnVoltar.setBounds(400, 30, 120, 30);
		frmListagemTelefones.getContentPane().add(btnVoltar);
		
	}

}