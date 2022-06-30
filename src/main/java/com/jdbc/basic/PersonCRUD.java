package com.jdbc.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonCRUD {

    // 내부 클래스 선언
    public static class Person {
        private String ssn; // 주민번호
        private String name; // 이름
        private int age; // 나이

        public Person(String ssn, String name, int age) {
            this.ssn = ssn;
            this.name = name;
            this.age = age;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "person{" +
                    "ssn='" + ssn + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    } //end inner class

    // 메서드 선언

    // 사람 객체를 생성해서 반환하는 팩토리메서드 선언

    public static Person makePerson(String ssn, String name, int age) {
        return new Person(ssn, name, age);
    }


    // INSERT 메서드
    public static boolean save(Person p) {
        //  1. SQL 구문을 작성
        String sql = "INSERT INTO PERSON" + "(ssn, person_name, age)" + "VALUES (?,?,?)";
         // sql 구문에는 sql 안에있는것을 넣어야 한다
        try {
            // 2. DB에 접속
            Connection conn = Connect.makeConnection();

            // 3. SQL 실행을 위한 객체 preparedStatement 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 4. SQL 에  ? 값 채우기
            pstmt.setString(1, p.getSsn()); // (ssn ,  )
            pstmt.setString(2, p.getName()); //
            pstmt.setInt(3, p.getAge()); //

            // 5. 실행 명령 내리기
            // - INSERT , UPDATE , DELETE :executeUpdate();
            // - SELECCT : executeQuery();
            // executeUpdate 는 삽입이 실패하면 0이 나온다
            int resultNumber = pstmt.executeUpdate();

            if (resultNumber == 0) return false;
            return true;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE 메서드
    public static boolean remove(String ssn) {
        // 1. SQL구문을 작성
        String sql = "DELETE FROM person WHERE ssn=?";

        // 2. DB에 접속
        try (Connection conn = Connect.makeConnection()) {

            // 3. SQL실행을 위한 객체 PreparedStatement 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 4. SQL에  ? 값 채우기
            pstmt.setString(1, ssn);

            // 5. 실행 명령 내리기
            // - INSERT, UPDATE, DELETE : executeUpdate()
            // - SELECT : executeQuery()

            // executeUpdate는 삭제가 실패하면 0을 리턴
            int resultNumber = pstmt.executeUpdate();

            return resultNumber != 0;

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    // UPDATE 메서드
    public static boolean modify(String name, String ssn) {
        // 1. SQL구문을 작성
        String sql = "UPDATE person " +
                "SET person_name = ? " +
                "WHERE ssn = ?";

        // 2. DB에 접속
        try (Connection conn = Connect.makeConnection()) {

            // 3. SQL실행을 위한 객체 PreparedStatement 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 4. SQL에  ? 값 채우기
            pstmt.setString(1, name);
            pstmt.setString(2, ssn);

            // 5. 실행 명령 내리기
            // - INSERT, UPDATE, DELETE : executeUpdate()
            // - SELECT : executeQuery()

            // executeUpdate는 삭제가 실패하면 0을 리턴
            int resultNumber = pstmt.executeUpdate();

            return resultNumber != 0;

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }


    // SELECT ALL
    public static List<Person> findAll() {

        List<Person> personList = new ArrayList<>();

        // 1. sql 작성

        String sql = "SELECT * FROM person";

        // 2. DB연결
        try (Connection conn = Connect.makeConnection()) {

            // 3. SQL 실행을 위한 PSTMT 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //4 . ? 값 채우기


            //5. sql 실행 -- SELECT 실행시  executeQuery()
            //  ResultSet : 조회 결과 나타내는 2차원의 표
            ResultSet rs = pstmt.executeQuery();

            // ResultSet 을 순회해서 소비
            // a - next() 메서드를 통해 행들을 순서대로 지목
            // b - getter메서드를 통해 열데이터를 추

            while (rs.next()) {

                //  rs.next(); // 한줄씩 꺼내줌 한번 치면 첫번째 행 나옴
                //  rs.next(); // 한줄씩 꺼내줌 두번치면 2번째 행 나옴
//                String ssn = rs.getString("ssn");
//                System.out.println("ssn = " + ssn);
//
//                String Person_name = rs.getString("Person_name");
//                System.out.println("Person_name = " + Person_name);
//
//                int age = rs.getInt("age");
//                System.out.println("age = " + age);
//
//                System.out.println("=========================");

                String ssn = rs.getString("ssn");
                String Person_name = rs.getString("Person_name");
                int age = rs.getInt("age");

                Person p = makePerson(ssn, Person_name, age);
                personList.add(p);

            }
          return personList;

        } catch (Exception e) {
            System.out.println("빈 리스트 입니다.");
            e.printStackTrace();
            return Collections.emptyList(); // 빈 리스트 반환

        }

    }

} // end outer class
