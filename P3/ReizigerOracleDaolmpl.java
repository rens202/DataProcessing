package kanker.DataProcessing.P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.List;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao{
	public ReizigerOracleDaolmpl() throws SQLException {
		getConnection();
	}
	
	public List<Reiziger> findall(){
		ArrayList<Reiziger> lijst = new ArrayList<Reiziger>();
		Reiziger reis = null;
		
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from REIZIGER");
			
			while (rs.next()) {
				reis = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), 
						rs.getString("ACHTERNAAM"), 
						rs.getDate("GEBORTEDATUM"), findKaartById(rs.getInt("REIZIGERID")));
				lijst.add(reis);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
	}
	
	public List<Reiziger> findbygbd(Date gb){
		ArrayList<Reiziger> lijst = new ArrayList<Reiziger>();
		Reiziger reis = null;
		
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("select * from REIZIGER where GEBORTEDATUM = ?");
		     ps.setDate(1, gb);
		     ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reis = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), rs.getString("TUSSENVOEGSEL"), rs.getString("ACHTERNAAM"), rs.getDate("GEBORTEDATUM"), findKaartById(rs.getInt("REIZIGERID")));
				lijst.add(reis);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
	}
	
	public ArrayList<OVKaart> findKaartById(int reizigerid){
		ArrayList<OVKaart> lijst = new ArrayList<OVKaart>();
		OVKaart kaart = null;
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = ?");
		     ps.setInt(1, reizigerid);
		     ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				kaart = new OVKaart(rs.getInt("REIZIGERID"), rs.getDate("GELDIGTOT"), rs.getInt("SALDO"), rs.getInt("KLASSE"), rs.getInt("KAARTNUMMER"), getOvProduct(rs.getInt("KAARTNUMMER")));
				//TESTING FOR VEEL OP VEEL
				lijst.add(kaart);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
	}
	
	
	public ArrayList<Product> getOvProduct(int kaartid) {
		ArrayList<Product> lijst = new ArrayList<Product>();
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT p.* FROM PRODUCT p, OV_CHIPKAART_PRODUCT o WHERE o.KAARTNUMMER = ? and p.productnummer = o.PRODUCTNUMMER");
		     ps.setInt(1, kaartid);
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()) {
					lijst.add(new Product(rs.getInt("PRODUCTNUMMER"), rs.getString("PRODUCTNAAM"), rs.getString("BESCHRIJVING"), rs.getDouble("PRIJS"), getOvKaart(rs.getInt("PRODUCTNUMMER"))));
		     }
		     rs.close();
		     stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
		
	}
	
	public ArrayList<OVKaart> getOvKaart(int productid) {
		ArrayList<OVKaart> lijst = new ArrayList<OVKaart>();
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT k.* FROM OV_CHIPKAART k, OV_CHIPKAART_PRODUCT o WHERE o.productnummer = ? and k.kaartnummer = o.kaartnummer");
		     ps.setInt(1, productid);
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()) {
					lijst.add(new OVKaart(rs.getInt("REIZIGERID"), rs.getDate("GELDIGTOT"), rs.getInt("SALDO"), rs.getInt("KLASSE"), rs.getInt("KAARTNUMMER")));
		     }
		     rs.close();
		     stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
		
	}
		
	
	@Override
	public Reiziger save(Reiziger rs) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into Reiziger values (?, ?, ?, ?, ?)");
        ps.setInt(1, rs.getReizigerID());
        ps.setString(2, rs.getVoorletters());
        ps.setString(3, rs.getTussenVoegsel());
        ps.setString(4, rs.getAchternaam());
        ps.setDate(5, rs.getgbd());
        int res = ps.executeUpdate();

        if (res == 0)
            return null;
        return rs;
    }
	
	@Override
	public boolean update(Reiziger rs) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update REIZIGER set voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? WHERE reizigerid = ?");
        ps.setString(1, rs.getVoorletters());
        ps.setString(2, rs.getTussenVoegsel());
        ps.setString(3, rs.getAchternaam());
        ps.setDate(4, rs.getgbd());
        ps.setInt(5, rs.getReizigerID());
        int res = ps.executeUpdate();

        boolean ending = true;
        if (res == 0)
            ending = false;
        return ending;
    }
	
	@Override
	public boolean delete(Reiziger rs) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from REIZIGER where REIZIGERID = ?");
        ps.setInt(1, rs.getReizigerID());
        int res = ps.executeUpdate();

        boolean ending = true;
        if (res == 0)
            ending = false;
        return ending;
    }

}
