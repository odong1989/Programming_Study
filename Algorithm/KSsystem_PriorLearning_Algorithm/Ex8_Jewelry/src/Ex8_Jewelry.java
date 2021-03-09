import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex8_Jewelry {
	public static void main(String[] args) {
		//Step1.
		//�ڵ��� ������� (�ð�üũ��)
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
	
		//�Է� ������ �������
    	ArrayList<Integer> inputData = new ArrayList();  //�ε� ������ �����ϴ� �迭
    	String line = "";								 //txt������ ���� 1�پ� �ε�
		
    //Step2.
    	try {
            //Step2.1 ������ ���� �ε�(input.txt)
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
    	int k =inputData.get(4);
    	
    	int[][] map = new int[inputData.get(0)+1][inputData.get(1)+1]; 

    	
    	int i=4;
    	while(i<inputData.size()) {
	    	for(int x=0; x<=inputData.get(0) ;x++){
	        	for(int y=0;y<=inputData.get(1);y++){
		    		if(x==inputData.get(i) && y==inputData.get(i+1)){
		    			map[x][y]=1;
		    		}
		        }	
	    	}
	    	i=i+2;
    	}
    	
    	
    	ArrayList<Integer> findJewelyEA = new ArrayList();  //�ε� ������ �����ϴ� �迭
    	//�� �ݺ��Ͽ� Ǯ�� �ǽ�
    	int cell=0;
    	int countJewelry=0;
    	for(int x=0; x<(map.length-k);x++) {
    		for(int y=0; y<(map[y].length-k); y++) {

    			for(int searchX=0;searchX<=k;searchX++){
        			findJewelyEA.add(null);
    				for(int searchY=0;searchY<=k;searchY++){
        				if(map[x][y]==1) {
        		    		findJewelyEA.set(cell,++countJewelry);
        				}
        			}	
    	    	cell++;
    	    	countJewelry=0;    			
    			}
    		}

    	}
    	
	    //����� �ð� �ڵ� �߰�        
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); //�� �ð��� �� ���
		System.out.println("�ð�����(ms) : "+secDiffTime);

	}

}
