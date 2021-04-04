public class Samp_190p{
    int id;

    public Samp_190p(int x)
    {
        this.id =x;
    }

    public void set(int x)
    {
        this.id = x;
    }

    public int get()
    {
        return this.id;
    }

    public static void main(String[] args){
        Samp_190p ob1 = new Samp_190p(3);
        Samp_190p ob2 = new Samp_190p(4);
        Samp_190p s;

        s = ob2;
        ob1= ob2; //객체의 치환
        System.out.println("ob1.id="+ob1.id);
        System.out.println("ob2.id="+ob2.id);

    }
}