package kanker.DataProcessing.P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OVOracleDaolmpl extends OracleBaseDao implements OVDao{
	public OVOracleDaolmpl() throws SQLException {
		getConnection();
	}
	ReizigerOracleDaolmpl reiziger = new ReizigerOracleDaolmpl();
	ProductDaolmpl product = new ProductDaolmpl();
	
	@Override
	public ArrayList<OVKaart> findKaartById(int reizigerid){
		ArrayList<OVKaart> lijst = new ArrayList<OVKaart>();
		OVKaart kaart = null;
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = ?");
		     ps.setInt(1, reizigerid);
		     ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				kaart = new OVKaart(rs.getInt("REIZIGERID"), rs.getDate("GELDIGTOT"), rs.getInt("SALDO"), rs.getInt("KLASSE"), rs.getInt("KAARTNUMMER"), product.getOvProduct(rs.getInt("KAARTNUMMER")));
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
	
	@Override
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

}
