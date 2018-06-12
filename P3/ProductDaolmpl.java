package kanker.DataProcessing.P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDaolmpl extends OracleBaseDao implements ProductDao{
	public ProductDaolmpl() throws SQLException {
		getConnection();
	}
	
	ReizigerOracleDaolmpl reiziger = new ReizigerOracleDaolmpl();
	OVOracleDaolmpl ov = new OVOracleDaolmpl();
	
	@Override
	public ArrayList<Product> getOvProduct(int kaartid) {
		ArrayList<Product> lijst = new ArrayList<Product>();
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT p.* FROM PRODUCT p, OV_CHIPKAART_PRODUCT o WHERE o.KAARTNUMMER = ? and p.productnummer = o.PRODUCTNUMMER");
		     ps.setInt(1, kaartid);
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()) {
					lijst.add(new Product(rs.getInt("PRODUCTNUMMER"), rs.getString("PRODUCTNAAM"), rs.getString("BESCHRIJVING"), rs.getDouble("PRIJS"), ov.getOvKaart(rs.getInt("PRODUCTNUMMER"))));
		     }
		     rs.close();
		     stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
		
	}

}
