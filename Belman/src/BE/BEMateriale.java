/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Stoffer, Jonas & Christian
 */
public class BEMateriale {
    private int id;
    private Float density;
    private String name;

    /**
     * The main constructor to Materiale.
     *
     * @param id
     * @param density
     * @param name
     */
    public BEMateriale(int id, Float density, String name)
    {
        this.id = id;
        this.density = density;
        this.name = name;
    }

    public BEMateriale(Float density, String name)
    {
        this(-1, density, name);
    }

    public BEMateriale(String name)
    {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the density
     */
    public double getDensity()
    {
        return density;
    }

    /**
     * @param density the density to set
     */
    public void setDensity(Float density)
    {
        this.density = density;
    }

    /**
     * @returnerne materialets id.
     */
    public int getId()
    {
        return id;
    }
}
