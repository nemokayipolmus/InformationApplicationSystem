import java.util.Date;

public class Kurum {
	private int kimlikNo;
	private int basvuruNo;
	private Date basvuruTarihi;
	private int basvuruTipiNo;
	private int basvuruDurumuNo;
	private int cevaplamaTipiNo;
	private String cevapAciklama;
	private int cevapTurNo;
	public Kurum(int kimlikNo, int basvuruNo, Date basvuruTarihi, int basvuruTipiNo, int basvuruDurumuNo,
			int cevaplamaTipiNo, String cevapAciklama, int cevapTurNo) {
		super();
		this.kimlikNo = kimlikNo;
		this.basvuruNo = basvuruNo;
		this.basvuruTarihi = basvuruTarihi;
		this.basvuruTipiNo = basvuruTipiNo;
		this.basvuruDurumuNo = basvuruDurumuNo;
		this.cevaplamaTipiNo = cevaplamaTipiNo;
		this.cevapAciklama = cevapAciklama;
		this.cevapTurNo = cevapTurNo;
	}
	
	
	
	public Kurum() {

	}



	public int getKimlikNo() {
		return kimlikNo;
	}
	public void setKimlikNo(int kimlikNo) {
		this.kimlikNo = kimlikNo;
	}
	public int getBasvuruNo() {
		return basvuruNo;
	}
	public void setBasvuruNo(int basvuruNo) {
		this.basvuruNo = basvuruNo;
	}
	public Date getBasvuruTarihi() {
		return basvuruTarihi;
	}
	public void setBasvuruTarihi(Date basvuruTarihi) {
		this.basvuruTarihi = basvuruTarihi;
	}
	public int getBasvuruTipiNo() {
		return basvuruTipiNo;
	}
	public void setBasvuruTipiNo(int basvuruTipiNo) {
		this.basvuruTipiNo = basvuruTipiNo;
	}
	public int getBasvuruDurumuNo() {
		return basvuruDurumuNo;
	}
	public void setBasvuruDurumuNo(int basvuruDurumuNo) {
		this.basvuruDurumuNo = basvuruDurumuNo;
	}
	public int getCevaplamaTipiNo() {
		return cevaplamaTipiNo;
	}
	public void setCevaplamaTipiNo(int cevaplamaTipiNo) {
		this.cevaplamaTipiNo = cevaplamaTipiNo;
	}
	public String getCevapAciklama() {
		return cevapAciklama;
	}
	public void setCevapAciklama(String cevapAciklama) {
		this.cevapAciklama = cevapAciklama;
	}
	public int getCevapTurNo() {
		return cevapTurNo;
	}
	public void setCevapTurNo(int cevapTurNo) {
		this.cevapTurNo = cevapTurNo;
	}
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "KimlikNo": return kimlikNo;
		case "BasvuruNo": return basvuruNo;
		case "BasvuruTarihi": return basvuruTarihi;
		case "BasvuruTipiNo": return basvuruTipiNo;
		case "BasvuruDurumuNo": return basvuruDurumuNo;
		case "CevaplamaTipiNo": return cevaplamaTipiNo;
		case "CevapAciklama": return cevapAciklama;

		default: return null;
		}
	}
	@Override
	public String toString() {
		return "Kurum [kimlikNo=" + kimlikNo + ", basvuruNo=" + basvuruNo + ", basvuruTarihi=" + basvuruTarihi
				+ ", basvuruTipiNo=" + basvuruTipiNo + ", basvuruDurumuNo=" + basvuruDurumuNo + ", cevaplamaTipiNo="
				+ cevaplamaTipiNo + ", cevapAciklama=" + cevapAciklama + ", cevapTurNo=" + cevapTurNo + "]";
	}
	

}
