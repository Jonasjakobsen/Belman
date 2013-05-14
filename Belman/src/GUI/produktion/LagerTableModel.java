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
 * @author Stoffer
 */
public class LagerTableModel extends AbstractTableModel
{

    private BLLLagerManager lm;
    private final String[] header =
    {
        "Material name", "Material density", "Stock quantity(kg)"
    };
    private final Class[] columnTypes =
    {
        String.class, Float.class, Float.class
    };
    private ArrayList<BELager> lager;
    
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
                    return l.getMaterialName();
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

    BELager getMedlemByRow(int row)
    {
        return lager.get(row);
    }
}
