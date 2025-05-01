package calculator_level_3;

import java.util.Scanner;

// Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기

public class AppLV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받는 첫 번째, 두 번째 숫자
        double num_1;
        double num_2;
        char what;
        double result = 0;

        ArithmeticCalculator<Double> calc = new ArithmeticCalculator();

        String answer;
        do {
            System.out.println("첫 번째 숫자를 입력하세요 : ");
            num_1 = sc.nextDouble();

            System.out.println("두 번째 숫자를 입력하세요 : ");
            num_2 = sc.nextDouble();

            System.out.println("사칙연산 기호를 입력하세요 : ");
            what = sc.next().charAt(0);

            OperatorType operator = toOperator(what);

            // calculate로 연산
            result = calc.calculate(num_1, num_2, operator);

            System.out.println("결과 : " + result);
            System.out.println("더 계산하시겠습니까? \n(exit 입력 시 종료, remove를 입력하면 첫 결과 삭제, bigger를 입력하면 특정 값보다 큰 결과 출력)");
            sc.nextLine(); // 중간 처리용
            answer = sc.nextLine();
            if (answer.equals("exit")) {
                System.exit(0);
            } else if (answer.equals("remove")){
                calc.removeResult();

            } else if (answer.equals("bigger")){
                System.out.println("기준 값을 입력하세요 : ");
                double in = sc.nextDouble();
                calc.biggerThanScanner(in);
            }
        } while (true);
    }

    public static OperatorType toOperator(char what) {
        switch (what) {
            case '+':
                return OperatorType.ADD;
            case '-':
                return OperatorType.MINUS;
            case '*':
                return OperatorType.MULTIPLY;

            case '/':
                return OperatorType.DIVIDE;

            default:
                throw new IllegalArgumentException("잘못된 연산자입니다. (+, -, *, / 만 가능)");
        }
    }

}

