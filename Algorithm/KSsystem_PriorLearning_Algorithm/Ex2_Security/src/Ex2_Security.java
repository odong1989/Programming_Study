import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* [����2 ��Ʈ]
 * ��Ʈ1) ���� ��ġ�� �߽����� ������.
 * ��Ʈ2) ��ǥ�� ǥ������� �پ��մϴ�.
 * 	     ������ �������⵵ �ϰ�, 1���� �Ÿ��ε� ǥ���غ��⵵ �ϰ�,2���� ��ǥ�� ǥ���ϴ� ����� �ֽ��ϴ�.
 * */

public class Ex2_Security {
    public static void main(String[] args) {
		//Step1. ��������
		//�Է� ������ �������
    	int InputValue[][] = new int[6][2];  //�ε� ������ ����
		int Cell_x =0, Cell_y =0;
		String line = "";
		
		//����� �����
		int distanceCalculate[][]= new int[3][2];
        

        try {
            //Step2. ������ ���� �ε�(input.txt)
        	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex2_Security\\bin\\input.txt"); // ��� ����
        						  
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step3.InputValue�迭�� Input������ ����
            while( ( line = bufferedReader.readLine() )!=null ) {
            	String[] words = line.split("\\s");	//������ �������� ������ �Է�
            	for(String wordEach : words) {
                	InputValue[Cell_x][Cell_y] = Integer.parseInt(wordEach);            			
            		Cell_y++;
            	}            	
    		    Cell_x++;
    		    Cell_y=0;
            }    
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); //�߸��� output�� ��¾ʵ��� ����ó��. 
        }

        
        //Step4.���� ��ġ �������� �� ������ �Ÿ� ���
		for(int i=2; i <= (InputValue.length-2) ;i++) {
			// 4.1.������ ������ ���� ���⿡ ��ġ���� Ȯ��
			if( InputValue[i][0] == InputValue[5][0] ){ 

				//4.1.1. ������ ������ ������ �ִ°�?
				if(InputValue[i][1] < InputValue[5][1] ){  
					//4.1.1.1. ���Ϲ���-������ ���� ������ ��������
					distanceCalculate[i-2][0]= InputValue[5][1]-InputValue[i][1] ; //�ð���� �Ÿ��� = ����y��-����y��
					distanceCalculate[i-2][1]= (InputValue[0][0]-InputValue[5][1]) + InputValue[0][0] + (2*InputValue[0][1]) + InputValue[i][1]; // �ݽð���� �Ÿ��� = (���κ�����-����y��) + ���κ����� + (2*���κ�����) + ����y��
				}
				else {
					//4.1.1.2. ���Ϲ���-������  ���� ������ ��������
					distanceCalculate[i-2][0]= InputValue[i][1]-InputValue[5][1]+ ( InputValue[0][0]+(2*InputValue[0][1]) ); //�ݽð����
					distanceCalculate[i-2][1]= InputValue[i][1]-InputValue[5][1] ; //�ð���� �Ÿ��� = ����y��-����y��
				}	
			}
			
			
			// 4.2.������ ������ ���� ������� �����Ѱ�?
			else if( InputValue[i][0] <=2 && InputValue[5][0]<=2 ){ 
				distanceCalculate[i-2][0]= InputValue[i][1]+InputValue[5][1] + InputValue[0][1]; //�ð����  : ����x��+����x��+���κ�����
				distanceCalculate[i-2][1]= (InputValue[0][0]-InputValue[i][1]) + (InputValue[0][0]-InputValue[5][1]) + InputValue[0][1];  //�ݽð���� : (���κ�����-����x��)+(���κ�����-����x��)+���κ�����
			}	


			// 4.3. ������ ������ ���� ������� �ٸ����
			else {			
				if(InputValue[i][1] < InputValue[5][1] ){ 
					//4.3.1. ������ ���� ������ ����
					distanceCalculate[i-2][0]= InputValue[5][1] + (InputValue[0][1]-InputValue[i][1]); //�ð���� �Ÿ��� = ����y��+(���κ�����-����y��)
					distanceCalculate[i-2][1]= (InputValue[0][0]-InputValue[5][1]) + InputValue[0][1]+ InputValue[0][0] +InputValue[i][1]; 
					        // �ݽð���� �Ÿ��� = (���κ�����-����y��) +���κ�����+ ���κ�����+����y��
				}
				
				else {
					//4.3.2.  ������ ���� ������ ����
					distanceCalculate[i-2][0] = InputValue[5][1]+InputValue[0][1] +InputValue[0][0] +(InputValue[0][1]-InputValue[i][1]) ; //�ð���� �Ÿ��� = ����y��         +���κ�����         +���κ�����        +(���κ�����-����y��)
					distanceCalculate[i-2][1] = (InputValue[0][0]-InputValue[5][1]) + InputValue[i][1]; //�ݽð���� �Ÿ��� = (���κ�����-����y��)+����y��
				}	
			}
		}
        
		
		
		
		
		
		
        //step5. output.txt���Ϸ� ������
    	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex2_Security\\bin\\output.txt"); // ��� ����
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        	int temp=0;
        	
            for(int i=0; i < distanceCalculate.length ;i++) {
            	if(distanceCalculate[i][0]<distanceCalculate[i][1]){
            		temp=temp+distanceCalculate[i][0];
            	}
            	else {
            		temp=temp+distanceCalculate[i][1];
            	}
            }
            
            writer.write(Integer.toString(temp) );
            writer.close();
            System.out.println("����2�� output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//[����] split���� String �� https://mainia.tistory.com/3950
//[����] �ڹ�-2���� �迭�� ���� ��� https://marvell.tistory.com/entry/Java-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%EA%B8%B8%EC%9D%B4

/*
//[����]2���� �迭 �ݺ���
for(int i=0; i < InputValue.length;i++) {	//2���� �迭 ���� ���̸�ŭ �ݺ�.
	for(int j=0; j < InputValue[i].length; j++) {							//2���� �迭 ���� ���̸�ŭ �ݺ�.
	//	System.out.println("InputValue["+i+"]["+j+"] : " + InputValue[i][j]); //�л��Է� üũ           		
	}        
}
*/