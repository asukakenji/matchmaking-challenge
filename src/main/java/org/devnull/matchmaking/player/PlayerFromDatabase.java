package org.devnull.matchmaking.player;

//import static org.devnull.matchmaking.CommonMacros.*;

import org.devnull.matchmaking.Player;
import org.devnull.matchmaking.SampleData;

import java.util.List;

/**
 * <p>
 * Representation of a player loaded from a database.
 * </p>
 * <p>
 * This class demonstrates situations where an object similar to
 * {@link BasicPlayer} is needed, but the {@code BasicPlayer} class could not be
 * subclassed. Since the fields in {@code BasicPlayer} are {@code final}-ed,
 * they must be initialized during construction. If {@code BasicPlayer} is
 * subclassed, the constructor of the derived class must call {@code super()}
 * with all the parameters at the very beginning. However, sometimes a
 * {@link Player} object is needed, but not all the parameters are ready.
 * Although a factory could be used for this situation, sometimes lazy loading
 * or delayed loading is needed. Then, a new class (like this) must be created
 * by implementing {@code Player} directly.
 * </p>
 */
public class PlayerFromDatabase implements Player, java.io.Serializable {

    /** Generated by the serialver utility */
    //TODO: private static final long serialVersionUID = -6874413774217148104L;

    //public static final PlayerProperties<PlayerFromDatabase> PLAYER_PROPERTIES = pps(
    //    null
    //);

    private static Player load(final String name) {
        try {
            // Sleep 1000 milliseconds = 1 second to simulate a delay
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            return null;
        }
        final List<Player> players = SampleData.getPlayers();
        for (final Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new RuntimeException("Player not found: " + name);
    }



    private final String name;
    private volatile transient boolean isLoaded;
    private transient Player player;

    public PlayerFromDatabase(final String name) {
        // The same as java.util.Objects#requireNonNull(T)
        if (name == null) throw new NullPointerException();
        this.name = name;
    }



    @Override
    public int hashCode() {
        // The same as java.util.Objects#hash(Object...)
        return (1 * 31) + this.name.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        // Note: Do NOT use "instanceof" here
        // Java equality sucks, let's use Scala!
        // See: http://stackoverflow.com/q/12239344/142239
        if (obj.getClass() != PlayerFromDatabase.class) return false;
        final PlayerFromDatabase p = (PlayerFromDatabase) obj;
        return this.name.equals(p.name);
    }

    @Override
    public String toString() {
        // TODO: Should use Apache Commons StringEscapeUtils to escape this.name here,
        //       but let's assume there are no special characters for simplicity.
        return (this.isLoaded)
            ? new StringBuilder("[PlayerFromDatabase: ")
                .append(this.player.toString())
                .append("]")
                .toString()
            : new StringBuilder("[PlayerFromDatabase: \"name\": \"")
                .append(this.name)
                .append("]")
                .toString();
    }



    //@Override
    //public PlayerProperties<Player> getPlayerProperty() {
    //    return null;
    //}

    @Override
    public Player getRealPlayer() {
        return this.getPlayer().getRealPlayer();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getWins() {
        return this.getPlayer().getWins();
    }

    @Override
    public long getLosses() {
        return this.getPlayer().getLosses();
    }

    public Player getPlayer() {
        if (!this.isLoaded) {
            final Player player = load(this.name);
            if (this.player == null) {
                this.player = player;
                this.isLoaded = true;
            }
        }
        return this.player;
    }

}
