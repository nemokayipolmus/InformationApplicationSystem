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
	
	//BaþvuruBilgiBelgeModel'deki cevaba bilgi veya belge eklenebilmesi için gerekli olan insert'ün operation'ý
	ViewData insert1Operation(ModelData modelData) throws Exception {
		System.out.println("Cevap niteliðindeki bilgi veya belgeler kullanýcýya baþarýyla iletilmiþtir.");
		
		return new ViewData("MainMenu", "");
	}
	
	//Cevaba bilgi veya belge eklenebilmesi için çýkan ekran
	ViewData insert1GUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldname", "BasvuruNo,BilgiMi,Veri");

		List<Object> rows = new ArrayList<>();
		
		Integer basvuruNo;
		String veri;
        Boolean bilgiMi = false;
		String bilgi;
        
			System.out.println("Cevap niteliðindeki bilgi veya belgeyi kullanýcýya iletmek için aþaðýdaki bilgileri eksiksiz doldurunuz:\n");
			basvuruNo = getInteger("Baþvuru No: ",true);
			veri = getString("Veri: ", true);
			bilgi = getString("Bilgi Mi: ", true);

			if(bilgi=="evet")
			{
				bilgiMi=true;
			}
			
			
			System.out.println();

			
		//Kullanýcýnýn girdiði bilgilere göre BasvuruBilgiBelge objecti oluþturulmasý
		rows.add(new BasvuruBilgiBelge(basvuruNo, veri, bilgiMi));
		
		parameters.put("rows", rows);
		
		return new ViewData("BasvuruBilgiBelge", "insert1", parameters);
	}
}
