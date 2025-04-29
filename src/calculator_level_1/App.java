package calculator_level_1;

import java.util.Scanner;

// Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받는 첫 번째, 두 번째 숫자
        int num_1;
        int num_2;
        char what;
        int result = 0;

        boolean keepgoing;
        do {
            System.out.println("첫 번째 숫자를 입력하세요 : ");
            num_1 = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요 : ");
            num_2 = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요 : ");
            what = sc.next().charAt(0);
            switch (what) {
                case '+':
                    result = num_1 + num_2;
                    break;
                case '-':
                    result = num_1 - num_2;
                    break;
                case '*':
                    result = num_1 * num_2;
                    break;
                case '/':
                    while (num_2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.\n 다시 입력해주세요.");
                        num_2 = sc.nextInt();
                    }
                    result = num_1 / num_2;
                    break;
                default:
                    System.out.println("사칙연산 기호가 유효하지 않습니다.\n 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/) 중 하나를 입력해주세요.");
                    break;
            }

            System.out.println("결과 : " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            keepgoing = true;
            if (sc.next().equals("exit")) {
                keepgoing = false;
                break;
            }
        } while (keepgoing);
    }
}
