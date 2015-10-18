package org.devnull.matchmaking.statistics;

@FunctionalInterface
public interface MatchStatistics {

    Object getStatistics(String key);

}
