/*
 * NeysParameters.java
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
public class NeysParameters extends CoordinateSystemParameters
{
  private double centralMeridian;
  private double originLatitude;
  private double standardParallel1;
  private double falseEasting;
  private double falseNorthing;

  
  /** Creates a new instance of NeysParameters */
  public NeysParameters(int coordinateType, double _centralMeridian, double _originLatitude, double _standardParallel1, double _falseEasting, double _falseNorthing) 
  {
    super(coordinateType);
    
    centralMeridian = _centralMeridian;
    originLatitude = _originLatitude;
    standardParallel1 = _standardParallel1;
    falseEasting = _falseEasting;
    falseNorthing = _falseNorthing;
  }
  
  
  public double getCentralMeridian()
  {
    return centralMeridian;
  }


  public double getOriginLatitude()
  {
    return originLatitude;
  }


  public double getStandardParallel1()
  {
    return standardParallel1;
  }


  public double getFalseEasting()
  {
    return falseEasting;
  }


  public double getFalseNorthing()
  {
    return falseNorthing;
  }
}
