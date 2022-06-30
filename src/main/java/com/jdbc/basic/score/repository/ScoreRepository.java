package com.jdbc.basic.score.repository;

import com.jdbc.basic.score.domain.Score;

import java.util.Map;

public interface ScoreRepository {


    //  성적 정보 저장
    boolean save(Score score);
    // boolean 으로 만드는 이유 실패 여부를 알수 있어서
    // 굳이 리턴값을 받을 이유가 없다

    // 성적 정보 삭제
    boolean remove(int StuMum);

    // 성적 정보 수정
    boolean modify(Score score);

    // 전체 성적 조회
    Map<Integer,Score> findAll();

    // 개별 성적 조회 // 1 명
    Score findOne(int StuNum);
    // 1명 찾아오는거고 그거 전체를 받아옴

    // 반 전체 평균 조회
    double getClassAverage();







}
