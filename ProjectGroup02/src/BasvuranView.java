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
	
	//BaþvuruModel'deki insert için kullanýlan operation
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Yeni kaydýnýz eklenmiþtir. Baþvuru yapmak için lütfen Kiþi Menüsüne dönüp 2'ye basýnýz.");
		
		return new ViewData("MainMenu", "");
	}

	//Yeni baþvurunun yapýlabilmesi için çýkan ekran
	
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "KimlikNo, Ad, Soyad, Cinsiyet, TelefonNo, Adres, Eposta, Fax, TurkVatandasiMý, TuzelKisiMi, TuzelKisiUnvaný");

		List<Object> rows = new ArrayList<>();
		
		String cevapTuzel, cevapTurk;
		
		Integer kimlikNo, telefonNo;
		String ad, soyad, cinsiyet, adres, eposta, fax, tuzelKisiUnvani;
		Boolean turkVatandasiMi = false; 
		Boolean tuzelKisiMi = false;
		
			System.out.println("Kayýt yapmak için lütfen aþaðýdaki bilgileri eksiksiz doldurunuz:\n");
			kimlikNo = getInteger("Kimlik No: ",true);
			ad = getString("Ad: ", true);
			soyad = getString("Soyad: ", true);
			cinsiyet = getString("Cinsiyet: ", true);
			telefonNo = getInteger("Telefon No : ", true);
			adres = getString("Adres: ", true);
			eposta = getString("Eposta: ", true);
			fax = getString("Fax: ", true);
			cevapTurk = getString("Türk Vatandaþý Mý: ", true);
			cevapTuzel = getString("Tüzel Kiþi Mi: ", true);
			tuzelKisiUnvani = getString("Tüzel Kiþi Unvaný: ", true);
			
			
			if(cevapTuzel=="evet")
			{
				tuzelKisiMi=true;
			}
			
			if(cevapTurk=="evet")
			{
				turkVatandasiMi=true;
			}
			
			System.out.println();
			
			
			//Kullanýcýdan alýnan bilgilerle Basvuran class'ýndan yeni bir obje oluþturulmasý
			if (kimlikNo!= 0 && ad != null && soyad != null && telefonNo != 0 && adres != null && eposta != null && (turkVatandasiMi == true || turkVatandasiMi == false ) && (tuzelKisiMi == true || tuzelKisiMi == false)) {
				rows.add(new Basvuran(kimlikNo, ad, soyad, cinsiyet, telefonNo, adres, eposta, fax, turkVatandasiMi, tuzelKisiMi, tuzelKisiUnvani));
			}
			
		
		
		
		parameters.put("rows", rows);
		
		return new ViewData("Basvuran", "insert", parameters);
	}

	
}

