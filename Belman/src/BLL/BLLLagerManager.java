package BLL;

import BE.BELager;
import DAL.DALLagerDBManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Christoffer, Jonas & Christian
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
     * Retrieves the getStockByOrderMaterial method from the Data access layer     *
     * @returns getStockByOrderMaterial
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BELager> getStockByOrderMaterial(BELager l) throws SQLServerException, SQLException
    {
        return db.getStockByOrderMaterial(l);
    }
}
