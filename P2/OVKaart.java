package kanker.DataProcessing.P2;

import java.sql.Date;

public class OVKaart {
	private int kaartnummer;
	private Date geldigtot;
	private int saldo;
	private Reiziger reiziger;
	private int klasse;

public OVKaart(Reiziger reisid, Date gt, int sl, int kl, int ktnmr) {
	kaartnummer = ktnmr;
	geldigtot = gt;
	saldo = sl;
	reiziger = reisid;
	klasse = kl;
}

@Override
public String toString() {
	return "\nOVKaart \n kaartnummer=" + kaartnummer + "\n geldigtot=" + geldigtot + "\n saldo=" + saldo + "\n reizigerID: "
			+ reiziger.toString2();
}

}