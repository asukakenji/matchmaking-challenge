import org.devnull.matchmaking.Match;
import org.devnull.matchmaking.Player;
import org.devnull.matchmaking.player.BasicPlayer;
import org.devnull.matchmaking.player.PlayerWithNameBasedEquality;

import java.util.Collections;
import java.util.Set;

public final class TestMain {

    public static final void testBasicPlayer() {
        // TODO: Test construction exceptions
        final BasicPlayer kenji_1a = new BasicPlayer("Kenji", 321, 123);
        final BasicPlayer kenji_1b = new BasicPlayer("Kenji", 321, 123);
        final BasicPlayer kenji_2 = new BasicPlayer("kenji", 321, 123);
        final BasicPlayer kenji_3 = new BasicPlayer("Kenji", 432, 123);
        final BasicPlayer kenji_4 = new BasicPlayer("Kenji", 321, 234);
        assert kenji_1a.hashCode() == kenji_1b.hashCode();
        assert kenji_1a.hashCode() != kenji_2.hashCode();
        assert kenji_1a.hashCode() != kenji_3.hashCode();
        assert kenji_1a.hashCode() != kenji_4.hashCode();
        assert kenji_1a.equals(kenji_1b);
        assert !kenji_1a.equals(kenji_2);
        assert !kenji_1a.equals(kenji_3);
        assert !kenji_1a.equals(kenji_4);
        assert kenji_1a.toString().equals("[BasicPlayer: \"name\": \"Kenji\", \"wins\": 321, \"losses\": 123]");
        assert BasicPlayer.NAME_COMPARATOR.compare(kenji_1a, kenji_1a) == 0;
        assert BasicPlayer.NAME_COMPARATOR.compare(kenji_1a, kenji_1b) == 0;
        assert BasicPlayer.NAME_COMPARATOR.compare(kenji_1a, kenji_2) < 0;
        assert BasicPlayer.NAME_COMPARATOR.compare(kenji_2, kenji_1a) > 0;
        assert BasicPlayer.NAME_COMPARATOR.compare(kenji_1a, kenji_3) == 0;
        assert BasicPlayer.NAME_COMPARATOR.compare(kenji_1a, kenji_4) == 0;
    }

    public static final void testPlayerWithNameBasedEquality() {
        // TODO: Test construction exceptions
        final BasicPlayer kenji_1 = new BasicPlayer("Kenji", 321, 123);
        final BasicPlayer kenji_2 = new BasicPlayer("Kenji", 432, 234);
        final BasicPlayer kenji_3 = new BasicPlayer("kenji", 321, 123);
        assert new PlayerWithNameBasedEquality(kenji_1).hashCode() == new PlayerWithNameBasedEquality(kenji_1).hashCode();
        assert new PlayerWithNameBasedEquality(kenji_1).hashCode() == new PlayerWithNameBasedEquality(kenji_2).hashCode();
        assert new PlayerWithNameBasedEquality(kenji_1).hashCode() != new PlayerWithNameBasedEquality(kenji_3).hashCode();
        assert new PlayerWithNameBasedEquality(kenji_1).equals(new PlayerWithNameBasedEquality(kenji_1));
        assert new PlayerWithNameBasedEquality(kenji_1).equals(new PlayerWithNameBasedEquality(kenji_2));
        assert !new PlayerWithNameBasedEquality(kenji_1).equals(new PlayerWithNameBasedEquality(kenji_3));
        assert new PlayerWithNameBasedEquality(kenji_1).toString().equals("[PlayerWithNameBasedEquality: \"name\": \"Kenji\"]");
    }

    public static final void testMatch() {
        // TODO: Test construction exceptions
        final BasicPlayer p1 = new BasicPlayer("Kate Wells", 961, 658);
        final BasicPlayer p2 = new BasicPlayer("Kristine Newman", 852, 179);
        final BasicPlayer p3 = new BasicPlayer("Billie Roberts", 942, 951);
        final BasicPlayer p4 = new BasicPlayer("Ernestine Holloway", 61, 500);
        final BasicPlayer p5 = new BasicPlayer("Candace Reynolds", 235, 8);
        final BasicPlayer p6 = new BasicPlayer("Susan Potter", 234, 486);
        final Set<Player> team1 = new java.util.HashSet<>();
        Collections.addAll(team1, p1, p2, p3);
        final Set<Player> team2 = new java.util.HashSet<>();
        Collections.addAll(team2, p4, p5, p6);
        final Match match = new Match(team1, team2);
        assert match.toString().equals("[Match: \"team1\": [\"Kate Wells\", \"Billie Roberts\", \"Kristine Newman\"], \"team2\": [\"Susan Potter\", \"Ernestine Holloway\", \"Candace Reynolds\"]]");
    }

    public static final void main(final String... args) {
        testBasicPlayer();
        testPlayerWithNameBasedEquality();
        testMatch();
    }

    private TestMain() {
    }

}
