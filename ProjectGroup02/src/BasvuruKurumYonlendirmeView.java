import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasvuruKurumYonlendirmeView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "update1": return updateOperation1(modelData);	
		case "insert1": return insertOperation1(modelData);
		case "insert1.gui": return insert1GUI(modelData);
		case "update1.gui": return update1GUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	//Kullan�c�n�n ba�vuru yapt��� kurumu girebilmesi i�in gerekli olan insert'�n operation'�
	ViewData insertOperation1(ModelData modelData) throws Exception {
		System.out.println("Ba�vurunuz se�ti�iniz kuruma y�nlendirilmi�tir. Ba�vurunuzun durumunu Kullan�c� Men�s�nden ��renebilirsiniz.");
		
		return new ViewData("MainMenu", "");
	}
	
	//Ba�vurunun se�ilen kuruma iletilebilmesi i�in ��kan ekran
	ViewData insert1GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "BasvuruNo, KurumNo");

		List<Object> rows = new ArrayList<>();
		
		int basvuruNo, kurumNo;

		
		
			System.out.println("Ba�vuraca��n�z kurumu se�mek i�in l�tfen a�a��daki bilgileri eksiksiz doldurunuz:\n");
			basvuruNo = getInteger("Ba�vuru No: ",true);
			kurumNo = getInteger("Kurum No : ", true);
			
			System.out.println();
					
			//Kullan�c�n�n girdi�i bilgilere g�re BasvuruKurumYonlendirme objectinin olu�turulmas�
			rows.add(new BasvuruKurumYonlendirme(basvuruNo, kurumNo));
		
			
		
		parameters.put("rows", rows);
	
		
		return new ViewData("BasvuruKurumYonlendirme", "insert1", parameters);
	}
	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Se�imleri filtrele");
		System.out.println("------------------\n");
		Integer basvuruNo = getInteger("Basvuru No: ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (basvuruNo != null) whereParameters.put("BasvuruNo",basvuruNo);

		return whereParameters;
	}
	
	//Ba�vurunun iletilece�i kurumun de�i�tirilebilmesi i�in ��kan ekran
	ViewData update1GUI(ModelData modelData) throws Exception {
		System.out.println("Kurumlaras� y�nlendirmenin sa�lanabilmesi i�in a�a��daki bilgileri eksiksiz doldurunuz:\n");
		
		System.out.println();
		Integer basvuruNo = getInteger("Ba�vuru No: ", true);
		Integer kurumNo = getInteger("Kurum No: ", true);
		Map<String, Object> updateParameters = new HashMap<>();
	
		if (basvuruNo != 0) updateParameters.put("BasvuruNo", basvuruNo);
		if (kurumNo != null) updateParameters.put("KurumNo",kurumNo );
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("BasvuruKurumYonlendirme", "update1", parameters);
	}
	
	//Ba�vurunun kurumlararas� iletilebilmesi i�in gerekli olan update'in operation'�
	ViewData updateOperation1(ModelData modelData) throws Exception {
		System.out.println("Kurumlararas� y�nlendirme ba�ar�yla tamamlanm��t�r.");
		
		return new ViewData("MainMenu", "");
	}

	@Override
	public String toString() {
		return " View";
	}		
}
