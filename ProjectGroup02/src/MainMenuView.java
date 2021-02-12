	import java.util.*;

	class MainMenuView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

	Integer choice;

	Integer yetkiSecim;

	System.out.println("ANA MEN�");
	System.out.println("--------\n");
	
	do {
	System.out.println("1. Ki�i");
	System.out.println("2. Kurum");
	System.out.println("3. ��k��");
	choice = getInteger("Se�iminizi giriniz : ", false);
	}
	while(choice == null || choice < 1 || choice>3);
	
	if(choice==1)
	{
		System.out.println("\nKi�i Men�");
		System.out.println("---------\n");
	do {
	System.out.println("1. Daha �nce kayd�m yok");
	System.out.println("2. Daha �nce kayd�m var");
	System.out.println("3. ��k�� yap");
	System.out.println();
	
	 choice = getInteger("Se�iminizi giriniz : ", false);
	}
	while (choice == null || choice < 1 || choice>3);
	
	Map<String, Object> userInput = new HashMap<>();
	userInput.put("mainMenuChoice", choice);
	if(choice==1) {
	System.out.println("\nYeni Kay�t");
	
	
	operationName = "insert.gui";
	return new ViewData("Basvuran", operationName, new HashMap<>());
	}
	
	if(choice==2)
		
	System.out.println("\nKullan�c� Men�");
	System.out.println("--------------\n");	
	{
	do {
	System.out.println("\n1. Ba�vurular�m� g�ster");
	System.out.println("2. Yeni ba�vuru yap");
	System.out.println("3. Ba�vuru durumumu sorgula");
	System.out.println("4. Ba�vurunun g�nderilece�i kurumu se�");
	System.out.println("5. ��k�� yap");
	System.out.println();
	
	 choice = getInteger("Se�iminizi giriniz : ", false);
	}
	while (choice == null || choice < 1 || choice>5);
	
	if(choice.intValue() == 4)
	{
		System.out.println("\nKurumlar�n Kurum No'lar� Hakk�nda Bilgilendirme");
		System.out.println("-----------------------------------------------\n");
		
		System.out.println("1. �SYM");
		System.out.println("2. AYBU");
		System.out.println("3. TEV");
		
		operationName = "insert1.gui";
		return new ViewData("BasvuruKurumYonlendirme", operationName, new HashMap<>());
	}
	
	
	else if(choice.intValue() == 2)
	{
		System.out.println("\nBa�vuru Tipi No Hakk�nda Bilgilendirme");
		System.out.println("--------------------------------------\n");
		
		System.out.println("1. Fax");
		System.out.println("2. Internet");
		System.out.println("3. E-mail");
		System.out.println("4. Yaz�l�");
		System.out.println("5. Ba�ka Kurumdan");
		System.out.println("\n");
		
		System.out.println("Cevaplama Tipi No Hakk�nda Bilgilendirme");
		System.out.println("----------------------------------------");
		System.out.println("1. Yaz�l�");
		System.out.println("2. E-posta");
		
		
		operationName = "insert.gui";
		
		return new ViewData("Basvuru", operationName, new HashMap<>());
	}
	
	switch (choice.intValue()) {
	case 1: operationName = "select.gui"; break;
	case 3: operationName = "select3.gui"; break;
	default: return new ViewData(null, null);
	}
	return new ViewData("Basvuru", operationName, new HashMap<>());
	}
	
	}
	
	else if(choice==2) {
		
	 yetkiSecim = getInteger("Yetki numaran�z� giriniz (Men�y� g�r�nt�leyebilmek i�in 1'e bas�n�z): ", false);
	 
	 
	if(yetkiSecim==1){	
	System.out.println("\nKurum Men�");
	System.out.println("----------");
	do {
	System.out.println("\n1. Yap�lan ba�vurular� g�ster");
	System.out.println("2. Cevap ver");
	System.out.println("3. Istatistikleri g�ster");
	System.out.println("4. �al��an personellerin bilgilerini g�ster");
	System.out.println("5. Bekleyen ba�vurular� g�ster");
	System.out.println("6. Ba�vuruyu ba�ka kuruma y�nlendir");
	System.out.println("7. Ba�vuru cevaplar�na yap�lan itirazlar�n sonu�lar�");
	System.out.println("8. Bilgi Belge");
	System.out.println();
	
	 choice = getInteger("Se�iminizi giriniz : ", false);
	}
	while (choice == null || choice < 1 || choice>8);
	
	
	if(choice==6) {
		operationName = "update1.gui";
		return new ViewData("BasvuruKurumYonlendirme", operationName, new HashMap<>());
	}
	else if(choice==8) {
		operationName = "insert1.gui";
		return new ViewData("BasvuruBilgiBelge", operationName, new HashMap<>());
	}
	switch (choice.intValue()) {
	case 1: operationName = "select.gui"; break;
	case 2: operationName = "update.gui"; break;
	case 3: operationName = "select1.gui"; break;
	case 4: operationName = "select2.gui"; break;
	case 5: operationName = "select4.gui"; break;
	case 7: operationName = "select5.gui"; break;
	default: return new ViewData(null, null);
	}
	
	return new ViewData("Kurum", operationName, new HashMap<>());
	}
	
	 }
	
	
	
	return new ViewData(null, null, null);
	}
	
	 @Override
	public String toString() {
	return "Main Menu View";
	}
	}