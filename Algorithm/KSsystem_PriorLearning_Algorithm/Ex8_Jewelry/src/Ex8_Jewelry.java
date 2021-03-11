import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex8_Jewelry {
	public static void main(String[] args) {
		//Step1.�ڵ��� ������� (�ð�üũ��)
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
	
		//�Է� ������ �������
    	ArrayList<Integer> inputData = new ArrayList();  //�ε� ������ �����ϴ� �迭
    	String line = "";								 //txt������ ���� 1�پ� �ε�
		
    	//Step2.�����ͷε�
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
 
    	//k : Ž���� �� ĭ�� ��
    	int k =inputData.get(3);
    	
    	//map : ������ �ִ� ��ġ�� ���� 1�� ������ �Ѵ�.
    	int[][] map = new int[inputData.get(0)+1][inputData.get(1)+1]; 

    	// location : inputData���� ������ x,y���� �������� ���� ����.  
    	int location=4;
    	while(location<inputData.size()) {
	    	for(int x=0; x<=inputData.get(0) ;x++){
	        	for(int y=0;y<=inputData.get(1);y++){
		    		if(x==inputData.get(location) && y==inputData.get(location+1)){
		    			map[x][y]=1;
		    		}
		        }	
	    	}
	    	location=location+2;
    	}
    	
    	//maxJewelyData : ���� ���� ������ ä���� �� �ִ� ��ǥ�� ȹ�溸������
    	int[] maxJewelyData=new int[3];
    	
    	// countJewelry : ���� ���� ������ ä���ϱ� ���� �񱳿뵵�� ����� ����.
    	int countJewelry=0;
		
    	for(int y=0; y<(map[y].length-k); y++) {
			for(int x=0; x<(map.length-k);x++) {
    			for(int searchX=x; searchX<=k+x; searchX++){
    				for(int searchY=y;searchY<=k+y;searchY++){
        				if(map[searchX][searchY]==1) {
        					countJewelry++;
        				}
        			}
    			}  			

    			if(maxJewelyData[2]<countJewelry) {
    				maxJewelyData[0]=x;
    				maxJewelyData[1]=y;
    				maxJewelyData[2]=countJewelry;
    			}
    	    	countJewelry=0;  
    		}
    		
    	}
    	

		//Step5.output.txt���Ϸ� ������
			File file = new File("C:\\KS_system\\output.txt"); // ��� ����
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));

				for(int output=0; output < maxJewelyData.length;output++) {
					if(output==2) {
			        	writer.write( "\n".toString() );						
					}
		        	writer.write( Integer.toString(maxJewelyData[output]));
		        	writer.write( " ".toString() );						
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
