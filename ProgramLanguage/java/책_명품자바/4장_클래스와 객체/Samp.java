/*
this의 상세 설명(책 189페이지)
 */

public class Samp{
    int id;
    public Samp(int x) 
    {
        this.id = x;
    }

    public void set(int x)
    {
        this.id =x;
    }

    public int get()
    {
        return this.id;
    }

    public static void main(String[] args){
        Samp ob1 = new Samp(3);
        Samp ob2 = new Samp(3);
        Samp ob3 = new Samp(3);

        //아래의 System.out.println()은 책에 없던 부분. 실제 결과확인 위해 임의로 추가.
        System.out.println("ob1 : "+ob1.get());
        System.out.println("ob2 : "+ob2.get());
        System.out.println("ob3 : "+ob3.get());
        
        ob1.set(5);
        ob2.set(6);
        ob3.set(7);

        //아래의 System.out.println()은 책에 없던 부분. 실제 결과확인 위해 임의로 추가.
         System.out.println("ob1,2,3 set()메소드 실시후");
         System.out.println("ob1 : "+ob1.get());
         System.out.println("ob2 : "+ob2.get());
         System.out.println("ob3 : "+ob3.get());
    }
}