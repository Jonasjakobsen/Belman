package BLL;

import BE.BEProduktion;
import DAL.DALProduktionDBManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Christoffer, Jonas & Christian
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
    /**
     * Retrieves the visOrdrer method from the Data access layer     *
     * @returns visOrdrer
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BEProduktion> visOrdrer() throws SQLServerException, SQLException {
        return db.visOrdrer();
    }
//    /**
//     * Retrieves the orderByUrgent method from the Data access layer     *
//     * @returns orderByUrgent
//     * @throws SQLException, SQLServerException
//     */
//    public ArrayList<BEProduktion> orderByUrgent() throws SQLServerException, SQLException {
//        return db.orderByUrgent();
//    }
//    /**
//     * Retrieves the visOrdrer method from the Data access layer     *
//     * @returns visOrdrer
//     * @throws SQLException, SQLServerException
//     */
//    public ArrayList<BEProduktion> orderByMaterial() throws SQLServerException, SQLException {
//        return db.orderByMaterial();
//    }
//    /**
//     * Retrieves the visOrdrer method from the Data access layer     *
//     * @returns visOrdrer
//     * @throws SQLException, SQLServerException
//     */
//    public ArrayList<BEProduktion> orderByDueDate() throws SQLServerException, SQLException {
//        return db.orderByDueDate();
//    }
//    /**
//     * Retrieves the visOrdrer method from the Data access layer     *
//     * @returns visOrdrer
//     * @throws SQLException, SQLServerException
//     */
//    public ArrayList<BEProduktion> sortOrdrer() throws SQLServerException, SQLException {
//        return db.orderByMaterial();
//    }
    /**
     * Retrieves the visOrdrer method from the Data access layer     *
     * @returns visOrdrer
     * @throws SQLException, SQLServerException
     */
    public ArrayList<BEProduktion> getOrderByOrderMaterial(BEProduktion p) throws SQLServerException, SQLException {
        return db.getOrderByOrderMaterial(p);
    }
//    /**
//     * Retrieves the visOrdrer method from the Data access layer     *
//     * @returns visOrdrer
//     * @throws SQLException, SQLServerException
//     */
//    public ArrayList<BEProduktion> getOrderByMaterial(BEProduktion p) throws SQLServerException, SQLException
//    {
//        return db.getOrderByMaterial(p);
//    }
}