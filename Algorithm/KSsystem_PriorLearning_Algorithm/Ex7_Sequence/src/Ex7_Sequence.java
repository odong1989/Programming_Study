import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ex7_Sequence {

	public static void main(String[] args) {
		//�ڵ��� ������� (�ð�üũ��)
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
				
		//�Է� ������ �������
    	int InputValue[][] = new int[9][2];  //�ε� ������ �����ϴ� �迭
		int Cell_x =0, Cell_y =0;			 //�迭�� ��ġ ����
    	String line = "";					 //txt������ ���� 1�پ� �ε�
		
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
		
	    //����� �ð� �ڵ� �߰�        
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); //�� �ð��� �� ���
		System.out.println("�ð�����(ms) : "+secDiffTime);

	}

}
