#!/bin/bash

mkdir -p classes
javac -sourcepath src/main/java -d classes src/main/java/org/devnull/matchmaking/*.java
