
.phony: all build load run clean
.phony: load_wlan run_wlan
.phony: load_vpcell run_vpcell cell


HADOOP_HOME=/ext/home/todd/src/hadoop-0.20.1/
HADOOP_VERSION=0.20.1
HADOOP_BIN=$(HADOOP_HOME)/bin

cell: build load_vpcell run_vpcell
all: build load_wlan run_wlan

build:
	mkdir -p classes
	javac -classpath $(HADOOP_HOME)/hadoop-$(HADOOP_VERSION)-core.jar -d classes *.java
	jar -cvf all.jar -C classes/ .

clean:
	rm -rf classes/ all.jar

load_wlan:
	ssh dmz 'echo "select * from WlanInfo" | mysql -ulp -plp lp' > wlaninfo
	$(HADOOP_BIN)/hadoop dfs -rm input/wlaninfo
	$(HADOOP_BIN)/hadoop dfs -put wlaninfo input/

run_wlan:
	$(HADOOP_BIN)/hadoop dfs -rmr output-wlan
	time $(HADOOP_BIN)/hadoop jar all.jar org.myorg.Centroid input/wlaninfo output-wlan
	$(HADOOP_BIN)/hadoop dfs -cat output-wlan/part*


load_vpcell:
	$(HADOOP_BIN)/hadoop dfs -rm input/vpcells
	$(HADOOP_BIN)/hadoop dfs -put VpCellId/observations-11-17-2009.txt input/vpcells

run_vpcell:
	$(HADOOP_BIN)/hadoop dfs -rmr output-vpcells
	time $(HADOOP_BIN)/hadoop jar all.jar com.wavemarket.hadoop.CellDB input/vpcells output-vpcells
	$(HADOOP_BIN)/hadoop dfs -cat output-vpcells/part*

