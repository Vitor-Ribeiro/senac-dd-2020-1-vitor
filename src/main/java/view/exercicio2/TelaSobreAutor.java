package view.exercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaSobreAutor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobreAutor frame = new TelaSobreAutor();
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
	public TelaSobreAutor() {
		setTitle("Sobre o autor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: Vitor De Souza Ribeiro");
		lblNome.setBounds(30, 30, 300, 20);
		contentPane.add(lblNome);
		
		JLabel lblCurso = new JLabel("Curso: Análise e Desenvolvimento de Sistemas");
		lblCurso.setBounds(30, 60, 300, 20);
		contentPane.add(lblCurso);
		
		JLabel lblData = new JLabel("Data: 22/04/2020");
		lblData.setBounds(30, 90, 300, 20);
		contentPane.add(lblData);
		
		JLabel lblCidade = new JLabel("Cidade: Florian\u00F3polis - SC - Brasil");
		lblCidade.setBounds(30, 120, 300, 20);
		contentPane.add(lblCidade);
	}


}