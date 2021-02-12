
public class BasvuruBilgiBelge {

	private int basvuruNo;
	private String veri;
	private Boolean bilgiMi;
	public BasvuruBilgiBelge(int basvuruNo, String veri, Boolean bilgiMi) {
		super();
		this.basvuruNo = basvuruNo;
		this.veri = veri;
		this.bilgiMi = bilgiMi;
	}
	public int getBasvuruNo() {
		return basvuruNo;
	}
	public void setBasvuruNo(int basvuruNo) {
		this.basvuruNo = basvuruNo;
	}
	public String getVeri() {
		return veri;
	}
	public void setVeri(String veri) {
		this.veri = veri;
	}
	public Boolean getBilgiMi() {
		return bilgiMi;
	}
	public void setBilgiMi(Boolean bilgiMi) {
		this.bilgiMi = bilgiMi;
	}
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "BasvuruNo": return basvuruNo;
		case "Veri": return veri;
		case "BilgiMi" : return Boolean.toString(bilgiMi);

		default: return null;
		}
	}
	
	

}

