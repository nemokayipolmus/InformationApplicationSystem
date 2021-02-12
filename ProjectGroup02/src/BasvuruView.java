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
	
	//Ba�vuruModel'deki kullan�c�n�n t�m ba�vurular�n� getiren select i�in kullan�lan operation
	
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
				String cevapAciklama = resultSet.getString("CevapA��klama");
				int cevapTurNo = resultSet.getInt("CevapTurNo");
				
				// Display values
				System.out.println("\nKimlik No: " +kimlikNo + "\t");
				System.out.println("Ba�vuru No: " +basvuruNo + "\t");
				System.out.println("Ba�vuru Tarihi: " +basvuruTarihi+ "\t");
				System.out.println("Ba�vuru Tipi No: " +basvuruTipiNo+ "\t");
				System.out.println("Ba�vuru Durumu No: " +basvuruDurumuNo+ "\t");
				System.out.println("Cevaplama Tipi No: " +cevaplamaTipiNo + "\t");
				System.out.println("Cevap A��klama: " +cevapAciklama + "\t");
				System.out.println("Cevap T�r No: " +cevapTurNo+ "\t");
				
				
				
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//Ba�vuruModel'deki kullan�c�n�n ba�vuru durumunu getiren select3 i�in kullan�lan operation
	
	ViewData selectOperation3(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				String basvuruAciklama = resultSet.getString("BasvuruDurumuA��klama");;
				
				// Display values
				System.out.println("\nBa�vurunun Durumu: " + basvuruAciklama + "\t");
				
				
				
				
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//Ba�vuruModel'deki yeni ba�vuru i�in kullan�lan insert'�n operation'�
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Ba�vurunuz eklenmi�tir. Ba�vuraca��n�z kurumu se�mek i�in l�tfen Kullan�c� Men�s�ne geri d�n�n�z.");
		
		return new ViewData("MainMenu", "");
	}

	//Kullan�c�n�n t�m ba�vurular�n� kimlik no'su arac�l���yla g�rmesini sa�layan WHERE ko�ulu
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Se�imleri Filtrele");
		System.out.println("------------------\n");
		Integer kimlikNo = getInteger("Kimlik No : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (kimlikNo != null) whereParameters.put("KimlikNo", kimlikNo);

		return whereParameters;
	}
	
	//Kullan�c�n�n ba�vuru durumunu ba�vuru no'su ve soyad� arac�l���yla g�rmesini sa�layan WHERE ko�ulu
	Map<String, Object> getWhereParameters3() throws Exception {
		System.out.println("Se�imleri Filtrele");
		System.out.println("------------------\n");
		Integer basvuruNo = getInteger("Ba�vuru No : ", true);
		String soyad = getString("Soyad: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (basvuruNo != null) whereParameters.put("BasvuruNo", basvuruNo);
		if (soyad != null) whereParameters.put("Soyad", soyad);
		
		return whereParameters;
	}
	
	//Kullan�c�n�n t�m ba�vurular�n� g�r�nt�leyebilmesi i�in ��kan ekran
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		
		return new ViewData("Basvuru", "select", parameters);
	}
	
	//Ba�vuru no'su girilen ba�vurunun durumunun g�r�nt�lenebilmesi i�in ��kan ekran
	ViewData select3GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters3());
		
		
		return new ViewData("Basvuru", "select3", parameters);
	}
	
	//Yeni ba�vurunun yap�labilmesi i�in ��kan ekran
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "KimlikNo, BasvuruTipiNo, BasvuruDurumuNo, CevaplamaTipiNo, CevapA��klama, CevapTurNo");

		List<Object> rows = new ArrayList<>();
		
		int kimlikNo, basvuruTipiNo, basvuruDurumuNo, cevaplamaTipiNo, cevapTurNo;
		String cevapAciklama;
		
		
			System.out.println("Ba�vurunuzu olu�turmak i�in l�tfen a�a��daki bilgileri eksiksiz doldurunuz:\n");
			kimlikNo = getInteger("Kimlik No: ",true);
			basvuruTipiNo = getInteger("Ba�vuru Tipi No: ", true);
			basvuruDurumuNo = 1;
			cevaplamaTipiNo = getInteger("Cevaplama Tipi No: ", true);
			cevapTurNo = 1;
			
			System.out.println();
			
			//Kullan�c�dan al�nan bilgilerle Basvuru class'�ndan yeni bir obje olu�turulmas�
			rows.add(new Basvuru(kimlikNo, basvuruTipiNo, basvuruDurumuNo, cevaplamaTipiNo, cevapTurNo));
			
		
		parameters.put("rows", rows);
	
		
		return new ViewData("Basvuru", "insert", parameters);
	}
	

}
