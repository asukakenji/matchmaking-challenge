package org.devnull.matchmaking;

//import org.devnull.matchmaking.analyzer.BasicMatchAnalyzer;
//import org.devnull.matchmaking.approver.AlwaysTrueMatchApprover;
import org.devnull.matchmaking.maker.FIFOMatchMaker;

import java.util.Random;
import java.util.logging.Logger;

public final class Main {

    private static MatchMaker matchMaker;
    //private static MatchAnalyzer matchAnalyzer;
    //private static MatchApprover matchApprover;
    private static Random random;
    private static Logger logger;

    public static final void main(final String... args) {
        matchMaker = new FIFOMatchMaker();
        random = new Random();
        logger = Logger.getLogger(Main.class.getCanonicalName());
        for (final Player player : SampleData.getPlayers()) {
            matchMaker.enterMatchmaking(player);
            final double r1 = random.nextDouble();
            int playersPerTeam = 0;
            if (r1 < 0.3) {
                playersPerTeam = 3;
            } else if (r1 < 0.6) {
                playersPerTeam = 5;
            }
            if (playersPerTeam != 0) {
                final Match match = matchMaker.findMatch(playersPerTeam);
                logger.info(match == null ? null : match.toString());
            }
        }
    }

    private Main() {
    }

}
