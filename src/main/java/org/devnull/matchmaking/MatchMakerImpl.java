package org.devnull.matchmaking;

import org.devnull.matchmaking.player.PlayerWithNameBasedEquality;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * The matchmaking implementation that you will write.
 *
 * MatchMakerImpl#enterMatchmaking(Player), a Player should be wrapped in a
 * PlayerToBeMatch before being store in a Set. If Set#add(Object) returns false,
 * then the incident should be logged because there is a high chance that either
 * the player uses an unofficial game client (e.g. a bot), or there is a bug in
 * the official game client.
 *
 */
public class MatchMakerImpl implements MatchMaker {

    private final LinkedHashSet<PlayerWithNameBasedEquality> players;

    private final Logger logger;

    public MatchMakerImpl() {
        this.players = new LinkedHashSet<PlayerWithNameBasedEquality>();
        this.logger = Logger.getLogger(this.getClass().getCanonicalName());
    }

    public Match findMatch(final int playersPerTeam) {
        synchronized (this.players) {
            final int playersInMatch = playersPerTeam * 2;
            if (this.players.size() >= playersInMatch) {
                final LinkedHashSet<PlayerWithNameBasedEquality> team1 = new LinkedHashSet<>();
                final LinkedHashSet<PlayerWithNameBasedEquality> team2 = new LinkedHashSet<>();
                for (int index = 0; index < playersPerTeam; ++index) {
                    // TODO: team1.add(this.players.remove());
                }
                for (int index = 0; index < playersPerTeam; ++index) {
                    // TODO: team2.add(this.players.remove());
                }
                return null; // TODO
            } else {
                return null;
            }
        }
    }

    public void enterMatchmaking(final Player player) {
        final PlayerWithNameBasedEquality ptbm = new PlayerWithNameBasedEquality(player);
        synchronized (this.players) {
            if (!this.players.add(ptbm)) {
                // Hacking Alert!
                logger.warning("Player already entered match making: " + player.toString());
            }
        }
    }

}
