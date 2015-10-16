package org.devnull.matchmaking;

/**
 * <p>
 * Representation of a player.
 * </p>
 * <p>
 * As indicated in the challenge description, feel free to augment the Player
 * class in any way that you feel will improve your final matchmaking solution.
 * <strong>Do NOT remove the name, wins, or losses fields.</strong> Also note
 * that if you make any of these changes, you are responsible for updating the
 * {@link SampleData} such that it provides a useful data set to exercise your
 * solution.
 * </p>
 */
public class Player {

    private final String name;
    private final long wins;
    private final long losses;

    public Player(String name, long wins, long losses) {
        // The same as java.util.Objects#requireNonNull(T)
        if (name == null) throw new NullPointerException();
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public long getWins() {
        return wins;
    }

    public long getLosses() {
        return losses;
    }

    @Override
    public int hashCode() {
        // The same as java.util.Objects#hash(Object...)
        return
            (
                (
                    (1 * 31) + this.name.hashCode()
                ) * 31 + ((int)(this.wins ^ (this.wins >>> 32)))
            ) * 31 + ((int)(this.losses ^ (this.losses >>> 32)));
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        // Note: Do NOT use "instanceof" here
        // Java equality sucks, use Scala!
        // See: http://stackoverflow.com/q/12239344/142239
        if (obj.getClass() != Player.class) return false;
        final Player p = (Player) obj;
        return this.name.equals(p.name)
            && this.wins == p.wins
            && this.losses == p.losses;
    }

    @Override
    public String toString() {
        // TODO: Should use Apache Commons StringEscapeUtils to escape this.name here,
        //       but let's assume there are no special characters for simplicity.
        return new StringBuilder("[Player: \"name\": \"")
            .append(this.name)
            .append("\", \"wins\": ")
            .append(this.wins)
            .append(", \"losses\": ")
            .append(this.losses)
            .append("]")
            .toString();
    }


    public static final void main(final String... args) {
        assert new Player("Kenji", 321, 123).hashCode() == new Player("Kenji", 321, 123).hashCode();
        assert new Player("Kenji", 321, 123).equals(new Player("Kenji", 321, 123));
        assert !new Player("Kenji", 321, 123).equals(new Player("kenji", 321, 123));
        assert !new Player("Kenji", 321, 123).equals(new Player("Kenji", 432, 123));
        assert !new Player("Kenji", 321, 123).equals(new Player("kenji", 321, 234));
        assert new Player("Kenji", 321, 123).toString().equals("[Player: \"name\": \"Kenji\", \"wins\": 321, \"losses\": 123]");
    }
}
