package com.boeing.tdd.api.util;

public class EloRankingUtil {
    public static double getExpectedMatchRank(int firstPlayerRank, int secondPlayerRank) {
        return 1d / (1d + (Math.pow(10d, (secondPlayerRank - firstPlayerRank)/400d)));
    }

    public static int getNewRank(int firstPlayerRank, double expectedScoreOfPlayerOne, double actualScore) {
        return (int) Math.round((double)firstPlayerRank + 32d * (actualScore - expectedScoreOfPlayerOne));
    }
}
