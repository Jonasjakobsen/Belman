/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.Date;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class BEProduktion {
    
    private final int SOrderID;
    private String SOrder;
    private int POrderID;
    private String POrder;
    private boolean Urgent;
    private Date DueDate;
    private float Quantity;
    private int MaterialID;
    private float Thickness;
    private float Width;
    private float Circumference;
    private String status;
    private int sleeveID;
    private String materialName;
    private BELager lager;
    private int employeeNo;
    private Float coilLength;
    private String coilCode;
    
    
    
    /**
     * The constructor for the BEProduction class
     * @param SOrderID - The salesorder ID to identify a specific sales order
     * @param SOrder - The salesorder number.
     * @param POrderID - The production ID to identify a specific production order
     * @param POrder - The productionorder number.
     * @param Urgent - Boolean to mark an order as urgent.
     * @param DueDate - The duedate for an order to be finished.
     * @param Quantity - The quantity of finished products needed to be produced.
     * @param MaterialID - The id of the material needed to produce this order.
     * @param Thickness - The thickness of the material.
     * @param Width - The width of the material.
     * @param Circumference - The circumference of the finished sleeve.
     */
    public BEProduktion (int SOrderID, String SOrder, int POrderID, 
                        String POrder, boolean Urgent, Date DueDate, Float Quantity,
                        int MaterialID, Float Thickness, Float Width,
                        Float Circumference, String coilCode)
    {
        this.SOrderID = SOrderID;
        this.SOrder = SOrder;
        this.POrderID = POrderID;
        this.POrder = POrder;
        this.Urgent = Urgent;
        this.DueDate = DueDate;
        this.Quantity = Quantity;
        this.MaterialID = MaterialID;
        this.Thickness = Thickness;
        this.Width = Width;
        this.Circumference = Circumference;
        this.coilCode = coilCode;
    }

    public BEProduktion(int SOrderID, String pOrder, Date DueDate, 
            Float quantity, String materialName, String status, 
            Boolean urgent, int employeeNo, Float coilLength, 
            Float coilWidth, String coilCode)
    {
        this.SOrderID = SOrderID;
        this.POrder = pOrder;
        this.DueDate = DueDate;
        this.Quantity = quantity;
        this.materialName = materialName;
        this.status = status;
        this.Urgent = urgent;
        this.employeeNo = employeeNo;
        this.coilLength = coilLength;
        this.Width = coilWidth;
        this.coilCode = coilCode;
    }
    

    /**
     * @return the SOrderID
     */
    public int getSOrderID() {
        return SOrderID;
    }

    /**
     * @return the SOrder
     */
    public String getSOrder() {
        return SOrder;
    }

    /**
     * @return the POrderID
     */
    public int getPOrderID() {
        return POrderID;
    }

    /**
     * @return the POrder
     */
    public String getPOrder() {
        return POrder;
    }

    /**
     * @return the DueDate
     */
    public Date getDueDate() {
        return DueDate;
    }

    /**
     * @return the Quantity
     */
    public float getQuantity() {
        return Quantity;
    }

    /**
     * @return the Thickness
     */
    public float getThickness() {
        return Thickness;
    }

    /**
     * @return the Width
     */
    public float getWidth() {
        return Width;
    }

    /**
     * @return the Circumference
     */
    public float getCircumference() {
        return Circumference;
    }

    /**
     * @return the Urgent
     */
    public boolean isUrgent() {
        return Urgent;
    }

    /**
     * @return the MaterialID
     */
    public int getMaterialID() {
        return MaterialID;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the sleeveID
     */
    public int getSleeveID() {
        return sleeveID;
    }

    /**
     * @return the materialName
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * @return the employeeNo
     */
    public int getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo the employeeNo to set
     */
    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return the coilLength
     */
    public Float getCoilLength() {
        return coilLength;
    }

    /**
     * @param coilLength the coilLength to set
     */
    public void setCoilLength(Float coilLength) {
        this.coilLength = coilLength;
    }

    /**
     * @return the coilCode
     */
    public String getCoilCode()
    {
        return coilCode;
    }


    /**
     * @return the lager
     */
    public BELager getLager()
    {
        return lager;
    }

    /**
     * @param lager the lager to set
     */
    public void setLager(BELager lager)
    {
        this.lager = lager;
    }


    @Override
    public String toString()
    {
        return String.format("%-25s %-15s %-15s %-10s %-5s\n", POrder, 
                             DueDate, Quantity, status, Urgent );
    }
    
}
