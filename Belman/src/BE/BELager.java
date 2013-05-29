/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Christoffer, Jonas & Christian
 */
public class BELager {

    private final int id;
    private String Code;
    private int MaterialID;
    private String MaterialName;
    private Float MaterialDensity;
    private String ChargeNo;
    private Float Length;
    private Float Width;
    private Float Thickness;
    private Float StockQuantity; 
    private BEProduktion produktion;

    
    
    /**
     * The constructor for the BELager class.
     * @param Code - The coilCode in the BELager.
     * @param MaterialID - The material ID, identifying the material.
     * @param MaterialName - The material name.
     * @param MaterialDensity - The density of the material.
     * @param ChargeNo - The chargeNo of the coil.
     * @param Length - The length of the material in stock.
     * @param Width - The width of the material in stock.
     * @param Thickness - The thickness of the material in stock.
     * @param StockQuantity - The stockquantity of the material in stock.
     */
    public BELager(String Code, int MaterialID, String MaterialName, 
            Float MaterialDensity, String ChargeNo, Float Length, 
            Float Width, Float Thickness, Float StockQuantity) 
    {
        this(-1, Code, MaterialID, MaterialName, MaterialDensity, 
                ChargeNo, Length, Width, Thickness, StockQuantity);
    }

    /**
     * The constructor for the BELager class.
     * @param id - The ID for the BELager constructor.
     * @param Code - The coilCode in the BELager.
     * @param MaterialID - The material ID, identifying the material.
     * @param MaterialName - The material name.
     * @param MaterialDensity - The density of the material.
     * @param ChargeNo - The chargeNo of the coil.
     * @param Length - The length of the material in stock.
     * @param Width - The width of the material in stock.
     * @param Thickness - The thickness of the material in stock.
     * @param StockQuantity - The amount in stock on the coil.
     */
    
    public BELager(int id, String Code, int MaterialID, String MaterialName, Float MaterialDensity, String ChargeNo, Float Length, Float Width, Float Thickness, Float StockQuantity) {
        this.id = id;
        this.Code = Code;
        this.MaterialID = MaterialID;
        this.MaterialName = MaterialName;
        this.MaterialDensity = MaterialDensity;
        this.ChargeNo = ChargeNo;
        this.Length = Length;
        this.Width = Width;
        this.Thickness = Thickness;
        this.StockQuantity = StockQuantity;

    }
    
    
    /**
     * The constructor for the BELager class.
     * @param id - the ID of the BELager.
     * @param Code - The coilcode of the coil in stock.
     * @param MaterialDensity - The material density for the coil in stock.
     * @param StockQuantity - The amount in stock on the coil.
     */
    public BELager(int id, String Code, Float MaterialDensity, Float StockQuantity) {
        
        this.id = id;
        this.Code = Code;
        this.MaterialDensity = MaterialDensity;        
        this.StockQuantity = StockQuantity;
    }
    
    /**
     * The constructor for the BELager class.
     * @param id - the ID of the BELager.
     * @param Code - The coilcode of the coil in stock.
     * @param MaterialDensity - The material density for the coil in stock.
     * @param StockQuantity - The amount in stock on the coil.
     * @param produktion - Getting the constructor from the BEProduktion class.
     */
    public BELager(int id, String Code, Float MaterialDensity, Float StockQuantity, BEProduktion produktion) {
        this.id = id;
        this.Code = Code;
        this.MaterialDensity = MaterialDensity;        
        this.StockQuantity = StockQuantity;
        this.produktion = produktion;
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @return the MaterialID
     */
    public int getMaterialID() {
        return MaterialID;
    }

    /**
     * @return the MaterialName
     */
    public String getMaterialName() {
        return MaterialName;
    }

    /**
     * @return the MaterialDensity
     */
    public Float getMaterialDensity() {
        return MaterialDensity;
    }

    /**
     * @return the ChargeNo
     */
    public String getChargeNo() {
        return ChargeNo;
    }

    /**
     * @return the Length
     */
    public Float getLength() {
        return Length;
    }

    /**
     * @return the Width
     */
    public Float getWidth() {
        return Width;
    }

    /**
     * @return the Thickness
     */
    public Float getThickness() {
        return Thickness;
    }

    /**
     * @return the StockQuantity
     */
    public Float getStockQuantity() {
        return StockQuantity;
    }

    /**
     * @return the produktion
     */
    public BEProduktion getProduktion()
    {
        return produktion;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-10s %-10s", Code, produktion);
    }

}
