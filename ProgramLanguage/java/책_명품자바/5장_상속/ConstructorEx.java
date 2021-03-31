//책 249 페이지 
//[그림5-9] 슈퍼클래스와 서브 클래스의 생성자 간의 호출 및 실행관계
class A {
    public A() {
        System.out.println("생성자 A");
    }
}

class B extends A{
    public B(){
        System.out.println("생성자 B");
    }
}

class C extends B{
    public C(){
        System.out.println("생성자 C");
    }
}


public class ConstructorEx {
    public static void main(String[] args){
        C c;
        c = new C();
    }
}
