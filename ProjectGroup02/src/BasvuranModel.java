import java.sql.*;
import java.util.*;


class BasvuranModel implements ModelInterface {
	
	
	//Yeni kullanýcý kaydýnýn yapýlabilmesi için gerekli olan SQL Insert Query'si
	
	@Override
	public int insert(String fieldname, List<Object> rows) throws Exception
	{
		
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO Basvuran  (" + fieldname + ") " );
		sql.append(" VALUES ");

		String[] fieldList = fieldname.split(",");

		int rowCount = 0;
		for(int i= 0; i<rows.size(); i++) {
			if (rows.get(i) instanceof Basvuran) {
				rowCount++;
				
				Basvuran basvuran = (Basvuran)rows.get(i); 
	
				sql.append("(");
				for (int j=0; j<fieldList.length; j++) {
					String fieldName = fieldList[j].trim();
					
					//Nullable column'lara eðer null deðeri girilirse query'e direkt NULL yazýlmasýný saðlamak 
					if(basvuran.getByName(fieldName) == null  )
					{
						sql.append("NULL");
					}
					
					else
					{
					sql.append(DatabaseUtilities.formatField(basvuran.getByName(fieldName)));
					}
					if (j < fieldList.length - 1) {
						sql.append(", ");
					}
				}
				sql.append(")");
				
				if (i < rows.size() - 1) {
					sql.append(", ");
				}				
			}
		}		
		
		// execute constructed SQL statement
		if (rowCount > 0) {
			Connection connection = DatabaseUtilities.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			rowCount = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		
		return rowCount;
	}
	

	//ModelInterface'te bulunan ancak bu class'ta kullanýlmayan abstract methodlarýn implement edilmesi 
	
	@Override
	public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet select2(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet select3(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert1(String fieldname, List<Object> rows) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update1(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet select5(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}		
	
	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		
		return null;
	}
	
	@Override
	public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
	{
		return 0;
	}

}

