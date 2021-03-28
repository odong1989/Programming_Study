//255page

class PersonExUpcasting{
    String name;
    String id;

    public PersonExUpcasting(String name){
        this.name= name;
    }
}

class StudentExUpcasting extends PersonExUpcasting{
    String grade;
    String department;

    public StudentExUpcasting(String name){
        super(name);
    }
}

public class UpcasingEx {
    public static void main(String[] args){
        PersonExUpcasting p;

        StudentExUpcasting s = new StudentExUpcasting("이재문");
        p=s; //업캐스팅 발생

        System.out.println(p.name);
    }
}
