package com.jdbc.basic.score.domain;

import lombok.*;

// 클래스 위에 작성


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder // 객체 생성시 생성자 역할을 대신
// 데이터베이스 score 테이블의 행 데이터를 저장할 객체

//@Data // 쓰지마

// 데이터베이스 score테이블의 행 데이터를 저장할 객체
public class Score {

    private int stuNum ; //    stu_num
    private String stuName;  // stu_name
    private int kor ;
    private int eng ;
    private int math ;

    private int total ;
    private double average;

// 총점 평균을 계산하는 메서드
    public void calc(){

        this.total = kor + eng + math;
        this.average = Math.round((total/3.0) * 100 /100.0);
    }








}
