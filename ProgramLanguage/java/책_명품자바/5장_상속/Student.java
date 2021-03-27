/*
책247페이지
예제5-2 상속관계에 있는 클래스 간 멤버 접근
*/ 

class Person5_2{
/*
책에서는 원래 class Person{... }이다.
하지만 class Person5_2{ ...} 으로 클래스 이름을 변경하여 실시.
이유는 'The type Person is already definedJava(0)'라는 에러가 뜨기때문.
Overring.java예제에서 class Person{}이미 선언하였는데 그것이 겹쳐서 에러로 작동하게 되었다.
이 에러가 마이크로소프트의 비쥬얼코드스튜디오에서만 발생하는 것인지는 아직 불명.
*/ 
    int age;                //Student 클래스에서 접근 가능
    public String name;     //Student 클래스에서 접근 가능
    protected int height;   //Student 클래스에서 접근 가능
    private int weight;     //Student 클래스에서 접근 불가!!
    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
}

public class Student extends Person5_2{
    void set(){
        age =30;
        name = "홍길동";
        height = 175;
        setWeight(99);
    }

    public static void main(String[] args){
        Student s = new Student();
        s.set();
    }
}