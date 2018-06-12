package kanker.DataProcessing.P2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OVOracleDaolmpl extends OracleBaseDao implements OVDao{
	public OVOracleDaolmpl() throws SQLException {
		getConnection();
	}
	
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
				kaart = new OVKaart(rs.getInt("REIZIGERID"), rs.getDate("GELDIGTOT"), rs.getInt("SALDO"), rs.getInt("KLASSE"), rs.getInt("KAARTNUMMER"));
				lijst.add(kaart);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
	}
	
	
}
