package calculator_level_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

// Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기

public class Calculator {
    // 연산 결과 저장
    private Collection<Integer> numbers;


    public int calculate(int num_1, int num_2, char what) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        boolean keepgoing;
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
                while (num_2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.\n 다시 입력해주세요.");
                    num_2 = sc.nextInt();
                }
                result = num_1 / num_2;
                break;
            default:
                System.out.println("사칙연산 기호가 유효하지 않습니다.\n 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/) 중 하나를 입력해주세요.");
                break;
        }

        numbers.add(result);
        return result;
    }

    public Collection<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Collection<Integer> numbers) {
        this.numbers = numbers;
    }

    public void removeResult(){
        if (numbers.isEmpty()){
            System.out.println("삭제할 결과가 없습니다.");
        } else {
            numbers.remove(0);
        }
    }

}
