package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.transform.stream.StreamResult;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 678);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnAplicacao = new JMenu("Aplicacao");
		menuBar_1.add(mnAplicacao);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAplicacao ta = new TelaAplicacao();
				ta.setVisible(true);
			}
		});
		mnAplicacao.add(mntmPrincipal);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar_1.add(mnSobre);
		
		JMenuItem mntmArtigo = new JMenuItem("Artigo");
		mntmArtigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaArtigo1 ta1 = new TelaArtigo1();
				ta1.setVisible(true);
			}
		});
		mnSobre.add(mntmArtigo);
		
		JMenuItem mntmEquipe = new JMenuItem("Equipe");
		mntmEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComponentes tc = new TelaComponentes();
				tc.setVisible(true);
			}
		});
		mnSobre.add(mntmEquipe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel foto1 = new JLabel("");
		foto1.setBounds(154, 26, 624, 551);
		contentPane.add(foto1);
		
		ImageIcon imagem = new ImageIcon(telatest.class.getResource("/imagem/frangLogo.png"));
		Image img =  imagem.getImage().getScaledInstance(foto1.getWidth(), foto1.getHeight(), Image.SCALE_DEFAULT);
		foto1.setIcon(new ImageIcon (img));
	}
}
