package org.devnull.matchmaking;

/**
 * TODO: Write this!
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
