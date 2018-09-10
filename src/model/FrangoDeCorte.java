package model;

public class FrangoDeCorte {
	private double idadeAve;
	private double temperaturaDoAr;
	private double umidadeRelativa;
	private double CR;
	private double CA;
	private double GP;
	public double getIdadeAve() {
		return idadeAve;
	}
	public void setIdadeAve(double idadeAve) {
		this.idadeAve = idadeAve;
	}
	public double getTemperaturaDoAr() {
		return temperaturaDoAr;
	}
	public void setTemperaturaDoAr(double temperaturaDoAr) {
		this.temperaturaDoAr = temperaturaDoAr;
	}
	public double getUmidadeRelativa() {
		return umidadeRelativa;
	}
	public void setUmidadeRelativa(double umidadeRelativa) {
		this.umidadeRelativa = umidadeRelativa;
	}
	public double getCR() {
		return CR;
	}
	public void setCR(double cR) {
		CR = cR;
	}
	public double getCA() {
		return CA;
	}
	public void setCA(double cA) {
		CA = cA;
	}
	public double getGP() {
		return GP;
	}
	public void setGP(double gP) {
		GP = gP;
	}
	public FrangoDeCorte(double idadeAve, double temperaturaDoAr, double umidadeRelativa) {
		super();
		this.idadeAve = idadeAve;
		this.temperaturaDoAr = temperaturaDoAr;
		this.umidadeRelativa = umidadeRelativa;
		CR = 0;
		CA = 0;
		GP = 0;
	}
	public FrangoDeCorte() {

	}
	
	
}
