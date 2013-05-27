package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Stoffer, Jonas & Christian
 * Lager DB Manager The data Access Layer
 */
public class DALMedarbejderDBManager extends DALBelmanDBManager {


    public DALMedarbejderDBManager() throws Exception {
        super();
    }

    public boolean logIn(int Id, String Password, boolean isLoggedIn) throws Exception {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM Employee WHERE EmployeeID = ? AND Password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                isLoggedIn = true;


            }
            return isLoggedIn;

        }
    }
}
