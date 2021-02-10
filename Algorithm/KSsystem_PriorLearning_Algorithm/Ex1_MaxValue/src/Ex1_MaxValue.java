/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.*;

public class Ex1_MaxValue {
	public static void main(String[] args)throws IOException {
		
		//Step1. ��������
		String arrayInputValue[] = null;  //�ε� ������ ����
		int arrayResultvalue[][]= null; //���� ����� ����
		int arrayCell=0;
		
		try {
			//Step2.������ ���� �ε�(input.txt)
			File filePath = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\input.txt"); // ��� ����
		    FileInputStream fileStream = null; // ���� ��Ʈ��
		        
		    fileStream = new FileInputStream( filePath );// ���� ��Ʈ�� ����
		    byte[ ] readBuffer = new byte[fileStream.available()];//���� ����
		    
		    
		    while (fileStream.read( readBuffer ) != -1){}
		    System.out.println(new String(readBuffer));
		    fileStream.close(); //��Ʈ�� �ݱ�

		    System.out.println("arrayCell : " + arrayCell);
//		    arrayInputValue[arrayCell] =new String(readBuffer);
		    arrayCell++;
		    
//		    System.out.println("arrayInputValue[inputData]"+arrayInputValue[arrayCell]); //���
		    
		} catch (Exception e) {
			e.getStackTrace();
		}
	
	}
}
	
*/

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
    	int arrayInputValue[] = new int[8];  //�ε� ������ ����
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
    		//    System.out.println(line);
    		    arrayInputValue[arrayCell] = Integer.parseInt(line);  		    
    		    arrayCell++;
            }    
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        //step4.�ִ밪 �� ���ȣ ����
        for(int i=0; i < arrayInputValue.length;i++) {
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
            System.out.println("output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


// 1)txt���� 1�پ� �ε� ���� : https://breath91.tistory.com/entry/�ڹ�-�ؽ�Ʈ-����-��-�پ�-�б�-���� [��[Breath]]
// 2)txt����,String���� ���� : https://codechacha.com/ko/java-write-to-a-file/
