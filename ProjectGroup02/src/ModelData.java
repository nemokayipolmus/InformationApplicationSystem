import java.sql.ResultSet;

public class ModelData {
	final String modelName;
	final ResultSet resultSet;
	final int recordCount;
	
	ModelData() {
		this.modelName = null;
		this.resultSet = null;
		this.recordCount = 0;		
	}
	
	ModelData(String modelName, ResultSet resultSet) {
		this.modelName = modelName;
		this.resultSet = resultSet;
		this.recordCount = 0;		
	}	
	
	ModelData(String modelName, int recordCount) {
		this.modelName = modelName;
		this.resultSet = null;
		this.recordCount = recordCount;		
	}	
	
	ModelData(String modelName, ResultSet resultSet, int recordCount) {
		this.modelName = modelName;
		this.resultSet = resultSet;
		this.recordCount = recordCount;
	}

	@Override
	public String toString() {
		return "Model Data (" + modelName + ")";
	}	
	
}
