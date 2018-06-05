package kanker.DataProcessing.P3;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reiziger {
	private int reizigerid;
	private String voorletters;
	private String naam;
	private String achternaam;
	private Date gbdatum;
	private String tussenvoegsel;
	private ArrayList<OVKaart> ovkaarten;
	
	
	public Reiziger(int ri, String vl, String ts, String an, Date gbd, ArrayList<OVKaart> kaarten) {
		gbdatum = gbd;
		reizigerid = ri;
		voorletters = vl;
		achternaam = an;
		ovkaarten = kaarten;
		tussenvoegsel = ts;
		
	}
	
	public Reiziger(int ri, String vl, String an, Date gbd, ArrayList<OVKaart> kaarten) {
		gbdatum = gbd;
		reizigerid = ri;
		voorletters = vl;
		achternaam = an;
		ovkaarten = kaarten;
		
	}
	
	public Reiziger(int ri, String vl, String ts, String an, Date gbd) {
		gbdatum = gbd;
		reizigerid = ri;
		voorletters = vl;
		achternaam = an;
		tussenvoegsel = ts;
		
	}

	
	public Reiziger(int ri, String vl, String an, Date gbd) {
		gbdatum = gbd;
		reizigerid = ri;
		voorletters = vl;
		achternaam = an;
		
	}
	public Reiziger(String string, Date date, String string2, String string3, int i) {
		achternaam = string;
		voorletters = string3;
		tussenvoegsel = string2;
		reizigerid = i;
		gbdatum = date;
	}
	
	public ArrayList<OVKaart> getOVKaarten(){
		return ovkaarten;
	}

	
	public String getNaam() {
		return naam;
	}
	
	public int getReizigerID(){
		return reizigerid;
	}
	
	public Date getgbd() {
		return gbdatum;
	}
	
	public String getTussenVoegsel() {
		return tussenvoegsel;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	
	public void setNaam(String nm) {
		naam = nm;
		
	}
	

	public void setGBdatum(Date gbd) {
		gbdatum = gbd;
	}

	public boolean equals(Object andereObject) {
		boolean resultaat = false;
		if(andereObject instanceof Reiziger) {
			Reiziger andereReiziger = (Reiziger) andereObject;
			if(this.naam.equals(andereReiziger.naam) &&
			this.gbdatum.equals(andereReiziger.gbdatum)) {
				resultaat = true;
			}
		}
		return resultaat;
	}
	
	public String toString() {
		String s = "";
		s += naam + " is geboren op: ";
		s += gbdatum;
		return s;
	}
}
