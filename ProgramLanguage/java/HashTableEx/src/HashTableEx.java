//명품자바 426페이지
import java.util.*;

public class HashTableEx {

	public static void main(String[] args) {

		Hashtable h = new Hashtable();
		h.put("21","홍길동");
		h.put("54","황기태");
		h.put("76","이소룡");
		h.put("123","해리슨포드");
		
		Enumeration e =h.keys();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = (String)h.get(key);
			System.out.println(key+":"+value);
		}
		
	}

}
