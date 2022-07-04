package com.jdbc.basic.blank.repository;

import com.jdbc.basic.blank.domain.Players;

import java.util.List;
import java.util.Map;


public interface PlayerRepository {


    boolean insertPlayer(Players players);

    List<Players> findAllPlayersNumber();

    List<Players> findAllPlayersTime();

    List<Players> givePlayerTable();


}
