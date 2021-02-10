//예제2-11 if-else 사용하기 (93p)
import java.util.Scanner;

public class MultipleOfThree {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("숫자를 입력하십시오:");
        int number = in.nextInt();

        if(number %3 ==0)
            System.out.println("3의 배수입니다");
        else
            System.out.println("3의 배수가 아닙니다");

    }    
}
