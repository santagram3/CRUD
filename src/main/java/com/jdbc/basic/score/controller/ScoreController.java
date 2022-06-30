package com.jdbc.basic.score.controller;

import com.jdbc.basic.score.domain.Score;
import com.jdbc.basic.score.repository.ScoreOracleRepo;
import com.jdbc.basic.score.repository.ScoreRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 데이터들을 전처리 후처리하고 메모리에 저장 관리하는 클래스
public class ScoreController {


    // 성적 정보가 저장될 맵 (k : 학번 , V: 성적표 )
    // 중간에 한명이 전학가면  남아있는 사람의 학번이 바뀌는게 아니기때문에
    // 고유 번호를 지정해줄수 있는 맵 으로 만든다

    private static Map<Integer, Score> scoreMap;

    // ScoreRepository에 의존성 관계를 가진다.
    private final ScoreRepository repository;

    public ScoreController() {
        this.repository = new ScoreOracleRepo();
    }

    static {
        scoreMap = new HashMap<>();
    }


    // 학생 성적정보 입력 기능
    public void insertStudent(Score score) {
        // 메모리에 저장
        scoreMap.put(score.getStuNum(), score);
        // DB에 저장 명령
        repository.save(score);
    }

    // 성적 전체 조회
    public List<Score> findAllStudents() {

        Map<Integer, Score> Students = repository.findAll();
        scoreMap = Students;

        List<Score> scoreList = new ArrayList<>();
        for (Integer stuNum : scoreMap.keySet()) {
            scoreList.add(scoreMap.get(stuNum));
        }
            return scoreList;
    }

   //  반평균을 구하는 메서드
    public double calcClassAverage(){
        // case 1. : 앱 내부세엇 구한다 .
//        double avgSum = 0.0 ;
//        for (Integer StuNum : scoreMap.keySet()) {
//            avgSum += scoreMap.get(StuNum).getAverage();
//        }
//        return avgSum /scoreMap.size();

    // case 2 . : DB에서 전체 평균을 구해서 가져온다
        return repository.getClassAverage();

    }


    // 성적 개별 조회
    public Score findOneStudent(int stuNum) {
        return repository.findOne(stuNum);
    }

    // 성적 수정
    public boolean updateStudent(int stuNum, int kor, int eng, int math) {
        // 1. DB에서 해당 학생을 조회한다.
        Score target = findOneStudent(stuNum);

        if (target != null) {

            // 2. 수정 진행
            target.setKor(kor);
            target.setEng(eng);
            target.setMath(math);
            target.calc();

            // 3. DB에 수정 반영

            return repository.modify(target);
        }
        return false;
    }

    // 성적정보 삭제
    public boolean deleteStudent(int stuNum) {
        return repository.remove(stuNum);
    }


    // 학번으로 조회했을 때 학생 존재 유뮤를 리턴

    public boolean hasScore (int stuNum){

        return repository.findOne(stuNum) !=null ;
    }



}