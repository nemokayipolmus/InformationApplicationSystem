import java.util.*;


public class ModelViewControllerConsole {

	public static void main(String[] args) throws Exception {
		// Connect to database
		connectToDatabase();

		
		// Model View Controller (MVC)
		// Router knows all the controllers
		Map<String, Controller> router = new HashMap<>();		
		router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
		router.put("Basvuran", new Controller(new BasvuranView(), new BasvuranModel()));
		router.put("Basvuru", new Controller(new BasvuruView(), new BasvuruModel()));
		router.put("Kurum", new Controller(new KurumView(), new KurumModel()));
		router.put("BasvuruKurumYonlendirme", new Controller(new BasvuruKurumYonlendirmeView(), new BasvuruKurumYonlendirmeModel()));
		router.put("BasvuruBilgiBelge", new Controller(new BasvuruBilgiBelgeView(), new BasvuruBilgiBelgeModel()));

		ViewData viewData = new ViewData("MainMenu", "");	
		do {
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);
			ModelData modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println();
		}
		while (viewData.functionName != null);
		
		System.out.println();
		System.out.println();
		System.out.println("Program is ended...");


		// Disconnect from database
		disconnectFromDatabase();
	}

	
	public static void connectToDatabase() {
		DatabaseUtilities.host = "localhost:49670";
		DatabaseUtilities.databaseName = "Group_2";
		
		try {
			DatabaseUtilities.getConnection();
		}
		catch(Exception e) {
			System.out.println("Exception occured : " + e);
			return;
		}		
	}
	
	public static void disconnectFromDatabase() {
		try {
			DatabaseUtilities.disconnect();
		}
		catch(Exception e) {
			System.out.println("Error disconnecting from database : " + e);
			return;
		}		
	}
	
}
