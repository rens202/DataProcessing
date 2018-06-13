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

	ProductDaolmpl product = new ProductDaolmpl();
	
	@Override
	public ArrayList<OVKaart> findKaartById(Reiziger reiziger){
		ArrayList<OVKaart> lijst = new ArrayList<OVKaart>();
		OVKaart kaart = null;
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = ?");
		     ps.setInt(1, reiziger.getReizigerID());
		     ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				kaart = new OVKaart(reiziger, rs.getDate("GELDIGTOT"), rs.getInt("SALDO"), rs.getInt("KLASSE"), rs.getInt("KAARTNUMMER"));
				kaart.setProducten(product.getOvProduct(kaart));
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
	public ArrayList<Product> getOvProduct(OVKaart ov) {
		ArrayList<Product> lijst = new ArrayList<Product>();
		ArrayList<OVKaart> ovs = new ArrayList<OVKaart>();
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT p.* FROM PRODUCT p, OV_CHIPKAART_PRODUCT o WHERE o.KAARTNUMMER = ? and p.productnummer = o.PRODUCTNUMMER");
		     ps.setInt(1, ov.getKaartnummer());
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()) {
		    	 Product product = new Product(rs.getInt("PRODUCTNUMMER"), rs.getString("PRODUCTNAAM"), rs.getString("BESCHRIJVING"), rs.getDouble("PRIJS"));
				ovs.add(ov);
		    	 product.setOVKaarten(ovs);
		    	 lijst.add(product);
		     }
		     rs.close();
		     stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
		
	}

}
