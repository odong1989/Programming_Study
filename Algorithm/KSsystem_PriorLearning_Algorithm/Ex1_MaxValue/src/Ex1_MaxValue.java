import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Ex1_MaxValue { 
    public static void main(String[] args) {
		//Step1. ��������
		//�Է� ������ �������
    	int arrayInputValue[] = new int[9];  //�ε� ������ ����
		int arrayCell =0;
		String line = "";
		
		//����� �����
		int maxValueData[]= new int[2];
        maxValueData[0]= 0;
        maxValueData[1]= 0;
        

        try {
            //Step2. ������ ���� �ε�(input.txt)
        	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\input.txt"); // ��� ����
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step3.�迭�� ������ ����
            while( ( line = bufferedReader.readLine() )!=null ) {
    		    arrayInputValue[arrayCell] = Integer.parseInt(line);  		    
    		    arrayCell++;
            }    
            
        } catch (Exception e) { //Step2. ������ ���� �ε�(input.txt) ������ ����ó��
            e.printStackTrace();
//            System.out.println("����1�� input.txt�� �д� ���߿����� �߻��Ͽ����ϴ�.");
//            System.out.println("���α׷� �����մϴ�.");
            System.exit(0); //�߸��� output�� ��¾ʵ��� ����ó��.
        }
        
        //step4.�ִ밪 �� ���ȣ ����
        for(int i=0; i < arrayInputValue.length;i++) {
        	//�ʱⰪ�� ���� �ʱⵥ���Ͱ� ���� ��쵵 ���� ������
        	if(arrayInputValue[i]>maxValueData[0]){
        		maxValueData[0]=arrayInputValue[i];
        		maxValueData[1]=i+1;
        	}
        }        
        
        
        //step5. output.txt���Ϸ� ������
    	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\output.txt"); // ��� ����
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(Integer.toString(maxValueData[0]) + "\n" + Integer.toString(maxValueData[1]) );
            writer.close();
            System.out.println("����1�� output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


// 1)txt���� 1�پ� �ε� ���� : https://breath91.tistory.com/entry/�ڹ�-�ؽ�Ʈ-����-��-�پ�-�б�-���� [��[Breath]]
// 2)txt����,String���� ���� : https://codechacha.com/ko/java-write-to-a-file/
