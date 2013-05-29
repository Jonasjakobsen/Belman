/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public abstract class DALBelmanDBManager
{
     protected SQLServerDataSource ds;

    /**
     * This is the connectionstring to the database. The login information
     * is stored in an external config file, so we don't have hardcoded information
     * in the code.
     * @throws Exception
     */
    public DALBelmanDBManager() throws Exception
    {
        Properties props = new Properties();
        props.load(new FileReader("Belman.cfg"));

        ds = new SQLServerDataSource();

        ds.setServerName(props.getProperty("SERVER"));
        ds.setInstanceName(props.getProperty("INSTANCENAME"));
        ds.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
        ds.setDatabaseName(props.getProperty("DATABASE"));
        ds.setUser(props.getProperty("USER"));
        ds.setPassword(props.getProperty("PASSWORD"));
    }
    
}
