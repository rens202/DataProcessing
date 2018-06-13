package kanker.DataProcessing.P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDaolmpl extends OracleBaseDao implements ProductDao{
	private ArrayList<Product> alleproducten = new ArrayList<Product>();
	public ProductDaolmpl() throws SQLException {
		getConnection();
	}
	

	
	@Override
	public ArrayList<Product> getOvProduct(OVKaart kaart) {
		ArrayList<Product> lijst = new ArrayList<Product>();
		ArrayList<OVKaart> kaarten = new ArrayList<OVKaart>();
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("SELECT p.* FROM PRODUCT p, OV_CHIPKAART_PRODUCT o WHERE o.KAARTNUMMER = ? and p.productnummer = o.PRODUCTNUMMER");
		     ps.setInt(1, kaart.getKaartnummer());
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()) {
		    	if(alleproducten != null) {
		    		for(Product p : alleproducten) {
		    			if(p.getProductNummer() == rs.getInt("PRODUCTNUMMER")){
		    				p.addKaarten(kaart);
		    				lijst.add(p);
		    			}
		    		}
		    		Product product = new Product(rs.getInt("PRODUCTNUMMER"), rs.getString("PRODUCTNAAM"), rs.getString("BESCHRIJVING"), rs.getDouble("PRIJS"));
    				product.addKaarten(kaart);
    				alleproducten.add(product);
    				lijst.add(product);
		    	}
					
		     }
		     rs.close();
		     stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
		
	}

}
