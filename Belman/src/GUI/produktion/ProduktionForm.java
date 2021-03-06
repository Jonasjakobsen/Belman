/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.produktion;

import BE.BELager;
import BE.BEProduktion;
import BLL.BLLLagerManager;
import BLL.BLLProduktionManager;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class ProduktionForm extends javax.swing.JFrame implements Observer
{

    private BLLProduktionManager promgr;
    private BLLLagerManager lagmgr;
    private ProduktionFormTableModel promodel;
    private SortOrdreTableModel sortmodel;
    private SortLagerTableModel sortlagermodel;
    private LagerTableModel lagmodel;

    private BELager lager = null;
    private static ProduktionForm instance = null;

    /**
     * Creates new form ProduktionForm
     */
    public ProduktionForm() throws Exception
    {
        constructTables();
        centerTables();
        selectOrder();
        selectStockItem();
    }

    public static ProduktionForm getInstance() throws Exception
    {
        if (instance == null)
        {
            instance = new ProduktionForm();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpFilter = new javax.swing.ButtonGroup();
        lblIgangvaerendeProduktion = new javax.swing.JLabel();
        jscrpProdOrdre = new javax.swing.JScrollPane();
        jtblVaelgOrdre = new javax.swing.JTable();
        lblVaelgOrdre = new javax.swing.JLabel();
        jscrpVaelgOrdre = new javax.swing.JScrollPane();
        jtblSortOrdre = new javax.swing.JTable();
        btnAfbyd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblLager = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Belman Produktion");
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(950, 800));
        setMinimumSize(new java.awt.Dimension(950, 800));
        setName("Belman produktion"); // NOI18N
        setPreferredSize(new java.awt.Dimension(950, 800));

        lblIgangvaerendeProduktion.setText("Choose an order to produce");

        jtblVaelgOrdre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtblVaelgOrdre.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jscrpProdOrdre.setViewportView(jtblVaelgOrdre);

        lblVaelgOrdre.setText("Orders matching material in guillotine");

        jtblSortOrdre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jscrpVaelgOrdre.setViewportView(jtblSortOrdre);

        btnAfbyd.setText("Close program");
        btnAfbyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfbydActionPerformed(evt);
            }
        });

        jtblLager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblLager.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtblLager);

        jLabel2.setText("Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIgangvaerendeProduktion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jscrpProdOrdre, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))
                    .addComponent(jscrpVaelgOrdre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVaelgOrdre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAfbyd)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIgangvaerendeProduktion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jscrpProdOrdre, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addComponent(lblVaelgOrdre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscrpVaelgOrdre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAfbyd)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAfbydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfbydActionPerformed
        dispose();
    }//GEN-LAST:event_btnAfbydActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfbyd;
    private javax.swing.ButtonGroup btngrpFilter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jscrpProdOrdre;
    private javax.swing.JScrollPane jscrpVaelgOrdre;
    private javax.swing.JTable jtblLager;
    private javax.swing.JTable jtblSortOrdre;
    private javax.swing.JTable jtblVaelgOrdre;
    private javax.swing.JLabel lblIgangvaerendeProduktion;
    private javax.swing.JLabel lblVaelgOrdre;
    // End of variables declaration//GEN-END:variables

    private void constructTables() throws Exception
    {
        initComponents();
        setLocationRelativeTo(this);

        lagmgr = BLLLagerManager.getInstance();
        lagmgr.addObserver(this);
        lagmodel = new LagerTableModel(lagmgr.visLager());
        jtblLager.setModel(lagmodel);

        promgr = BLLProduktionManager.getInstance();
        promgr.addObserver(this);
        sortmodel = new SortOrdreTableModel(promgr.visOrdrer());
        jtblVaelgOrdre.setModel(sortmodel);
        promodel = new ProduktionFormTableModel(promgr.visOrdrer());
        jtblVaelgOrdre.setModel(promodel);

    }

    private void centerTables()
    {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jtblVaelgOrdre.setDefaultRenderer(String.class, centerRenderer);
        jtblVaelgOrdre.setDefaultRenderer(Float.class, centerRenderer);
        jtblVaelgOrdre.setDefaultRenderer(int.class, centerRenderer);
        jtblVaelgOrdre.setDefaultRenderer(Date.class, centerRenderer);
        jtblSortOrdre.setDefaultRenderer(String.class, centerRenderer);
        jtblSortOrdre.setDefaultRenderer(Float.class, centerRenderer);
        jtblSortOrdre.setDefaultRenderer(int.class, centerRenderer);
        jtblSortOrdre.setDefaultRenderer(Date.class, centerRenderer);
        jtblLager.setDefaultRenderer(String.class, centerRenderer);
        jtblLager.setDefaultRenderer(Float.class, centerRenderer);
        jtblLager.setDefaultRenderer(int.class, centerRenderer);
    }

    private void selectStockItem()
    {
        jtblLager.getSelectionModel().addListSelectionListener(new ListSelectionListener()
            {
                @Override
                public void valueChanged(ListSelectionEvent evt)
                {
                    sortmodel.clear();
                    int selectedStockRow = jtblLager.getSelectedRow();
                    if(selectedStockRow == -1)
                    {
                        return;
                    }
                    BELager p = lagmodel.getLagerByRow(selectedStockRow);

                    try
                    {
                        if (!lagmgr.getStockByOrderMaterial(p).isEmpty());
                        {
                            sortlagermodel = new SortLagerTableModel(lagmgr.getStockByOrderMaterial(p));
                            jtblSortOrdre.setModel(sortlagermodel);
                            jtblSortOrdre.getSelectionModel().addListSelectionListener(new ListSelectionListener()
                            {
                                @Override
                                public void valueChanged(ListSelectionEvent evt)
                                {
                                    int selectedRow = jtblSortOrdre.getSelectedRow();
                                    if(selectedRow == -1)
                                    {
                                        return;
                                    }
                                    BELager p = sortlagermodel.getOrderByRow(selectedRow);

                                }
                            });
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("ERROR -" + e.getMessage());
                    }
                }
            });
    }
    
    private void selectOrder()
    {
        jtblVaelgOrdre.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent evt)
            {
                sortmodel.clear();
                int selectedRow = jtblVaelgOrdre.getSelectedRow();
                if (selectedRow == -1)
                {
                    return;
                }
   
                BEProduktion p = promodel.getOrderByRow(selectedRow);

                try
                {
                    if (!promgr.getOrderByOrderMaterial(p).isEmpty());
                    {
                        sortmodel = new SortOrdreTableModel(promgr.getOrderByOrderMaterial(p));
                        jtblSortOrdre.setModel(sortmodel);
                        jtblSortOrdre.getSelectionModel().addListSelectionListener(new ListSelectionListener()
                        {
                            @Override
                            public void valueChanged(ListSelectionEvent evt)
                            {
                                int selectedRow = jtblSortOrdre.getSelectedRow();
                                if(selectedRow == -1)
                                {
                                    return;
                                }
                                BEProduktion p = sortmodel.getOrderByRow(selectedRow);

                            }
                        });
                    }
                }
                catch (Exception e)
                {
                    System.out.println("ERROR -" + e.getMessage());
                }
            }
        });
    }
    

    @Override
    public void update(Observable o, Object arg)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
