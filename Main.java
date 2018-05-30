package kanker.DataProcessing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
	public static void main(String[] arg) throws SQLException { 
		
	ReizigerOracleDaolmpl x = new ReizigerOracleDaolmpl();
	Reiziger R1 = new Reiziger("Dollee", Date.valueOf(LocalDate.of(2000,10,15)), "RD", "D", 6);
	Reiziger Adolf = new Reiziger("Hitler", Date.valueOf(LocalDate.of(1889,04,20)), "AH", "H", 7);
//	x.save(Adolfs);
//	x.save(R1);
	System.out.println(Adolf);
	x.delete(R1);
	System.out.println(R1);
	
	System.out.println("entering findall");
	List<Reiziger> reizigers = x.findall();
	System.out.println(reizigers);
	for(Reiziger r : reizigers) {
		System.out.println(r.getOVKaarten());
		
	}
	
	
	}
	

}