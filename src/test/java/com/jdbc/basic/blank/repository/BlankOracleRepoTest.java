package com.jdbc.basic.blank.repository;

import com.jdbc.basic.blank.controller.BlankController;
import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.score.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BlankOracleRepoTest {


    BlankOracleRepo repository  = new BlankOracleRepo();

    @Test
    @DisplayName(" 전체 조회를 해야된다 ") // 성공했다
    void findAllTest(){

        Map<Integer, Blank> qMap = repository.findAll();
        for (Integer qnum : qMap.keySet()) {
            System.out.println(qMap.get(qnum));
        }

        assertEquals( 2, qMap.size()); // 사이즈가 2 맞냐 ? // ㅇㅇ 맞아

    }
    @Test
    @DisplayName(" 하나만 조회 되어야 한다 ") // 넘버를 주면 넘버에 맞는 전체를 가져옴
    void findOneTest(){
        Blank b =  repository.findOne(1);

        System.out.println(b);
        assertEquals(1, b.getQnum());

    }
    @Test
    @DisplayName("테이블 주는지 확인해봐")
    void giveTableTest(){
        BlankController blankController = new BlankController();
        Map<Integer, Blank> integerBlankMap = blankController.giveTable();

        for (Integer integer : integerBlankMap.keySet()) {
            System.out.println(integerBlankMap.get(integer));
        }

    }



}