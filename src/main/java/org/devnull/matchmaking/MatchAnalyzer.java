package org.devnull.matchmaking.analyzer;

import org.devnull.matchmaking.Match;
import org.devnull.matchmaking.MatchStatistics;

@FunctionalInterface
public interface MatchAnalyzer {

    MatchStatistics analyze(Match match);

}
