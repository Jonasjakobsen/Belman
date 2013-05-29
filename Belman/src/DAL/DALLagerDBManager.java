package DAL;

import BE.BELager;
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
public class DALLagerDBManager extends DALBelmanDBManager {
    
    private static final String COILCODE = "code";
    private static final String MATERIALNAME = "code";
    private static final String MATERIALDENSITY = "density";
    private static final String WIDTH = "width";
    private static final String STOCKQUANTITY = "stockQuantity";
    private static final String SORDERID = "sOrderId";
    private static final String PORDER = "pOrder";
    private static final String DUEDATE = "dueDate";
    private static final String QUANTITY = "quantity";
    private static final String STATUS = "status";
    private static final String URGENT = "urgent";
    private static final String EMPLOYEEID = "Employeeid";
    private static final String COILLENGTH = "length";

    
    
    

    public DALLagerDBManager() throws Exception {
        super();
    }

    /**
     * Makes an ArrayList and adds the lines read from the file into the lageret
     * arrayList
     * @return lageret - The ArrayList containing all the items they have on 
     * stock.
     * @throws SQLServerException, SQLException
     */
    public ArrayList<BELager> visLager() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {

            String sql = "SELECT CoilType.code, Material.density, "
                    + "Stockitem.stockQuantity "                    
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY CoilType.code DESC";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {

                String Code = rs.getString(COILCODE);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);

                BELager l = new BELager(-1, Code, MaterialDensity, 
                                        StockQuantity);
                lageret.add(l);
            }
            return lageret;
        }
    }


    /**
     * 
     * @param l - The BELager object, sent from the BLL Layer.
     * @return orders - The ArrayList containing the orders sorted by material
     * @throws SQLException
     */
    public ArrayList<BELager> getStockByOrderMaterial(BELager l) throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql = "SELECT CoilType.code, Material.density, "
                        + "Stockitem.stockQuantity, ProductionOrder.sOrderId, "
                        + "ProductionOrder.pOrder, "
                        + "ProductionOrder.dueDate, ProductionOrder.quantity, "
                        + "CoilType.code, "
                        + "ProductionOrder.[status], ProductionOrder.urgent, "
                        + "StockItem.[length], CoilType.width, "
                        + "Sleeve.Employeeid "
                        + "FROM ProductionOrder, Material, Sleeve, StockItem, "
                        + "CoilType "
                        + "WHERE CoilType.code = ? "
                        + "AND CoilType.id = StockItem.coilTypeId "
                        + "AND CoilType.materialId = Material.id "
                        + "AND Material.id = Sleeve.materialId "
                        + "AND Sleeve.pOrderId = ProductionOrder.pOrderId "
                        + "AND CoilType.thickness = Sleeve.thickness "
                        + "ORDER BY urgent DESC, duedate ASC";
            
            

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, l.getCode());

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> ordrers = new ArrayList<>();

            while (rs.next())
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
                String Code = rs.getString(COILCODE);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);
                
                BELager la = new BELager(-1, Code, MaterialDensity, StockQuantity, 
                             new BEProduktion(sOrderID, pOrder, dueDate, 
                             quantity, materialName, status, urgent, employeeID, 
                             coilLength, coilWidth, coilCode));
                ordrers.add(la);
            }
            return ordrers;
        }
    }
}
