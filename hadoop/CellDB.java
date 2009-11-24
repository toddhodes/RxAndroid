package com.wavemarket.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


// GSM: (5,6) of 8
// 310     410     56994   787655  -122.291068333333       37.840315       132     1249528508

// CDMA: (4,5) of 7
// 4       264     4183    -122.29113      37.84064        67.88   1249533613


public class CellDB {
 	
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable> {


        /** Done:    
            - create average cell locations
            - ### remove cells with too few observations ###

            Todo:
            - ### remove outliers ###
            - ### remove cells with too little uncertainty ###
        */


 	
        public void map(LongWritable key, 
                        Text value, 
                        OutputCollector<Text, FloatWritable> output, 
                        Reporter reporter) throws IOException {

            String line = value.toString();
            Observation obs = Observation.makeObs(line);
            Text id = new Text();

            FloatWritable lon = new FloatWritable(obs.lon);
            id.set(obs.id() + "-lon");
            output.collect(id, lon);

            FloatWritable lat = new FloatWritable(obs.lat);
            id.set(obs.id() + "-lat");
            output.collect(id, lat);

            id.set(obs.id() + "-uncert");
            output.collect(id, new FloatWritable(obs.uncertainty));
        }
    }


    public static class Reduce extends MapReduceBase implements Reducer<Text, FloatWritable, Text, FloatWritable> {
        public void reduce(Text key, 
                           Iterator<FloatWritable> values, 
                           OutputCollector<Text, FloatWritable> output, 
                           Reporter reporter) throws IOException {

            float sum = 0.0f;
            int count = 0;
            while (values.hasNext()) {
                sum += values.next().get();
                count++;
            }

            // ### remove cells with too few observations ###
            int min_observations = 4;
            if (count >= min_observations)
                output.collect(key, new FloatWritable(sum/count));
            else
                output.collect(key, new FloatWritable(count*-1.0f));
        }
    }


    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(CellDB.class);
        conf.setJobName("centroid");
 	
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(FloatWritable.class);
 	
        conf.setMapperClass(Map.class);
        conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);
 	
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
 	
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
        JobClient.runJob(conf);
    }


}
 	


