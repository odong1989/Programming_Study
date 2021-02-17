import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4_MelonField {
	public static void main(String[] args) {
		int dataOfMelonField[][] = new int[7][2];
		
    	//Step2. 데이터 파일 로드(input.txt)
       	String LoadlineOfTxt = "";	//txt파일의 문자 1줄씩 로드
		int cell_x =0, cell_y =0;	 //배열의 위치 선택
       	try {
	    	File file = new File("C:\\KS_system\\input.txt"); // 대상 파일
	         
	    	FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        //Step3.InputValue배열에 Input데이터 저장
	        while( ( LoadlineOfTxt = bufferedReader.readLine() )!=null ) {
	        	String[] words = LoadlineOfTxt.split("\\s");	//공백을 기준으로 나눠서 입력
	        	for(String wordEach : words) { //1개의 셀마다 저장
	            	dataOfMelonField[cell_x][cell_y] = Integer.parseInt(wordEach);            			
            		cell_y++;
	        	}
    		    cell_x++;
    		    cell_y=0;
	        }    
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(0); //잘못된 output값 출력않도록 종료처리. 
	    }
    	
       	//Step3. 가로최대값, 세로최대값 찾기
       	int maxLengthOfMelonField[][] = new int[1][2];
       	maxLengthOfMelonField[0][0]=0; //가장긴 가로길이      	
       	maxLengthOfMelonField[0][1]=0; //가장긴 세로길이
       	
       	for(int i=1;i < dataOfMelonField.length;i++){
       		//1 : 동쪽, 2 : 서쪽 
       		//조건문 통해 방위구분
       		if(dataOfMelonField[i][0] ==1 || dataOfMelonField[i][0] ==2){
       			if(dataOfMelonField[i][1] > maxLengthOfMelonField[0][0]){
       				maxLengthOfMelonField[0][0]=dataOfMelonField[i][1];
       			}
       		}
       			
       		else{
       			if(dataOfMelonField[i][1] > maxLengthOfMelonField[0][1]){
       				maxLengthOfMelonField[0][1]=dataOfMelonField[i][1];
       			}
       		}
       	}
       	
       	//Step4. 밭의 면적(넓이) 구하기
       	int lengthOfStartPoint[][] = new int[1][2]; //시작지점의 시작과 끝의 길이.
       	lengthOfStartPoint[0][0] = dataOfMelonField[6][1]; //시작지점의 가로길이
       	lengthOfStartPoint[0][1] = dataOfMelonField[1][1]; //시작지점의 세로길이
       	

   		int lengthOfFirstField[][] = new int[1][2]; //첫번째 사각형 넓이 구하는데 사용.
   		int lengthOfSecondField[][] = new int[1][2]; //두번째 사각형 넓이 구하는데 사용.	
   		
   		int areaOfFirstField=0;
   		int areaOfSecondField=0;
   		int areaOftotalField=0; //최종계산된 밭의 면적
   		
       	//lengthOfStartPoint가 maxLengthOfMelonField같은지 여부에 따라 밭 면적 계산방법이 달라짐.
       	if(lengthOfStartPoint[0][0] == maxLengthOfMelonField[0][0] && lengthOfStartPoint[0][1] == maxLengthOfMelonField[0][1]) {
           	//lengthOfStartPoint가 maxLengthOfMelonField같은 경우 시작지점을 첫번쨰 사각형 넓이 구하는데 사용불가.
  
       		//첫번째 구간의 길이값 설정
       		lengthOfFirstField[0][0]=dataOfMelonField[2][1];
       	    lengthOfFirstField[0][1]=dataOfMelonField[3][1];
       	    
       		//두번째 구간의 길이값 설정
       	    lengthOfSecondField[0][0]=dataOfMelonField[6][1]; 
       		lengthOfSecondField[0][1]=dataOfMelonField[7][1]; 

       		//밭의 총면적(areaOftotalField) 계산
       		areaOfFirstField =lengthOfFirstField[0][0]*lengthOfFirstField[0][1];
       		areaOfSecondField=lengthOfSecondField[0][0]*lengthOfSecondField[0][1];
       		areaOftotalField = areaOfFirstField+areaOfSecondField;
       	}
       	else {
          	//lengthOfStartPoint를 첫번째면적을 구하는데 활용가능. 
       		lengthOfFirstField[0][0]=lengthOfStartPoint[0][0];
       	    lengthOfFirstField[0][1]=lengthOfStartPoint[0][1];
       	    
       	    lengthOfSecondField[0][0]=dataOfMelonField[3][1]; 
       		lengthOfSecondField[0][1]=dataOfMelonField[4][1]; 

       		areaOfFirstField =lengthOfFirstField[0][0]*lengthOfFirstField[0][1];
       		areaOfSecondField=lengthOfSecondField[0][0]*lengthOfSecondField[0][1];
       		areaOftotalField = areaOfFirstField+areaOfSecondField;
       	}
       	
       	//Step5.밭에서 생산예상되는 참외의 수 계산.
       	int melonPerArea = dataOfMelonField[0][0];
       	int calculateOfMelonEA = areaOftotalField*melonPerArea;
       	
       	
	    //step5. output.txt파일로 결과출력
		File file = new File("C:\\KS_system\\output.txt"); // 대상 파일
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(Integer.toString(calculateOfMelonEA) );
	        writer.close();
	        System.out.println("예제4의 output.txt 파일이 출력완료되었습니다.");
	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }
       	
	}
}
