package fuzzy;

import model.FrangoDeCorte;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyFrangoDeCorte {
	private FIS fis;
	//construtor da classe que carrega as regras para o objeto fis
	public FuzzyFrangoDeCorte(){
		try{
			fis = FIS.load("src/resource/regras.fcl", true);
		}catch(Exception e){
			System.err.println("Can't load file" + e);
		}
		
	}
	
	//altera as entradas do objeto fis
	public void setEntradas(FrangoDeCorte fdc){
		fis.setVariable("idadeAve", fdc.getIdadeAve());
        
        fis.setVariable("temperaturaDoAr", fdc.getTemperaturaDoAr());
        
        fis.setVariable("umidadeRelativaDoAr", fdc.getUmidadeRelativa());
        //chama as regras apos alterar as entradas
		fis.evaluate();
	}
	
	//retorna as saidas de maneira numerica, com [0] = cr, [1] = ca, [2] = gp
	public double[] getSaidas(){

		Variable cr = fis.getFunctionBlock("frangoDeCorte").getVariable("CR");
	    Variable ca = fis.getFunctionBlock("frangoDeCorte").getVariable("CA");
	    Variable gp = fis.getFunctionBlock("frangoDeCorte").getVariable("GP");
		
		double[] saidas = new double[3];
		saidas[0] = cr.getValue();
		saidas[1] = ca.getValue();
		saidas[2] = gp.getValue();
		return saidas;
	}
	
	public String rotuloCR(){
		
		if((getSaidas()[0] >= 80) && (getSaidas()[0] < 180)){
			return "Ruim";
		}else if((getSaidas()[0] >= 180) && (getSaidas()[0] < 380)){
			return "Mediano";
		}else if((getSaidas()[0] >= 710) && (getSaidas()[0] < 800))
			return "Bom";
		else 
			return "Muito Bom";
	}
	
	public String rotuloCA(){
		if( ( getSaidas()[1] >=0.6 ) && (getSaidas()[1]<0.8)){
			return "Ruim";
		}else if( ( getSaidas()[1] >= 0.8 ) && (getSaidas()[1]<1.25) ){
			return "Mediano";
		}else if( ( getSaidas()[1] >=1.25 ) && (getSaidas()[1]< 1.5) ){
			return "Bom";
		}else{
			return "Muito Bom";
		}
	}
	
	public String rotuloGP(){
		if( (getSaidas()[2] > 100) && (getSaidas()[2]<=200) ){
			return "Ruim";
		}else if( (getSaidas()[2] > 200) && (getSaidas()[2]<=410) ){
			return "Mediano";
		}else if( (getSaidas()[2] > 410) && (getSaidas()[2]<=520) ){
			return "Bom";
		}else {
			return "Muito bom";
		}
	}
	
	//retorna os conjuntos fuzzy modelados em forma de grafico
	public void graficosConjuntos(){
		JFuzzyChart.get().chart(fis.getFunctionBlock("frangoDeCorte"));
	}
	
	//retorna os conjuntos fuzzy de saida do sistema(grafico)
	public void graficosSaidas(){
		Variable cr = fis.getFunctionBlock("frangoDeCorte").getVariable("CR");
	    Variable ca = fis.getFunctionBlock("frangoDeCorte").getVariable("CA");
	    Variable gp = fis.getFunctionBlock("frangoDeCorte").getVariable("GP");
		JFuzzyChart.get().chart(cr, cr.getDefuzzifier(), true);
		JFuzzyChart.get().chart(ca, ca.getDefuzzifier(), true);
		JFuzzyChart.get().chart(gp, gp.getDefuzzifier(), true);
	}
	
}
