package kanker.DataProcessing.P2;

import java.sql.Date;

public class OVKaart {
	private int kaartnummer;
	private Date geldigtot;
	private int saldo;
	private int reizigerid;
	private int klasse;

public OVKaart(int reisid, Date gt, int sl, int kl, int ktnmr) {
	kaartnummer = ktnmr;
	geldigtot = gt;
	saldo = sl;
	reizigerid = reisid;
	klasse = kl;
}

@Override
public String toString() {
	return "OVKaart [kaartnummer=" + kaartnummer + ", geldigtot=" + geldigtot + ", saldo=" + saldo + ", reizigerid="
			+ reizigerid + ", klasse=" + klasse + "]";
}

}