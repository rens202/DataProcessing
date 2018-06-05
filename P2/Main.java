package kanker.DataProcessing.P2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
	public static void main(String[] arg) throws SQLException { 
		
	ReizigerOracleDaolmpl x = new ReizigerOracleDaolmpl();	
	System.out.println("entering findall");
	List<Reiziger> reizigers = x.findall();
	System.out.println(reizigers);
	for(Reiziger r : reizigers) {
		System.out.println(r.getOVKaarten());
		
	}
/*	Reiziger r1 = new Reiziger(55, "RD", "", "Dollee", Date.valueOf(LocalDate.of(2000, 10, 15)));
	x.save(r1);*/
	
	Reiziger r2 = new Reiziger(55, "RD", "De", "Dollee", Date.valueOf(LocalDate.of(2000, 10, 15)));
	x.update(r2);
	
	x.findbygbd(Date.valueOf(LocalDate.of(2000, 10, 15)));
	
	x.delete(r2);
	
	
	}

	

}