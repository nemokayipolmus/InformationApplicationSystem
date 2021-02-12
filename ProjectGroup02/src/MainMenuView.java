	import java.util.*;

	class MainMenuView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

	Integer choice;

	Integer yetkiSecim;

	System.out.println("ANA MENÜ");
	System.out.println("--------\n");
	
	do {
	System.out.println("1. Kiþi");
	System.out.println("2. Kurum");
	System.out.println("3. Çýkýþ");
	choice = getInteger("Seçiminizi giriniz : ", false);
	}
	while(choice == null || choice < 1 || choice>3);
	
	if(choice==1)
	{
		System.out.println("\nKiþi Menü");
		System.out.println("---------\n");
	do {
	System.out.println("1. Daha önce kaydým yok");
	System.out.println("2. Daha önce kaydým var");
	System.out.println("3. Çýkýþ yap");
	System.out.println();
	
	 choice = getInteger("Seçiminizi giriniz : ", false);
	}
	while (choice == null || choice < 1 || choice>3);
	
	Map<String, Object> userInput = new HashMap<>();
	userInput.put("mainMenuChoice", choice);
	if(choice==1) {
	System.out.println("\nYeni Kayýt");
	
	
	operationName = "insert.gui";
	return new ViewData("Basvuran", operationName, new HashMap<>());
	}
	
	if(choice==2)
		
	System.out.println("\nKullanýcý Menü");
	System.out.println("--------------\n");	
	{
	do {
	System.out.println("\n1. Baþvurularýmý göster");
	System.out.println("2. Yeni baþvuru yap");
	System.out.println("3. Baþvuru durumumu sorgula");
	System.out.println("4. Baþvurunun gönderileceði kurumu seç");
	System.out.println("5. Çýkýþ yap");
	System.out.println();
	
	 choice = getInteger("Seçiminizi giriniz : ", false);
	}
	while (choice == null || choice < 1 || choice>5);
	
	if(choice.intValue() == 4)
	{
		System.out.println("\nKurumlarýn Kurum No'larý Hakkýnda Bilgilendirme");
		System.out.println("-----------------------------------------------\n");
		
		System.out.println("1. ÖSYM");
		System.out.println("2. AYBU");
		System.out.println("3. TEV");
		
		operationName = "insert1.gui";
		return new ViewData("BasvuruKurumYonlendirme", operationName, new HashMap<>());
	}
	
	
	else if(choice.intValue() == 2)
	{
		System.out.println("\nBaþvuru Tipi No Hakkýnda Bilgilendirme");
		System.out.println("--------------------------------------\n");
		
		System.out.println("1. Fax");
		System.out.println("2. Internet");
		System.out.println("3. E-mail");
		System.out.println("4. Yazýlý");
		System.out.println("5. Baþka Kurumdan");
		System.out.println("\n");
		
		System.out.println("Cevaplama Tipi No Hakkýnda Bilgilendirme");
		System.out.println("----------------------------------------");
		System.out.println("1. Yazýlý");
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
		
	 yetkiSecim = getInteger("Yetki numaranýzý giriniz (Menüyü görüntüleyebilmek için 1'e basýnýz): ", false);
	 
	 
	if(yetkiSecim==1){	
	System.out.println("\nKurum Menü");
	System.out.println("----------");
	do {
	System.out.println("\n1. Yapýlan baþvurularý göster");
	System.out.println("2. Cevap ver");
	System.out.println("3. Istatistikleri göster");
	System.out.println("4. Çalýþan personellerin bilgilerini göster");
	System.out.println("5. Bekleyen baþvurularý göster");
	System.out.println("6. Baþvuruyu baþka kuruma yönlendir");
	System.out.println("7. Baþvuru cevaplarýna yapýlan itirazlarýn sonuçlarý");
	System.out.println("8. Bilgi Belge");
	System.out.println();
	
	 choice = getInteger("Seçiminizi giriniz : ", false);
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