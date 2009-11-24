package com.wavemarket.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


public class CDMA_Obs extends Observation {
    String bid;
    String nid;
    String sid;

    public String id() {
        return bid+","+nid+","+sid;
    }
}

    



