#!/bin/bash

mkdir -p classes
javac -Xlint:unchecked -Xdiags:verbose -sourcepath src/main/java -d classes src/main/java/TestMain.java src/main/java/org/devnull/matchmaking/*.java src/main/java/org/devnull/matchmaking/*/*.java
