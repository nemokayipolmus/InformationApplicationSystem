
public class BasvuruKurumYonlendirme {

	private int basvuruNo;
	private int kurumNo;
	
	
	public BasvuruKurumYonlendirme(int basvuruNo, int kurumNo) {
		super();
		this.basvuruNo = basvuruNo;
		this.kurumNo = kurumNo;
	}
	public int getBasvuruNo() {
		return basvuruNo;
	}
	public void setBasvuruNo(int basvuruNo) {
		this.basvuruNo = basvuruNo;
	}
	public int getKurumNo() {
		return kurumNo;
	}
	public void setKurumNo(int kurumNo) {
		this.kurumNo = kurumNo;
	}
	
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "BasvuruNo": return basvuruNo;
		case "KurumNo": return kurumNo;
		
		default: return null;
		}
	}
	
	
}

