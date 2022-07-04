package com.jdbc.basic.blank.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.blank.domain.Players;
import com.jdbc.basic.score.domain.Score;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class PlayersOracleRepo implements PlayerRepository {


    @Override
    public boolean insertPlayer(Players players) {

        String sql = "INSERT INTO players " +
                "VALUES ( ?,?,?)";

        try (Connection conn = Connect.makeConnection()) {
            // 트랜잭션 처리
            conn.setAutoCommit(false); // 자동커밋 설정 끄기

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, players.getPname());
            pstmt.setInt(2, players.getOnumber());
            pstmt.setInt(3, players.getPlustime());

            int result = pstmt.executeUpdate();

            if (result != 0) {
                conn.commit(); // 커밋 완료
                return true;
            } else {
                conn.rollback(); // 롤백
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }



    @Override
    public List<Players> findAllPlayersNumber() {

        List<Players> pMap = new ArrayList<>();

        String sql = "SELECT * FROM Players ORDER BY onumber DESC ,plustime";
        // 오름차 정렬

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Players s = new Players(
                         rs.getString("PNAME")
                        , rs.getInt("onumber")
                        , rs.getInt("plustime")

                );
                pMap.add(s);

            }
            return pMap;


        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public  List<Players> findAllPlayersTime() {

       List<Players> pMap = new ArrayList<>();

        String sql = "SELECT * FROM Players ORDER BY plustime ,onumber DESC";
        // 오름차 정렬

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Players s = new Players(
                        rs.getString("PNAME")
                        , rs.getInt("onumber")
                        , rs.getInt("plustime")

                );
                pMap.add(s);

            }
            return pMap;


        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }


    }

    @Override
    public List<Players> givePlayerTable() {

        List<Players> allPlayer = new ArrayList<>();

        String sql = "SELECT * FROM Players";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                Players s = new Players(
                        rs.getString("PNAME")
                        , rs.getInt("onumber")
                        , rs.getInt("plustime")

                );
              allPlayer.add(s);


            }
            return allPlayer;


        } catch (Exception e) {
            e.printStackTrace();
//            return Collections.emptyArr();
        }
        return allPlayer;
    }


}
