//추상클래스의 종류(책 275페이지)

//종류1-추상메소드를 가진 추상 클래스
//     특징1-추상메소들를 포함하는 클래스이다.
//     특징2-반드시 abstract로 선언되어야 한다.
abstract class DObject{ //추상 클래스 선언
    public DObject next;

    public DObject() {next = null; }
    abstract public void draw(); //추상 메소드 선언
}

//종류2-추상 메소드 없는 추상 클레스
//     특징1-추상메소드가 없음. 하지만 abstract로 선언한 추상클래스이다.
abstract class Person { //추상 클래스 선언
    public String name;
    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
