package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaArtigo1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaArtigo1 frame = new TelaArtigo1();
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
	public TelaArtigo1() {
		setTitle("Informações Sobre o Artigo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel foto1 = new JLabel("");
		foto1.setBounds(191, 13, 229, 227);
		contentPane.add(foto1);
		
		ImageIcon imagem = new ImageIcon(telatest.class.getResource("/imagem/qrcode.jpg"));
		Image img =  imagem.getImage().getScaledInstance(foto1.getWidth(), foto1.getHeight(), Image.SCALE_DEFAULT);
		foto1.setIcon(new ImageIcon (img));
		
		JLabel lblArtigoDisponvelEm = new JLabel("Artigo dispon\u00EDvel em:");
		lblArtigoDisponvelEm.setBounds(12, 105, 141, 16);
		contentPane.add(lblArtigoDisponvelEm);
		
		JLabel foto2 = new JLabel("");
		foto2.setBounds(44, 134, 59, 57);
		contentPane.add(foto2);
		
		ImageIcon imagem1 = new ImageIcon(telatest.class.getResource("/imagem/qricon.png"));
		Image img1 =  imagem1.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon (img1));
	}

}
