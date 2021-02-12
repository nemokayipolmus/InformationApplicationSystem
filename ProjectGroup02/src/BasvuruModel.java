import java.sql.*;
import java.util.*;

public class BasvuruModel implements ModelInterface {

	//Kullan�c�n�n yapt��� t�m ba�vurular� g�r�nt�leyebilmesi i�in gerekli olan SQL Select Query'si
	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("KimlikNo, BasvuruNo, BasvuruTarihi, BasvuruTipiNo, BasvuruDurumuNo, CevaplamaTipiNo, CevapA��klama, CevapTurNo");
		sql.append(" FROM Basvuru");
		
		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}
	
	//Kullan�c�n�n yapt��� t�m ba�vurular�n durumlar�n� g�rmesi i�in gerekli olan SQL Select Query'si
	public ResultSet select3(Map<String, Object> whereParameters) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" BasvuruDurumuA��klama");
		sql.append(" FROM Basvuru as Bas INNER JOIN BasvuruDurumu as Bd ON");
		sql.append(" Bas.BasvuruDurumuNo=Bd.BasvuruDurumuNo");
		sql.append(" INNER JOIN Basvuran as BasV ON BasV.KimlikNo = Bas.KimlikNo");
		
		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}

	//Kullan�c�n�n yeni bir ba�vuru yapabilmesi i�in gerekli olan SQL Insert Query'si
	@Override
	public int insert(String fieldname, List<Object> rows) throws Exception {
		// construct SQL statement
				StringBuilder sql = new StringBuilder();
				sql.append(" INSERT INTO Basvuru  (" + fieldname + ") " );
				sql.append(" VALUES ");

				String[] fieldList = fieldname.split(",");

				int rowCount = 0;
				for(int i= 0; i<rows.size(); i++) {
					if (rows.get(i) instanceof Basvuru) {
						rowCount++;
						
						Basvuru basvuru = (Basvuru)rows.get(i); 
			
						sql.append("(");
						for (int j=0; j<fieldList.length; j++) {
							String fieldName = fieldList[j].trim();
							
							//Nullable column'lara e�er null de�eri girilirse query'e direkt NULL yaz�lmas�n� sa�lamak 
							if(basvuru.getByName(fieldName) == null  )
							{
								sql.append("NULL");
							}
							
							else {
							sql.append(DatabaseUtilities.formatField(basvuru.getByName(fieldName)));
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

	//ModelInterface'te bulunan ancak bu class'ta kullan�lmayan abstract methodlar�n implement edilmesi 
	
	@Override
	public ResultSet select2(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	public int insert1(String fieldname, List<Object> rows) throws Exception {
		return 0;
}
	
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}


}
