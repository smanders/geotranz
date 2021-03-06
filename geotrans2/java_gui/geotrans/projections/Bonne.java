/*
 * Bonne.java
 *
 * Created on April 10, 2001, 12:26 PM
 */

package geotrans.projections;

/**
 *
 * @author  amyc
 * @version 
 */
public class Bonne extends Object {

    // Parameters
    private double origin_latitude;   
    private double central_meridian;  
    private double false_easting;     
    private double false_northing;    

    // Coordinates
    private double easting;
    private double northing;
    
    /** Creates new Bonne */
    public Bonne() {
    }
    
    public Bonne(double olat, 
                 double cent_merid,
                 double feast,
                 double fnorth) 
    {
        origin_latitude = olat;
        central_meridian = cent_merid;
        false_easting = feast;
        false_northing = fnorth;
    }
    
    public Bonne(double east, 
                 double north) 
    {
        easting = east;
        northing = north;
    }
    
    public double getOriginLatitude()
    {
        return origin_latitude;
    }
    
    public double getCentralMeridian()
    {
        return central_meridian;
    }

    public double getFalseEasting()
    {
        return false_easting;
    }
    
    public double getFalseNorthing()
    {
        return false_northing;
    }

    public double getEasting()
    {
        return easting;
    }
    
    public double getNorthing()
    {
        return northing;
    }
}
