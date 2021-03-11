import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex7_Sequence {
	public static void main(String[] args) {
	//Step1.�ڵ��� ������� (�ð�üũ��)
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
	
		//�Է� ������ �������
    	ArrayList<Integer> inputData = new ArrayList();  //�ε� ������ �����ϴ� �迭
    	String line = "";								 //txt������ ���� 1�پ� �ε�
		
    	
    //Step2.������ ���� �ε� �������
    	try {
            //Step2.1 ������ ���� �ε�(input.txt)
        	//File file = new File("C:\\KS_system\\Ex2_SecurityUpdate_2021_02_16\\bin\\input.txt"); // ��� ����
        	
        	File file = new File("C:\\KS_system\\input.txt"); // ��� ����
            
        	FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step2.2 InputValue�迭�� Input������ ����
            while( ( line = bufferedReader.readLine() )!=null ) {
            	String[] words = line.split("\\s");	//������ �������� ������ �Է�
            	for(String wordEach : words) { //1���� ������ ����
            		inputData.add(Integer.parseInt(wordEach));            			
            	}            	
            }
            
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); //�߸��� output�� ��¾ʵ��� ����ó��. 
        }
		
    	//Step3.������ ���� ���θ� �����ذ� ���� ���� �� ������ ���� ī��Ʈ
    	//Step3.1.������ ���� ���θ� �����ذ� ���� ����
		ArrayList<Integer> saveIncreaseSequence = new ArrayList();
		ArrayList<Integer> saveDecreaseSequence = new ArrayList();
		saveIncreaseSequence.add(0);
		saveDecreaseSequence.add(0);

    	//ArrayList�� 0��°���� �����ϵ��� ����ϴ� ����.(������ġ ������)
		int cellNumberIncreaseArray =0;
    	int cellNumberDecreaseArray =0;
    	
    	//������ ���Ӱ��� ī��Ʈ(�⺻���� 0���� �ϸ� ���ʽ� 2�� �����ϵ��� ���� ������ �ʿ��ϰ� �ǹǷ� 1���� �ǽ�.)
		int lengthIncreaseSequence =1; 
    	int lengthDecreaseSequence =1;    	
    	
    	//Step3.2.������ ���� ī��Ʈ
		for(int i=1; i<inputData.get(0);i++ ) {	
	    	if(inputData.get(i) <= inputData.get(i+1)) {
				saveIncreaseSequence.set(cellNumberIncreaseArray, ++lengthIncreaseSequence);
			}
	    	else {
	    		lengthIncreaseSequence=1; //������ �ش���� �����Ƿ� ���ο� ������ ī��Ʈ �� �� �ֵ��� 1���� �ʱ�ȭ.
				++cellNumberIncreaseArray; //���� ���̸� ī��Ʈ�� ���� �缳��
				saveIncreaseSequence.add(cellNumberIncreaseArray, 0); //������ ���������� ���� �ʵ��� �������� �̸� ����.
	    		
	    	}
						
	    	
			if(inputData.get(i) >= inputData.get(i+1)) {
				saveDecreaseSequence.set(cellNumberDecreaseArray, ++lengthDecreaseSequence);
			}
			else {
				lengthDecreaseSequence=1; //������ �ش���� �����Ƿ� ���ο� ������ ī��Ʈ �� �� �ֵ��� 1���� �ʱ�ȭ.
				++cellNumberDecreaseArray;//���� ���̸� ī��Ʈ�� ���� �缳��				
				saveDecreaseSequence.add(cellNumberDecreaseArray, 0);//������ ���������� ���� �ʵ��� �������� �̸� ����.
	    	}			

		}
		
    	//Step4. �� ����(������ ������ ���Ҽ� ���� ��2����)�� �ִ� �������̸� ã�´�.(Step5���� ������½� Ȱ��) 
   		int maxIncreaseSequence=0;
		for(int j=0; j<saveIncreaseSequence.size();j++) {
			if(maxIncreaseSequence <saveIncreaseSequence.get(j)){
				maxIncreaseSequence=saveIncreaseSequence.get(j);
			}
		}

		int maxDecreaseSequence=0;
		for(int k=0; k<saveDecreaseSequence.size();k++) {
			if(maxDecreaseSequence <saveDecreaseSequence.get(k)){
				maxDecreaseSequence=saveDecreaseSequence.get(k);
			}
		}
		
		
		
		
		//Step5. output.txt���Ϸ� ������
		File file = new File("C:\\KS_system\\output.txt"); // ��� ����
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

	        //���������� ����� ���� �� ������ ���� ������ ��¹����� ������ ��� �ǽ�.
	        if(maxIncreaseSequence>=maxDecreaseSequence) {
		        writer.write(Integer.toString(maxIncreaseSequence));	        	
	        }
	        else if(maxIncreaseSequence<=maxDecreaseSequence) {
		        writer.write(Integer.toString(maxDecreaseSequence));	        	
	        }

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
