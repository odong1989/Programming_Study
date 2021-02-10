//예제2-5 산술연산 예제 책 80-81페이지
public class ArithmeticOperator {
    public static void main(String[] args){
        final int TIME = 500;
        int second;
        int minute;
        int hour;

        second = TIME % 60;     //500초를 60으로 나눈 나머지는 초를 의미.
        minute = (TIME / 60)%60;//500초를 60으로 나눈 몫을 다시 60으로 나눈 나머지는 분을 의미한다.
        hour = (TIME/60)/60;    //500초를 60으로 나눈 몫을 다시 60으로 나눈 몫은 시간을 의미한다.

        System.out.println(TIME+"초는");
        System.out.println(hour+"시간,");
        System.out.println(minute+"분, ");
        System.out.println(second + "초입니다");
        
    }    
}
