import org.devnull.matchmaking.player.BasicPlayer;

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

    public static final void main(final String... args) {
        testBasicPlayer();
    }

    private TestMain() {
    }

}
