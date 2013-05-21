/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.events;

import BE.BEEvent;
import GUI.medlem.*;
import BE.BEMedlem;
import BLL.BLLEventManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Stoffer
 */
public class EventAddForm extends javax.swing.JDialog
{
    private MedlemTableModel medmodel;
    private BEMedlem medlem = null;

    /**
     * Creates new form addMedlemForm
     */
    public EventAddForm(java.awt.Frame parent, boolean modal) throws SQLServerException, SQLException
    {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        addEnterKeyListeners();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtBeskrivelse = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        btnAfbryd = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("Efternavn:");

        jLabel2.setText("Navn:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tilføj medlem");
        setLocationByPlatform(true);
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setType(java.awt.Window.Type.POPUP);

        jScrollPane1.setViewportView(jtxtBeskrivelse);

        jScrollPane1.setBounds(10, 30, 190, 120);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Arrangementbeskrivelse (Max 255 tegn)");
        jLabel5.setBounds(10, 10, 210, 14);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAfbryd.setText("Afbryd");
        btnAfbryd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAfbrydActionPerformed(evt);
            }
        });
        btnAfbryd.setBounds(30, 160, 80, 23);
        jLayeredPane1.add(btnAfbryd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAdd.setText("Tilføj");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.setBounds(120, 160, 80, 23);
        jLayeredPane1.add(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img/bg.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(0, 0, 220, 200);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAfbrydActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAfbrydActionPerformed
    {//GEN-HEADEREND:event_btnAfbrydActionPerformed
        dispose();
    }//GEN-LAST:event_btnAfbrydActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        String errorMessage = validateRequiredFields();
        if ("".contains(errorMessage))
        {
            try
            {
                String arrangementbeskrivelse = jtxtBeskrivelse.getText().trim();
                
                BEEvent e = new BEEvent (-1, arrangementbeskrivelse);
                BLLEventManager.getInstance().addEvent(e);
                JOptionPane.showMessageDialog(this, "Event tilføjet til databasen");
                clearFields();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
                System.out.println("ERROR" + e.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, errorMessage, getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

        
    private String validateRequiredFields()
    {
        String errorMessage = "";
        if (jtxtBeskrivelse == null || jtxtBeskrivelse.getText().trim().isEmpty())
        {
            errorMessage += "Du mangler at udfylde navn\n";
        }
        return errorMessage;
    }
    private void clearFields()
    {
        jtxtBeskrivelse.setText("");
    }
    
    private void addEnterKeyListeners()
    {
        KeyListener enterListener = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent ke)
            {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    btnAdd.doClick();
                }
            }
        };
        jtxtBeskrivelse.addKeyListener(enterListener);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAfbryd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtxtBeskrivelse;
    // End of variables declaration//GEN-END:variables
}
