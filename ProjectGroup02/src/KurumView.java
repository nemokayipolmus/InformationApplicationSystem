import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KurumView implements ViewInterface {
	
	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);
		case "select1" : return selectOperation1(modelData);
		case "select2" : return selectOperation2(modelData);
		case "select4" : return selectOperation4(modelData);
		case "select5" : return selectOperation5(modelData);
		case "update": return updateOperation(modelData);		
		case "select.gui": return selectGUI(modelData);
		case "select1.gui": return select1GUI(modelData);
		case "select2.gui": return select2GUI(modelData);
		case "select4.gui": return select4GUI(modelData);
		case "select5.gui": return select5GUI(modelData);
		case "update.gui": return updateGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun kendisine yapýlan tüm baþvurularý görebilmesini saðlayan select'in operation'ý
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				
				String cevapAciklama=resultSet.getString("CevapAçýklama");
				String kurumAdi=resultSet.getString("KurumAdý");
				int basvuruNo = resultSet.getInt("BasvuruNo");
				Date basvuruTarihi= resultSet.getDate("BasvuruTarihi");
				String basvuruDurumuAciklama = resultSet.getString("BasvuruDurumuAçýklama");
				String cevaplamaTipiAciklama = resultSet.getString("CevaplamaTipiAçýklama");
				String basvuruTipiAciklama = resultSet.getString("BasvuruTipiAçýklama");
				String kurumTipiAciklama = resultSet.getString("KurumTipiAçýklama");
				
				
				System.out.println("\nKurum Adý: " + kurumAdi + "\t");
				System.out.println("Kurum Tipi: " + kurumTipiAciklama + "\t");
				System.out.println("Baþvuru No: " + basvuruNo + "\t");
				System.out.println("Baþvuru Tarihi: " + basvuruTarihi + "\t");
				System.out.println("Baþvuru Tipi: " + basvuruTipiAciklama + "\t");
				System.out.println("Baþvuru Durumu: " + basvuruDurumuAciklama + "\t");
				System.out.println("Cevaplama Tipi: " + cevaplamaTipiAciklama + "\t");
				System.out.println("Cevap Açýklama: " + cevapAciklama + "\t");
				
					
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun kendisine yapýlan tüm baþvurularýn istatistiklerini görmesini saðlayan select1'in operation'ý
	
	ViewData selectOperation1(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		int redSayisi = 0;
		
		int basvuruSayisi = 0;
		
		int itirazSayisi = 0;
		
		int cikarilmisKabul = 0;
		
		int olumluBasvuru = 0;
		
		if (resultSet != null) {
		while (resultSet.next()) {
		
		 if(resultSet.getInt("CevapTurNo")>1 && resultSet.getInt("CevapTurNo")!=17)
		 {
			 redSayisi++;
		 }
		 
		 
		 if(resultSet.getInt("CevapTurNo")== 15 || resultSet.getInt("CevapTurNo") ==16)
		 {
			 itirazSayisi++;
		 }
		 
		 
		 if( resultSet.getInt("CevapTurNo")==17)
		 {
			 cikarilmisKabul++;
		 }
		 
		 if( resultSet.getInt("CevapTurNo")==0)
		 {
			 olumluBasvuru++;
		 }
		 basvuruSayisi++;
		 

		}
		
		System.out.println("Toplam Baþvuru Sayýsý: " + basvuruSayisi + "\t");
		
		System.out.println("Toplam Red Sayýsý: " + redSayisi + "\t");
		
		System.out.println("Toplam Itiraz Sayýsý: " + itirazSayisi + "\t");
		
		System.out.println("Olumlu Baþvuru Sayýsý: " + olumluBasvuru + "\t");
		
		System.out.println("Sýr Niteliðindeki Belgeler Çýkartýlarak Cevap Verilmiþ Toplam Baþvuru Sayýsý: " + cikarilmisKabul + "\t");
		resultSet.close();
		}
		return new ViewData("MainMenu", "");
		}
	
	//Kurumun tüm personellerinin bilgilerini görmesini saðlayan select2'nin operation'ý
	ViewData selectOperation2(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int personelID = resultSet.getInt("PersonelID");
				
				String ad = resultSet.getString("Ad");
				
				String soyad = resultSet.getString("Soyad");
				
				String gorevAciklama = resultSet.getString("GorevAçýklama");
				
				String kullaniciYetkiAciklama = resultSet.getString("KullanýcýYetkiAçýklama");
				
				System.out.println("\nPersonel ID: " + personelID + "\t");
				System.out.println("Ad: " + ad + "\t");
				System.out.println("Soyad: " + soyad + "\t");
				System.out.println("Görev Açýklama: " + gorevAciklama + "\t");
				System.out.println("Kullanýcý Yetki Açýklama: " + kullaniciYetkiAciklama + "\t");
				
				
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun bekleyen baþvurularý görmesini saðlayan select4'ün operation'ý
	ViewData selectOperation4(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				
				int basvuruNo = resultSet.getInt("BasvuruNo");
				Date basvuruTarihi= resultSet.getDate("BasvuruTarihi");
				Date sonBasvuruTarihi= resultSet.getDate("SonBasvuruTarihi");
				
				
				System.out.println("Baþvuru No: " + basvuruNo + "\t");
				System.out.println("Baþvuru Tarihi: " + basvuruTarihi + "\t");
				System.out.println("Son Baþvuru Tarihi: " + sonBasvuruTarihi + "\t");
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun baþvuru cevaplarýna yapýlan itirazlarýn sonuçlarýný görmesini saðlayan select'in operation'ý
	ViewData selectOperation5(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				
				int basvuruNo = resultSet.getInt("BasvuruNo");
				String cevapAciklama = resultSet.getString("CevapAçýklama");
				
				
				System.out.println("Baþvuru No: " + basvuruNo + "\t");
				System.out.println("Cevap Açýklama: " + cevapAciklama + "\t");
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	
	//Kurumun yapýlan baþvurulara cevap vermesini saðlayan update'in operation'ý
	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Cevap baþarýyla gönderilmiþtir.");
		
		return new ViewData("MainMenu", "");
	}
	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Seçimleri filtrele");
		System.out.println("------------------\n");
		Integer basvuruNo = getInteger("Baþvuru No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (basvuruNo != null) whereParameters.put("Basvuru.BasvuruNo",basvuruNo);

		return whereParameters;
	}
	
	//Kurumun verilere Kurum No aracýlýðýyla eriþmesini saðlayan ve select, select1 ve select4'te kullanýlan WHERE koþulu
	
	Map<String, Object> getWhereParameters1() throws Exception {
		System.out.println("Seçimleri filtrele");
		System.out.println("------------------\n");
		Integer kurumNo = getInteger("Kurum No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (kurumNo != null) whereParameters.put("K.KurumNo",kurumNo);

		return whereParameters;
	}
	
	//Kurumun verileri Kurum No aracýlýðýyla deðiþtirmesini saðlayan ve update'te kullanýlan WHERE koþulu
	Map<String, Object> getWhereParameters4() throws Exception {
		System.out.println("Seçimleri filtrele");
		System.out.println("------------------\n");
		Integer kurumNo= getInteger("Kurum No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		whereParameters.put("CT.CevapTurNo",1);
		if (kurumNo != null) whereParameters.put("K.KurumNo",kurumNo);
		return whereParameters;
	}
	
	//Kurumun itiraz edilen baþvurularýn sonuçlarýný Kurum No aracýlýðýyla görmesini saðlayan WHERE koþulu
	Map<String, Object> getWhereParameters6() throws Exception {
		System.out.println("Seçimleri filtrele");
		System.out.println("------------------\n");
		Integer kurumNo = getInteger("Kurum No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (kurumNo != null) whereParameters.put("K.KurumNo",kurumNo);

		whereParameters.put("CT.CevapTurNo",15);
		
		
		return whereParameters;
	}
	
	//Kurumun kendisine yapýlan tüm baþvurularý görüntüleyebilmesini saðlayan ekran
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters1());
		
		return new ViewData("Kurum", "select", parameters);
	}

	//Kurumun istatistikleri görüntüleyebilmesini saðlayan ekran
	ViewData select1GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters1());
		
		return new ViewData("Kurum", "select1", parameters);
	}
	
	//Kurumun çalýþan personellerini görüntüleyebilmesini saðlayan ekran
	ViewData select2GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters1());
		
		return new ViewData("Kurum", "select2", parameters);
	}
	
	//Kurumun bekleyen baþvurularý en önce cevaplanmasý gerekenden baþlayarak görüntüleyebilmesini saðlayan ekran
	ViewData select4GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters4());
		
		return new ViewData("Kurum", "select4", parameters);
	}
	
	//Kurumun yapýlan itirazlarýn sonuçlarýný görüntüleyebilmesini saðlayan ekran
	ViewData select5GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters6());
		
		return new ViewData("Kurum", "select5", parameters);
	}
	
	
	//Kurumun baþvurulara cevap verebilmesini saðlayan ekran
	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Cevabý oluþturmak için aþaðýdaki bilgileri eksiksiz doldurunuz:");
	
		System.out.println();
		String cevapAciklama = getString("Cevap Açýklama: ", true);
		Integer cevapTurNo = getInteger("Cevap Tür No: ", true);
		Map<String, Object> updateParameters = new HashMap<>();
	
		if (cevapTurNo != 0) updateParameters.put("CevapTurNo", cevapTurNo);
		if (cevapAciklama != null) updateParameters.put("CevapAçýklama",cevapAciklama );
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Basvuru", "update", parameters);
	}
	
}
