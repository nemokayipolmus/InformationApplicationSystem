import java.text.*;
import java.util.*;

interface ViewInterface {
	public static final Scanner scanner = new Scanner(System.in); 
	
	public default Integer getInteger(String prompt, boolean allowNulls)  throws ParseException {
		Integer inputValue;
		do {
			System.out.print(prompt);		
			String input = scanner.nextLine();
			if (allowNulls && input.trim().equals("")) {
				return null;
			}			
			if (!allowNulls && input.trim().equals("")) {
				inputValue = null;
			}			
			else {
				try {
					inputValue = Integer.parseInt(input);
				}
				catch(Exception e) {
					inputValue = null;
				}
			}
		}
		while (inputValue == null);
		
		return inputValue;
	}

	public default Double getDouble(String prompt, boolean allowNulls)  throws ParseException {
		Double inputValue;
		do {
			System.out.print(prompt);		
			String input = scanner.nextLine();
			if (allowNulls && input.trim().equals("")) {
				return null;
			}			
			if (!allowNulls && input.trim().equals("")) {
				inputValue = null;
			}			
			else {
				try {
					inputValue = Double.parseDouble(input);
				}
				catch(Exception e) {
					inputValue = null;
				}
			}
		}
		while (inputValue == null);
		
		return inputValue;
	}

	public default Boolean getBoolean(String prompt, boolean allowNulls)  throws ParseException {
		Boolean inputValue;
		do {
			System.out.print(prompt);		
			String input = scanner.nextLine();
			if (allowNulls && input.trim().equals("")) {
				return null;
			}			
			if (!allowNulls && input.trim().equals("")) {
				inputValue = null;
			}
			else {
				try {
					inputValue = Boolean.parseBoolean(input);
				}
				catch(Exception e) {
					inputValue = null;
				}
			}
		}
		while (inputValue == null);
		
		return inputValue;
	}

	public default Date getDate(String prompt, boolean allowNulls) throws ParseException {
		Date inputValue;
		do {
			System.out.print(prompt);		
			String input = scanner.nextLine();
			if (allowNulls && input.trim().equals("")) {
				return null;
			}			
			if (!allowNulls && input.trim().equals("")) {
				inputValue = null;
			}			
			else {
				try {
				    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				    inputValue = formatter.parse(input);	
				}
				catch(Exception e) {
					inputValue = null;
				}
			}
		}
		while (inputValue == null);		
		
		return inputValue;
	}
		
	public default String getString(String prompt, boolean allowNulls)  throws ParseException {
		String inputValue;
		do {
			System.out.print(prompt);		
			inputValue = scanner.nextLine();
			if (allowNulls && inputValue.trim().equals("")) {
				return null;
			}			
			if (!allowNulls && inputValue.trim().equals("")) {
				inputValue = null;
			}
		}
		while (inputValue == null);		
		
		return inputValue;
	}
	
	abstract ViewData create(ModelData modelData, String functionName, String operationName) throws Exception;
	
}
