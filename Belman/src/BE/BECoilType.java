/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Stoffer, Jonas & Christian
 */
public class BECoilType {
     private final int id;
    private String code;
    private Float width;
    private Float thickness;
    private int materialId;

    /**
     * The main constructor to CoilType.
     *
     * @param id
     * @param code
     * @param width
     * @param thickness
     * @param materialId
     */
    public BECoilType(int id, String code, Float width, Float thickness, int materialId)
    {
        this.id = id;
        this.code = code;
        this.width = width;
        this.thickness = thickness;
        this.materialId = materialId;
    }

    public BECoilType(int id, BECoilType c)
    {
        this(id,
                c.getCode(),
                c.getWidth(),
                c.getThickness(),
                c.getMaterialId());
    }

    public BECoilType(String code, Float width, Float thickness, int materialId)
    {
        this(-1, code, width, thickness, materialId);
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * @return the width
     */
    public Float getWidth()
    {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Float width)
    {
        this.width = width;
    }

    /**
     * @return the thickness
     */
    public Float getThickness()
    {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(Float thickness)
    {
        this.thickness = thickness;
    }

    /**
     * @return the materialId
     */
    public int getMaterialId()
    {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(int materialId)
    {
        this.materialId = materialId;
    }
}
