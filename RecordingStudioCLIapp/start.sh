#!/bin/bash

find src -name "*.java" > sources.txt

javac -d bin @sources.txt

java -cp "bin;C:/Users/dcabe/.m2/repository/com/mysql/mysql-connector-j/9.5.0/mysql-connector-j-9.5.0.jar" com.joysistvi.recordingstudio.App
