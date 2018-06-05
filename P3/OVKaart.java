package kanker.DataProcessing.P3;

import java.sql.Date;
import java.util.ArrayList;

public class OVKaart {
	private int kaartnummer;
	private Date geldigtot;
	private int saldo;
	private int reizigerid;
	private int klasse;
	private ArrayList<Product> producten;
	
	
public OVKaart(int reisid, Date gt, int sl, int kl, int ktnmr) {
	kaartnummer = ktnmr;
	geldigtot = gt;
	saldo = sl;
	reizigerid = reisid;
	klasse = kl;
}

public OVKaart(int reisid, Date gt, int sl, int kl, int ktnmr, ArrayList<Product> prodcu) {
	kaartnummer = ktnmr;
	geldigtot = gt;
	saldo = sl;
	reizigerid = reisid;
	klasse = kl;
	producten = prodcu;
}

public OVKaart(int kn) {
	kaartnummer = kn;
}

public void setProducten(ArrayList<Product> product) {
	producten = product;
}

public int getKaartnummer() {
	return kaartnummer;
}

public ArrayList<Product> getProducten(){
	return producten;
}


@Override
public String toString() {
	String s = " \n\nOVKaart: \n"
			+ "kaartnummer: " + kaartnummer 
			+ ", geldigtot " + geldigtot 
			+ ", saldo: " + saldo
			+ ", reizigerid: "+ reizigerid
			+ ", klasse: " + klasse;
			if(producten != null) {
			for(Product item : producten) {
				s += item.toString2();
			}}else {s+= " GEEN GEKOPPELDE PRODUCTEN \n";}
	
	return s;
}

public String toString2() {
	String s = " \n\nOVKaart: \n"
			+ "kaartnummer: " + kaartnummer 
			+ ", geldigtot " + geldigtot 
			+ ", saldo: " + saldo
			+ ", reizigerid: "+ reizigerid
			+ ", klasse: " + klasse;
	return s;
}

}