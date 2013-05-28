/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BELager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Stoffer
 */
public class BLLLagerManagerTest
{
    static BLLLagerManager lagmgr;
    
    public BLLLagerManagerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception
    {
        System.out.println("-------Starting jUnittest-------");
        lagmgr = BLLLagerManager.getInstance();
    }

    @AfterClass
    public static void tearDownClass()
    {
        
    }

    public void testConstructOrderManager()
    {
    }

    /**
     * Test of getInstance method, of class BLLLagerManager.
     * Testing if the getInstance(); method works in the BLLLagerManager.
     * Will show this by returning all the stockitems in our database.
     */
    @Test
    public void testGetInstance() throws Exception
    {
        System.out.println("Testing getInstance for the BLLLagerManager : ");
        try
        {
            lagmgr = BLLLagerManager.getInstance();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("ERROR - lagmgr threw a fileNotFoundException: " + ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println("ERROR - lagmgr threw a inputOutputException: " + ex.getMessage());

        }
        System.out.println("Showing number of stockitems in the database");
        System.out.println("Number of stockitems : " + lagmgr.visLager().size());
        System.out.println("");
        System.out.println("");
    }
    
    /**
     * Test of getStockByOrderMaterial method, of class BLLLagerManager.
     * This method will create a new BELager object, and send this Object
     * to the DAL layer. Then it will return the production orders containing
     * the material coiltype in the BELager object in an ArrayList
     * which we will print out in a string.
     */
    @Test
    public void testGetStockByOrderMaterial() throws Exception
    {
        System.out.println("Testing the method 'GetStockByOrderMaterial'");
        System.out.println("This method will return the orders, matching the"
                         + "material from the item chosen in the stock list.");
        
        System.out.println("\nCreating a stock item, to sort by.");
        
                int id = 1000;
                String Code = "RP-05/39";
                int MaterialID = 20000;
                String MaterialName = "14541";
                Float MaterialDensity = 7.9f;
                String ChargeNo = "N32595";
                Float Length = 300f;
                Float Width = 5f;
                Float Thickness = 5f;
                Float StockQuantity = 40.0f;
                
                BELager l = new BELager(id, Code, MaterialID, MaterialName, 
                MaterialDensity, ChargeNo, Length, Width, Thickness, 
                StockQuantity);
        
        System.out.println("The stockitem created:");
        System.out.println("CoilCode :" + l.getCode() +
                           " | Material Density :" + l.getMaterialDensity() + 
                           " | StockQuantity :" + l.getStockQuantity());
        
        System.out.println("\nShowing the orders matching the material "
                         + "in the selected stockitem.");
        ArrayList<BELager> stockByOrderMaterial = lagmgr.getStockByOrderMaterial(l);
        
        System.out.println("Number of Orders matching the material in the "
                          + "selected stockitem selected : "
                          + lagmgr.getStockByOrderMaterial(l).size());
        
        System.out.println("\nPrinting out the arraylist, showing the orders "
                         + " matching material in the selected stockitem");
        System.out.println("Coil Code    Production Order         Due Date    "
                + "    Quantity        Status     Urgent");
        System.out.println(stockByOrderMaterial.toString());
        
        System.out.println("");
        System.out.println("");
    }
}
