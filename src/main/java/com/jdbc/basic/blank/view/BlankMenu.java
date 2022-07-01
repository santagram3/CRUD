package com.jdbc.basic.blank.view;


import com.jdbc.basic.blank.controller.BlankController;
import com.jdbc.basic.blank.controller.PlayerController;
import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.blank.domain.Players;


import java.util.Map;
import java.util.Scanner;

public class BlankMenu {

    private PlayerController playerController;
    private BlankController controller;
    private Scanner sc;
    Map<Integer, Blank> table;
    int count = 10;

    public BlankMenu() {
        controller = new BlankController();
        sc = new Scanner(System.in);
        table = controller.giveTable();
        playerController = new PlayerController();

    }

    public void mainManu() {

        while (true) {

            System.out.println("\n============공백 빠르게 세기 에 오신걸 환영합니다.==========");
            String name = sc.next();

            System.out.println("# 1. 문제 설명 보기 ");
            System.out.println("# 2. 문제 풀기 ");
            System.out.println("# 3. 내 기록 보기 ");
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
//                    modifyMenu();
                    break;
                case 5:
//                    removeMenu();
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
    // 내 기록 보기
    private void lookMyScore() {

    }

    public void printText() {
        System.out.println("당신의 이름은 ? ");
        String name = sc.next();
        long accmulTime = 0;
        for (Integer q : table.keySet()) {
            long start = System.currentTimeMillis();
            System.out.println("============================\n");
            System.out.printf("%d번 문제를 풀겠습니다.\n", table.get(q).getQnum());
            Blank blank = table.get(q);
            String texts = blank.getTexts();
            System.out.println("===========================");
            System.out.println(">>> 공백의 갯수를 입력하세요 ");
            System.out.println(texts);
            int s = sc.nextInt();
            long end = System.currentTimeMillis();
            if (table.get(q).getAnswer() == s) {
                System.out.println("문제를 맞췄습니다.");
                count ++;
            } else if (table.get(q).getAnswer() != s) {
                System.out.printf(" 문제를 틀리셨습니다 공백의 갯수는 %d 입니다.", table.get(q).getAnswer());
            }
            long time = (end-start)/1000;
            System.out.printf("걸린 시간은 %d 초 입니다." , time);
            accmulTime += time;
        }
        Players players =new Players();
        players.setPname(name);
        players.setOnumber(count);
        players.setPlustime((int) accmulTime);

          playerController.insertList(players);
    }


    private void explanation() {
        System.out.println("==================================");
        System.out.println(" 문제는 간단합니다 , 주어진 문장을 보고 사이의 공백의 갯수를 맞춰주시면 됩니다.");
        System.out.println("가 나 다 라 마마마");
        System.out.println("위의 문장에서 공백의 갯수는 4개 입니다");
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
