package com.jdbc.basic.blank.controller;

import com.jdbc.basic.blank.domain.Players;
import com.jdbc.basic.blank.repository.PlayerRepository;
import com.jdbc.basic.blank.repository.PlayersOracleRepo;
import com.jdbc.basic.score.domain.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PlayerController {

    private List<Players> play;

    private PlayerRepository repository;

   public PlayerController(){
       this.repository = new PlayersOracleRepo();
       play = new ArrayList<>();
   }

    public void insertList(Players players){
       play.add(players);
       repository.insertPlayer(players);
    }
    //public Players[]
    public Players[] givePlayerTable(){
        Players[] playerList = repository.givePlayerTable();
        return playerList;
    }

    public List<Players> givePlayerTable2(){
       List<Players> PlayerTable = repository.findAllPlayersNumber();
       return PlayerTable;
    }

   public List<Players> givePlayerNumberTable(){
       List<Players> allPlayersNumber = repository.findAllPlayersNumber();
       return allPlayersNumber;
   }

    public List<Players> givePlayerTimeTable(){
        List<Players> time = repository.findAllPlayersTime();
        return time;
    }



}
