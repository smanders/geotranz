/*
 * ObliqueMercatorParameters.java
 *
 * Created on April 4, 2007, 8:50 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geotrans.parameters;


/**
 *
 * @author comstam
 */
public class ObliqueMercatorParameters extends CoordinateSystemParameters
{
  private double originLatitude;
  private double longitude1;
  private double latitude1;
  private double longitude2;
  private double latitude2;
  private double falseEasting;
  private double falseNorthing;
  private double scaleFactor;

  
  /** Creates a new instance of ObliqueMercatorParameters */
  public ObliqueMercatorParameters(int coordinateType, double _originLatitude, double _longitude1, double _latitude1, double _longitude2, double _latitude2, double _falseEasting, double _falseNorthing, double _scaleFactor) 
  {
    super(coordinateType);
    
    originLatitude = _originLatitude;
    longitude1 = _longitude1;
    latitude1 = _latitude1;
    longitude2 = _longitude2;
    latitude2 = _latitude2;
    falseEasting = _falseEasting;
    falseNorthing = _falseNorthing;
    scaleFactor = _scaleFactor;
  }
  
  
  public double getOriginLatitude()
  {
    return originLatitude;
  }


  public double getLongitude1()
  {
    return longitude1;
  }


  public double getLatitude1()
  {
    return latitude1;
  }


  public double getLongitude2()
  {
    return longitude2;
  }


  public double getLatitude2()
  {
    return latitude2;
  }


  public double getFalseEasting()
  {
    return falseEasting;
  }


  public double getFalseNorthing()
  {
    return falseNorthing;
  }
  
  
  public double getScaleFactor()
  {
    return scaleFactor;
  }
}
