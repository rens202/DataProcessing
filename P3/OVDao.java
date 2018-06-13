package kanker.DataProcessing.P3;

import java.util.ArrayList;

public interface OVDao {
	
	public ArrayList<OVKaart> findKaartById(Reiziger reiziger);
	public ArrayList<Product> getOvProduct(OVKaart ov);

}
