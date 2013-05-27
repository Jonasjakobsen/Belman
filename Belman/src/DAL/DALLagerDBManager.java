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
 * Lager DB Manager The data Access Layer
 */
public class DALLagerDBManager extends DALBelmanDBManager {

    private ArrayList<BELager> lager;
    
    private static final String STOCKITEMID = "id";
    private static final String COILCODE = "code";
    private static final String MATERIALID = "materialId";
    private static final String MATERIALNAME = "code";
    private static final String MATERIALDENSITY = "density";
    private static final String CHARGENO = "chargeNo";
    private static final String LENGTH = "lenght";
    private static final String WIDTH = "width";
    private static final String THICKNESS = "thickness";
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
     *
     * @return lageret
     * @throws SQLServerException, SQLException
     */
    public ArrayList<BELager> visLager() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {

            String sql = "SELECT CoilType.code, Material.density, Stockitem.stockQuantity "                    
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId ";
//                    + "ORDER BY CoilType.code DESC";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
//                int id = rs.getInt(STOCKITEMID);
//                String Code = rs.getString(COILCODE);
//                int MaterialID = rs.getInt(MATERIALID);
                String Code = rs.getString(COILCODE);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
//                String ChargeNo = rs.getString(CHARGENO);
//                Float Length = rs.getFloat(LENGTH);
//                Float Width = rs.getFloat(WIDTH);
//                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(-1, Code, MaterialDensity, StockQuantity);
                lageret.add(l);
            }
            return lageret;
        }
    }

    public ArrayList<BELager> orderByThickness() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density,"
                    + " StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY CoilType.thickness";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
                lageret.add(l);
            }
            return lageret;

        }
    }

    public ArrayList<BELager> orderByLength() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density,"
                    + " StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY StockItem.length";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
                lageret.add(l);
            }
            return lageret;

        }
    }

    public ArrayList<BELager> orderByWidth() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density,"
                    + " StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY CoilType.width";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
                lageret.add(l);
            }
            return lageret;

        }
    }

    public ArrayList<BELager> orderByMaterialID() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density,"
                    + " StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY CoilType.materialID";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
                lageret.add(l);
            }
            return lageret;

        }
    }

    public ArrayList<BELager> orderByDensity() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density,"
                    + " StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY Material.Density";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
                lageret.add(l);
            }
            return lageret;

        }
    }

    public ArrayList<BELager> orderByStockQuantity() throws SQLServerException, SQLException {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density,"
                    + "StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId "
                    + "ORDER BY StockItem.stockQuantity";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<BELager> lageret = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);


                BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
                lageret.add(l);
            }
            return lageret;

        }


    }

    /**
     * Makes an ArrayList and adds the lines read from the file into the members
     * arrayList
     *
     * @return members
     * @throws SQLServerException, SQLException
     */
    public ArrayList<BELager> getLagerById(int Id) throws SQLException {
        Connection con = ds.getConnection();
        String sql = "SELECT StockItem.id, CoilType.code, "
                    + "CoilType.materialID, Material.name, "
                    + "Material.density, "
                    + "StockItem.chargeNo, StockItem.[length], "
                    + "CoilType.width, CoilType.thickness, "
                    + "StockItem.stockQuantity "
                    + "FROM Material, CoilType, StockItem "
                    + "WHERE (StockItem.id = ? OR Material.name = ?)"
                    + "AND Material.id = CoilType.materialId "
                    + "AND CoilType.id = StockItem.coilTypeId";               
 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Id);
        ps.setInt(2, Id);
        ResultSet rs = ps.executeQuery();

        ArrayList<BELager> LagerID = new ArrayList<>();
        while (rs.next()) {
                int id = rs.getInt(STOCKITEMID);
                String Code = rs.getString(COILCODE);
                int MaterialID = rs.getInt(MATERIALID);
                String MaterialName = rs.getString(MATERIALNAME);
                Float MaterialDensity = rs.getFloat(MATERIALDENSITY);
                String ChargeNo = rs.getString(CHARGENO);
                Float Length = rs.getFloat(LENGTH);
                Float Width = rs.getFloat(WIDTH);
                Float Thickness = rs.getFloat(THICKNESS);
                Float StockQuantity = rs.getFloat(STOCKQUANTITY);

            BELager l = new BELager(id, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
            LagerID.add(l);
        }
        return LagerID;

    }

    public ArrayList<BELager> getStockByOrderMaterial(BELager l) throws SQLException
    {
        try (Connection con = ds.getConnection())
        {
            String sql =
//                    "SELECT ProductionOrder.sOrderId, ProductionOrder.pOrder, "
//                    + "ProductionOrder.dueDate, ProductionOrder.quantity, CoilType.code, "
//                    + "ProductionOrder.[status], ProductionOrder.urgent, "
//                    + "Sleeve.Employeeid, StockItem.[length], CoilType.width "
//                    + "FROM ProductionOrder, Material, Sleeve, StockItem, CoilType "
//                    + "WHERE CoilType.code = ? "
//                    + "AND CoilType.materialId = Material.id "
//                    + "AND Material.id = Sleeve.materialId "
//                    + "AND Sleeve.pOrderId = ProductionOrder.id "
//                    + "ORDER By duedate ASC, urgent DESC";
                    
                        "SELECT CoilType.code, Material.density, Stockitem.stockQuantity, ProductionOrder.sOrderId, ProductionOrder.pOrder, "
                        +"ProductionOrder.dueDate, ProductionOrder.quantity, CoilType.code, "
                        +"ProductionOrder.[status], ProductionOrder.urgent, StockItem.[length], CoilType.width, "
                        +"Sleeve.Employeeid "
                        +"FROM ProductionOrder, Material, Sleeve, StockItem, CoilType "
                        +"WHERE CoilType.code = ? "
                        +"AND CoilType.id = StockItem.coilTypeId "
                        +"AND CoilType.materialId = Material.id "
                        +"AND Material.id = Sleeve.materialId "
                        +"AND Sleeve.pOrderId = ProductionOrder.pOrderId "
                        +"AND CoilType.thickness = Sleeve.thickness "
                        + "ORDER BY urgent DESC, duedate ASC";
            
            

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, l.getCode());
//            ps.setString(2, p.getPOrder());

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
                
//                int materialid = rs.getInt(MATERIALID);
//                String materialCoilCode = rs.getString(COILCODE);
//                Float materialDensity = rs.getFloat(MATERIALDENSITY);
//                Float materialQuantity = rs.getFloat(MATERIALQUANTITY);
                BELager la = new BELager(-1, Code, MaterialDensity, StockQuantity, new BEProduktion(sOrderID, pOrder, dueDate, quantity, materialName, status, urgent, employeeID, coilLength, coilWidth, coilCode));
//                BEProduktion l = new BEProduktion(sOrderID, pOrder, dueDate, quantity, materialName, status, urgent, employeeID, coilCode, new BELager(materialid, materialCoilCode, materialDensity, materialQuantity));
               
                ordrers.add(la);
            }
            return ordrers;
        }
    }
}
