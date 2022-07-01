package com.jdbc.basic.blank.controller;

import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.blank.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {

    PlayerController pc = new PlayerController();

    @Test
    @DisplayName("맞은갯수 오름차로 나오는지 확인")
    void givePlayerNumberTableTest() {
        List<Players> players = pc.givePlayerNumberTable();
        for (Players s : players) {
            System.out.println(s);
        }
        assertEquals(2, players.size());

    }

    @Test
    @DisplayName("시간초 오름차로 나오는지 확인")
    void givePlayerTimeTableTest() {
        List<Players> numMap = pc.givePlayerTimeTable();
        for (Players s : numMap) {
            System.out.println(s);
        }
        assertEquals(2, numMap.size());

    }

}