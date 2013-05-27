/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Stoffer, Jonas & Christian
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

    
    
    public BELager(String Code, int MaterialID, String MaterialName, Float MaterialDensity, String ChargeNo, Float Length, Float Width, Float Thickness, Float StockQuantity) {
        this(-1, Code, MaterialID, MaterialName, MaterialDensity, ChargeNo, Length, Width, Thickness, StockQuantity);
    }

    /**
     * The main constructor to Lager.
     *
     * @param id
     * @param code
     * @param MaterialID
     * @param MaterialName
     * @param MaterialDensity
     * @param ChargeNo
     * @param Length
     * @param Width
     * @param Thickness
     * @param StockQuantity
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
    
    
    public BELager(int id, String Code, Float MaterialDensity, Float StockQuantity) {
        
        this.id = id;
        this.Code = Code;
        this.MaterialDensity = MaterialDensity;        
        this.StockQuantity = StockQuantity;
    }
    
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

}
