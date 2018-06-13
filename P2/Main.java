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


	
	
	}

	

}