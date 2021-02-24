import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex6_electricWire {
	public static void main(String[] args){
		
		//�Է� ������ �������
    	int InputValue[][] = new int[9][2];  //�ε� ������ �����ϴ� �迭
		int Cell_x =0, Cell_y =0;			 //�迭�� ��ġ ����
    	String line = "";					 //txt������ ���� 1�پ� �ε�
		
		try {
            //Step2. ������ ���� �ε�(input.txt)
        	//File file = new File("C:\\KS_system\\Ex2_SecurityUpdate_2021_02_16\\bin\\input.txt"); // ��� ����
        	
        	File file = new File("C:\\KS_system\\input.txt"); // ��� ����
            
        	FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step3.InputValue�迭�� Input������ ����
            while( ( line = bufferedReader.readLine() )!=null ) {
            	String[] words = line.split("\\s");	//������ �������� ������ �Է�
            	for(String wordEach : words) { //1���� ������ ����
                	InputValue[Cell_x][Cell_y] = Integer.parseInt(wordEach);            			
            		Cell_y++;
            	}            	
    		    Cell_x++;
    		    Cell_y=0;
            }
            
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); //�߸��� output�� ��¾ʵ��� ����ó��. 
        }
		
		//��ħ Ƚ���� ī������ �迭 ���� �� ī���� �ǽ�.
		int compareChart[][] = new int [InputValue.length-1][3]; //x,y,��ħȽ��
		for(int i=0; i <compareChart.length ; i++) {
			//x,y������ �ε�
			compareChart[i][0] = InputValue[i+1][0];
			compareChart[i][1] = InputValue[i+1][1];

			//��ħȽ�� ī���� �ǽ�.
			for(int j=1; j<InputValue.length;j++){
				//���� ��߹����� ��� �ǽþʵ��� ����
				if(compareChart[i][0] != InputValue[j][0]){
					//1.��(3��)�������� �浹 �߻��� ī��Ʈ����

					 if(compareChart[i][0] >InputValue[j][0] && compareChart[i][1]> InputValue[j][1]) {
						 compareChart[i][2]++;
					 }

					//2.��(5��)�������� �浹 �߻��� ī��Ʈ���� 
					 else if(compareChart[i][0] < InputValue[j][0] && compareChart[i][1]> InputValue[j][1]) {
						 compareChart[i][2]++;
					 }
				}
			}
			
		}
			
		
		
		
		
		
	    //step. output.txt���Ϸ� ������
		File file = new File("C:\\KS_system\\output.txt"); // ��� ����
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(Integer.toString(111) );
	        writer.close();
	        System.out.println("����4�� output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");
	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }		
		
	}
}
