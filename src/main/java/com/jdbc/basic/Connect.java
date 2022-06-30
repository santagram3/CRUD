package com.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    // 데이터베이스 연결을 위한 정보 저장
    // 4가지 데이터
    // 계정명
    private final static String ACCOUNT = "sqld"; //계정명
    private final static String PASSWORD = "1234"; //비밀번호
    // 데이터 베이스의 위치정보 (DB URL) - DB회사마다 패턴이 다름
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //192.168.25.198 서로 공유되는것
    //구글에 oracle xe 11g jdbc url 검색
    // https://docs.oracle.com/cd/E17781_01/appdev.112/e18805/getconn.htm#TDPJD127 들어가면
    // jdbc:oracle:driver_type:[username/password]@//host_name:port_number:SID
    // jdbc:oracle:thin:hr/hr@localhost:1521:XE  -- localhost 은 내 아이피 주소 125.133.75.24
    // 만약 DB 받는곳이 다른곳이라면 그쪽 IP 를 받아서 넣어줘야 한다
    // 데이터 베이스 접속에 쓸 드라이버 클래스 - DB회사마다 다름
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    // 구글에 oracle jdbc driver class name -- 검색
    // oracle.jdbc.driver.OracleDriver 나옴

    // DB 연결 메서드
    public static Connection makeConnection() {
        //import java.sql.Connection; 이거 임포트를 해야된다


        try {
            // 1. 드라이버 클래스를 동적 로딩
            Class.forName(DRIVER);
            // 2. 연결 정보를 담아 연결 객체 생성
            Connection conn = DriverManager.getConnection(URL, ACCOUNT, PASSWORD);
            return conn;
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            return null;
        }

    }

//        try(Connection conn = DriverManager.getConnection(URL, ACCOUNT, PASSWORD)) {
//            // try - with - resource 문법
//        // 1. 드라이버 클래스를 동적 로딩
//        Class.forName(DRIVER);
//        // 2. 연결 정보를 담아 연결 객체 생성
//
//        return conn;
//    } catch (Exception e) {
//        //throw new RuntimeException(e);
//        e.printStackTrace();
//        return null;
//    }
//
//}

  // 아무데나 컨트롤 쉬프트 티 누르면
   // 새 테스트 생성 나오거든
    public static void main(String[] args) {


    }
}
