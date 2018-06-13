package kanker.DataProcessing.P2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public interface OVDao {
	public ArrayList<OVKaart> findKaartById(Reiziger reiziger);

}
