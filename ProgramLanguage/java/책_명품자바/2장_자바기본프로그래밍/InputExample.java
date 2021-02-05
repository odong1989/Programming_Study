import java.io.*;
//예제 2-3 표준 입력 스트림을 이용한 키보드 입력(페이지74)

public class InputExample {
    public static void main(String[] args){
        InputStreamReader rd = new InputStreamReader(System.in);

        try{
            while(true){
                int a = rd.read();
                if(a == -1)//ctrl + z 입력시 프로그램 무한루프 종료.
                    break;
                System.out.println((char)a);
            }
        }
        
        catch(IOException e){
            System.out.println("입력 오류 발생");
        }
    }    
}
