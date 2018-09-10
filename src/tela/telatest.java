package tela;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fuzzy.FuzzyFrangoDeCorte;
import model.FrangoDeCorte;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;

public class telatest extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTemperatura;
	private JTextField textFieldIdade;
	private JTextField textFieldUmidadeRelativaAr;
	private JLabel foto;
	private JButton btnOk;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JMenuBar menuBar;
	private JMenu mnSobre;
	private JMenuItem mntmArtigo;
	private JCheckBoxMenuItem chckbxmntmComponentes;
	private FuzzyFrangoDeCorte ffg = new FuzzyFrangoDeCorte();
	private FrangoDeCorte fdg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telatest frame = new telatest();
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

	public telatest() {
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 267);
		setTitle("Frango de Corte");
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);

		mntmArtigo = new JMenuItem("Artigo");
		mntmArtigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaArtigo1 ta = new TelaArtigo1();
				ta.setVisible(true);
			}
		});
		mnSobre.add(mntmArtigo);

		chckbxmntmComponentes = new JCheckBoxMenuItem("Componentes");
		chckbxmntmComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComponentes tc = new TelaComponentes();
				tc.setVisible(true);
			}
		});
		mnSobre.add(chckbxmntmComponentes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldTemperatura = new JTextField();
		textFieldTemperatura.setBounds(359, 84, 116, 22);
		contentPane.add(textFieldTemperatura);
		textFieldTemperatura.setColumns(10);

		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(359, 49, 116, 22);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);

		textFieldUmidadeRelativaAr = new JTextField();
		textFieldUmidadeRelativaAr.setBounds(359, 119, 116, 22);
		contentPane.add(textFieldUmidadeRelativaAr);
		textFieldUmidadeRelativaAr.setColumns(10);

		JLabel lblIdade = new JLabel("Idade (Semanas)");
		lblIdade.setBounds(196, 52, 123, 16);
		contentPane.add(lblIdade);

		JLabel lblTemperatura = new JLabel("Temperatura ï¿½C");
		lblTemperatura.setBounds(196, 87, 133, 16);
		contentPane.add(lblTemperatura);

		JLabel lblUmidadeRelativaDo = new JLabel("Umidade Relativa do Ar %");
		lblUmidadeRelativaDo.setBounds(196, 122, 151, 16);
		contentPane.add(lblUmidadeRelativaDo);

		foto = new JLabel("");
		foto.setBounds(12, -32, 158, 224);
		contentPane.add(foto);

		ImageIcon imagem = new ImageIcon(telatest.class.getResource("/imagem/frang1.png"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);

		foto.setIcon(new ImageIcon(img));

		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textFieldIdade.getText().equals("") || textFieldTemperatura.getText().equals("")
						|| textFieldUmidadeRelativaAr.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha os Campos");
				} else {
					double idade = Double.valueOf(textFieldIdade.getText());
					double temperatura = Double.valueOf(textFieldTemperatura.getText());
					double umidade = Double.valueOf(textFieldUmidadeRelativaAr.getText());
					if(idade>=1 && idade<=21 && temperatura>=23 && temperatura<=35 &&
							umidade>=30 && umidade<=90){

						defuzz();
						double s[] = new double[3];
						s = ffg.getSaidas();/*exibe apenas os valores defuzzificados*/ 

						/*
						 * precisei fazer isso para diminuir as casas decimais que
						 * estavam muito grandes
						 */
						String s0 = String.format("Consumo Racao: %.2f", s[0]);
						String s1 = String.format("Conversao Alimentar: %.1f", s[1]);
						String s2 = String.format("Ganho de Peso: %.2f", s[2]);

						JOptionPane.showMessageDialog(null, s0 + " g" +" - "+ffg.rotuloCA()+"\n"
						+ s1 + " g"+ " - "+ ffg.rotuloCR() +"\n"
						+ s2 + " g g-1"+" - "+ ffg.rotuloGP() +"\n");

					}else{
						JOptionPane.showMessageDialog(null, "Por favor informe valores dentro das faixas validas");
					}
				}
			}
		});
		btnOk.setBounds(503, 46, 90, 25);
		contentPane.add(btnOk);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* limpa os campos */
				textFieldIdade.setText("");
				textFieldTemperatura.setText("");
				textFieldUmidadeRelativaAr.setText("");
			}
		});
		btnLimpar.setBounds(503, 116, 90, 25);
		contentPane.add(btnLimpar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//
			}
		});
		btnCancelar.setBounds(503, 81, 90, 25);
		contentPane.add(btnCancelar);

		JButton buttonGerarRelatorio = new JButton("Gerar Relatorio");
		buttonGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textFieldIdade.getText().equals("") || textFieldTemperatura.getText().equals("")
						|| textFieldUmidadeRelativaAr.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha os campos para gerar relatï¿½rio");
					
				}else{
					Document doc = new Document();
					String aquivoPDF = "relatorioGeral.pdf";

					try {
						Font f = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
						Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
						Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 13);
						PdfWriter.getInstance(doc, new FileOutputStream(aquivoPDF));
						doc.open();
						
						Paragraph p = new Paragraph("Universidade Federal do Rio Grande do Norte\n"
								+ "Escola Agrícola de Jundiaí\n"
								+ "Tecnologia em Análise e Desenvolvimento de Sistemas\n"
								+ "Disciplina: Inteligência Computacional\n"
								+ "Docente: Laura Emmanuella\n"
								+ "Discentes: André Gomes, Bruno Jamelli, Tuany Mariah",f);
						p.setAlignment(Element.ALIGN_CENTER);
						doc.add(p);
						
						Paragraph p1 = new Paragraph("\nRelatório Geral", f1);
						p1.setAlignment(Element.ALIGN_CENTER);
						doc.add(p1);
						
						
						defuzz();

						double s[] = new double[3];
						s = ffg.getSaidas();
						String s0 = String.format("Consumo Racao: %.1f ", s[0]);
						String s1 = String.format("Conversao Alimentar: %.1f ", s[1]);
						String s2 = String.format("Ganho de Peso: %.1f ", s[2]);
											
						Paragraph p3 = new Paragraph("\n\n\n\tO sistema de inferência fuzzy foi desenvolvido baseado em dados "
								+ "da literatura para prediçao do consumo de ração, ganho de peso e conversão alimentar de "
								+ "frangos de corte co idade variando de 1 a 21 dias, submetidos a diferentes condições termicas."
								+ " O sistema fuzzy foi estruturado com base em três variáveis de entrada: idade das aves: "+ textFieldIdade.getText()+" semanas,"
								+ " Temperatura: "+textFieldTemperatura.getText()+"ºC"+" e Umidade Relativa: " +textFieldUmidadeRelativaAr.getText()+ "% "
								+ " as saídas consideradas foram: "+s0+"g, "+s1+"g e "+s2
								+ "g g-1. A inferência foi realizada por meio do método do Mamdani, que constituiu na elaboração de"
								+ " 45 reagras e a defuzzificação por meio do método do Centro de Gravidade.", f2);
						
						p3.setAlignment(Element.ALIGN_JUSTIFIED);
						doc.add(p3);
						
						Date dataSistema = new Date();
		                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		                sdf.format(dataSistema);

		                Paragraph p4 = new Paragraph("\n\n\n\n\n\n\n\n Macaï¿½ba, " + sdf.format(dataSistema), f2);
		                p4.setAlignment(Element.ALIGN_CENTER);
						doc.add(p4);
						
						
						doc.close();
						Desktop.getDesktop().open(new File(aquivoPDF));

					} catch (Exception e) {
						System.out.println("Deu Ruim" + e);
						JOptionPane.showConfirmDialog(null, "Deu Ruim" + e);
					}
				}

			}
		});
		buttonGerarRelatorio.setBounds(489, 154, 123, 25);
		contentPane.add(buttonGerarRelatorio);

	}
	public void defuzz(){
	
		fdg = new FrangoDeCorte(Double.parseDouble(textFieldIdade.getText()),
				Double.parseDouble(textFieldTemperatura.getText()),
				Double.parseDouble(textFieldTemperatura.getText()));

		ffg.setEntradas(fdg);
		//ffg.graficosConjuntos(); 
	}
}
