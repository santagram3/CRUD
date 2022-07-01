package com.jdbc.basic.blank.repository;

import com.jdbc.basic.blank.domain.Blank;


import java.util.Map;


public interface BlankRepository {

    // 하나만 가져오기
    Blank findOne(int qnum);

    // 전체 가져오기
    Map<Integer, Blank> findAll();






}
