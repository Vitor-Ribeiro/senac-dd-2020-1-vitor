package view.aula10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuPrincipal extends JFrame {

	private int limitarTelaClientes = 0;
	private int limitarTelaAutores = 0;
	private int limitarExclusaoTelefones = 0;
	private int limitarListagemTelefones = 0;
	private int limitarCadastroTelefones = 0;
	private TelaInternaCadastroCliente cadastroCliente;
	private TelaInternaCadastroTelefone cadastroTelefone;
	private TelaInternaExclusaoTelefone exclusaoTelefone;
	private TelaInternaListagemTelefone listagemTelefone;
	private TelaSobreAutor sobreAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);

		JMenu menuCliente = new JMenu("Clientes");
		menuCliente.setForeground(Color.WHITE);
		menuCliente.setBackground(Color.DARK_GRAY);
		menuCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_user_50px.png")));
		menuBar.add(menuCliente);

		final JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		JMenuItem menuItemCadastroCliente = new JMenuItem("Cadastrar cliente");
		menuItemCadastroCliente.setForeground(Color.WHITE);
		menuItemCadastroCliente.setBackground(Color.DARK_GRAY);
		menuItemCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (limitarTelaClientes == 0) {
					limitarTelaClientes++;
					cadastroCliente = new TelaInternaCadastroCliente();
					desktopPane.add(cadastroCliente);
					cadastroCliente.show();
				}
				if (cadastroCliente.isClosed()) {
					limitarTelaClientes--;
				}
			}
		});
		menuItemCadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		menuItemCadastroCliente
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_add_user_male_80px.png")));
		menuCliente.add(menuItemCadastroCliente);

		JMenu menuAutores = new JMenu("Autores");
		menuAutores.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_hand_with_pen_80px.png")));
		menuAutores.setForeground(Color.WHITE);
		menuAutores.setBackground(Color.DARK_GRAY);
		menuBar.add(menuAutores);

		JMenuItem menuItemSobre = new JMenuItem("Sobre");
		menuItemSobre.setForeground(Color.WHITE);
		menuItemSobre.setBackground(Color.DARK_GRAY);
		menuItemSobre.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_info_80px.png")));
		menuItemSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		menuItemSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (limitarTelaAutores == 0) {
					limitarTelaAutores++;
					sobreAutor = new TelaSobreAutor();
					sobreAutor.setVisible(true);
				}
				if (!sobreAutor.isDisplayable()) {
					limitarTelaAutores--;
				}
			}
		});
		menuAutores.add(menuItemSobre);
		
		JMenu menuListagemTelefone = new JMenu("Telefones");
		menuListagemTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_phone_80px_5.png")));
		menuListagemTelefone.setBackground(Color.DARK_GRAY);
		menuListagemTelefone.setForeground(Color.WHITE);
		menuBar.add(menuListagemTelefone);
		
		JMenuItem menuItemListarTodos = new JMenuItem("Listar todos");
		menuItemListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (limitarListagemTelefones == 0) {
					limitarListagemTelefones++;
					listagemTelefone = new TelaInternaListagemTelefone();
					desktopPane.add(listagemTelefone);
					listagemTelefone.show();
				}
				if (listagemTelefone.isClosed()) {
					limitarListagemTelefones--;
				}
			}
		});
		menuItemListarTodos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		menuItemListarTodos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_address_book_80px.png")));
		menuItemListarTodos.setForeground(Color.WHITE);
		menuItemListarTodos.setBackground(Color.DARK_GRAY);
		menuListagemTelefone.add(menuItemListarTodos);
		
		JMenuItem menuItemExcluirTelefone = new JMenuItem("Excluir telefone");
		menuItemExcluirTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (limitarExclusaoTelefones == 0) {
					limitarExclusaoTelefones++;
					exclusaoTelefone = new TelaInternaExclusaoTelefone();
					desktopPane.add(exclusaoTelefone);
					exclusaoTelefone.show();
				}
				if (exclusaoTelefone.isClosed()) {
					limitarExclusaoTelefones--;
				}
			}
		});
		menuItemExcluirTelefone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		menuItemExcluirTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_no_phones_80px.png")));
		menuItemExcluirTelefone.setForeground(Color.WHITE);
		menuItemExcluirTelefone.setBackground(Color.DARK_GRAY);
		menuListagemTelefone.add(menuItemExcluirTelefone);
		
		JMenuItem menuItemCadastrarTelefone = new JMenuItem("Cadastrar Telefone");
		menuItemCadastrarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (limitarCadastroTelefones == 0) {
					limitarCadastroTelefones++;
					cadastroTelefone = new TelaInternaCadastroTelefone();
					desktopPane.add(cadastroTelefone);
					cadastroTelefone.show();
				}
				if (cadastroTelefone.isClosed()) {
					limitarCadastroTelefones--;
				}
			}
		});
		menuItemCadastrarTelefone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		menuItemCadastrarTelefone.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8_add_phone_80px.png")));
		menuItemCadastrarTelefone.setForeground(Color.WHITE);
		menuItemCadastrarTelefone.setBackground(Color.DARK_GRAY);
		menuListagemTelefone.add(menuItemCadastrarTelefone);

	}
}