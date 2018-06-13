package kanker.DataProcessing.P3;

import java.sql.Date;
import java.util.ArrayList;

public class OVKaart {
	private int kaartnummer;
	private Date geldigtot;
	private int saldo;
	private Reiziger reiziger;
	private int klasse;
	private ArrayList<Product> producten;
	
	
public OVKaart(Reiziger reisid, Date gt, int sl, int kl, int ktnmr) {
	kaartnummer = ktnmr;
	geldigtot = gt;
	saldo = sl;
	reiziger = reisid;
	klasse = kl;
}

public OVKaart(Reiziger reisid, Date gt, int sl, int kl, int ktnmr, ArrayList<Product> prodcu) {
	kaartnummer = ktnmr;
	geldigtot = gt;
	saldo = sl;
	reiziger = reisid;
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
			+ "	 -kaartnummer: " + kaartnummer + "\n"
			+ "	 -geldigtot " + geldigtot  + "\n"
			+ "	 -saldo: " + saldo + "\n"
			+ "	 -reizigerid: "+ reiziger.getReizigerID()  + "\n"
			+ "  -Deze OVKaart heeft de volgende producten:";
	
	for(Product item : producten) {
		s += "		\nProducten: " + item;
	}
			
	
	return s;
}


}