package user;
import org.apache.hadoop.io.* ;
import org.apache.hadoop.hive.ql.exec.UDF ;
public class Index extends UDF{
	
	
	public Text evaluate(Text val,Text v)
	{
		int v1 = Integer.parseInt(v.toString()) ;
		boolean flag = false ;
		if(val==null)
			return null ;
		
		String num = val.toString() ;
		//int l = st.length();
		//String num = st.substring(1,l-1) ;
		
		if((num.substring(0,1)).equals("-"))      // IF A VALUE IS NEGATIVE
		{
			num = num.substring(1) ;
			flag = true ;
		}
		
		float n = Float.parseFloat(num) ;
		int x = (int) Math.floor(n) ;
		
		int ans = (x/5) ;
		
		if(ans==0)
		{
			if(v1==-1)
			{
				if(flag==false)
				    { ans=0 ;
				      flag=true ;
				    }
				
				else
				    ans = 1;
			}
			
			else if(v1==1)
			{
				if(flag==true)
					{ ans=0 ;
					  flag=false ;
					}
					
				else
				    ans = 1;
			}
			
		}
		
		else
		{
			ans += v1;
		}
		
		if(flag==false)
		{
			return (new Text(String.valueOf(ans))) ;
		}
		
		else
		{
			return (new Text("-"+String.valueOf(ans)) ) ;
		}
	}

}
