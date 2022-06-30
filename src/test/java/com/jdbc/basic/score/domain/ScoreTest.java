package com.jdbc.basic.score.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {


    @Test
    void lombokTest() {
        Score s = new Score(1, "김철수", 99, 88, 11, 300, 55);
        s.setTotal(22);

        System.out.println(s.getStuName());
        assertEquals(s.getStuName(),"김철수");

        // 했는데
        // 이거 안뜨면
        // annotation processing
        // 설정 annotation processing

    }

    @Test
    void lombokBuilderTest(){
        Score park = new Score.ScoreBuilder()
                .stuNum(2)
                .stuName("박영희")
                .math(92)
                .eng(100)
                .total(192)
                .average(96).build();

        System.out.println(park);
    }




}