import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class NopModel implements ModelInterface {

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
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
	
	
	@Override
	public int insert(String fieldname, List<Object> rows) throws Exception {
		return 0;
	}
	public int insert1(String fieldname, List<Object> rows) throws Exception {
		return 0;
	}

	@Override
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}
	public int update1(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}
	

	@Override
	public String toString() {
		return "No Operation Model";
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
	public ResultSet select5(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
