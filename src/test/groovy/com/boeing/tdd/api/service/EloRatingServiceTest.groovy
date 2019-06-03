package com.boeing.tdd.api.service

import com.boeing.tdd.api.entity.Player
import com.boeing.tdd.api.util.EloRankingUtil
import spock.lang.Specification

class EloRatingServiceTest extends Specification {

    EloRatingService eloService

    def setup() {
        eloService = new EloRatingService()
    }
:wq
    def "apply the rankings of first player after a match" () {
        given:
        def firstPlayerRank = 1500
        Player firstPlayer = new Player(rank: firstPlayerRank, name: "jim")
        Player secondPlayer = new Player(rank: 1600, name: "sarah")

        when:
        eloService.applyMatch(firstPlayer, secondPlayer, 1)

        then:
        def expectedMatchRank = EloRankingUtil.getExpectedMatchRank(firstPlayerRank, secondPlayer.rank)
        def newRank = EloRankingUtil.getNewRank(firstPlayerRank, expectedMatchRank, 1)
        firstPlayer.rank == newRank
    }

    def "apply the rankings of second player after a match" () {
        given:
        def firstPlayerRank = 1500
        def secondPlayerRank = 1600
        Player firstPlayer = new Player(rank: firstPlayerRank, name: "jim")
        Player secondPlayer = new Player(rank: secondPlayerRank, name: "sarah")

        when:
        eloService.applyMatch(firstPlayer, secondPlayer, 1)

        then:
        def expectedMatchRank = EloRankingUtil.getExpectedMatchRank(secondPlayerRank, firstPlayerRank)
        def newRank = EloRankingUtil.getNewRank(secondPlayerRank, expectedMatchRank, 0)
        secondPlayer.rank == newRank
    }
}
