package org.devnull.matchmaking;

@FunctionalInterface
public interface MatchAnalyzer {

    MatchStatistics analyze(Match match);

}
