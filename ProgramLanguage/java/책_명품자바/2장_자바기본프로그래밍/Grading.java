//예제 2-12 학점 매기기 (95p)
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Grading {
    public static void main(String[] args){
        char grade;

        Scanner a = new Scanner(System.in);

        while(a.hasNext() ){
            System.out.println("받은 점수를 입력해주세요.");
            int score = a.nextInt();//키보드에서 정수를 입력받음.
            if(score >= 90.0)
                grade = 'A';
            else if(score >=80.0)
                grade = 'B';
            else if(score >=70.0)
                grade = 'C';
            else if(score >=60.0)
                grade = 'D';
            else
                grade = 'F';
                
            System.out.println("학점은"+grade+"입니다");
        }
    }
}
