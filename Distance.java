package haversine;
import org.apache.hadoop.hive.ql.exec.UDF ;
import org.apache.hadoop.io.* ;
public class Distance extends UDF{
	public double evaluate(Text citylat, Text citylong, Text userlat, Text userlong)
	{
		  double lat1 = Double.parseDouble(citylat.toString());
		  double long1 = Double.parseDouble(citylong.toString());
		  double lat2 = Double.parseDouble(userlat.toString()); ;
		  double long2 = Double.parseDouble(userlong.toString()) ;
		  
		  Distance obj = new Distance() ;
		  double a = obj.hav(lat2-lat1) ;
		  double b = Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))* obj.hav(long2-long1) ;
		  int r = 6371 ;
		  return (2 * r * Math.asin(Math.sqrt(a+b))) ;
		  
	}
	
	public double hav(double value)
	{
		double a = Math.toRadians(value) ;
		return Math.pow(Math.sin(a/2), 2) ;
	}

}
