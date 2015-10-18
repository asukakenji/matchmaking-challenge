package org.devnull.matchmaking.analyzer;

import org.devnull.matchmaking.Player;
import org.devnull.matchmaking.Match;
import org.devnull.matchmaking.MatchAnalyzer;
import org.devnull.matchmaking.MatchStatistics;
import org.devnull.matchmaking.statistics.BasicMatchStatistics;

import java.util.Set;

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
        long battlesFoughtTeam1Min = Long.MAX_VALUE;
        long battlesFoughtTeam1Max = Long.MIN_VALUE;
        long battlesFoughtTeam2Min = Long.MAX_VALUE;
        long battlesFoughtTeam2Max = Long.MIN_VALUE;
        long battlesFoughtMatchMin = Long.MAX_VALUE;
        long battlesFoughtMatchMax = Long.MIN_VALUE;

        for (final Player player : team1) {
            //final PlayerToBeMatched player = (PlayerToBeMatched) p;

            double winRate = player.getWinRate();
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

            long battlesFought = player.getBattlesFought();
            if (battlesFought < battlesFoughtTeam1Min) {
                battlesFoughtTeam1Min = battlesFought;
            }
            if (battlesFought > battlesFoughtTeam1Max) {
                battlesFoughtTeam1Max = battlesFought;
            }
            if (battlesFought < battlesFoughtMatchMin) {
                battlesFoughtMatchMin = battlesFought;
            }
            if (battlesFought > battlesFoughtMatchMax) {
                battlesFoughtMatchMax = battlesFought;
            }
        }

        for (final Player player : team2) {
            //final PlayerToBeMatched player = (PlayerToBeMatched) p;

            double winRate = player.getWinRate();
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

            long battlesFought = player.getBattlesFought();
            if (battlesFought < battlesFoughtTeam2Min) {
                battlesFoughtTeam2Min = battlesFought;
            }
            if (battlesFought > battlesFoughtTeam2Max) {
                battlesFoughtTeam2Max = battlesFought;
            }
            if (battlesFought < battlesFoughtMatchMin) {
                battlesFoughtMatchMin = battlesFought;
            }
            if (battlesFought > battlesFoughtMatchMax) {
                battlesFoughtMatchMax = battlesFought;
            }
        }

//         this.winRateTeam1Min = winRateTeam1Min; 
//         this.winRateTeam1Max = winRateTeam1Max; 
//         this.winRateTeam2Min = winRateTeam2Min; 
//         this.winRateTeam2Max = winRateTeam2Max; 
//         this.winRateMatchMin = winRateMatchMin; 
//         this.winRateMatchMax = winRateMatchMax; 
//         this.battlesFoughtTeam1Min = battlesFoughtTeam1Min; 
//         this.battlesFoughtTeam1Max = battlesFoughtTeam1Max; 
//         this.battlesFoughtTeam2Min = battlesFoughtTeam2Min; 
//         this.battlesFoughtTeam2Max = battlesFoughtTeam2Max; 
//         this.battlesFoughtMatchMin = battlesFoughtMatchMin; 
//         this.battlesFoughtMatchMax = battlesFoughtMatchMax; 
         return null;
    }
}
