package fuzzy;

import model.FrangoDeCorte;

public class TesteFrango {
	public static void main(String args[]){
		FrangoDeCorte f = new FrangoDeCorte();
		f.setIdadeAve(5);
		f.setTemperaturaDoAr(28.91);
		f.setUmidadeRelativa(78);
		FuzzyFrangoDeCorte fz = new FuzzyFrangoDeCorte();
		fz.setEntradas(f);
		//fz.graficosConjuntos();
		double s[] = new double[3];
		s = fz.getSaidas();
		
		System.out.println("Consumo de Racao "+s[0]+" - "+fz.rotuloCR() 
		 +"\nConversao alimentar "+s[1]+" - "+fz.rotuloCA()
		+"\nGanho de peso "+s[2]+" - "+fz.rotuloGP());
		
      }
}