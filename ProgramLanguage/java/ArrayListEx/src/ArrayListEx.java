//명품자바 421 페이지 
import java.util.ArrayList;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		
		 a.add("Hello");
		 a.add(new Integer(3));
		 a.add(new Double(3.14));
		 a.add(new Double(3.4));
		 
		 a.remove(1);
		 
		 for(int i=0; i<a.size();i++){
			 Object obj = a.get(i);
			 if(obj instanceof String){
				 String str = (String)obj;
				 System.out.println(str);
			 }
			 
			 else if(obj instanceof Integer){
				 Integer x = (Integer)obj;
				 int n = x.intValue();
				 System.out.println(n);
			 }
			 
			 else if(obj instanceof Double) {
				 Double y = (Double)obj;
				 double d = y.doubleValue();
				 System.out.println(d);
			 }
		 }
		 
	}

}
