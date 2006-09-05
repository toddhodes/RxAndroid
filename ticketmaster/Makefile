
default: build run

build:
	javac -classpath .:swt/swt.jar Ticketmaster.java

run:
	java -Djava.library.path=swt -classpath .:swt/swt.jar Ticketmaster

pkg:
	zip -r pkg/ticketmaster.zip * -x CVS/ CVS/* 

