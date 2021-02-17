import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4_MelonField {
	public static void main(String[] args) {
		int dataOfMelonField[][] = new int[7][2];
		
    	//Step2. ������ ���� �ε�(input.txt)
       	String LoadlineOfTxt = "";	//txt������ ���� 1�پ� �ε�
		int cell_x =0, cell_y =0;	 //�迭�� ��ġ ����
       	try {
	    	File file = new File("C:\\KS_system\\input.txt"); // ��� ����
	         
	    	FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        //Step3.InputValue�迭�� Input������ ����
	        while( ( LoadlineOfTxt = bufferedReader.readLine() )!=null ) {
	        	String[] words = LoadlineOfTxt.split("\\s");	//������ �������� ������ �Է�
	        	for(String wordEach : words) { //1���� ������ ����
	            	dataOfMelonField[cell_x][cell_y] = Integer.parseInt(wordEach);            			
            		cell_y++;
	        	}
    		    cell_x++;
    		    cell_y=0;
	        }    
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(0); //�߸��� output�� ��¾ʵ��� ����ó��. 
	    }
    	
       	//Step3. �����ִ밪, �����ִ밪 ã��
       	int maxLengthOfMelonField[][] = new int[1][2];
       	maxLengthOfMelonField[0][0]=0; //����� ���α���      	
       	maxLengthOfMelonField[0][1]=0; //����� ���α���
       	
       	for(int i=1;i < dataOfMelonField.length;i++){
       		//1 : ����, 2 : ���� 
       		//���ǹ� ���� ��������
       		if(dataOfMelonField[i][0] ==1 || dataOfMelonField[i][0] ==2){
       			if(dataOfMelonField[i][1] > maxLengthOfMelonField[0][0]){
       				maxLengthOfMelonField[0][0]=dataOfMelonField[i][1];
       			}
       		}
       			
       		else{
       			if(dataOfMelonField[i][1] > maxLengthOfMelonField[0][1]){
       				maxLengthOfMelonField[0][1]=dataOfMelonField[i][1];
       			}
       		}
       	}
       	
       	//Step4. ���� ����(����) ���ϱ�
       	int lengthOfStartPoint[][] = new int[1][2]; //���������� ���۰� ���� ����.
       	lengthOfStartPoint[0][0] = dataOfMelonField[6][1]; //���������� ���α���
       	lengthOfStartPoint[0][1] = dataOfMelonField[1][1]; //���������� ���α���
       	

   		int lengthOfFirstField[][] = new int[1][2]; //ù��° �簢�� ���� ���ϴµ� ���.
   		int lengthOfSecondField[][] = new int[1][2]; //�ι�° �簢�� ���� ���ϴµ� ���.	
   		
   		int areaOfFirstField=0;
   		int areaOfSecondField=0;
   		int areaOftotalField=0; //�������� ���� ����
   		
       	//lengthOfStartPoint�� maxLengthOfMelonField������ ���ο� ���� �� ���� ������� �޶���.
       	if(lengthOfStartPoint[0][0] == maxLengthOfMelonField[0][0] && lengthOfStartPoint[0][1] == maxLengthOfMelonField[0][1]) {
           	//lengthOfStartPoint�� maxLengthOfMelonField���� ��� ���������� ù���� �簢�� ���� ���ϴµ� ���Ұ�.
  
       		//ù��° ������ ���̰� ����
       		lengthOfFirstField[0][0]=dataOfMelonField[2][1];
       	    lengthOfFirstField[0][1]=dataOfMelonField[3][1];
       	    
       		//�ι�° ������ ���̰� ����
       	    lengthOfSecondField[0][0]=dataOfMelonField[6][1]; 
       		lengthOfSecondField[0][1]=dataOfMelonField[7][1]; 

       		//���� �Ѹ���(areaOftotalField) ���
       		areaOfFirstField =lengthOfFirstField[0][0]*lengthOfFirstField[0][1];
       		areaOfSecondField=lengthOfSecondField[0][0]*lengthOfSecondField[0][1];
       		areaOftotalField = areaOfFirstField+areaOfSecondField;
       	}
       	else {
          	//lengthOfStartPoint�� ù��°������ ���ϴµ� Ȱ�밡��. 
       		lengthOfFirstField[0][0]=lengthOfStartPoint[0][0];
       	    lengthOfFirstField[0][1]=lengthOfStartPoint[0][1];
       	    
       	    lengthOfSecondField[0][0]=dataOfMelonField[3][1]; 
       		lengthOfSecondField[0][1]=dataOfMelonField[4][1]; 

       		areaOfFirstField =lengthOfFirstField[0][0]*lengthOfFirstField[0][1];
       		areaOfSecondField=lengthOfSecondField[0][0]*lengthOfSecondField[0][1];
       		areaOftotalField = areaOfFirstField+areaOfSecondField;
       	}
       	
       	//Step5.�翡�� ���꿹��Ǵ� ������ �� ���.
       	int melonPerArea = dataOfMelonField[0][0];
       	int calculateOfMelonEA = areaOftotalField*melonPerArea;
       	
       	
	    //step5. output.txt���Ϸ� ������
		File file = new File("C:\\KS_system\\output.txt"); // ��� ����
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(Integer.toString(calculateOfMelonEA) );
	        writer.close();
	        System.out.println("����4�� output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");
	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }
       	
	}
}
