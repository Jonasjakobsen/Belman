/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.lager;

import BE.BELager;
import BLL.BLLLagerManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Groggy
 */
public class LagerVisForm extends javax.swing.JDialog {

    private BLLLagerManager lagmgr;
    private LagerTableModel lagmodel;
    private BELager lager = null;

    /**
     * Creates new form GUILagerDialog
     */
    public LagerVisForm(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);


        // Reference for the BLL layer.
        lagmgr = new BLLLagerManager();

        // Set the table model for the JTable
        lagmodel = new LagerTableModel(lagmgr.visLager());
        tblLager.setModel(lagmodel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnProduktion = new javax.swing.JToggleButton();
        btnAfbryd = new javax.swing.JToggleButton();
        pnlSortBy = new javax.swing.JPanel();
        rbtnThickness = new javax.swing.JRadioButton();
        rbtnWidth = new javax.swing.JRadioButton();
        rbtnLength = new javax.swing.JRadioButton();
        rbtnMaterialeID = new javax.swing.JRadioButton();
        rbtnDensity = new javax.swing.JRadioButton();
        rbtnStockQuantity = new javax.swing.JRadioButton();
        pnlSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLager = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Belman Lageroversigt");
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1200, 600));

        btnProduktion.setText("Produktion");
        btnProduktion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduktionActionPerformed(evt);
            }
        });

        btnAfbryd.setText("Afbryd");
        btnAfbryd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfbrydActionPerformed(evt);
            }
        });

        pnlSortBy.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sort by"));

        buttonGroup1.add(rbtnThickness);
        rbtnThickness.setText("Thickness");
        rbtnThickness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnThicknessActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnWidth);
        rbtnWidth.setText("Width");

        buttonGroup1.add(rbtnLength);
        rbtnLength.setText("Length");

        buttonGroup1.add(rbtnMaterialeID);
        rbtnMaterialeID.setText("Materiale ID");

        buttonGroup1.add(rbtnDensity);
        rbtnDensity.setText("Material Density");

        buttonGroup1.add(rbtnStockQuantity);
        rbtnStockQuantity.setSelected(true);
        rbtnStockQuantity.setText("Stock Quantity");

        javax.swing.GroupLayout pnlSortByLayout = new javax.swing.GroupLayout(pnlSortBy);
        pnlSortBy.setLayout(pnlSortByLayout);
        pnlSortByLayout.setHorizontalGroup(
            pnlSortByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortByLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSortByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnDensity)
                    .addComponent(rbtnMaterialeID)
                    .addComponent(rbtnLength)
                    .addComponent(rbtnWidth)
                    .addComponent(rbtnThickness)
                    .addComponent(rbtnStockQuantity))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSortByLayout.setVerticalGroup(
            pnlSortByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortByLayout.createSequentialGroup()
                .addComponent(rbtnThickness)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnWidth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnLength)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnMaterialeID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnDensity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(rbtnStockQuantity))
        );

        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search ID"));

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(tblLager);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlSortBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addGap(115, 115, 115))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProduktion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAfbryd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAfbryd, btnProduktion});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProduktion)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAfbryd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAfbryd, btnProduktion});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAfbrydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfbrydActionPerformed
        dispose();
    }//GEN-LAST:event_btnAfbrydActionPerformed

    private void rbtnThicknessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnThicknessActionPerformed
    }//GEN-LAST:event_rbtnThicknessActionPerformed

    private void btnProduktionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduktionActionPerformed
//        try
//            {
//                ProduktionForm prodForm = new ProduktionForm(this, true);
//                prodForm.pack();
//                prodForm.setVisible(true);
//             }
//        catch (Exception ex)
//        {
//            Logger.getLogger(GUIMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnProduktionActionPerformed
    /*
     * Checks which radiobutton is active and searches with the conditions that the
     * radiobutton indicates
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        if (rbtnStockQuantity.isSelected() == true) {
            lagmodel.clear();
            try {

                lagmodel = new LagerTableModel(lagmgr.orderByStockQuantity());
                tblLager.setModel(lagmodel);
            } catch (Exception ex) {
                Logger.getLogger(LagerVisForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rbtnDensity.isSelected() == true) {
            lagmodel.clear();
            try {

                lagmodel = new LagerTableModel(lagmgr.orderByDensity());
                tblLager.setModel(lagmodel);
            } catch (Exception ex) {
                Logger.getLogger(LagerVisForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rbtnMaterialeID.isSelected() == true) {
            lagmodel.clear();
            try {

                lagmodel = new LagerTableModel(lagmgr.orderByMaterialID());
                tblLager.setModel(lagmodel);
            } catch (Exception ex) {
                Logger.getLogger(LagerVisForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rbtnWidth.isSelected() == true) {
            lagmodel.clear();
            try {

                lagmodel = new LagerTableModel(lagmgr.orderByWidth());
                tblLager.setModel(lagmodel);
            } catch (Exception ex) {
                Logger.getLogger(LagerVisForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rbtnLength.isSelected() == true) {
            lagmodel.clear();
            try {

                lagmodel = new LagerTableModel(lagmgr.orderByLength());
                tblLager.setModel(lagmodel);
            } catch (Exception ex) {
                Logger.getLogger(LagerVisForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rbtnThickness.isSelected() == true) {
            lagmodel.clear();
            try {
                lagmodel = new LagerTableModel(lagmgr.orderByThickness());
                tblLager.setModel(lagmodel);
            } catch (Exception ex) {
                Logger.getLogger(LagerVisForm.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }//GEN-LAST:event_btnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAfbryd;
    private javax.swing.JToggleButton btnProduktion;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSortBy;
    private javax.swing.JRadioButton rbtnDensity;
    private javax.swing.JRadioButton rbtnLength;
    private javax.swing.JRadioButton rbtnMaterialeID;
    private javax.swing.JRadioButton rbtnStockQuantity;
    private javax.swing.JRadioButton rbtnThickness;
    private javax.swing.JRadioButton rbtnWidth;
    private javax.swing.JTable tblLager;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
