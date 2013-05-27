/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.BEMateriale;
import BE.BESleeve;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Stoffer, Jonas & Christian
 * Sleeve DB Manager The data Access Layer
 */
public class DALSleeveDBManager extends DALBelmanDBManager  {
    
    public DALSleeveDBManager() throws Exception {
        super();
    }
    
    private static final String ID = "id";
    private static final String THICKNESS = "thickness";
    private static final String CIRCUMFERENCE = "circumference";
    private static final String MATERIALID = "materialId";
    private static final String PORDERID = "pOrderId";
    private static final String NAME = "name";
    
    public ArrayList<BESleeve> getAllSleeves() throws SQLException
    {
         try (Connection con = ds.getConnection())
        {
            String sql = "SELECT Sleeve.*, Material.name FROM Sleeve, Material WHERE Sleeve.materialId = Material.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<BESleeve> sleeves = new ArrayList<>();
            while (rs.next())
            {
                sleeves.add(getOneSleeve(rs));
            }
            return sleeves;
        }
    }
    
    public BESleeve getOneSleeve(ResultSet rs) throws SQLException
    {
        int id = rs.getInt(ID);
        Float thickness = rs.getFloat(THICKNESS);
        Float circumference = rs.getFloat(CIRCUMFERENCE);
        int materialId = rs.getInt(MATERIALID);
        int pOrderId = rs.getInt(PORDERID);
        String materialName = rs.getString(NAME);
        
        return new BESleeve(id, thickness, circumference, materialId, pOrderId, new BEMateriale(materialName));
    }
    
//    protected String convertDateToSQL(GregorianCalendar date)
//    {
//        String str = String.format("%04d%02d%02d %02d:%02d:%02d",
//                date.get(Calendar.YEAR),
//                date.get(Calendar.MONTH) + 1,
//                date.get(Calendar.DAY_OF_MONTH),
//                date.get(Calendar.HOUR_OF_DAY),
//                date.get(Calendar.MINUTE),
//                0);
//        return str;
//    }
}
