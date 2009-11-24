package com.wavemarket.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;



public class GSM_Obs extends Observation {
    String mcc;
    String mnc;
    String lac;
    String cid;

    public String id() {
        return mcc+","+mnc+","+lac+","+cid;
    }
}



