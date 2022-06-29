package com.jdbc.basic;

import com.jdbc.basic.PersonCRUD.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jdbc.basic.PersonCRUD.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonCRUDTest {

//    @Test
//    @DisplayName("사람 정보가 데이터베이스에 저장되어야 한다.")
//    void saveTest(){
//
//        // 사람 객체 생성
//        Person p = makePerson("924455-1139212","고길동",38);
//        Person e = makePerson("844455-1139212","길고동",38);
//        // 사람 저장 명령
//        boolean result1 = save(p);
//        boolean result2 = save(e);
//        // 단언
//        assertTrue(result1);
//        assertTrue(result2);
//    }

//    @Test
//    @DisplayName("사람 정보가 데이터베이스에 지워져야 한다.")
//    void removeTest(){
//        boolean flag = remove("266-2313      ");
//        assertTrue(flag);
//    }
//
//    @Test
//    @DisplayName("사람의 이름이 수정되어야 한다.")
//    void updateTest() {
//        boolean flag = modify("사람이므니다","924455-1139212");
//        assertTrue(flag);
//    }

//    @Test
//    void bulkInsertTest() {
//
//        String[] firstNames = {"김", "이", "박", "최", "송", "라"};
//        for (int i = 0; i < 10; i++) {
//            String f = firstNames[(int) (Math.random() * firstNames.length)];
//            save(makePerson("991112-123456"+i, f+"철수", 24));
//        }
//    }
//

    @Test
    @DisplayName("전체 사람 데이터를 조회 해야한다.")
    void findAllTest(){


        List<Person> people = findAll();

        for (Person p : people) {
            System.out.println(p);

        }

    }

}