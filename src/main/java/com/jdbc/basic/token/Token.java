package com.jdbc.basic.token;

import java.util.StringTokenizer;

public class Token {

    public static void main(String[] args) {
        System.out.println(" 10문제가 랜덤으로 나갑니다 .");
        System.out.println(" 문장을 읽고 공백의 숫자를 써주시면 되는겁니다 .");
        System.out.println("가나다라 마바사 ");
        System.out.println(" 이 문장에서 공백의 숫자는 2 입니다.");
        System.out.println("===========================");

        String s = "인간의 욕심은 끝이 없고 같은 실수를 반복하지\n" +
                "너그럽게 살면서 대박을 노린다면 어림 반푼어치\n" +
                "우린 운명의 주사위를 던졌고 한치 오차도 용납 못하지";
        System.out.println(s);
        System.out.println("====================");

        System.out.println("문자의 총 길이 : "+s.length());
        StringTokenizer result = new StringTokenizer(s);
        String t = "";
        System.out.println(s.length());

        while (result.hasMoreTokens()) {
            t += result.nextToken();
            //System.out.println(result.nextToken());
        }
        System.out.println(t);
        System.out.println("공백을 뺀 문장 길이 " + t.length());

        // 공백 갯수 구하기 문제를 내는데
        int le =  s.length()-t.length();
        System.out.println("공백 갯수 : " +le);
        // 공백 갯수는

        System.out.println(le);

        int[] arr = new int[5];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }

        long start = System.currentTimeMillis();
        for (int i : arr) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(start);
        System.out.println(end);
        System.out.println(end - start);
        // 0.003초
        // 1000분에 1초



    }


}
