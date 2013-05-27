/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Stoffer, Jonas & Christian
 */
public class BEStockItem {
    private final int id;
    private String chargeNo;
    private Float length;
    private Float stockQuantity;
    private int coilTypeId;
    private int sleeveId;
    private BECoilType coilType;
    private BEMateriale material;
    
    /**
     * Den overordnede konstruktør til CoilType.
     *
     * @param id
     * @param chargeNo
     * @param length
     * @param stockQuantity
     * @param coilTypeId
     * @param sleeveId
     * @param BECoilType coilType
     * @param BEMateriale material
     */

    public BEStockItem(int id, String chargeNo, Float length, Float stockQuantity, int coilTypeId, int sleeveId, BECoilType coilType, BEMateriale material)
    {
        this.id = id;
        this.chargeNo = chargeNo;
        this.length = length;
        this.stockQuantity = stockQuantity;
        this.coilTypeId = coilTypeId;
        this.sleeveId = sleeveId;
        this.coilType = coilType;
        this.material = material;
    }

    public BEStockItem(int id, BEStockItem item)
    {
        this(id,
                item.getChargeNo(),
                item.getLength(),
                item.getStockQuantity(),
                item.getCoilTypeId(),
                item.getSleeveId(),
                item.getCoilType(),
                item.getMaterial());                
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the chargeNo
     */
    public String getChargeNo()
    {
        return chargeNo;
    }

    /**
     * @param chargeNo the chargeNo to set
     */
    public void setChargeNo(String chargeNo)
    {
        this.chargeNo = chargeNo;
    }

    /**
     * @return the length
     */
    public Float getLength()
    {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Float length)
    {
        this.length = length;
    }

    /**
     * @return the stockQuantity
     */
    public Float getStockQuantity()
    {
        return stockQuantity;
    }

    /**
     * @param stockQuantity the stockQuantity to set
     */
    public void setStockQuantity(Float stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }

    /**
     * @return the coilTypeId
     */
    public int getCoilTypeId()
    {
        return coilTypeId;
    }

    /**
     * @param coilTypeId the coilTypeId to set
     */
    public void setCoilTypeId(int coilTypeId)
    {
        this.coilTypeId = coilTypeId;
    }

    /**
     * @return the sleeveId
     */
    public int getSleeveId()
    {
        return sleeveId;
    }

    /**
     * @param sleeveId the sleeveId to set
     */
    public void setSleeveId(int sleeveId)
    {
        this.sleeveId = sleeveId;
    }

    /**
     * @return the coilType
     */
    public BECoilType getCoilType()
    {
        return coilType;
    }

    /**
     * @param coilType the coilType to set
     */
    public void setCoilType(BECoilType coilType)
    {
        this.coilType = coilType;
    }

    /**
     * @return the material
     */
    public BEMateriale getMaterial()
    {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(BEMateriale material)
    {
        this.material = material;
    }
}
