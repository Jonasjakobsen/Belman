package DAL;

import BE.BEProduktion;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class DALProduktionDBManager extends DALBelmanDBManager {
    
    private static final String SORDERID = "sOrderId";
    private static final String PORDER = "pOrder";
    private static final String DUEDATE = "dueDate";
    private static final String QUANTITY = "quantity";
    private static final String MATERIALNAME = "code";
    private static final String WIDTH = "width";
    private static final String STATUS = "status";
    private static final String URGENT = "urgent";
    private static final String EMPLOYEEID = "Employeeid";
    private static final String COILLENGTH = "length";
    private static final String COILCODE = "code";

    public DALProduktionDBManager() throws Exception {
        super();
    }

    public ArrayList<BEProduktion> visOrdrer() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
           String sql = "SELECT ProductionOrder.sOrderId, "
            + "ProductionOrder.pOrder, "
            + "ProductionOrder.dueDate, ProductionOrder.quantity, "
            + "Coiltype.code, ProductionOrder.[status], "
            + "ProductionOrder.urgent, Sleeve.Employeeid, "
            + "StockItem.[length], CoilType.width "
            +"FROM ProductionOrder, Material, Sleeve, StockItem, CoilType "
            +"WHERE ProductionOrder.pOrderId = Sleeve.pOrderId "
            +"AND Sleeve.materialId = Material.id  "
            +"AND Material.id = CoilType.materialId "
            +"AND CoilType.id = StockItem.coilTypeId "
            +"AND CoilType.thickness = Sleeve.thickness ";
              
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BEProduktion> ordre = new ArrayList<>();

            while (rs.next()) 
            {
                ordre.add(getOneOrder(rs));
            }
            return ordre;

        }
    
    }
    

    public ArrayList<BEProduktion> getOrderByOrderMaterial(BEProduktion p) throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql =
                    "SELECT ProductionOrder.sOrderId, ProductionOrder.pOrder, "
                    + "ProductionOrder.dueDate, ProductionOrder.quantity, "
                    + "CoilType.code, "
                    + "ProductionOrder.[status], ProductionOrder.urgent, "
                    + "Sleeve.Employeeid, StockItem.[length], CoilType.width "
                    + "FROM ProductionOrder, Material, Sleeve, StockItem, "
                    + "CoilType "
                    + "WHERE ProductionOrder.pOrderId = Sleeve.pOrderId "
                    + "AND Sleeve.materialId = Material.id "
                    + "AND Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "AND CoilType.thickness = Sleeve.thickness "
                    + "AND CoilType.code = ? "
                    + "EXCEPT "
                    + "SELECT ProductionOrder.sOrderId, ProductionOrder.pOrder, "
                    + "ProductionOrder.dueDate, ProductionOrder.quantity, "
                    + "CoilType.code, "
                    + "ProductionOrder.[status], ProductionOrder.urgent, "
                    + "Sleeve.Employeeid, StockItem.[length], CoilType.width "
                    + "FROM ProductionOrder, Material, Sleeve, StockItem, "
                    + "CoilType "
                    + "WHERE ProductionOrder.pOrderId = Sleeve.pOrderId "
                    + "AND Sleeve.materialId = Material.id "
                    + "AND Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "AND CoilType.thickness = Sleeve.thickness "
                    + "AND ProductionOrder.pOrder = ? "
                    + "ORDER BY urgent DESC, duedate ASC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getCoilCode());
            ps.setString(2, p.getPOrder());

            ResultSet rs = ps.executeQuery();

            ArrayList<BEProduktion> matordre = new ArrayList<>();

            while (rs.next())
            {              
                matordre.add(getOneOrder(rs));
            }
            return matordre;
        }
    }

    public ArrayList<BEProduktion> getOrderByMaterial(BEProduktion p) throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql ="SELECT ProductionOrder.sOrderId, ProductionOrder.pOrder, "
                        +"ProductionOrder.dueDate, ProductionOrder.quantity, CoilType.code, "
                        +"ProductionOrder.[status], ProductionOrder.urgent, StockItem.[length], CoilType.width, "
                        +"Sleeve.Employeeid "
                        +"FROM ProductionOrder, Material, Sleeve, StockItem, CoilType "
                        +"WHERE CoilType.code = ? "
                        +"AND CoilType.id = StockItem.coilTypeId "
                        +"AND CoilType.materialId = Material.id "
                        +"AND Material.id = Sleeve.materialId "
                        +"AND Sleeve.pOrderId = ProductionOrder.pOrderId "
                        +"AND CoilType.thickness = Sleeve.thickness ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getCoilCode());

            ResultSet rs = ps.executeQuery();

            ArrayList<BEProduktion> order = new ArrayList<>();

            while (rs.next())
            {
                order.add(getOneOrder(rs));
            }
            return order;
        }
    }
    
    public BEProduktion getOneOrder(ResultSet rs) throws SQLException
    {
        int sOrderID = rs.getInt(SORDERID);
        String pOrder = rs.getString(PORDER);
        Date dueDate = rs.getDate(DUEDATE);
        Float quantity = rs.getFloat(QUANTITY);
        String materialName = rs.getString(MATERIALNAME);
        String status = rs.getString(STATUS);
        Boolean urgent = rs.getBoolean(URGENT);
        int employeeID = rs.getInt(EMPLOYEEID);
        Float coilLength = rs.getFloat(COILLENGTH);
        Float coilWidth = rs.getFloat(WIDTH);
        String coilCode = rs.getString(COILCODE);
        
        return new BEProduktion(sOrderID, pOrder, dueDate, quantity, 
                materialName, status, urgent, employeeID, coilLength, 
                coilWidth, coilCode);
    }
}
