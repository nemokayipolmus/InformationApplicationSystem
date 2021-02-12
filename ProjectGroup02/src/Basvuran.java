
class Basvuran {

	private int kimlikNo;
	private String ad;
	private String soyad;
	private String cinsiyet;
	private int telefonNo;
	private String adres;
	private String eposta;
	private String fax;
	private boolean turkVatandasiMi;
	private boolean tuzelKisiMi;
	private String tuzelKisiUnvani;
	
		
	
	Basvuran(){
	
	}
    
	
	Basvuran(int kimlikNo, String ad, String soyad, String cinsiyet, int telefonNo, String adres,
			String eposta, String fax, boolean turkVatandasiMi, boolean tuzelKisiMi, String tuzelKisiUnvani) {
		this.kimlikNo = kimlikNo;
		this.ad = ad;
		this.soyad = soyad;
		this.cinsiyet = cinsiyet;
		this.telefonNo = telefonNo;
		this.adres = adres;
		this.eposta = eposta;
		this.fax = fax;
		this.turkVatandasiMi = turkVatandasiMi;
		this.tuzelKisiMi = tuzelKisiMi;
		this.tuzelKisiUnvani = tuzelKisiUnvani;
	}

	
	public int getKimlikNo() {
		return kimlikNo;
	}





	public void setKimlikNo(int kimlikNo) {
		this.kimlikNo = kimlikNo;
	}





	public String getAd() {
		return ad;
	}





	public void setAd(String ad) {
		this.ad = ad;
	}





	public String getSoyad() {
		return soyad;
	}





	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}





	public String getCinsiyet() {
		return cinsiyet;
	}





	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}





	public int getTelefonNo() {
		return telefonNo;
	}





	public void setTelefonNo(int telefonNo) {
		this.telefonNo = telefonNo;
	}





	public String getAdres() {
		return adres;
	}





	public void setAdres(String adres) {
		this.adres = adres;
	}





	public String getEposta() {
		return eposta;
	}





	public void setEposta(String eposta) {
		this.eposta = eposta;
	}





	public String getFax() {
		return fax;
	}





	public void setFax(String fax) {
		this.fax = fax;
	}





	public boolean isTurkVatandasiMi() {
		return turkVatandasiMi;
	}





	public void setTurkVatandasiMi(boolean turkVatandasiMi) {
		this.turkVatandasiMi = turkVatandasiMi;
	}





	public boolean isTuzelKisiMi() {
		return tuzelKisiMi;
	}





	public void setTuzelKisiMi(boolean tuzelKisiMi) {
		this.tuzelKisiMi = tuzelKisiMi;
	}





	public String getTuzelKisiUnvani() {
		return tuzelKisiUnvani;
	}





	public void setTuzelKisiUnvani(String tuzelKisiUnvani) {
		this.tuzelKisiUnvani = tuzelKisiUnvani;
	}



	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "KimlikNo": return kimlikNo;
		case "Ad": return ad;
		case "Soyad": return soyad;
		case "Cinsiyet": return cinsiyet;
		case "TelefonNo": return telefonNo;
		case "Adres": return adres;
		case "Eposta": return eposta;
		case "Fax": return fax;
		case "TurkVatandasiMý": return Boolean.toString(turkVatandasiMi);
		case "TuzelKisiMi": return Boolean.toString(tuzelKisiMi);
		case "TuzelKisiUnvaný": return tuzelKisiUnvani;
		default: return null;
		}
	}


	
	
	
}

