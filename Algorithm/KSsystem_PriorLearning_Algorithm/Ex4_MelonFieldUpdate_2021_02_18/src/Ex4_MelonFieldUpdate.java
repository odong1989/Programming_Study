import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.awt.Point;//ccw 알고리즘 적용위해 추가.

/*ccw 알고리즘 참고 웹사이트
CCW(CounterClockWise) 알고리즘 - https://code0xff.tistory.com/40
CCW와 CCW를 이용한 선분 교차 판별 - https://jason9319.tistory.com/358
#백준_11758 CCW - Java 자바 - https://ukyonge.tistory.com/184
*/

public class Ex4_MelonFieldUpdate {
    
	public static int ccw(Point[] p) {
		//소스코드 참고 : #백준_11758 CCW - Java 자바 - https://ukyonge.tistory.com/184
        //CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
        // CCW는 점 A,B,C를 순서대로 봤을때 반시계방향으로 놓여 있으면 양수를, 시계방향이면 음수를, 평행하게 놓여있으면 0을 반환하게 됩니다.
        int result = ((p[0].x*p[1].y) + (p[1].x*p[2].y) + (p[2].x * p[0].y)) - ((p[0].y*p[1].x) + (p[1].y*p[2].x) + (p[2].y*p[0].x));
        if(result < 0)
            return -1;
        else if(result > 0)
            return 1;
        else
            return 0;
    }
	
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
    	
       	
       	//ccw알고리즘 통해 방향분석
		//소스코드 참고 : #백준_11758 CCW - Java 자바 - https://ukyonge.tistory.com/184
        Point[] po = new Point[ (dataOfMelonField.length)-1 ];        
    	int xyforCCW[][] = new int[dataOfMelonField.length-1 ][2]; //시작점을 기준점(0,0)으로 하도록 초기값설정.
        int directionToggleEW = 0;//본 예제경우 xy좌표대신 방위가 제공됨에 따라 변경. EW : East, West
        int directionToggleNS = 0;//본 예제경우 xy좌표대신 방위가 제공됨에 따라 변경. NS : North, South

        //[미완성] 제공된 방위와 거리를 통해 절대좌표로 표현한 다음 ccw알고리즘 통해 방향에 따라 계산하는 것으로 계획.
        for(int i=1; i < (dataOfMelonField.length)-1; i++) {
            int nowdirection=dataOfMelonField[i][0];
        	if(dataOfMelonField[i][0] ==1 || dataOfMelonField[i][0] ==2){ //1 : 동쪽, 2 : 서쪽 	
        		if(directionToggleEW == nowdirection){
        			//미완성
        			directionToggleEW=dataOfMelonField[i][0];
        		}
        		else {
        			//미완성        			
        		}
       	}	
            else{ //남쪽, 북쪽
        		if(directionToggleNS == nowdirection){	 
        			//미완성
        			directionToggleEW=dataOfMelonField[i][0];
        		}
        		else {
        			//미완성        			
        		}
        	}        	
        }    	        
       	
       	//Step3. 가로최대값, 세로최대값 찾기
       	int maxLengthOfMelonField[][] = new int[1][2];
       	//maxLengthOfMelonField[0][0]=0; //가장긴 가로길이      	
       	//maxLengthOfMelonField[0][1]=0; //가장긴 세로길이

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
