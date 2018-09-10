package tela;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fuzzy.FuzzyFrangoDeCorte;
import model.FrangoDeCorte;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAplicacao extends JFrame {

	private FuzzyFrangoDeCorte ffg = new FuzzyFrangoDeCorte();
	private FrangoDeCorte fdg;
	private JPanel contentPane;
	private JTextField textFieldIdade;
	private JTextField textFieldTemperatura;
	private JTextField textFieldUmidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAplicacao frame = new TelaAplicacao();
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
	public TelaAplicacao() {
		setResizable(false);
		setTitle("Aplicacao");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 417);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVariaveis = new JMenu("Conjuntos");
		menuBar.add(mnVariaveis);
		
		JMenuItem mntmVariaveisDeEntrada = new JMenuItem("Conjuntos");
		mntmVariaveisDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ffg.graficosConjuntos();
				
			}
		});
		mnVariaveis.add(mntmVariaveisDeEntrada);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel foto = new JLabel("");
		foto.setBounds(12, 20, 216, 291);
		contentPane.add(foto);
		
		ImageIcon imagem = new ImageIcon(telatest.class.getResource("/imagem/frang1.png"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);

		foto.setIcon(new ImageIcon(img));
		
		JLabel lblInformeAIdade = new JLabel("Informe a Idade");
		lblInformeAIdade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformeAIdade.setBounds(308, 13, 181, 16);
		contentPane.add(lblInformeAIdade);
		
		JLabel lblInformeATemperatura = new JLabel("Informe a Temperatura oC");
		lblInformeATemperatura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformeATemperatura.setBounds(308, 79, 239, 16);
		contentPane.add(lblInformeATemperatura);
		
		JLabel lblInformeAUmidade = new JLabel("Informe a Umidade %");
		lblInformeAUmidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformeAUmidade.setBounds(308, 153, 181, 16);
		contentPane.add(lblInformeAUmidade);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(309, 44, 149, 22);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		textFieldTemperatura = new JTextField();
		textFieldTemperatura.setBounds(308, 118, 149, 22);
		contentPane.add(textFieldTemperatura);
		textFieldTemperatura.setColumns(10);
		
		textFieldUmidade = new JTextField();
		textFieldUmidade.setBounds(308, 191, 145, 22);
		contentPane.add(textFieldUmidade);
		textFieldUmidade.setColumns(10);
		
		JButton btnProcessar = new JButton("Processar");
		btnProcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vazio()){
					JOptionPane.showMessageDialog(null, "Preencha os Campos");
				}else{
					if(validaConjuntos()){
						defuzz();
						JOptionPane.showMessageDialog(null, valorSaida());
					}else{
						
					}
				}
				
				
			}
		});
		btnProcessar.setBounds(295, 230, 97, 25);
		contentPane.add(btnProcessar);
		
		JButton btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vazio()){
					JOptionPane.showMessageDialog(null, "Preencha os campos para gerar relatorio");
				}else{
					if(validaConjuntos()){
						Document doc = new Document();
						String aquivoPDF = "relatorioGeral.pdf";
						try {
							PdfWriter.getInstance(doc, new FileOutputStream(aquivoPDF));
							doc.open();
							
							Paragraph p = new Paragraph("Universidade Federal do Rio Grande do Norte\n" + "Escola Agricola de Jundiaí\n"
											+ "Tecnologia em Analise e Desenvolvimento de Sistemas\n"
											+ "Disciplina: Inteligencia Computacional\n" + "Docente: Laura Emmanuella\n"
											+ "Discentes: Andre Gomes, Bruno Jamelli, Tuany Mariah", new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD));
							p.setAlignment(Element.ALIGN_CENTER);
							doc.add(p);

							Paragraph p1 = new Paragraph("\nRelatório Geral", new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN,25, Font.BOLD));
							p1.setAlignment(Element.ALIGN_CENTER);
							doc.add(p1);
							
							defuzz();
							Paragraph p3 = new Paragraph(
									"\n\n\n\tO sistema de inferencia fuzzy foi desenvolvido baseado em dados "
											+ "da literatura para predicao do consumo de racao, ganho de peso e conversao alimentar de "
											+ "frangos de corte co idade variando de 1 a 21 dias, submetidos a diferentes condicoes termicas."
											+ " O sistema fuzzy foi estruturado com base em tres variáveis de entrada: idade das aves: "
											+ textFieldIdade.getText() + " dias," + " Temperatura: "
											+ textFieldTemperatura.getText() + "oC" + " e Umidade Relativa: "
											+ textFieldUmidade.getText() + "% " + " as saidas consideradas foram: \n" +valorSaida()
											+ "A inferencia foi realizada por meio do metodo do Mamdani, que constituiu na elaboracao de"
											+ " 45 reagras e a defuzzificacao por meio do metodo do Centro de Gravidade.", new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 15));

							p3.setAlignment(Element.ALIGN_JUSTIFIED);
							doc.add(p3);
							
							Date dataSistema = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							sdf.format(dataSistema);

							Paragraph p4 = new Paragraph("\n\n\n\n\n\n\n\n Macaiba, " + sdf.format(dataSistema), new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 13));
							p4.setAlignment(Element.ALIGN_CENTER);
							doc.add(p4);

							doc.close();
							Desktop.getDesktop().open(new File(aquivoPDF));
							
						} catch (Exception e2) {
							System.out.println("Deu Ruim\n Erro: " + e2.getMessage());
							JOptionPane.showMessageDialog(null, "Deu Ruim\n Erro: " + e2.getMessage());

						}
					}
				}
				
			}
		});
		btnGerarRelatorio.setBounds(404, 230, 130, 25);
		contentPane.add(btnGerarRelatorio);
		
		JButton btnResultadosDefuzzyficados = new JButton("Resultados Defuzzyficados");
		btnResultadosDefuzzyficados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vazio()){
					JOptionPane.showMessageDialog(null, "Preencha os Campos");
				}else{
					if(validaConjuntos()){
						defuzz();
						ffg.graficosSaidas();	
					}else{
						//JOptionPane.showMessageDialog(null, "Informe os valores dentro das faixas validas");
					}
					
				}
				
			}
		});
		btnResultadosDefuzzyficados.setBounds(295, 268, 239, 25);
		contentPane.add(btnResultadosDefuzzyficados);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(295, 306, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldIdade.setText("");
				textFieldTemperatura.setText("");
				textFieldUmidade.setText("");
			}
		});
		btnLimpar.setBounds(404, 306, 130, 25);
		contentPane.add(btnLimpar);
		
		JLabel label = new JLabel("( 1 - 21 dias)");
		label.setBounds(308, 30, 84, 16);
		contentPane.add(label);
		
		JLabel lblococ = new JLabel("(23oC - 35oC)");
		lblococ.setBounds(308, 101, 120, 16);
		contentPane.add(lblococ);
		
		JLabel lblNewLabel = new JLabel("30% - 90%");
		lblNewLabel.setBounds(308, 171, 97, 16);
		contentPane.add(lblNewLabel);
	}
	
	private void defuzz(){
		
		fdg = new FrangoDeCorte(Double.parseDouble(textFieldIdade.getText()),
				Double.parseDouble(textFieldTemperatura.getText()),
				Double.parseDouble(textFieldUmidade.getText()));

		ffg.setEntradas(fdg);

	}
	
	private String valorSaida(){
		
		double s[] = new double[3];
		s = ffg.getSaidas();
		String s0 = String.format("Consumo Racao: %.2f ", s[0]);
		String s1 = String.format("Conversao Alimentar: %.2f ", s[1]);
		String s2 = String.format("Ganho de Peso: %.2f ", s[2]);
		
		String text = s0 + " g" + " - " + ffg.rotuloCA() + "\n" + s1 + " g"
				+ " - " + ffg.rotuloCR() + "\n" + s2 + " g g-1" + " - " + ffg.rotuloGP() + "\n";
		return text;
	}
	
	private boolean vazio() {
		if (textFieldIdade.getText().equals("") || textFieldTemperatura.getText().equals("")
				|| textFieldUmidade.getText().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validaConjuntos() {
		double idade = Double.valueOf(textFieldIdade.getText());
		double temperatura = Double.valueOf(textFieldTemperatura.getText());
		double umidade = Double.valueOf(textFieldUmidade.getText());
		if (idade >= 1 && idade <= 21 && temperatura >= 23 && temperatura <= 35 && umidade >= 30 && umidade <= 90) {
			System.out.println("valido");
			return true;
		} else {
			System.out.println("invalido");
			JOptionPane.showMessageDialog(null, "Por favor informe valores dentro das faixas validas");
			return false;

		}
	}
	
}
