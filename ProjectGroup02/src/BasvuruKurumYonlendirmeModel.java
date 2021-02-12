import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class BasvuruKurumYonlendirmeModel implements ModelInterface {

   
	//Baþvurunun kurumlararasý iletilebilmesi için gerekli olan SQL Update Query'si
	
	    @Override
	    public int update1(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
	    {
	        // construct SQL statement
	        StringBuilder sql = new StringBuilder();
	        sql.append(" UPDATE BasvuruKurumYonlendirme SET ");
	        int appendCount = 0;
	        for (Map.Entry<String, Object> entry : updateParameters.entrySet()) {
	            sql.append(entry.getKey() + " = " + DatabaseUtilities.formatField(entry.getValue()));
	            if (++appendCount < updateParameters.size()) {
	                sql.append(", ");
	            }
	        }
	        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
	        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
	        //System.out.println(sql.toString());
	        
	    
	        // execute constructed SQL statement
	        Connection connection = DatabaseUtilities.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
	        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);        
	        int rowCount = preparedStatement.executeUpdate();
	        preparedStatement.close();
	        
	        return rowCount;
	    }

	 //Kullanýcýnýn baþvuru yaptýðý kurumu girebilmesi için gerekli olan SQL Insert Query'si
	    
	    @Override
		public int insert1(String fieldname, List<Object> rows) throws Exception {
	    	// construct SQL statement
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO BasvuruKurumYonlendirme  (" + fieldname + ") " );
			sql.append(" VALUES ");

			String[] fieldList = fieldname.split(",");

			int rowCount = 0;
			for(int i= 0; i<rows.size(); i++) {
				if (rows.get(i) instanceof BasvuruKurumYonlendirme) {
					rowCount++;
					
					BasvuruKurumYonlendirme basvuruKurumYonlendirme = (BasvuruKurumYonlendirme)rows.get(i); 
		
					sql.append("(");
					for (int j=0; j<fieldList.length; j++) {
						String fieldName = fieldList[j].trim();
						sql.append(DatabaseUtilities.formatField(basvuruKurumYonlendirme.getByName(fieldName)));
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
	public int insert(String fieldname, List<Object> rows) throws Exception {
	    // TODO Auto-generated method stub
	    return 0;
	}

	 
	@Override
	public ResultSet select3(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
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
	    public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
		       return null;
		    }
	  
	  @Override
	    public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
	      return null;
	    }
	 @Override
	    public ResultSet select2(Map<String, Object> whereParameters) throws Exception {
	       return null;
	    }
}
