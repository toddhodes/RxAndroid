
for i in 5105551212 5105551213 5106107008 5103326150 5109184126 5109184123
do
	GET http://sparkledemo.locationlabs.com/finder-att-family/location_feed/$i/playback.svc \
		| python -mjson.tool \
		> data/$i.json
done
