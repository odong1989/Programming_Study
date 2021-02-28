import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

		int countOfCrash=0;
		int maxChash = 0;
		int deleteKey =0;
		int countOfDeleteLines=0;
		ArrayList resultPrint = new ArrayList();
		resultPrint.add(0);
		
		do{
			countOfCrash=0;
			maxChash = 0;
			deleteKey=0;
			
			//���ĵ� �����͹迭�� Ȱ���Ͽ� ��ħȽ�� üũ
			for(int i=0; i < compareChart.length-countOfDeleteLines;i++) {
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
			
			//��ħȽ�� üũ �� �ִ��浹Ƚ���� ã�� �ݺ��� �ǽ�
			for(int k=0; k < compareChart.length-countOfDeleteLines ;k++) {
				//�� ��ħȽ�� �հ�
				countOfCrash=countOfCrash+compareChart[k][2];
				
				//�浹�� ���帹�� �߻��� ������ ã��
				if(compareChart[k][2] >maxChash){
					maxChash=compareChart[k][2];
					deleteKey=k;
				}
				//�������� 2->2, 4->1ó�� ���� ��ġ�� ���� ������ ���� ��찡 ���� �� �ִ�.
				//�̷��� ��쿡�� �����ϴ� �밢���� ���� ū ���� �����ϵ����Ѵ�.
				else if(maxChash <=compareChart[k][2] && Math.abs(compareChart[k][0]-compareChart[k][1]) > Math.abs(compareChart[deleteKey][0]-compareChart[deleteKey][1])) 
				{
					maxChash=compareChart[k][2];
					deleteKey=k;
				}
			}
			
			//�����¿� ArrayList resultPrint�� ������ ����
			if(countOfCrash!=0) {
				resultPrint.set(0,++countOfDeleteLines);//������ ���ǰ��� +1���� �迭�� �ݿ�
				resultPrint.add(compareChart[deleteKey][0]);//������ ���� ��ȣ�� ����			
				//compareChart�迭���� ���� ��ġ�� ���� ���� ������ �迭 ������ 
				for(int l=0; l < compareChart.length-countOfDeleteLines ;l++) {
				     if(l==deleteKey){
				           for(int m=l; m<compareChart.length-1; m++){
				        	   compareChart[m][0] =compareChart[m+1][0];
				        	   compareChart[m][1] =compareChart[m+1][1];
				        	   compareChart[m][2] =0;//������ ī��Ʈ �ʱ�ȭ
				           }
				           //�ǳ��� �迭�� ���̻� �������Ƿ� 0���� �ʱ�ȭ
				           compareChart[compareChart.length-countOfDeleteLines][0]=0;
				           compareChart[compareChart.length-countOfDeleteLines][1]=0;
				           compareChart[compareChart.length-countOfDeleteLines][2]=0;
				        break;
				     }
				     else {
			        	   compareChart[l][2] =0;//������ ī��Ʈ �ʱ�ȭ
				     }
				}
			}		
		}while(countOfCrash >0);
		
	    //step. output.txt���Ϸ� ������
		File file = new File("C:\\KS_system\\output.txt"); // ��� ����
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        
	        for(int i=0; i<resultPrint.size();i++ ){
	        	writer.write( resultPrint.get(i).toString() );
	        	writer.write( "\n".toString() );
	        }
	        writer.close();
	        System.out.println("����6�� output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }		
	    
	    //����� �ð� �ڵ� �߰�        
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); //�� �ð��� �� ���
		System.out.println("�ð�����(ms) : "+secDiffTime);
	    
	}
}
