#!/bin/bash

java -cp classes org.devnull.matchmaking.Player
java -cp classes org.devnull.matchmaking.PlayerToBeMatched
serialver -classpath classes org.devnull.matchmaking.Player
serialver -classpath classes org.devnull.matchmaking.Player.NameComparator
serialver -classpath classes org.devnull.matchmaking.PlayerToBeMatched
