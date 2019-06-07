#!/bin/sh

echo Pleae provide the Path until code directory?

read dir

cd $dir

mvn test