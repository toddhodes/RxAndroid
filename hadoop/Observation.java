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


public class Observation extends Coord {

    String timestamp;
    Float uncertainty;

    public String id() {
        return "noID";
    }
    

    public static Observation makeObs(String input) {
        Observation obs = null;
        String[] s = input.split("\t");
        if (s.length == 7) {
            CDMA_Obs o = new CDMA_Obs();
            o.bid = s[0];
            o.nid = s[1];
            o.sid = s[2];
            o.lon = Float.parseFloat(s[3]);
            o.lat = Float.parseFloat(s[4]);
            o.uncertainty = Float.parseFloat(s[5]);
            o.timestamp = s[6];
            obs = o;
        } else if (s.length == 8) {
            GSM_Obs o = new GSM_Obs();
            o.mcc = s[0];
            o.mnc = s[1];
            o.lac = s[2];
            o.cid = s[3];
            o.lon = Float.parseFloat(s[4]);
            o.lat = Float.parseFloat(s[5]);
            o.uncertainty = Float.parseFloat(s[6]);
            o.timestamp = s[7];
            obs = o;
            
        } else {
            System.out.println("ERROR: data has bad length ("
                               + s.length
                               +"): '" + input + "'");
        }
        
        return obs;
    }
    
}
 	


