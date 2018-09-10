package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaComponentes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComponentes frame = new TelaComponentes();
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
	public TelaComponentes() {
		setTitle("Equipe");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDiscentes = new JLabel("Discentes");
		lblDiscentes.setBounds(30, 112, 79, 16);
		contentPane.add(lblDiscentes);
		
		JLabel lblAndrGomes = new JLabel("Andre Gomes");
		lblAndrGomes.setBounds(51, 128, 114, 16);
		contentPane.add(lblAndrGomes);
		
		JLabel label = new JLabel("Bruno Jamelli");
		label.setBounds(51, 142, 114, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Tuany Mariah");
		label_1.setBounds(51, 157, 114, 16);
		contentPane.add(label_1);
		
		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setBounds(30, 13, 56, 16);
		contentPane.add(lblDocente);
		
		JLabel lblLauraEmmanuell = new JLabel("Laura Emmanuella");
		lblLauraEmmanuell.setBounds(51, 28, 169, 16);
		contentPane.add(lblLauraEmmanuell);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(30, 70, 56, 16);
		contentPane.add(lblDisciplina);
		
		JLabel lblTadInteligncia = new JLabel("TAD0025 - Inteligencia Computacional");
		lblTadInteligncia.setBounds(51, 83, 241, 16);
		contentPane.add(lblTadInteligncia);
	}

}
