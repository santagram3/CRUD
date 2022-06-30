package com.jdbc.basic.blank.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.score.domain.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlankOracleRepo implements BlankRepository {

    @Override
    public Blank findtext(int qnum) {
        System.out.println("qnum = " + qnum);
        //  1. SQL 구문을 작성
        String sql = "SELECT texts FROM Blank WHERE qnum = ?";

        // 2. DB에 접속
        try (Connection conn = Connect.makeConnection()) {

            // 3. SQL 실행을 위한 객체 preparedStatement 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, qnum);

            // 5. 실행 명령 내리기
            // - INSERT , UPDATE , DELETE :executeUpdate();
            // - SELECCT : executeQuery();
            // executeUpdate 는 삽입이 실패하면 0이 나온다
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                //blankText = bt
                Blank tt = new Blank(rs.getInt("qnum")
                        , rs.getString("texts"), 18);

                return tt;
            }

            return null;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
