/*
책260페이지
예제5-3 instanceof를 이용한 객체 구별
*/
class PersonInstanceofExample{
    //별도 내용없음
}

class StudentInstanceofExample extends PersonInstanceofExample{
    //별도 내용없음.
}

class Researcher extends PersonInstanceofExample{
    //별도 내용없음.
}

class ProfessorInstanceofExample extends Researcher{
    //별도 내용없음.
}

public class InstanceofExample {
    public static void main(String[] args){
        PersonInstanceofExample jee = new StudentInstanceofExample();
        PersonInstanceofExample kim = new ProfessorInstanceofExample();
        PersonInstanceofExample lee = new Researcher();

        if(jee instanceof StudentInstanceofExample) //jee는 studnet타입으로 ture이다.
            System.out.println("jee는 student타입");
        if(jee instanceof Researcher)                   //jee는 Researcher타입이 아니므로 false이다.
            System.out.println("jee는 Researcher타입");

        if(kim instanceof StudentInstanceofExample) //kim는 student타입이 아니므로 false
            System.out.println("kim는 student타입");
        if(kim instanceof ProfessorInstanceofExample) //kim는 professor타입이므로 ture
            System.out.println("kim는 Professor타입");
        if(kim instanceof PersonInstanceofExample)   //kim는 person타입이기도 하므로 ture 맞음
            System.out.println("kim는 person타입");

        if(lee instanceof ProfessorInstanceofExample) //lee는 prfessor타입이 아니므로 false
            System.out.println("lee는 professor타입");

        if("java" instanceof String) //java는 String 타입의 인스턴스이므로 true
            System.out.println("\"java\"는 String 타입");
    }    
}
