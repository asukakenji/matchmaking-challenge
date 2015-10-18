package org.devnull.matchmaking;

/**
 * <p>
 * {@code Player} is the interface a player. It exists to support various
 * design patterns. Since eliminating concrete classes in all method signatures
 * is an important goal of the design of the package, this interface is a
 * essential abstraction of a player.
 * </p>
 * <p>
 * Since Java SE 8, "default methods" are allowed in interfaces. For example,
 * the implementation of {@link #getWinRate()} only depends on methods in the
 * interface, and therefore could be written in the interface.
 * </p>
 * <p>
 * Before Java SE 8, {@code #getWinRate()} should be written in an abstract
 * class / base class, like {@link BasicPlayer}. However, not all classes
 * implementing the interface derive from the same abstract class / base class
 * - {@link org.devnull.matchmaking.player.PlayerFromDatabase} is a good
 * example.
 * </p>
 * <p>Most probably, methods like {@code #getWinRate()} are copied-and-pasted
 * from one file to another. Therefore, when a change or an improvement to the
 * implementation is to be made, it is hard to find and update all copies. Bugs
 * may thus produced. Writing the implementation in the interface eliminates
 * this problem.
 * </p>
 */
public interface Player {

    /**
     * TODO: Write this!
     */
    //PlayerProperties<Player> getPlayerProperty();

    /**
     * TODO: Write this!
     */
    Player getRealPlayer();

    /**
     * Returns the name of this player.
     *
     * @return the name of this player, which is a non-null String
     */
    String getName();

    /**
     * Returns the number of battles this player has won.
     *
     * @return the number of battles this player has won,
     * which is a non-negative integer
     */
    long getWins();

    /**
     * Returns the number of battles this player has lost.
     *
     * @return the number of battles this player has lost,
     * which is a non-negative integer
     */
    long getLosses();

    /**
     * Returns the win rate of this player.
     *
     * @return the win rate of this player,
     * which is a floating-pointer number between 0.0 and 1.0 inclusive
     */
    // Interview Note: Java Feature - Default Methods
    default double getWinRate() {
        // See docs/assumptions_and_ideas.md for explanation
        // rate = wins / (wins + losses)
        //     = 1 / [ (wins + losses) / wins ]
        //     = 1 / [ 1 + (losses / wins) ]
        final double wins = (double) this.getWins();
        final double losses = (double) this.getLosses();
        return 1.0 / (1.0 + losses / wins);
    }

    /**
     * Returns the battle experience of this player, which is calculated as
     * half of the number of battles this player has won (round down) plus
     * half of the number of battles this player has lost (round down).
     *
     * @return the battle experience of this player,
     * which is a non-negative integer
     */
    // Interview Note: Java Feature - Default Methods
    default long getBattleExperience() {
        final long halfOfWins = this.getWins() / 2;
        final long halfOfLosses = this.getLosses() / 2;
        return halfOfWins + halfOfLosses;
    }

}
