//예제2-6 비트연산자와 시프트 연산자 사용 예 (책84p)
public class BitShiftOperator {
    public static void main(String[] args){
        short a = (short)0x55ff;
        short b = 0x00ff;

        //비트 연산
        System.out.printf("%x\n", a&b);
        System.out.printf("%x\n", a|b);
        System.out.printf("%x\n", a^b);
        System.out.printf("%x\n", ~a);

        byte c = 20;
        byte d = -8;

        //시프트 연산
        System.out.println(c << 2);
        System.out.println(c >> 2);
        System.out.println(d >> 2);
        System.out.printf("%x\n", d>>>2);
    }
}
