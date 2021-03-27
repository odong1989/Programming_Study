/*
class Person과 class Professor는 책과 달리 앞에 public을 제외했다.
제외하지 않으면 
The public type Professor must be defined in its own file 자바 에러가 뜬다.

참고 링크 : https://mainia.tistory.com/1952
*/

class Person{
    String phone;

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }
}

class Professor extends Person{
    
    public String getPhone(){ //Person의 getPhone()을 오버라이딩
        return "Professor : " + super.getPhone(); // Person의 getPhone()호출
    }
}

public class Overriding{
    public static void main(String[] args){
        Professor a = new Professor();

        a.setPhone("011-1234-1234");

        Person p = a;
        System.out.println(p.getPhone());
    }
}
