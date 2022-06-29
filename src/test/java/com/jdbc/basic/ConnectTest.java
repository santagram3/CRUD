package com.jdbc.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest {

    @Test
    // Assertion(단언하다) : 애매하게 말하면 안된다
    // 좋은 예 : 데이터베이스 연결이 정상 수행되어야 한다
    // 나쁜 예 : 데이터베이스 연결이 정상 수행 될거같다
    @DisplayName("데이터베이스 연결이 정상 수행되어야 한다 ")
    void connectTest(){
        Connection conn = Connect.makeConnection();

        if (conn != null){
            System.out.println("연결 성공");
        }
        else {
            System.out.println("연결 실패");
        }
        assertNotNull(conn); // 나는 conn 이 null 아닐것을 단언한다
        // AssertionFailedError: expected: not <null>
        // 널 들어왔다고 임마
    }

}