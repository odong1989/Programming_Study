//책 253 페이지 
//[그림5-13] super()를 이용하여 슈퍼 클래스의 생성자를 선택한 경우
class A_Ex4 {
    public A_Ex4() {
        System.out.println("생성자 A");
    }

    public A_Ex4(int x) {
        System.out.println("매개변수 생성자 A"+x);
    }
}

class B_Ex4 extends A_Ex4{
    public B_Ex4(){
        System.out.println("생성자 B");
    }

    public B_Ex4(int x) {
        super(x);
        System.out.println("매개변수 생성자 B"+x);
    }
}


public class ConstructorEx4 {
    public static void main(String[] args){
        B_Ex4 b;
        b = new B_Ex4(5);
    }
}
