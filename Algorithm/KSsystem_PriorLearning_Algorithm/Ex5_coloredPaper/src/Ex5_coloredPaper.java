import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex5_coloredPaper {

	public static void main(String[] args) {
    	
		//입력 데이터 저장관련
    	int InputValue[][] = new int[5][2];  //로드 데이터 저장하는 배열
		int Cell_x =0, Cell_y =0;			 //배열의 위치 선택
    	String line = "";					 //txt파일의 문자 1줄씩 로드
		
		try {
            //Step2. 데이터 파일 로드(input.txt)
        	//File file = new File("C:\\KS_system\\Ex2_SecurityUpdate_2021_02_16\\bin\\input.txt"); // 대상 파일
        	
        	File file = new File("C:\\KS_system\\input.txt"); // 대상 파일
            
        	FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step3.InputValue배열에 Input데이터 저장
            while( ( line = bufferedReader.readLine() )!=null ) {
            	String[] words = line.split("\\s");	//공백을 기준으로 나눠서 입력
            	for(String wordEach : words) { //1개의 셀마다 저장
                	InputValue[Cell_x][Cell_y] = Integer.parseInt(wordEach);            			
            		Cell_y++;
            	}            	
    		    Cell_x++;
    		    Cell_y=0;
            }
            
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); //잘못된 output값 출력않도록 종료처리. 
        }
		/*//일일이 나눠 선언하기엔 반복문등의 활용에 비효율성이 커져서 포기..
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

		//4개의 4각형들 좌표값을 저장
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
		
		
		int tempX=0, tempY=0; //y좌표쪽 선택
		int circumference=0;  //둘레(circumference)길이
		boolean flag=true;
		
		for(int i=0; i< 4; i++) {
			int direction=i%4;
			switch(direction) {
				case 0 : //→방향
					tempX=rectangeXY[i][0];
					tempY=rectangeXY[i][1];

					for(int j=0;j<10;j++){
						if(tempX < rectangeXY[i+4][0] && tempX < rectangeXY[i+8][0] && tempX < rectangeXY[i+12][0] ) {
							//x값 자체가 같지 않으면 접점(또는 포함)없음.
							circumference++;
						}
						else if(tempX >= rectangeXY[i+4][0] && !(tempY<=rectangeXY[i+4][1] || tempY<=rectangeXY[i+7][1]))
						{
							circumference++;							
						}
						tempX++;
					}
				
					break;
				
				case 1 : //↑방향
				
					break;
			
				case 2 : //←방향
				
					
					break;
			
			case 3 : //↓방향
				break;
			}			
		}
		
		
	    //step. output.txt파일로 결과출력
		File file = new File("C:\\KS_system\\output.txt"); // 대상 파일
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(Integer.toString(111) );
	        writer.close();
	        System.out.println("예제4의 output.txt 파일이 출력완료되었습니다.");
	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }

	}
}
