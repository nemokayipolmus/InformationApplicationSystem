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
	
	//Kurumun kendisine yap�lan t�m ba�vurular� g�rebilmesini sa�layan select'in operation'�
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				
				String cevapAciklama=resultSet.getString("CevapA��klama");
				String kurumAdi=resultSet.getString("KurumAd�");
				int basvuruNo = resultSet.getInt("BasvuruNo");
				Date basvuruTarihi= resultSet.getDate("BasvuruTarihi");
				String basvuruDurumuAciklama = resultSet.getString("BasvuruDurumuA��klama");
				String cevaplamaTipiAciklama = resultSet.getString("CevaplamaTipiA��klama");
				String basvuruTipiAciklama = resultSet.getString("BasvuruTipiA��klama");
				String kurumTipiAciklama = resultSet.getString("KurumTipiA��klama");
				
				
				System.out.println("\nKurum Ad�: " + kurumAdi + "\t");
				System.out.println("Kurum Tipi: " + kurumTipiAciklama + "\t");
				System.out.println("Ba�vuru No: " + basvuruNo + "\t");
				System.out.println("Ba�vuru Tarihi: " + basvuruTarihi + "\t");
				System.out.println("Ba�vuru Tipi: " + basvuruTipiAciklama + "\t");
				System.out.println("Ba�vuru Durumu: " + basvuruDurumuAciklama + "\t");
				System.out.println("Cevaplama Tipi: " + cevaplamaTipiAciklama + "\t");
				System.out.println("Cevap A��klama: " + cevapAciklama + "\t");
				
					
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun kendisine yap�lan t�m ba�vurular�n istatistiklerini g�rmesini sa�layan select1'in operation'�
	
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
		
		System.out.println("Toplam Ba�vuru Say�s�: " + basvuruSayisi + "\t");
		
		System.out.println("Toplam Red Say�s�: " + redSayisi + "\t");
		
		System.out.println("Toplam Itiraz Say�s�: " + itirazSayisi + "\t");
		
		System.out.println("Olumlu Ba�vuru Say�s�: " + olumluBasvuru + "\t");
		
		System.out.println("S�r Niteli�indeki Belgeler ��kart�larak Cevap Verilmi� Toplam Ba�vuru Say�s�: " + cikarilmisKabul + "\t");
		resultSet.close();
		}
		return new ViewData("MainMenu", "");
		}
	
	//Kurumun t�m personellerinin bilgilerini g�rmesini sa�layan select2'nin operation'�
	ViewData selectOperation2(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int personelID = resultSet.getInt("PersonelID");
				
				String ad = resultSet.getString("Ad");
				
				String soyad = resultSet.getString("Soyad");
				
				String gorevAciklama = resultSet.getString("GorevA��klama");
				
				String kullaniciYetkiAciklama = resultSet.getString("Kullan�c�YetkiA��klama");
				
				System.out.println("\nPersonel ID: " + personelID + "\t");
				System.out.println("Ad: " + ad + "\t");
				System.out.println("Soyad: " + soyad + "\t");
				System.out.println("G�rev A��klama: " + gorevAciklama + "\t");
				System.out.println("Kullan�c� Yetki A��klama: " + kullaniciYetkiAciklama + "\t");
				
				
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun bekleyen ba�vurular� g�rmesini sa�layan select4'�n operation'�
	ViewData selectOperation4(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				
				int basvuruNo = resultSet.getInt("BasvuruNo");
				Date basvuruTarihi= resultSet.getDate("BasvuruTarihi");
				Date sonBasvuruTarihi= resultSet.getDate("SonBasvuruTarihi");
				
				
				System.out.println("Ba�vuru No: " + basvuruNo + "\t");
				System.out.println("Ba�vuru Tarihi: " + basvuruTarihi + "\t");
				System.out.println("Son Ba�vuru Tarihi: " + sonBasvuruTarihi + "\t");
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	//Kurumun ba�vuru cevaplar�na yap�lan itirazlar�n sonu�lar�n� g�rmesini sa�layan select'in operation'�
	ViewData selectOperation5(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				
				int basvuruNo = resultSet.getInt("BasvuruNo");
				String cevapAciklama = resultSet.getString("CevapA��klama");
				
				
				System.out.println("Ba�vuru No: " + basvuruNo + "\t");
				System.out.println("Cevap A��klama: " + cevapAciklama + "\t");
				
		}
			
			resultSet.close();
		}
		
		
		return new ViewData("MainMenu", "");
	}
	
	
	//Kurumun yap�lan ba�vurulara cevap vermesini sa�layan update'in operation'�
	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Cevap ba�ar�yla g�nderilmi�tir.");
		
		return new ViewData("MainMenu", "");
	}
	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Se�imleri filtrele");
		System.out.println("------------------\n");
		Integer basvuruNo = getInteger("Ba�vuru No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (basvuruNo != null) whereParameters.put("Basvuru.BasvuruNo",basvuruNo);

		return whereParameters;
	}
	
	//Kurumun verilere Kurum No arac�l���yla eri�mesini sa�layan ve select, select1 ve select4'te kullan�lan WHERE ko�ulu
	
	Map<String, Object> getWhereParameters1() throws Exception {
		System.out.println("Se�imleri filtrele");
		System.out.println("------------------\n");
		Integer kurumNo = getInteger("Kurum No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (kurumNo != null) whereParameters.put("K.KurumNo",kurumNo);

		return whereParameters;
	}
	
	//Kurumun verileri Kurum No arac�l���yla de�i�tirmesini sa�layan ve update'te kullan�lan WHERE ko�ulu
	Map<String, Object> getWhereParameters4() throws Exception {
		System.out.println("Se�imleri filtrele");
		System.out.println("------------------\n");
		Integer kurumNo= getInteger("Kurum No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		whereParameters.put("CT.CevapTurNo",1);
		if (kurumNo != null) whereParameters.put("K.KurumNo",kurumNo);
		return whereParameters;
	}
	
	//Kurumun itiraz edilen ba�vurular�n sonu�lar�n� Kurum No arac�l���yla g�rmesini sa�layan WHERE ko�ulu
	Map<String, Object> getWhereParameters6() throws Exception {
		System.out.println("Se�imleri filtrele");
		System.out.println("------------------\n");
		Integer kurumNo = getInteger("Kurum No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (kurumNo != null) whereParameters.put("K.KurumNo",kurumNo);

		whereParameters.put("CT.CevapTurNo",15);
		
		
		return whereParameters;
	}
	
	//Kurumun kendisine yap�lan t�m ba�vurular� g�r�nt�leyebilmesini sa�layan ekran
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters1());
		
		return new ViewData("Kurum", "select", parameters);
	}

	//Kurumun istatistikleri g�r�nt�leyebilmesini sa�layan ekran
	ViewData select1GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters1());
		
		return new ViewData("Kurum", "select1", parameters);
	}
	
	//Kurumun �al��an personellerini g�r�nt�leyebilmesini sa�layan ekran
	ViewData select2GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters1());
		
		return new ViewData("Kurum", "select2", parameters);
	}
	
	//Kurumun bekleyen ba�vurular� en �nce cevaplanmas� gerekenden ba�layarak g�r�nt�leyebilmesini sa�layan ekran
	ViewData select4GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters4());
		
		return new ViewData("Kurum", "select4", parameters);
	}
	
	//Kurumun yap�lan itirazlar�n sonu�lar�n� g�r�nt�leyebilmesini sa�layan ekran
	ViewData select5GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters6());
		
		return new ViewData("Kurum", "select5", parameters);
	}
	
	
	//Kurumun ba�vurulara cevap verebilmesini sa�layan ekran
	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Cevab� olu�turmak i�in a�a��daki bilgileri eksiksiz doldurunuz:");
	
		System.out.println();
		String cevapAciklama = getString("Cevap A��klama: ", true);
		Integer cevapTurNo = getInteger("Cevap T�r No: ", true);
		Map<String, Object> updateParameters = new HashMap<>();
	
		if (cevapTurNo != 0) updateParameters.put("CevapTurNo", cevapTurNo);
		if (cevapAciklama != null) updateParameters.put("CevapA��klama",cevapAciklama );
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Basvuru", "update", parameters);
	}
	
}
