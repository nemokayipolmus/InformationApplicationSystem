import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BasvuruView implements ViewInterface {
	
	
	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		switch(operationName) {
		case "select": return selectOperation(modelData);
		case "select3": return selectOperation3(modelData);
		case "insert": return insertOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
		case "select3.gui": return select3GUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//BaþvuruModel'deki kullanýcýnýn tüm baþvurularýný getiren select için kullanýlan operation
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int kimlikNo = resultSet.getInt("KimlikNo");
				int basvuruNo = resultSet.getInt("BasvuruNo");
				Date basvuruTarihi = resultSet.getDate("BasvuruTarihi");
				int basvuruTipiNo = resultSet.getInt("BasvuruTipiNo");
				int basvuruDurumuNo = resultSet.getInt("BasvuruDurumuNo");
				int cevaplamaTipiNo = resultSet.getInt("CevaplamaTipiNo");
				String cevapAciklama = resultSet.getString("CevapAçýklama");
				int cevapTurNo = resultSet.getInt("CevapTurNo");
				
				// Display values
				System.out.println("\nKimlik No: " +kimlikNo + "\t");
				System.out.println("Baþvuru No: " +basvuruNo + "\t");
				System.out.println("Baþvuru Tarihi: " +basvuruTarihi+ "\t");
				System.out.println("Baþvuru Tipi No: " +basvuruTipiNo+ "\t");
				System.out.println("Baþvuru Durumu No: " +basvuruDurumuNo+ "\t");
				System.out.println("Cevaplama Tipi No: " +cevaplamaTipiNo + "\t");
				System.out.println("Cevap Açýklama: " +cevapAciklama + "\t");
				System.out.println("Cevap Tür No: " +cevapTurNo+ "\t");
				
				
				
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//BaþvuruModel'deki kullanýcýnýn baþvuru durumunu getiren select3 için kullanýlan operation
	
	ViewData selectOperation3(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				String basvuruAciklama = resultSet.getString("BasvuruDurumuAçýklama");;
				
				// Display values
				System.out.println("\nBaþvurunun Durumu: " + basvuruAciklama + "\t");
				
				
				
				
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//BaþvuruModel'deki yeni baþvuru için kullanýlan insert'ün operation'ý
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Baþvurunuz eklenmiþtir. Baþvuracaðýnýz kurumu seçmek için lütfen Kullanýcý Menüsüne geri dönünüz.");
		
		return new ViewData("MainMenu", "");
	}

	//Kullanýcýnýn tüm baþvurularýný kimlik no'su aracýlýðýyla görmesini saðlayan WHERE koþulu
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Seçimleri Filtrele");
		System.out.println("------------------\n");
		Integer kimlikNo = getInteger("Kimlik No : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (kimlikNo != null) whereParameters.put("KimlikNo", kimlikNo);

		return whereParameters;
	}
	
	//Kullanýcýnýn baþvuru durumunu baþvuru no'su ve soyadý aracýlýðýyla görmesini saðlayan WHERE koþulu
	Map<String, Object> getWhereParameters3() throws Exception {
		System.out.println("Seçimleri Filtrele");
		System.out.println("------------------\n");
		Integer basvuruNo = getInteger("Baþvuru No : ", true);
		String soyad = getString("Soyad: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (basvuruNo != null) whereParameters.put("BasvuruNo", basvuruNo);
		if (soyad != null) whereParameters.put("Soyad", soyad);
		
		return whereParameters;
	}
	
	//Kullanýcýnýn tüm baþvurularýný görüntüleyebilmesi için çýkan ekran
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		
		return new ViewData("Basvuru", "select", parameters);
	}
	
	//Baþvuru no'su girilen baþvurunun durumunun görüntülenebilmesi için çýkan ekran
	ViewData select3GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters3());
		
		
		return new ViewData("Basvuru", "select3", parameters);
	}
	
	//Yeni baþvurunun yapýlabilmesi için çýkan ekran
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "KimlikNo, BasvuruTipiNo, BasvuruDurumuNo, CevaplamaTipiNo, CevapAçýklama, CevapTurNo");

		List<Object> rows = new ArrayList<>();
		
		int kimlikNo, basvuruTipiNo, basvuruDurumuNo, cevaplamaTipiNo, cevapTurNo;
		String cevapAciklama;
		
		
			System.out.println("Baþvurunuzu oluþturmak için lütfen aþaðýdaki bilgileri eksiksiz doldurunuz:\n");
			kimlikNo = getInteger("Kimlik No: ",true);
			basvuruTipiNo = getInteger("Baþvuru Tipi No: ", true);
			basvuruDurumuNo = 1;
			cevaplamaTipiNo = getInteger("Cevaplama Tipi No: ", true);
			cevapTurNo = 1;
			
			System.out.println();
			
			//Kullanýcýdan alýnan bilgilerle Basvuru class'ýndan yeni bir obje oluþturulmasý
			rows.add(new Basvuru(kimlikNo, basvuruTipiNo, basvuruDurumuNo, cevaplamaTipiNo, cevapTurNo));
			
		
		parameters.put("rows", rows);
	
		
		return new ViewData("Basvuru", "insert", parameters);
	}
	

}
