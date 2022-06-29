package com.jdbc.basic;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {

       Connection conn =  Connect.makeConnection();


       if(conn != null){
           System.out.println("연결 성공");
       }
       else {
           System.out.println("연결 실패");
           // 비밀번호 틀렸을때 나오는 오류메세지
           //invalid username/password; logon denied
       }



    }
}
