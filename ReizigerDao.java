package kanker.DataProcessing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public interface ReizigerDao {
	public List<Reiziger> findbygbd(Date gb);
	public Reiziger save(Reiziger rs) throws SQLException;
	public boolean update(Reiziger rs) throws SQLException;
	public boolean delete(Reiziger rs) throws SQLException;
	

}
