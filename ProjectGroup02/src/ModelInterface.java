import java.sql.*;
import java.util.*;


interface ModelInterface {

	abstract ResultSet select(Map<String, Object> whereParameters) throws Exception;
	
	abstract ResultSet select1(Map<String, Object> whereParameters) throws Exception;
	
	abstract ResultSet select2(Map<String, Object> whereParameters) throws Exception;
	
	abstract ResultSet select3(Map<String, Object> whereParameters) throws Exception;
	
	abstract ResultSet select4(Map<String, Object> whereParameters) throws Exception;
	
	abstract ResultSet select5(Map<String, Object> whereParameters) throws Exception;
	
	abstract int insert(String fieldname, List<Object> rows) throws Exception;
	
	abstract int insert1(String fieldname, List<Object> rows) throws Exception;
		
	abstract int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception;
	
	abstract int update1(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception;

	
	default ModelData execute(ViewData viewData) throws Exception {
		if (viewData.viewParameters == null) {
			return new ModelData();
		}
	
		switch(viewData.operationName) {
			case "select":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				ResultSet resultSet = select(whereParameters);
				
				return new ModelData(viewData.functionName, resultSet);
			}
			
			
			case "select1":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				ResultSet resultSet = select1(whereParameters);
				
				return new ModelData(viewData.functionName, resultSet);
			}
			
			case "select2":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				ResultSet resultSet = select2(whereParameters);
				
				return new ModelData(viewData.functionName, resultSet);
			}
			
			case "select3":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				ResultSet resultSet = select3(whereParameters);
				
				return new ModelData(viewData.functionName, resultSet);
			}
			
			case "select4":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				ResultSet resultSet = select4(whereParameters);
				
				return new ModelData(viewData.functionName, resultSet);
			}
			
			case "select5":
			{
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				ResultSet resultSet = select5(whereParameters);
				
				return new ModelData(viewData.functionName, resultSet);
			}
			
			case "insert":
			{
				String fieldname = (String)(viewData.viewParameters.get("fieldname"));
				List<Object> rows = (List<Object>)(viewData.viewParameters.get("rows"));
				
				int recordCount = insert(fieldname, rows);
				
				return new ModelData(viewData.functionName, recordCount);
			}
			
			case "insert1":
			{
				String fieldname = (String)(viewData.viewParameters.get("fieldname"));
				List<Object> rows = (List<Object>)(viewData.viewParameters.get("rows"));
				
				int recordCount = insert1(fieldname, rows);
				
				return new ModelData(viewData.functionName, recordCount);
			}
			
			
			case "update":
			{
				Map<String, Object> updateParameters = (Map<String, Object>)(viewData.viewParameters.get("updateParameters"));
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				int recordCount = update(updateParameters, whereParameters);
				
				return new ModelData(viewData.functionName, recordCount);
			}
			
			
			case "update1":
			{
				Map<String, Object> updateParameters = (Map<String, Object>)(viewData.viewParameters.get("updateParameters"));
				Map<String, Object> whereParameters = (Map<String, Object>)(viewData.viewParameters.get("whereParameters"));
				
				int recordCount = update1(updateParameters, whereParameters);
				
				return new ModelData(viewData.functionName, recordCount);
			}
			
			
		}
		
		return new ModelData();
	}
	
}
