package com.jdbc.basic.blank.view;


import com.jdbc.basic.blank.controller.BlankController;
import com.jdbc.basic.blank.controller.PlayerController;
import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.blank.domain.Players;

import java.util.*;
import java.util.Map;
import java.util.Scanner;

public class BlankMenu {

    private PlayerController playerController;
    private BlankController controller;
    private Scanner sc;
    Map<Integer, Blank> table; // 문제테이블
    //    List<Players> playersList;
   // Players[] playerList;
    List<Players> playerList2;
    boolean flag;

    public BlankMenu() {
        controller = new BlankController();
        playerController = new PlayerController();
        sc = new Scanner(System.in);
        table = controller.giveTable();
      //  playerList = playerController.givePlayerTable();
        flag = false;
        playerList2 = playerController.givePlayerTable2();
    }

    public void mainManu() {

        while (true) {

            System.out.println("\n============내가 스페이스를 몇번 눌렀을까 ? ==========");

            System.out.println("# 1. 문제 설명 보기 ");
            System.out.println("# 2. 문제 풀기 ");
            System.out.println("# 3. 내 기록 조회하기 ");
            System.out.println("# 4. 명예의 전당 ");
            System.out.println("# 9. 끝내기");

            int menu = inputN("\n메뉴 입력: ");

            switch (menu) {
                case 1:
                    explanation();
                    break;
                case 2:
                    printText();
                    break;
                case 3:
                    lookMyScore();
                    break;
                case 4:
                    hallOfFame();
                    break;
                case 9:
                    System.out.println("\n# 프로그램을 종료합니다.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("\n# 메뉴를 다시 입력하세요.");
            }
        }

    }

    private void hallOfFame() {
        System.out.println("=============명예의 전당===========");
        System.out.println("# 1. 문제 맞춘 갯수로 정렬 해서보기 ");
        System.out.println("# 2. 시간순으로 보기 ");

        int menu = inputN("\n메뉴 입력: ");

        switch (menu) {
            case 1:
                List<Players> nTable = playerController.givePlayerNumberTable();
                for (Players n : nTable) {
                    System.out.println(n);
                }
                break;
            case 2:
                List<Players> tTable = playerController.givePlayerTimeTable();
                for (Players t : tTable) {
                    System.out.println(t);
                }
                break;
            case 9:
                System.out.println("\n# 프로그램을 종료합니다.");
                System.exit(0);
                return;
            default:
                System.out.println("\n# 메뉴를 다시 입력하세요.");
        }
    }

    // 내 기록 보기
    private void lookMyScore() {

        // 이미 들어가있는 데이터는 검색이 되는데
        // 새로 들어간 데이터는 검색이 안된다
        // 갱신된 결과값이 안나옴
        System.out.println("찾고싶은 ID을 적어주세요 ");
        String result = sc.next();
        for (Players players : playerList2) {
//            System.out.println("===================");
            if (players.getPname().equals(result)){
                System.out.println("찾으시는 정보 >> ");
                System.out.println(players);
               flag = true;
               break;
            }
        }
        if (!flag) {
            System.out.println("찾으시는 ID가 없습니다 ");
        }

        // 배열로 하면 검색이 안되고 리스트로 해야 검색 되는이유가 뭔지 모르겠다 .

//        for (Players players : playerList) {
//            System.out.println(players);
//            if (players.getPname().equals(result)) {
//                System.out.println("===============");
//                System.out.println(players);
//                flag = true;
////                break;
//            }
//        }
//        if (!flag) {
//            System.out.println("찾으시는 iddd가 없습니다 ");
//        }

    }


    public void printText() {
        System.out.println("당신의 ID는 ? ");
        String name = sc.next();
        int num = 0;
        long accmulTime = 0;
        int count = num;
        for (Integer q : table.keySet()) {

            long start = System.currentTimeMillis();

            System.out.printf("\n%d번 문제를 풀겠습니다.\n", table.get(q).getQnum());
            Blank blank = table.get(q);
            String texts = blank.getTexts();
            System.out.println("===========================");
            System.out.println(texts);
            System.out.println("===========================");
            System.out.println("내가 스페이스를 누른 횟수를 입력하세요 ");
            int s = sc.nextInt();
//            if( s < 0 || !sc.hasNextInt()){
//                System.out.println("음수를 입력하시거나 , 문자를 입력하셨습니까 ? ");
//                System.out.println(" 정수를 입력해주세요 ");
//                continue;
//            }

            long end = System.currentTimeMillis();
            if (table.get(q).getAnswer() == s) {
                System.out.println("문제를 맞췄습니다."); // 여기까지는 맞는데 //
                System.out.printf("현재 맞춘 문제 갯수는 : %d 개 입니다.", ++count); // 카운트 정상작동
                //count += 1;
            } else if (table.get(q).getAnswer() != s) {
                System.out.printf(" 문제를 틀리셨습니다 공백의 갯수는 %d 입니다.\n", table.get(q).getAnswer());
            }
            long time = (end - start) / 1000;
            System.out.printf("걸린 시간은 %d 초 입니다.\n", time);
            accmulTime += time;
        }
        // System.out.println("count = " + count);
        Players players = new Players();
        players.setPname(name);
        players.setOnumber(count);
        players.setPlustime((int) accmulTime);

        playerList2.add(players);
        playerController.insertList(players);
    }


    private void explanation() {
        System.out.println("==================================");
        System.out.println(" 문제는 간단합니다 \n 주어진 문장을 보고 사이의 공백의 갯수를 맞춰주시면 됩니다.");
        System.out.println("==================================");
        System.out.println("가 나 다 라 마마마");
        System.out.println("==================================");
        System.out.println("위의 문장에서 제가 스페이스바를 누른 횟수는 4번 입니다");
        System.out.println();

        System.out.println("==================================");
        System.out.println("가  e  e r   q  w마");
        System.out.println("==================================");
        System.out.println("위의 문장에서 제가 스페이스바를 누른 횟수는 10번 입니다");

        System.out.println("그리고 시간초를 재고 있으니까 빨리 풀어주세요");
    }


    // 숫자입력 메서드
    private int inputN(String msg) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("# 정수로만 입력하세요");
            }
        }
        return n;
    }


}
