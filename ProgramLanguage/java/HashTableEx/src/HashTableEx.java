//��ǰ�ڹ� 426������
import java.util.*;

public class HashTableEx {

	public static void main(String[] args) {

		Hashtable h = new Hashtable();
		h.put("21","ȫ�浿");
		h.put("54","Ȳ����");
		h.put("76","�̼ҷ�");
		h.put("123","�ظ�������");
		
		Enumeration e =h.keys();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = (String)h.get(key);
			System.out.println(key+":"+value);
		}
		
	}

}
