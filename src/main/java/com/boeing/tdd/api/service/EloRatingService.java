package com.boeing.tdd.api.service;

import com.boeing.tdd.api.entity.Player;
import com.boeing.tdd.api.util.EloRankingUtil;

public class EloRatingService {

    public void applyMatch(Player firstPlayer, Player secondPlayer, double matchWinPercentage) {
        applyMatchForPlayer(firstPlayer, secondPlayer, matchWinPercentage);
        applyMatchForPlayer(secondPlayer, firstPlayer, 1d - matchWinPercentage);
    }

    private void applyMatchForPlayer(Player firstPlayer, Player secondPlayer, double matchWinPercentage) {
        double expectedMatchRank = EloRankingUtil.getExpectedMatchRank(firstPlayer.rank, secondPlayer.rank);
        firstPlayer.rank = EloRankingUtil.getNewRank(firstPlayer.rank, expectedMatchRank, matchWinPercentage);
    }
}
