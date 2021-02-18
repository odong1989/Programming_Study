import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class diceOfThreeUpdate {
	public static void main(String[] args) {
 
    	int dice[]=new int[3];
    	int cellNum=0;
    	
    	//Step2. ������ ���� �ε�(input.txt)
       	String LoadlineOfTxt = "";					 //txt������ ���� 1�پ� �ε�
    	try {
	    	File file = new File("C:\\KS_system\\input.txt"); // ��� ����
	        
	    	FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        //Step3.InputValue�迭�� Input������ ����
	        while( ( LoadlineOfTxt = bufferedReader.readLine() )!=null ) {
	        	String[] words = LoadlineOfTxt.split("\\s");	//������ �������� ������ �Է�
	        	for(String wordEach : words) { //1���� ������ ����
	            	dice[cellNum] = Integer.parseInt(wordEach);
	            	cellNum++;
	        	}    
	        	bufferedReader.close();	       //waring_1_���۸��� �� �������� ��� ����. 	
	        }    
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(0); //�߸��� output�� ��¾ʵ��� ����ó��. 
	    }
    
	    
	    //Step���� ���� ���� üũ
    	int countArrayEqualNum[]=new int[6]; //���� �� ���� ����
    	//int equalNumber=0;   //���� �� ����._������ �ʾƼ� ����.
    	int maxNum=0;	     //���� ū ���� ��(�ֻ��� ���� ��� �ٸ� ���)
    	
    	//�� ���ڸ��� ���� ������ ī��Ʈ.
        for(int i=0; i < dice.length ;i++) {
        	switch(dice[i]) {
            	case 1: 
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 2:
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 3 :
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 4: 
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 5:
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 6 :
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break; 

            	default :
            		System.out.println("���ֿ��� ���ڰ��� Ȯ�εǾ����ϴ�.");	
            		break; 
        	}        	        	
        }
        for(int i=0; i < countArrayEqualNum.length ;i++) {
        	if(countArrayEqualNum[i] >= 1) {
        		maxNum=i+1;
        	}
        }


	    //����� ��ݾ� ���
        int cashPrize = 0;
        for(int i=0; i <6  ;i++) {
        	if(countArrayEqualNum[i] == dice.length ){ 
	        	//��Ģ(1) ���� ���� 3���� ������ 10,000��+(���� ��)*1,000���� ����� �ް� �ȴ�. 
	        	cashPrize = 10000 + (i+1)*1000;
	        }
	        else if(countArrayEqualNum[i] >=2) {
	        	//��Ģ(2) ���� ���� 2���� ������ ��쿡�� 1,000��+(���� ��)*100���� ����� �ް� �ȴ�. 
	        	cashPrize = 1000+ (i+1)*100;
	        }
        }
        if(cashPrize ==0 ){
        	//��Ģ(3) ��� �ٸ� ���� ������ ��쿡�� (�� �� ���� ū ��)*100���� ����� �ް� �ȴ�.
        	cashPrize = maxNum*100;
        }
        
	    //step5. output.txt���Ϸ� ������
		File file = new File("C:\\KS_system\\output.txt"); // ��� ����
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(Integer.toString(cashPrize) );
	        writer.close();
	        System.out.println("����2�� output.txt ������ ��¿Ϸ�Ǿ����ϴ�.");
	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }

	}
}
