#!/bin/bash

set -e

java -cp target/classes TestMain
java -cp target/classes org.devnull.matchmaking.Main
#serialver -classpath target/classes org.devnull.matchmaking.player.BasicPlayer
#serialver -classpath target/classes org.devnull.matchmaking.player.BasicPlayer.NameComparator
#serialver -classpath target/classes org.devnull.matchmaking.player.EquippedPlayer
#serialver -classpath target/classes org.devnull.matchmaking.player.PlayerFromDatabase
#serialver -classpath target/classes org.devnull.matchmaking.player.PlayerWithNameBasedEquality
#serialver -classpath target/classes org.devnull.matchmaking.Match
#serialver -classpath target/classes org.devnull.matchmaking.statistics.BasicMatchStatistics
