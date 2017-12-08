package Convert;
import java.util.regex.* ;
import java.io.* ;
import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;
public class FileReducer extends Reducer<Text,Text,Text,Text> {
	
	@Override
	public void reduce(Text key,Iterable<Text> value, Context context) throws IOException, InterruptedException
	{   
		String ans = "," ;
		String first = "" ;
		String sec = "" ;
	
		for(Text t : value)
		{   
			String prefix = "(.)+(|)(\")((-)?(.)+)(\")" ;
			
			String st = new FileReducer().Extract(t.toString(), prefix) ;
			
			String chk = st.substring(0,3) ;  // THIS WILL CONTAIN EITHER lat OR lon
			
		 
			if(chk.equals("lat"))
			{
				first = st ;    
			}
			
			else
			{
				sec = st ;
			} 
				
		}
		
		ans = "^"+first+"^"+sec ;           // HERE DELIMITER IS ^ 
		
		context.write(key, new Text(ans));
	}
	
	public String Extract(String data , String prefix)
	{
		String ans = "" ;
		Pattern pattern = Pattern.compile(prefix);
		Matcher matcher = pattern.matcher(data);
		if (matcher.find())
		{
		    ans = matcher.group(0);
		}
		
		return ans ;
	}

}
