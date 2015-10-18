package org.devnull.matchmaking.analyzer;

import org.devnull.matchmaking.Player;
import org.devnull.matchmaking.Match;
import org.devnull.matchmaking.MatchAnalyzer;
import org.devnull.matchmaking.MatchStatistics;
import org.devnull.matchmaking.statistics.BasicMatchStatistics;

import java.util.Set;

/**
 * TODO: Write this!
 */
public final class BasicMatchAnalyzer implements MatchAnalyzer {

    public final MatchStatistics analyze(final Match match) {
        final Set<Player> team1 = match.getTeam1();
        final Set<Player> team2 = match.getTeam2();

        double winRateTeam1Min = Double.MAX_VALUE;
        double winRateTeam1Max = Double.MIN_VALUE;
        double winRateTeam2Min = Double.MAX_VALUE;
        double winRateTeam2Max = Double.MIN_VALUE;
        double winRateMatchMin = Double.MAX_VALUE;
        double winRateMatchMax = Double.MIN_VALUE;
        long battleExperienceTeam1Min = Long.MAX_VALUE;
        long battleExperienceTeam1Max = Long.MIN_VALUE;
        long battleExperienceTeam2Min = Long.MAX_VALUE;
        long battleExperienceTeam2Max = Long.MIN_VALUE;
        long battleExperienceMatchMin = Long.MAX_VALUE;
        long battleExperienceMatchMax = Long.MIN_VALUE;

        for (final Player player : team1) {
            final double winRate = player.getWinRate();
            if (winRate < winRateTeam1Min) {
                winRateTeam1Min = winRate;
            }
            if (winRate > winRateTeam1Max) {
                winRateTeam1Max = winRate;
            }
            if (winRate < winRateMatchMin) {
                winRateMatchMin = winRate;
            }
            if (winRate > winRateMatchMax) {
                winRateMatchMax = winRate;
            }

            final long battleExperience = player.getBattleExperience();
            if (battleExperience < battleExperienceTeam1Min) {
                battleExperienceTeam1Min = battleExperience;
            }
            if (battleExperience > battleExperienceTeam1Max) {
                battleExperienceTeam1Max = battleExperience;
            }
            if (battleExperience < battleExperienceMatchMin) {
                battleExperienceMatchMin = battleExperience;
            }
            if (battleExperience > battleExperienceMatchMax) {
                battleExperienceMatchMax = battleExperience;
            }
        }

        for (final Player player : team2) {
            final double winRate = player.getWinRate();
            if (winRate < winRateTeam2Min) {
                winRateTeam2Min = winRate;
            }
            if (winRate > winRateTeam2Max) {
                winRateTeam2Max = winRate;
            }
            if (winRate < winRateMatchMin) {
                winRateMatchMin = winRate;
            }
            if (winRate > winRateMatchMax) {
                winRateMatchMax = winRate;
            }

            final long battleExperience = player.getBattleExperience();
            if (battleExperience < battleExperienceTeam2Min) {
                battleExperienceTeam2Min = battleExperience;
            }
            if (battleExperience > battleExperienceTeam2Max) {
                battleExperienceTeam2Max = battleExperience;
            }
            if (battleExperience < battleExperienceMatchMin) {
                battleExperienceMatchMin = battleExperience;
            }
            if (battleExperience > battleExperienceMatchMax) {
                battleExperienceMatchMax = battleExperience;
            }
        }

        return new BasicMatchStatistics(
            match,
            winRateTeam1Min,
            winRateTeam1Max,
            winRateTeam2Min,
            winRateTeam2Max,
            winRateMatchMin,
            winRateMatchMax,
            battleExperienceTeam1Min,
            battleExperienceTeam1Max,
            battleExperienceTeam2Min,
            battleExperienceTeam2Max,
            battleExperienceMatchMin,
            battleExperienceMatchMax
        );
    }

}
