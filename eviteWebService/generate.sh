#!/bin/bash

# To get libs:
#svn co svn://svn/wm/third_party/trunk/axis/1.2RC2/lib axis-1.2
#svn co svn://svn/wm/third_party/trunk/axis/1.4/lib axis-1.4
#svn co svn://svn/wm/third_party/trunk/j2ee/5.02/lib j2ee

# axis 1.2RC2
CLASSPATH=
CLASSPATH=$CLASSPATH:axis/axis.jar
CLASSPATH=$CLASSPATH:axis/commons-logging.jar
CLASSPATH=$CLASSPATH:axis/commons-discovery.jar
CLASSPATH=$CLASSPATH:axis/wsdl4j.jar
CLASSPATH=$CLASSPATH:axis/jaxrpc.jar
CLASSPATH=$CLASSPATH:axis/saaj.jar
CLASSPATH=$CLASSPATH:j2ee/activation.jar
CLASSPATH=$CLASSPATH:j2ee/mail.jar

# axis 1.4
#CLASSPATH=$CLASSPATH:axis/commons-logging-1.0.4.jar
#CLASSPATH=$CLASSPATH:axis/commons-discovery-0.2.jar
#CLASSPATH=$CLASSPATH:axis/wsdl4j-1.5.1.jar

#rm -f com/evite/...

java -cp $CLASSPATH org.apache.axis.wsdl.WSDL2Java -v http://test1.evite.com/app/webservices/qv?wsdl 

javac -cp $CLASSPATH com/evite/qv/model/*java com/evite/qv/webservice/*java 

jar -cvf lib/quickvite.jar com/evite/qv/model/*class com/evite/qv/webservice/*class 

#find com/ -name *.java | xargs javadoc -d doc com.microsoft.schemas.MSNSearch._2005._09.fex 
