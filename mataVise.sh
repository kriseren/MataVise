#!/bin/bash
javac -d bin/ -cp jar/jlayer-1.0.1.jar src/mataVise/*.java
mate-terminal --zoom=1.8 --full-screen --command "java -cp jar/jlayer-1.0.1.jar:bin/ mataVise.mataVise" --display=:0
