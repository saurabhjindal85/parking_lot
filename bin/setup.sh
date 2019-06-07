#!/bin/sh

echo Pleae provide the Path until code directory?

read dir

cd $dir
 
##project clean and install
mvn clean verify install
