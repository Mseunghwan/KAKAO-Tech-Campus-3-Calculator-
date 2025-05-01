package calculator_level_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

// Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기

public class ArithmeticCalculator<T extends Number> {
    // 연산 결과 저장
    private Collection<Double> numbers;

    public ArithmeticCalculator() {
        numbers = new ArrayList<>();
    }

    public double calculate(T num_1, T num_2, OperatorType what) {
        Scanner sc = new Scanner(System.in);

        double first = num_1.doubleValue();
        double second = num_2.doubleValue();
        double result = 0;

        boolean keepgoing;
        switch (what) {
            case ADD :
                result = first + second;
                break;
            case MINUS :
                result = first - second;
                break;
            case MULTIPLY :
                result = first * second;
                break;
            case DIVIDE :
                if (second == 0) {
                    System.out.println("나눗셈 연산에서 분모가 0이 될 수 없습니다.\n 1을 기준으로 시행합니다.");
                    second = 1;
                }
                result = first / second;
                break;
            default:
                System.out.println("사칙연산 기호가 유효하지 않습니다.\n 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/) 중 하나를 입력해주세요.");
                break;
        }

        numbers.add(result);
        return result;
    }

    // 저장된 연산 결과 중 입력받은 값 보다 큰 결과값 출력
    public void biggerThanScanner(double here){
        numbers.stream()
                .filter(r -> r > here) // 조건
                .forEach(System.out::println); // 출력
    }

    public Collection<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(Collection<Double> numbers) {
        this.numbers = numbers;
    }

    public void removeResult(){
        if (numbers.isEmpty()){
            System.out.println("삭제할 결과가 없습니다.");
        } else {
            ((ArrayList<Double>) numbers).remove(0);
        }
    }

}
