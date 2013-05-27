/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.BECoilType;
import BE.BEMateriale;
import BE.BESleeve;
import BE.BEStockItem;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Stoffer, Jonas & Christian
 * Stock Item DB Manager The data Access Layer
 */
public class DALStockItemDBManager extends DALBelmanDBManager {
    
    public DALStockItemDBManager() throws Exception {
        super();
    }
    
    private static final String ID = "id";
    private static final String CHARGE_NO = "chargeNo";
    private static final String LENGTH = "length";
    private static final String STOCK_QUANTITY = "stockQuantity";
    private static final String COIL_TYPE_ID = "coilTypeId";
    private static final String SLEEVE_ID = "sleeveId";
    private static final String CODE = "code";
    private static final String WIDTH = "width";
    private static final String THICKNESS = "thickness";
    private static final String DENSITY = "density";
    private static final String NAME = "name";
    private static final String MATERIAL_ID = "materialId";    
    

    public BEStockItem add(BEStockItem item) throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "INSERT INTO StockItem(chargeNo, length, stockQuantity, coilTypeId, sleeveId) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getChargeNo());
            ps.setFloat(2, item.getLength());
            ps.setFloat(3, item.getStockQuantity());
            ps.setFloat(4, item.getCoilTypeId());
            ps.setInt(5, item.getSleeveId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to add an StockItem");
            }
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);

            return new BEStockItem(id, item);
        }
    }

    public ArrayList<BEStockItem> getAllItems() throws SQLException, IOException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "SELECT * FROM StockItem, CoilType, Material WHERE Coiltype.MaterialId = Material.Id AND CoilType.Id = StockItem.coilTypeId";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<BEStockItem> items = new ArrayList<>();
            while (rs.next())
            {
                items.add(getOneItem(rs));
            }
            return items;
        }
    }

    public void remove(int id) throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "DELETE * FROM StockItem WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to remove StockItem!");
            }
        }
    }

    public ArrayList<BEStockItem> getItemByMaterial(String materialName) throws SQLException, IOException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "SELECT * FROM StockItem WHERE materialName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materialName);

            ArrayList<BEStockItem> items = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                items.add(getOneItem(rs));
            }
            return items;
        }
    }
    
    public ArrayList<BEStockItem> getItemBySleeve(BESleeve s) throws SQLServerException, SQLException, IOException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "SELECT * FROM StockItem, CoilType, Material, Sleeve WHERE Sleeve.Id = StockItem.sleeveId AND StockItem.coilTypeId = CoilType.id AND CoilType.materialId = Material.id AND Sleeve.id = ?";        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, s.getId());

            ResultSet rs = ps.executeQuery();

            ArrayList<BEStockItem> items = new ArrayList<>();
            while (rs.next())
            {
                items.add(getOneItem(rs));
            }
            return items;
        }
    }

    protected BEStockItem getOneItem(ResultSet rs) throws SQLException, IOException
    {
        int id = rs.getInt(ID);
        String chargeNo = rs.getString(CHARGE_NO);
        Float length = rs.getFloat(LENGTH);
        Float stockQuantity = rs.getFloat(STOCK_QUANTITY);
        int coilTypeId = rs.getInt(COIL_TYPE_ID);
        int sleeveId = rs.getInt(SLEEVE_ID);
        String code = rs.getString(CODE);
        Float width = rs.getFloat(WIDTH);
        Float thickness = rs.getFloat(THICKNESS);
        Float density = rs.getFloat(DENSITY);
        String name = rs.getString(NAME);
        int materialId = rs.getInt(MATERIAL_ID);

        return new BEStockItem(id, chargeNo, length, stockQuantity, coilTypeId, sleeveId, new BECoilType(code, width, thickness, materialId), new BEMateriale(density, name));
    }
    
}
