package Convert;
import java.io.* ;

import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.* ;

public class FileMain {
	public static void main(String[] args) throws Exception
	{

		Job job = new Job() ;
		job.setJarByClass(FileMain.class) ;
		job.setMapperClass(FileMapper.class);
		job.setReducerClass(FileReducer.class) ;
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class) ;
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
				
		//job.setNumReduceTasks(0);
		
		job.waitForCompletion(true) ;
	 
	}

}
