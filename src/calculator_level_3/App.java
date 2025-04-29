package calculator_level_3;

import java.util.Scanner;

// Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받는 첫 번째, 두 번째 숫자
        int num_1;
        int num_2;
        char what;
        int result = 0;

        ArithmeticCalculator calc = new ArithmeticCalculator();

        boolean keepgoing;
        do {
            System.out.println("첫 번째 숫자를 입력하세요 : ");
            num_1 = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요 : ");
            num_2 = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요 : ");
            what = sc.next().charAt(0);

            // calculate로 연산
            result = calc.calculate(num_1, num_2, what);

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
