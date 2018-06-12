package kanker.DataProcessing.P3;

import java.util.ArrayList;

public interface OVDao {
	
	public ArrayList<OVKaart> getOvKaart(int productid);
	public ArrayList<OVKaart> findKaartById(int reizigerid);
	public ArrayList<Product> getOvProduct(int kaartid);

}
