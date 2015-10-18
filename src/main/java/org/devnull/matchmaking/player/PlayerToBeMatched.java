package org.devnull.matchmaking.player;

import org.devnull.matchmaking.Player;

/**
 * TODO: Add main description here!
 * TODO: Decorator
 *
 * The "name" field of Player is assumed to be its unique identifier. In
 * MatchmakerImpl#enterMatchmaking(Player), a Player should be wrapped in a
 * PlayerToBeMatch before being store in a Set. If Set#add(Object) returns false,
 * then the incident should be logged because there is a high chance that either
 * the player uses an unofficial game client (e.g. a bot), or there is a bug in
 * the official game client.
 *
 * Using BasicPlayer#NAME_COMPARATOR is not an alternative. The Java Collections
 * Framework states that "the ordering imposed by a comparator should be
 * consistent with equals", otherwise "the sorted set (or sorted map) will
 * behave 'strangely'".
 */
public final class PlayerToBeMatched implements Player, Comparable<PlayerToBeMatched>, java.io.Serializable {

    /** Generated by the serialver utility */
    //private static final long serialVersionUID = 7807574855911584647L;



    private final Player player;

    public PlayerToBeMatched(final Player player) {
        // The same as java.util.Objects#requireNonNull(T)
        if (player == null) throw new NullPointerException();
        this.player = player;
    }

    //@Override
    //public PlayerProperties<Player> getPlayerProperty() {
    //    return null;
    //}

    @Override
    public final Player getRealPlayer() {
        return this.player.getRealPlayer();
    }

    @Override
    public final String getName() {
        return this.player.getName();
    }

    @Override
    public final long getWins() {
        return this.player.getWins();
    }

    @Override
    public final long getLosses() {
        return this.player.getLosses();
    }

    @Override
    public final int hashCode() {
        // The same as java.util.Objects#hash(Object...)
        return (1 * 31) + this.player.getName().hashCode();
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        // Note: Do NOT use "instanceof" here
        // Java equality sucks, let's use Scala!
        // See: http://stackoverflow.com/q/12239344/142239
        if (obj.getClass() != PlayerToBeMatched.class) return false;
        final PlayerToBeMatched ptbm = (PlayerToBeMatched) obj;
        return this.player.getName().equals(ptbm.player.getName());
    }

    @Override
    public final String toString() {
        // TODO: Should use Apache Commons StringEscapeUtils to escape this.name here,
        //       but let's assume there are no special characters for simplicity.
        return new StringBuilder("[PlayerToBeMatched: \"name\": \"")
            .append(this.player.getName())
            .append("\"]")
            .toString();
    }

    @Override
    public final int compareTo(final PlayerToBeMatched playerToBeMatched) {
        return this.player.getName().compareTo(playerToBeMatched.player.getName());
    }

}
