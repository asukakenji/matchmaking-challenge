package org.devnull.matchmaking;

import java.util.Set;
import java.util.function.Function;

public class Match implements java.io.Serializable {

    /** Generated by the serialver utility */
    //TODO: private static final long serialVersionUID = -5262879256745620081L;

    // Interview Note: Java Feature - Streams
    // Interview Note: Java Feature - Lambda Expressions
    // Interview Note: Java Feature - Method References
    private static String stringify(final Set<PlayerInterface> team) {
        // TODO: Should use Apache Commons StringEscapeUtils to escape this.name here,
        //       but let's assume there are no special characters for simplicity.
        final Function<PlayerInterface, String> mapper = (player) ->
            new StringBuilder().append('"').append(player.getName()).append('"').toString();
        final Iterable<String> iterable = team.stream().map(mapper)::iterator;
        return new StringBuilder().append('[').append(String.join(", ", iterable)).append(']').toString();
    }

    private final Set<PlayerInterface> team1;
    private final Set<PlayerInterface> team2;

    public Match(final Set<PlayerInterface> team1, final Set<PlayerInterface> team2) {
        // The same as java.util.Objects#requireNonNull(T)
        if (team1 == null) throw new NullPointerException();
        if (team2 == null) throw new NullPointerException();
        if (team1.size() != team2.size()) {
            throw new IllegalArgumentException("team1: " + stringify(team1) + ", team2: " + stringify(team2));
        }
        this.team1 = team1;
        this.team2 = team2;
    }

    public Set<PlayerInterface> getTeam1() {
        return this.team1;
    }

    public Set<PlayerInterface> getTeam2() {
        return this.team2;
    }

    @Override
    public int hashCode() {
        // The same as java.util.Objects#hash(Object...)
        return
            (
                (1 * 31) + this.team1.hashCode()
            ) * 31 + this.team2.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        // Note: Do NOT use "instanceof" here
        // Java equality sucks, let's use Scala!
        // See: http://stackoverflow.com/q/12239344/142239
        if (obj.getClass() != Match.class) return false;
        final Match m = (Match) obj;
        return this.team1.equals(m.team1)
            && this.team2.equals(m.team2);
    }

    @Override
    public String toString() {
        return new StringBuilder("[Match: \"team1\": ")
            .append(stringify(this.team1))
            .append(", \"team2\": ")
            .append(stringify(this.team2))
            .append("]")
            .toString();
    }


    public static final void main(final String... args) {
        // TODO: Test construction exceptions
        final BasicPlayer p1 = new BasicPlayer("Kate Wells", 961, 658);
        final BasicPlayer p2 = new BasicPlayer("Kristine Newman", 852, 179);
        final BasicPlayer p3 = new BasicPlayer("Billie Roberts", 942, 951);
        final BasicPlayer p4 = new BasicPlayer("Ernestine Holloway", 61, 500);
        final BasicPlayer p5 = new BasicPlayer("Candace Reynolds", 235, 8);
        final BasicPlayer p6 = new BasicPlayer("Susan Potter", 234, 486);
        final Set<PlayerInterface> team1 = new java.util.HashSet<>();
        java.util.Collections.addAll(team1, p1, p2, p3);
        final Set<PlayerInterface> team2 = new java.util.HashSet<>();
        java.util.Collections.addAll(team2, p4, p5, p6);
        final Match match = new Match(team1, team2);
        assert match.toString().equals("[Match: \"team1\": [\"Kate Wells\", \"Billie Roberts\", \"Kristine Newman\"], \"team2\": [\"Susan Potter\", \"Ernestine Holloway\", \"Candace Reynolds\"]]");
    }

}
