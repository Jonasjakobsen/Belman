/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.produktion;

import BE.BELager;
import BLL.BLLLagerManager;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class LagerTableModel extends AbstractTableModel
{

    private BLLLagerManager lm;
    private final String[] header =
    {
        "Coil Code", "Material density", "Stock quantity(kg)"
    };
    private final Class[] columnTypes =
    {
        String.class, Float.class, Float.class
    };
    private ArrayList<BELager> lager;
    
    /**
     * Creates a new BLLLagermanager, to be able to run the methods from the 
     * BLLLagerManager in the LagerTable Model.
     */
    public LagerTableModel()
    {
        try
        {
            lm = new BLLLagerManager();
        }
        catch (Exception ex)
        {
            System.out.println("lol");
        }
    }
    LagerTableModel(ArrayList<BELager> AllLager)
    {
        fireTableDataChanged();
        lager = AllLager;
    }

    @Override
    public int getRowCount()
    {
        return lager.size();
    }

    @Override
    public int getColumnCount()
    {
        return header.length;
    }
    

    @Override
    public Object getValueAt(int row, int col)
    {
        {
            BELager l = lager.get(row);
            switch (col)
            {
                case 0:
                    return l.getCode();
                case 1:
                    return l.getMaterialDensity();                
                case 2:
                    return l.getStockQuantity();
            }
            return null;
        }
    }

    @Override
    public String getColumnName(int col)
    {
        return header[col];
    }

    @Override
    public Class<?> getColumnClass(int col)
    {
        return columnTypes[col];
    }

    @Override
    public boolean isCellEditable(int row, int col)
    {
        return (false);
    }
    
    
    public void clear()
    {
         lager.clear();
    }
    

    public void setCollection(Collection<BELager> list)
    {
        lager = new ArrayList<>(list);
        fireTableDataChanged();
    }

    BELager getLagerByRow(int row)
    {
        return lager.get(row);
    }
}
