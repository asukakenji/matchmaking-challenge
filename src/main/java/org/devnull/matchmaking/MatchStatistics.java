package org.devnull.matchmaking;

/**
 * TODO: Write this!
 */
@FunctionalInterface
public interface MatchStatistics {

    Object getStatistics(String key);

    public static final String TEAM1_WIN_RATE_MIN = "team1.winRate.min";
    public static final String TEAM1_WIN_RATE_MAX = "team1.winRate.max";
    public static final String TEAM1_BATTLE_EXPERIENCE_MIN = "team1.battleExperience.min";
    public static final String TEAM1_BATTLE_EXPERIENCE_MAX = "team1.battleExperience.max";

    public static final String TEAM2_WIN_RATE_MIN = "team2.winRate.min";
    public static final String TEAM2_WIN_RATE_MAX = "team2.winRate.max";
    public static final String TEAM2_BATTLE_EXPERIENCE_MIN = "team2.battleExperience.min";
    public static final String TEAM2_BATTLE_EXPERIENCE_MAX = "team2.battleExperience.max";

    public static final String MATCH_WIN_RATE_MIN = "match.winRate.min";
    public static final String MATCH_WIN_RATE_MAX = "match.winRate.max";
    public static final String MATCH_BATTLE_EXPERIENCE_MIN = "match.battleExperience.min";
    public static final String MATCH_BATTLE_EXPERIENCE_MAX = "match.battleExperience.max";

}
