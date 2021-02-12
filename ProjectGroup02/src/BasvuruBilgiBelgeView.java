import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BasvuruBilgiBelgeView implements ViewInterface {
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		
		case "insert1": return insert1Operation(modelData); 

		case "insert1.gui": return insert1GUI(modelData);
	

		}
		
		return new ViewData("MainMenu", "");
	}
	
	//Ba�vuruBilgiBelgeModel'deki cevaba bilgi veya belge eklenebilmesi i�in gerekli olan insert'�n operation'�
	ViewData insert1Operation(ModelData modelData) throws Exception {
		System.out.println("Cevap niteli�indeki bilgi veya belgeler kullan�c�ya ba�ar�yla iletilmi�tir.");
		
		return new ViewData("MainMenu", "");
	}
	
	//Cevaba bilgi veya belge eklenebilmesi i�in ��kan ekran
	ViewData insert1GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "BasvuruNo,BilgiMi,Veri");

		List<Object> rows = new ArrayList<>();
		
		Integer basvuruNo;
		String veri;
        Boolean bilgiMi = false;
		String bilgi;
        
			System.out.println("Cevap niteli�indeki bilgi veya belgeyi kullan�c�ya iletmek i�in a�a��daki bilgileri eksiksiz doldurunuz:\n");
			basvuruNo = getInteger("Ba�vuru No: ",true);
			veri = getString("Veri: ", true);
			bilgi = getString("Bilgi Mi: ", true);

			if(bilgi=="evet")
			{
				bilgiMi=true;
			}
			
			
			System.out.println();

			
		//Kullan�c�n�n girdi�i bilgilere g�re BasvuruBilgiBelge objecti olu�turulmas�
		rows.add(new BasvuruBilgiBelge(basvuruNo, veri, bilgiMi));
		
		parameters.put("rows", rows);
		
		return new ViewData("BasvuruBilgiBelge", "insert1", parameters);
	}
}
