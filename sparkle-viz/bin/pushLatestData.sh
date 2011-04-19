
cat data/captured-data.txt | grep 2011 | while read i
do   
    echo $i \
	| cut -d: -f4- \
	| POST http://sparkledemo.locationlabs.com/finder-att-family/location_feed/5105551213/notify.svc
done

