import java.util.Scanner;

public class example_java_input {

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("입력할 정수 값 : "); 
        int inputValue = stdIn.nextInt();
        System.out.println("입력된 값 : " + inputValue);

    }
}
