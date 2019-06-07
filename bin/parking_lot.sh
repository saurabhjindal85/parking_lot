#!/bin/sh

#InputCommand file 
arg1=$1

##directory where jar file is located
dir=target

##jar file name
jar_name=ParkingLotApp-jar-with-dependencies.jar

##clean compile and install
mvn clean install

## Permform some validation on input arguments, one example below
if [ -z "$1" ] ; then
        java -jar $dir/$jar_name
        exit 1

else
        java -jar $dir/$jar_name $arg1

fi
