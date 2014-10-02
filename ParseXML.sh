#!/bin/bash

cd /home/bismith/Programs/wolframalpha-json/

classpath="./:json.jar"

if [ ! -f ParseXML.class ]; then
	/home/bismith/Programs/jdk1.8.0_20/bin/javac -cp $classpath ParseXML.java
fi

/home/bismith/Programs/jdk1.8.0_20/bin/java -cp $classpath ParseXML "$1"
