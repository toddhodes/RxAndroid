
.PHONEY: zip deploy clean

zip:
	zip /tmp/sviz.zip \
		images/*.png images/*.jpg images/ui/*.png \
		css/*.css \
		js/*.js \
		*.html


deploy:
	ssh root@sparkledemo mkdir -p /opt/wm/apache-tomcat-5.5.28/webapps/sviz
	scp /tmp/sviz.zip root@sparkledemo:/opt/wm/apache-tomcat-5.5.28/webapps/sviz/
	ssh root@sparkledemo unzip /opt/wm/apache-tomcat-5.5.28/webapps/sviz/sviz.zip -d /opt/wm/apache-tomcat-5.5.28/webapps/sviz/

clean:
	rm -f /tmp/sviz.zip
