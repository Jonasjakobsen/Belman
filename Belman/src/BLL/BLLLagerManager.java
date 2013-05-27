package BLL;

import BE.BELager;
import BE.BEProduktion;
import DAL.DALLagerDBManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * LagerManager The Business logic layer
 */
public class BLLLagerManager extends Observable{

    private static BLLLagerManager instance = null;
    private DALLagerDBManager db = null;

    /**
     * Constructor for the BLLLagerManager
     *
     * @throws Exception
     */
    public BLLLagerManager() throws Exception {
        db = new DALLagerDBManager();
    }

    public static BLLLagerManager getInstance() throws Exception {
        if (instance == null) {
            instance = new BLLLagerManager();
        }
        return instance;
    }

    /**
     * Retrieves the visLager method from the Data access layer     *
     * @returns visLager
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> visLager() throws SQLServerException, SQLException {
        return db.visLager();
    }
    /**
     * Retrieves the orderByThickness method from the Data access layer     *
     * @returns orderByThickness
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> orderByThickness() throws SQLServerException, SQLException {
        return db.orderByThickness();
    }
    /**
     * Retrieves the orderByLength method from the Data access layer     *
     * @returns orderByLength
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> orderByLength() throws SQLServerException, SQLException {
        return db.orderByLength();
    }
    /**
     * Retrieves the orderByWidth method from the Data access layer     *
     * @returns orderByWidth
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> orderByWidth() throws SQLServerException, SQLException {
        return db.orderByWidth();
    }
    /**
     * Retrieves the orderByMaterialID method from the Data access layer     *
     * @returns orderByMaterialID
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> orderByMaterialID() throws SQLServerException, SQLException {
        return db.orderByMaterialID();
    }
    /**
     * Retrieves the orderByDensity method from the Data access layer     *
     * @returns orderByDensity
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> orderByDensity() throws SQLServerException, SQLException {
        return db.orderByDensity();
    }
    /**
     * Retrieves the orderByStockQuantity method from the Data access layer     *
     * @returns orderByStockQuantity
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> orderByStockQuantity() throws SQLServerException, SQLException {
        return db.orderByStockQuantity();
    }
    /**
     * Retrieves the getLagerById method from the Data access layer     *
     * @returns getLagerById
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> getLagerById(int id) throws SQLServerException, SQLException {
        return db.getLagerById(id);
    }
    /**
     * Retrieves the getStockByOrderMaterial method from the Data access layer     *
     * @returns getStockByOrderMaterial
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> getStockByOrderMaterial(BELager l) throws SQLServerException, SQLException
    {
        return db.getStockByOrderMaterial(l);
    }
}
