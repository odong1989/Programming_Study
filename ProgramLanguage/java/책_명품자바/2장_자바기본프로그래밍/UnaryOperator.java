//예제 2-8 대입 여산자와 증감 연산자 사용 88페이지
public class UnaryOperator {
    public static void main(String[] args){
        int opr = 0;
        System.out.println("opr++ : " + opr++);  //출력 후 증가
        System.out.println("opr : " + opr);

        System.out.println("++opr : " + ++opr);  //증가 후 출력
        System.out.println("opr : " + opr);
        
        System.out.println("opr-- : " + opr--);  //출력 후 감소
        System.out.println("opr : " + opr);

        System.out.println("--opr : " + --opr);//감소 후 출력
        System.out.println("opr : " + opr);
    }
}
