/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.produktion;

import BE.BEProduktion;
import BLL.BLLProduktionManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class ProduktionFormTableModel extends AbstractTableModel {

    private BLLProduktionManager pm;
    private final String[] header = {"pOrder", "Due Date", "Quantity", "Coil Code", "Status", "Urgent"};
    private final Class[] columnTypes = {String.class, Date.class, Float.class, String.class, String.class, Boolean.class};
    private ArrayList<BEProduktion> produktion;

    public ProduktionFormTableModel() {
        try {
            pm = new BLLProduktionManager();
        } catch (Exception ex) {
            System.out.println("lol");
        }
    }

    ProduktionFormTableModel(ArrayList<BEProduktion> AllProduktion) {
        fireTableDataChanged();
        produktion = AllProduktion;
    }

    @Override
    public int getRowCount() {
        return produktion.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        {
            BEProduktion p = produktion.get(row);
            switch (col) {


                case 0:
                    return p.getPOrder();
                case 1:
                    return p.getDueDate();
                case 2:
                    return p.getQuantity();
                case 3:
                    return p.getMaterialName();
                case 4:
                    return p.getStatus();
                case 5:
                    return p.isUrgent();
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

    public void setCollection(Collection<BEProduktion> list) {
        produktion = new ArrayList<>(list);
        fireTableDataChanged();
    }

    BEProduktion getOrderByRow(int row) {
        return produktion.get(row);
    }

    void clear() {
        produktion.clear();
    }
    
    
    @Override
    public void setValueAt(Object o, int row, int col)
    {
            BEProduktion p = produktion.get(row);
            switch (col) {


                case 0: p.getPOrder(); break;
                case 1: p.getDueDate(); break;
                case 2: p.getQuantity(); break;
                case 3: p.getMaterialName(); break;
            }
        }

    BEProduktion getOrderByMaterial(int selectedRow2) {
        return produktion.get(selectedRow2);
    }
    
}
