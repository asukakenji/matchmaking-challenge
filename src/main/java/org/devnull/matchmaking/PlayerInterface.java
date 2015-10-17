package org.devnull.matchmaking;

/**
 * TODO: Write this!
 */
public interface PlayerInterface {

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
    int getWins();

    /**
     * Returns the number of battles this player has lost.
     *
     * @return the number of battles this player has lost,
     * which is a non-negative integer
     */
    int getLosses();

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
     * Returns the number of battles this player has fought.
     *
     * @return the number of battles this player has fought,
     * which is a non-negative integer
     */
    default long getBattlesFought() {
        final long wins = (long) this.getWins();
        final long losses = (long) this.getLosses();
        return wins + losses;
    }

}
