import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex6_electricWire {
	public static void main(String[] args){
		//�ڵ��� ������� (�ð�üũ��)
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
				
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
		//�����͸� �����Ͽ� �ε��Ѵ�.
		int compareChart[][] = new int [InputValue.length-1][3]; //�� 3���� ������(��߹�ȣ, ������ȣ ,��ħȽ��)
		int numberOfStart=1;
		boolean flag=false;

		for(int i=0; i < compareChart.length ;) {
			for(int j=1; j < InputValue.length ; j++) {
				if(flag==false && numberOfStart==InputValue[j][0]){
					//x,y������ ����
					compareChart[i][0] = InputValue[j][0];
					compareChart[i][1] = InputValue[j][1];
					flag=true;//�ش��ȣ�� ��� ������ ���Ծ��µ��� �����Ǵ� �� ������.
				}
			}
			//���������� �����ϴ� ���
			if(flag) {
				i++;
				numberOfStart++;		
				flag=false;
			}
			//�ش��ȣ�� ��� ������ ���Ծ��µ��� �����Ǵ� �� ������.		
			else{
				numberOfStart++;  //���� ���ڸ� ����. ������ �迭�� ����ȣ(i)�� �����ʵ��� �ǽ�.
			}			
		}
			
		//���ĵ� �����͹迭�� Ȱ���Ͽ� ��ħȽ�� üũ
		for(int i=0; i < compareChart.length;i++) {
			//��ħȽ�� ī���� �ǽ�.
			for(int j=0; j<compareChart.length;j++){
				//���� ��߹����� ��� �ǽþʵ��� ����
				int standStart = compareChart[i][0];
				int standEnd = compareChart[i][1];
				int compareStart = compareChart[j][0];
				int compareEnd = compareChart[j][1];
				
				if(standStart != compareStart){

					//1.��(3��)�������� �浹 �߻��� ī��Ʈ����
					 if(standStart > compareStart && standEnd< compareEnd) {
						 compareChart[i][2]++;
					 }

					//2.��(5��)�������� �浹 �߻��� ī��Ʈ���� 
					 else if(standStart < compareStart && standEnd > compareEnd) {
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
	    
	    //����� �ð� �ڵ� �߰�        
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); //�� �ð��� �� ���
		System.out.println("�ð�����(ms) : "+secDiffTime);
	    
	}
}
