interface MobilePhone{
    public boolean sendCall();
    public boolean receiveCall();
    public boolean sendSMS();
    public boolean receiveSMS();
}

interface MP3{
    public void play();
    public void stop();
}

class PDA{
    public int calculate(int x, int y){
        return x+y;
    }
}

public class SmartPhone extends PDA implements MobilePhone, MP3 {
    //MobilePhone의 모든 추상메소드 구현
    public boolean sendCall(){
        System.out.println("전화 걸기");
        return true;
    }

    public boolean receiveCall(){
        System.out.println("전화 받기");
        return true;
    }

    public boolean sendSMS(){
        System.out.println("SMS 보내기");
        return true;
    }

    public boolean receiveSMS(){
        System.out.println("SMS 받기");
        return true;
    }


    //MP3의 모든 추상메소드구현
    public void play(){
        System.out.println("음악 재생");
    }
    public void stop(){
        System.out.println("재생 중지");
    }

    //메소드 추가 구현
    public void scheduler(){
        System.out.println("일정관리");
    }
    public void applicationManager(){
        System.out.println("응용프로그램 설치/삭제");
    }

    public static void main(String[] args){
        SmartPhone p = new SmartPhone();

        p.sendCall();
        p.play();
        p.calculate(3,5);
        p.scheduler();
    }    
}
