package kanker.DataProcessing.P3;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<OVKaart> kaarten = new ArrayList<OVKaart>();
	
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
	
	public void addKaarten(OVKaart ov) {
		kaarten.add(ov);
	}
	
	@Override
	public String toString() {
		String s = 
				 "		\n-productNummer: " + productNummer + "\n"
				+ "		-productNaam: " + productNaam + "\n"
				+ "		-beschrijving: "+ beschrijving + "\n"
				+ "		-prijs: "+ prijs + "\n"
				+ " 	-OVKaarten: ";
		if(kaarten == null) {
			return s;
		}else {
		for(OVKaart ov : kaarten) {
			s += "\n 	OVKaart: " + ov.toString2();
			
		}
		
		s+= "\n Dat waren alle kaarten van dit product.";}
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
