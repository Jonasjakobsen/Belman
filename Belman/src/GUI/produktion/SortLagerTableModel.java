/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.produktion;

import BE.BELager;
import BLL.BLLLagerManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class SortLagerTableModel extends AbstractTableModel {

    private BLLLagerManager lm;
    private final String[] header = {"pOrder", "Due Date", "Quantity", "Coil Code", "Status", "Urgent"};
    private final Class[] columnTypes = {String.class, Date.class, Float.class, String.class, String.class, Boolean.class};
    private ArrayList<BELager> lager;

    public SortLagerTableModel() {
        try {
            lm = new BLLLagerManager();
        } catch (Exception ex) {
            System.out.println("lol");
        }
    }

    SortLagerTableModel(ArrayList<BELager> AllLager) {
        fireTableDataChanged();
        lager = AllLager;
    }

    @Override
    public int getRowCount() {
        return lager.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        {
            BELager l = lager.get(row);
            switch (col) {

                case 0:
                    return l.getProduktion().getPOrder();
                case 1:
                    return l.getProduktion().getDueDate();
                case 2:
                    return l.getProduktion().getQuantity();
                case 3:
                    return l.getProduktion().getMaterialName();
                case 4:
                    return l.getProduktion().getStatus();
                case 5:
                    return l.getProduktion().isUrgent();
            }
            return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return header[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return columnTypes[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return (false);
    }

    public void setCollection(Collection<BELager> list) {
        lager = new ArrayList<>(list);
        fireTableDataChanged();
    }

    BELager getOrderByRow(int row) {
        return lager.get(row);
    }

    void clear() {
        lager.clear();
    }
 
}
