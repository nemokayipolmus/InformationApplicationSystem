import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class BasvuranView implements ViewInterface {

	
	
	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {	
		case "insert": return insertOperation(modelData);		
		case "insert.gui": return insertGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//Ba�vuruModel'deki insert i�in kullan�lan operation
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Yeni kayd�n�z eklenmi�tir. Ba�vuru yapmak i�in l�tfen Ki�i Men�s�ne d�n�p 2'ye bas�n�z.");
		
		return new ViewData("MainMenu", "");
	}

	//Yeni ba�vurunun yap�labilmesi i�in ��kan ekran
	
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "KimlikNo, Ad, Soyad, Cinsiyet, TelefonNo, Adres, Eposta, Fax, TurkVatandasiM�, TuzelKisiMi, TuzelKisiUnvan�");

		List<Object> rows = new ArrayList<>();
		
		String cevapTuzel, cevapTurk;
		
		Integer kimlikNo, telefonNo;
		String ad, soyad, cinsiyet, adres, eposta, fax, tuzelKisiUnvani;
		Boolean turkVatandasiMi = false; 
		Boolean tuzelKisiMi = false;
		
			System.out.println("Kay�t yapmak i�in l�tfen a�a��daki bilgileri eksiksiz doldurunuz:\n");
			kimlikNo = getInteger("Kimlik No: ",true);
			ad = getString("Ad: ", true);
			soyad = getString("Soyad: ", true);
			cinsiyet = getString("Cinsiyet: ", true);
			telefonNo = getInteger("Telefon No : ", true);
			adres = getString("Adres: ", true);
			eposta = getString("Eposta: ", true);
			fax = getString("Fax: ", true);
			cevapTurk = getString("T�rk Vatanda�� M�: ", true);
			cevapTuzel = getString("T�zel Ki�i Mi: ", true);
			tuzelKisiUnvani = getString("T�zel Ki�i Unvan�: ", true);
			
			
			if(cevapTuzel=="evet")
			{
				tuzelKisiMi=true;
			}
			
			if(cevapTurk=="evet")
			{
				turkVatandasiMi=true;
			}
			
			System.out.println();
			
			
			//Kullan�c�dan al�nan bilgilerle Basvuran class'�ndan yeni bir obje olu�turulmas�
			if (kimlikNo!= 0 && ad != null && soyad != null && telefonNo != 0 && adres != null && eposta != null && (turkVatandasiMi == true || turkVatandasiMi == false ) && (tuzelKisiMi == true || tuzelKisiMi == false)) {
				rows.add(new Basvuran(kimlikNo, ad, soyad, cinsiyet, telefonNo, adres, eposta, fax, turkVatandasiMi, tuzelKisiMi, tuzelKisiUnvani));
			}
			
		
		
		
		parameters.put("rows", rows);
		
		return new ViewData("Basvuran", "insert", parameters);
	}

	
}

