import java.sql.*;
import java.util.*;

 

public class KurumModel implements ModelInterface {

 
	//Kurumun kendisine yap�lan t�m ba�vurular� g�rebilmesini sa�layan Select Query'si
    @Override
    public ResultSet select(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("KimlikNo, B.KurumNo,  Bas.BasvuruNo, Bas.BasvuruTipiNo, Bas.CevapTurNo, Bas.BasvuruDurumuNo, Bas.CevapTurNo, Bas.CevaplamaTipiNo, K. KurumTipiNo, BasvuruTarihi, CeTur.CevapA��klama, BasvuruDurumuA��klama, CevaplamaTipiA��klama,BasvuruTipiA��klama, KurumAd�, KurumTipiA��klama");
        sql.append(" FROM BasvuruKurumYonlendirme as B");
        sql.append(" INNER JOIN Kurum as K ON B.KurumNo = K.KurumNo");
        sql.append(" INNER JOIN Basvuru as Bas ON B.BasvuruNo = Bas.BasvuruNo");
        sql.append(" INNER JOIN BasvuruDurumu AS Bd ON Bas.BasvuruDurumuNo = Bd.BasvuruDurumuNo");
        sql.append(" INNER JOIN BasvuruTipi AS Bt ON Bas.BasvuruTipiNo = Bt.BasvuruTipiNo");
        sql.append(" INNER JOIN CevaplamaTip AS Ct ON Bas.CevaplamaTipiNo = Ct.CevaplamaTipiNo");
        sql.append(" INNER JOIN CevapTur AS CeTur ON Bas.CevapTurNo = CeTur.CevapTurNo");
        sql.append(" INNER JOIN KurumTip AS KT ON K.KurumTipiNo = KT.KurumTipiNo");
        //sql.append("ON Basvuran.KimlikNo = Basvuru.KimlikNo");

 

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        
        //sql.append("ORDER BY Basvuran.KimlikNo");        
        //System.out.println(sql.toString() + "\n");

 

        
        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();
        
        return result;
    }
    
    /*
    public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("K.KurumNo,COUNT(B.BasvuruNo) AS BasvuruNo,COUNT(CASE WHEN B.CevapTurNo > 1 THEN 1 ELSE NULL END) AS ToplamRed,COUNT(CASE WHEN B.CevapTurNo = 0 THEN 1 ELSE NULL END) AS ToplamOlumluBasvuru,COUNT(CASE WHEN B.CevapTurNo = 17 THEN 1 ELSE NULL END) AS ��kar�lm��Kabul,COUNT(CASE WHEN B.CevapTurNo = 15 THEN 1 WHEN B.CevapTurNo = 16 THEN 1 ELSE NULL END) AS ToplamItiraz");
        sql.append(" FROM BasvuruKurumYonlendirme AS BK ");
        sql.append(" INNER JOIN Basvuru AS B ON BK.BasvuruNo = B.BasvuruNo ");
        sql.append(" INNER JOIN Kurum AS K ON BK.KurumNo = K.KurumNo ");
        
        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        
        sql.append(" GROUP BY K.KurumNo ");
        

 

       
        
        //sql.append("ORDER BY Basvuran.KimlikNo");        
        //System.out.println(sql.toString() + "\n");

 

        
        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();
        
        return result;
    }
    
        */
    
  //Kurumun kendisine yap�lan t�m ba�vurular�n istatistiklerini g�rmesini sa�layan Select Query'si
    public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        
       
        sql.append(" SELECT ");
        sql.append("B.KurumNo,  Bas.BasvuruNo, Bas.BasvuruTipiNo, Bas.CevapTurNo, Bas.BasvuruDurumuNo, Bas.CevapTurNo, Bas.CevaplamaTipiNo");
        sql.append(" FROM BasvuruKurumYonlendirme as B");
        sql.append(" INNER JOIN Kurum as K ON B.KurumNo = K.KurumNo");
        sql.append(" INNER JOIN Basvuru as Bas ON B.BasvuruNo = Bas.BasvuruNo");
    
        

 

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

       
        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();
        
        return result;
    }
    
    //Kurumun t�m personellerinin bilgilerini g�rmesini sa�layan Select Query'si
    public ResultSet select2(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("P.PersonelID, Ad, Soyad, GorevA��klama, Kullan�c�YetkiA��klama");
        sql.append(" FROM Kurum AS K");
        sql.append(" INNER JOIN Personel AS P ON K.KurumNo = P.KurumNo");
        sql.append(" INNER JOIN Gorev AS G ON P.GorevNo = G.GorevNo");
        sql.append(" INNER JOIN Kullanici As KU ON P.PersonelID = KU.PersonelID");
        sql.append(" INNER JOIN Yetkisi AS Y ON KU.Kullan�c�YetkiNo = Y.Kullan�c�YetkiNo");
        //sql.append("ON Basvuran.KimlikNo = Basvuru.KimlikNo");

 

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        
        //sql.append("ORDER BY Basvuran.KimlikNo");        
        //System.out.println(sql.toString() + "\n");

 

        
        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();
        
        return result;
    }
    
  //Kurumun bekleyen ba�vurular� g�rmesini sa�layan Select Query'si
    
    public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("B.BasvuruNo, BasvuruTarihi, SonBasvuruTarihi");
        sql.append(" FROM BasvuruKurumYonlendirme AS BK");
        sql.append(" INNER JOIN Kurum AS K ON BK.KurumNo = K.KurumNo");
        sql.append(" INNER JOIN Basvuru AS B ON BK.BasvuruNo = B.BasvuruNo");
        sql.append(" INNER JOIN CevapTur AS CT ON B.CevapTurNo = CT.CevapTurNo");
   

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        
        sql.append(" ORDER BY DATEDIFF(DAY, SonBasvuruTarihi, CURRENT_TIMESTAMP)");        

 
        

        
        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();
        
        return result;
    }
    
    
   //Kurumun ba�vuru cevaplar�na yap�lan itirazlar�n sonu�lar�n� g�rmesini sa�layan Select Query'si
    public ResultSet select5(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("B.BasvuruNo, CT.CevapA��klama");
        sql.append(" FROM BasvuruKurumYonlendirme AS BK");
        sql.append(" INNER JOIN Kurum AS K ON BK.KurumNo = K.KurumNo");
        sql.append(" INNER JOIN Basvuru AS B ON BK.BasvuruNo = B.BasvuruNo");
        sql.append(" INNER JOIN CevapTur AS CT ON B.CevapTurNo = CT.CevapTurNo");
        //sql.append("ON Basvuran.KimlikNo = Basvuru.KimlikNo");

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);        
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        
        //sql.append(" ORDER BY DATEDIFF(DAY, SonBasvuruTarihi, CURRENT_TIMESTAMP)");        
        //System.out.println(sql.toString() + "\n");

 
        

        
        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();
        
        return result;
    }
    

    //Kurumun yap�lan ba�vurulara cevap vermesini sa�layan Update Query'si
    @Override
    public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
    {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE Basvuru SET ");
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

    
//ModelInterface'te bulunan ancak bu class'ta kullan�lmayan abstract methodlar�n implement edilmesi    
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
public int update1(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
{
   return 0;
}

@Override
public int insert1(String fieldname, List<Object> rows) throws Exception {
	// TODO Auto-generated method stub
	return 0;
}


 


}