#!/bin/bash

set -e

java -cp classes TestMain
java -cp classes org.devnull.matchmaking.Match
serialver -classpath classes org.devnull.matchmaking.player.BasicPlayer
serialver -classpath classes org.devnull.matchmaking.player.BasicPlayer.NameComparator
serialver -classpath classes org.devnull.matchmaking.player.PlayerWithNameBasedEquality
serialver -classpath classes org.devnull.matchmaking.player.EquippedPlayer
serialver -classpath classes org.devnull.matchmaking.player.PlayerFromDatabase
serialver -classpath classes org.devnull.matchmaking.Match
serialver -classpath classes org.devnull.matchmaking.statistics.BasicMatchStatistics
