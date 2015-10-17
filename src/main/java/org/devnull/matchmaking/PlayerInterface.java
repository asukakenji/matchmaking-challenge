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

}
