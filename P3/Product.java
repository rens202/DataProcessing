package kanker.DataProcessing.P3;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<OVKaart> kaarten;
	
	public Product(int pn, String pna, String besch, double pr) {
		productNummer = pn;
		productNaam = pna;
		beschrijving = besch;
		prijs = pr;
	}
	
	public Product(int pn, String pna, String besch, double pr, ArrayList<OVKaart> ovka) {
		productNummer = pn;
		productNaam = pna;
		beschrijving = besch;
		prijs = pr;
		kaarten = ovka;
	}
	
	@Override
	public String toString() {
		String s =  "\n\nProduct: \n"
				+ "productNummer: " + productNummer 
				+ ", productNaam: " + productNaam 
				+ ", beschrijving: "+ beschrijving 
				+ ", prijs: "+ prijs;
		if(kaarten != null) {
		for(OVKaart item : kaarten) {
			s += item.toString2();
			s += "\n";
		}}else {
			s += " GEEN GEKOPPELDE KAARTEN \n" ;
		}
		return s;
	}
	
	public String toString2() {
		String s =  "\n\nProduct: \n"
				+ "productNummer: " + productNummer 
				+ ", productNaam: " + productNaam 
				+ ", beschrijving: "+ beschrijving 
				+ ", prijs: "+ prijs;
		return s;
	}

	public int getProductNummer() {
		return productNummer;
	}
	
	public void setOVKaarten(ArrayList<OVKaart>ovkaart) {
		kaarten = ovkaart;
	}
	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}
	public String getProductNaam() {
		return productNaam;
	}
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

}
