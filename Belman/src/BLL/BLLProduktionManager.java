package BLL;

import BE.BEProduktion;
import DAL.DALProduktionDBManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * LagerManager The Business logic layer
 */
public class BLLProduktionManager extends Observable {

    private static BLLProduktionManager instance = null;
    private DALProduktionDBManager db = null;

    /**
     * Constructor for the BLLLagerManager
     *
     * @throws Exception
     */
    public BLLProduktionManager() throws Exception {
        db = new DALProduktionDBManager();
    }

    public static BLLProduktionManager getInstance() throws Exception {
        if (instance == null) {
            instance = new BLLProduktionManager();
        }
        return instance;
    }

    public ArrayList<BEProduktion> visOrdrer() throws SQLServerException, SQLException {
        return db.visOrdrer();
    }

    public ArrayList<BEProduktion> orderByUrgent() throws SQLServerException, SQLException {
        return db.orderByUrgent();
    }

    public ArrayList<BEProduktion> orderByMaterial() throws SQLServerException, SQLException {
        return db.orderByMaterial();
    }

    public ArrayList<BEProduktion> orderByDueDate() throws SQLServerException, SQLException {
        return db.orderByDueDate();
    }

    public ArrayList<BEProduktion> sortOrdrer() throws SQLServerException, SQLException {
        return db.orderByMaterial();
    }

    public ArrayList<BEProduktion> getOrderByOrderMaterial(BEProduktion p) throws SQLServerException, SQLException {
        return db.getOrderByOrderMaterial(p);
    }

    public ArrayList<BEProduktion> getOrderByMaterial(BEProduktion p) throws SQLServerException, SQLException
    {
        return db.getOrderByMaterial(p);
    }
}