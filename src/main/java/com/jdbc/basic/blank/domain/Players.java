package com.jdbc.basic.blank.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString

public class Players {

    private String pname;
    private int onumber;
    private int plustime;

    @Override
    public String toString() {
        return " [" +
                " 사용자 ID : " + pname +
                "  || 맞춘 문제 : " + onumber + "개" +
                "  || 문제 푼 총 시간 : " + plustime + "초"+
                ']';
    }
}
