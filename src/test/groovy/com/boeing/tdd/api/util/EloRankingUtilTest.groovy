package com.boeing.tdd.api.util

import spock.lang.Specification

class EloRankingUtilTest extends Specification {
    int firstPlayerRank
    int secondPlayerRank
    double expectedScoreOfPlayerOne

    def setup() {
        firstPlayerRank = 1500
        secondPlayerRank = 1600
        expectedScoreOfPlayerOne = 1d / (1d + (Math.pow(10d, (this.secondPlayerRank - this.firstPlayerRank)/400d)))
    }

    def "get an expected player rating of a match" () {
        when:
        double actualScoreOfPlayerOne = EloRankingUtil.getExpectedMatchRank(this.firstPlayerRank, this.secondPlayerRank)

        then:
        actualScoreOfPlayerOne != 0.0d
        actualScoreOfPlayerOne == this.expectedScoreOfPlayerOne
    }

    def "get the adjusted score of player after a match" () {
        given:
        double actualScore = 1
        int firstPlayersNewScore = Math.round((double)firstPlayerRank + 32d * (actualScore - expectedScoreOfPlayerOne))

        when:
        int actualNewScore = EloRankingUtil.getNewRank(firstPlayerRank, expectedScoreOfPlayerOne, actualScore)

        then:
        actualNewScore != 0
        actualNewScore == firstPlayersNewScore
    }

}
