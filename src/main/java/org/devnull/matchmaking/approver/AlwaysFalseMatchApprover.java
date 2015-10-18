package org.devnull.matchmaking.approver;

import org.devnull.matchmaking.Match;
import org.devnull.matchmaking.MatchApprover;

/**
 * TODO: Write this!
 */
public final class AlwaysFalseMatchApprover implements MatchApprover {

    public final boolean isAcceptable(final Match match) {
        return false;
    }

}
