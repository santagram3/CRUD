package com.jdbc.basic.blank.repository;

import com.jdbc.basic.blank.domain.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayersOracleRepoTest {


    PlayerRepository repository = new PlayersOracleRepo();

    @Test
    @DisplayName("삽입이 되는지 본다 ")
    void insertPlayersTest() {
        Players p = new Players();
        p.setPname("삼삼");
        p.setOnumber(22);
        p.setPlustime(22);

        boolean result = repository.insertPlayer(p);
        assertTrue(result);

    }

    @Test
    @DisplayName("onumber 기준으로 나옴 오름차수")
    void findAllPlayersNumberTest() {
        List<Players> allPlayersNumber = repository.findAllPlayersNumber();
        for (Players p : allPlayersNumber) {
            System.out.println(p);
        }
        assertEquals(2, allPlayersNumber.size());
    }

    @Test
    @DisplayName("plustime 기준으로 나옴 내림차수  ")
    void findAllPlayersTimeTest() {
        List<Players> pMap = repository.findAllPlayersTime();
        for (Players p : pMap ) {
            System.out.println(p);
        }
        assertEquals(2, pMap.size());
    }


}