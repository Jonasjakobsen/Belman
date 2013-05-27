/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.BEMateriale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Stoffer, Jonas & Christian
 * Materiale DB Manager The data Access Layer
 */
public class DALMaterialeDBManager extends DALBelmanDBManager { 
    
    public DALMaterialeDBManager() throws Exception {
        super();
    }
    
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DENSITY = "density";
    
    
    public ArrayList<BEMateriale> getAllMaterials() throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "SELECT * FROM Material";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<BEMateriale> materials = new ArrayList<>();
            while (rs.next())
            {
                materials.add(getOneMaterial(rs));
            }
            return materials;
        }
    }
    
    protected BEMateriale getOneMaterial(ResultSet rs) throws SQLException
    {
        int id = rs.getInt(ID);
        String name = rs.getString(NAME);
        Float density = rs.getFloat(DENSITY);
        
        return new BEMateriale(id, density, name);
    }
}