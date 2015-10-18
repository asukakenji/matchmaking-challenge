#!/bin/bash

mkdir -p classes
javac -Xlint:unchecked -sourcepath src/main/java -d classes src/main/java/org/devnull/matchmaking/*.java src/main/java/org/devnull/matchmaking/*/*.java
