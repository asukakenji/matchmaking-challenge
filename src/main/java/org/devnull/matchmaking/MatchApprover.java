package org.devnull.matchmaking;

@FunctionalInterface
public interface MatchApprover {

    boolean isAcceptable(MatchStatistics statistics);

}
