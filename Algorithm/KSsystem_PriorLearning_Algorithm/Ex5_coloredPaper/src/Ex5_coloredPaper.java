import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex5_coloredPaper {

	public static void main(String[] args) {
    	
		//�Է� ������ �������
    	int InputValue[][] = new int[5][2];  //�ε� ������ �����ϴ� �迭
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
		/*//������ ���� �����ϱ⿣ �ݺ������� Ȱ�뿡 ��ȿ������ Ŀ���� ����..
		int rectange_A[][] = new int[4][2];
		rectange_A[0][0]=InputValue[1][0];		rectange_A[0][1]=InputValue[1][1];	 //(3,7)
		rectange_A[1][0]=rectange_A[0][0]+10;	rectange_A[1][1]=rectange_A[0][1];	 //(13,7)
		rectange_A[2][0]=rectange_A[1][0];		rectange_A[2][1]=rectange_A[1][1]+10;//(13,17)
		rectange_A[3][0]=rectange_A[2][0]-10;	rectange_A[3][1]=rectange_A[2][1]; 	 //(3,17)
		
		int rectange_B[][] = new int[4][2];
		rectange_B[0][0]=InputValue[2][0];		rectange_B[0][1]=InputValue[2][1];	 //(5,2)
		rectange_B[1][0]=rectange_B[0][0]+10;	rectange_B[1][1]=rectange_B[0][1];	 //(15,2)
		rectange_B[2][0]=rectange_B[1][0];		rectange_B[2][1]=rectange_B[1][1]+10;//(15,12)
		rectange_B[3][0]=rectange_B[2][0]-10;	rectange_B[3][1]=rectange_B[2][1]; 	 //(5,12)
		
		int rectange_C[][] = new int[4][2];
		rectange_C[0][0]=InputValue[3][0];		rectange_C[0][1]=InputValue[3][1];	 //(15,7)
		rectange_C[1][0]=rectange_C[0][0]+10;	rectange_C[1][1]=rectange_C[0][1];	 //(25,7)
		rectange_C[2][0]=rectange_C[1][0];		rectange_C[2][1]=rectange_C[1][1]+10;//(25,17)
		rectange_C[3][0]=rectange_C[2][0]-10;	rectange_C[3][1]=rectange_C[2][1]; 	 //(15,17)

		int rectange_D[][] = new int[4][2];
		rectange_D[0][0]=InputValue[2][0];		rectange_D[0][1]=InputValue[2][1];	 //(13,14)
		rectange_D[1][0]=rectange_D[0][0]+10;	rectange_D[1][1]=rectange_D[0][1];	 //(23,14)
		rectange_D[2][0]=rectange_D[1][0];		rectange_D[2][1]=rectange_D[1][1]+10;//(23,24)
		rectange_D[3][0]=rectange_D[2][0]-10;	rectange_D[3][1]=rectange_D[2][1]; 	 //(13,24)
		 */

		//4���� 4������ ��ǥ���� ����
		int rectangeXY[][] = new int [16][2];
		int h=1;
		for(int i=0; i< rectangeXY.length; i++) {
			int initXY=i%4;
			switch(initXY) {
			case 0 :
				rectangeXY[i][0]=InputValue[h][0];
				rectangeXY[i][1]=InputValue[h][1];			
				h++;
				break;
			case 1 :
				rectangeXY[i][0]=rectangeXY[i-1][0]+10;
				rectangeXY[i][1]=rectangeXY[i-1][1];			
				break;
			
			case 2 :
				rectangeXY[i][0]=rectangeXY[i-1][0];
				rectangeXY[i][1]=rectangeXY[i-1][1]+10;			
				break;
			
			case 3 :
				rectangeXY[i][0]=rectangeXY[i-1][0]-10;
				rectangeXY[i][1]=rectangeXY[i-1][1];			
				break;
			}			
		}
		
		
		int tempX=0, tempY=0; //y��ǥ�� ����
		int circumference=0;  //�ѷ�(circumference)����
		boolean flag=true;
		
		for(int i=0; i< 4; i++) {
			int direction=i%4;
			switch(direction) {
				case 0 : //�����
					tempX=rectangeXY[i][0];
					tempY=rectangeXY[i][1];

					for(int j=0;j<10;j++){
						if(tempX < rectangeXY[i+4][0] && tempX < rectangeXY[i+8][0] && tempX < rectangeXY[i+12][0] ) {
							//x�� ��ü�� ���� ������ ����(�Ǵ� ����)����.
							circumference++;
						}
						else if(tempX >= rectangeXY[i+4][0] && !(tempY<=rectangeXY[i+4][1] || tempY<=rectangeXY[i+7][1]))
						{
							circumference++;							
						}
						tempX++;
					}
				
					break;
				
				case 1 : //�����
				
					break;
			
				case 2 : //�����
				
					
					break;
			
			case 3 : //�����
				break;
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
