package org.devnull.matchmaking.maker;

import org.devnull.matchmaking.Match;
import org.devnull.matchmaking.MatchApprover;
import org.devnull.matchmaking.MatchMaker;
import org.devnull.matchmaking.Player;
import org.devnull.matchmaking.approver.AlwaysTrueMatchApprover;
import org.devnull.matchmaking.player.PlayerWithNameBasedEquality;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.logging.Logger;

/**
 * <p>
 * The matchmaking implementation that you will write.
 * </p>
 * <p>
 * In {@link #enterMatchmaking(org.devnull.matchmaking.Player)}, a
 * {@link org.devnull.matchmaking.Player} should be wrapped in a
 * {@link org.devnull.matchmaking.player.PlayerWithNameBasedEquality} before
 * being store in a {@link java.lang.Set}. If {@link java.util.Set#add(Object)}
 * returns false, then the incident should be logged because there is a high
 * chance that either the player uses an unofficial game client (e.g. a bot), or
 * there is a bug in the official game client.
 * </p>
 */
public class FIFOMatchMaker implements MatchMaker {

    private final LinkedHashSet<PlayerWithNameBasedEquality> players;
    private final MatchApprover approver;
    private final Logger logger;

    public FIFOMatchMaker() {
        this.players = new LinkedHashSet<>();
        this.approver = new AlwaysTrueMatchApprover();
        this.logger = Logger.getLogger(this.getClass().getCanonicalName());
    }

    public Match findMatch(final int playersPerTeam) {
        synchronized (this.players) {
            final int playersInMatch = playersPerTeam * 2;
            if (this.players.size() >= playersInMatch) {
                final Set<Player> team1 = new HashSet<>();
                final Set<Player> team2 = new HashSet<>();
                final Iterator<PlayerWithNameBasedEquality> itr = this.players.iterator();
                for (int index = 0; index < playersPerTeam; ++index) {
                    final Player player = itr.next();
                    team1.add(player);
                }
                for (int index = 0; index < playersPerTeam; ++index) {
                    final Player player = itr.next();
                    team2.add(player);
                }
                final Match match = new Match(team1, team2);
                if (this.approver.isAcceptable(match)) {
                    this.players.removeAll(team1);
                    this.players.removeAll(team2);
                    return match;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public void enterMatchmaking(final Player player) {
        final PlayerWithNameBasedEquality pwnbe = new PlayerWithNameBasedEquality(player);
        synchronized (this.players) {
            if (!this.players.add(pwnbe)) {
                // Hacking Alert!
                logger.warning("Player already entered match making: " + player.toString());
            }
        }
    }

}
