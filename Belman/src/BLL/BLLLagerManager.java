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
     * Retrieves the visLager method from the Data access layer
     *
     * @returns showAll
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> visLager() throws SQLServerException, SQLException {
        return db.visLager();
    }

    public ArrayList<BELager> orderByThickness() throws SQLServerException, SQLException {
        return db.orderByThickness();
    }

    public ArrayList<BELager> orderByLength() throws SQLServerException, SQLException {
        return db.orderByLength();
    }

    public ArrayList<BELager> orderByWidth() throws SQLServerException, SQLException {
        return db.orderByWidth();
    }

    public ArrayList<BELager> orderByMaterialID() throws SQLServerException, SQLException {
        return db.orderByMaterialID();
    }

    public ArrayList<BELager> orderByDensity() throws SQLServerException, SQLException {
        return db.orderByDensity();
    }

    public ArrayList<BELager> orderByStockQuantity() throws SQLServerException, SQLException {
        return db.orderByStockQuantity();
    }

    public ArrayList<BELager> getLagerById(int id) throws SQLServerException, SQLException {
        return db.getLagerById(id);
    }

//    public ArrayList<BEProduktion> getMaterialByOrder(BEProduktion p)  throws SQLServerException, SQLException {
//        return db.getMaterialByOrder(p);
//    }
//    public ArrayList<BEProduktion> materialeLager(BELager p) throws SQLServerException, SQLException, Exception {
//        return db.materialeLager(p);
//    }

    public ArrayList<BELager> getStockByOrderMaterial(BELager l) throws SQLServerException, SQLException
    {
        return db.getStockByOrderMaterial(l);
    }
}
