package com.KSsystem.Ex4update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.Point;//좌표상의 어떤 위치를 나타낼 때, 각종프레임이나 다른 컴포넌트의 위치 설정시 사용- [설명참고] https://codedragon.tistory.com/6044
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*ccw 알고리즘 참고 웹사이트
CCW(CounterClockWise) 알고리즘 - https://code0xff.tistory.com/40
CCW와 CCW를 이용한 선분 교차 판별 - https://jason9319.tistory.com/358
#백준_11758 CCW - Java 자바 - https://ukyonge.tistory.com/184
*/


public class Ex4_MelonFieldUpdate {

	public static void main(String[] args) {
    	//Step2. 데이터 파일 로드(input.txt)
		int dataOfMelonField[][] = new int[7][2];
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
       	int maxLengthWidth=0;  //가장긴 가로길이      	
       	int maxLengthHeight=0; //가장긴 세로길이
       	for(int i=1;i < dataOfMelonField.length;i++){
       		//1 : 동쪽, 2 : 서쪽 
       		//조건문 통해 방위구분
       		if(dataOfMelonField[i][0] ==1 || dataOfMelonField[i][0] ==2){
       			if(dataOfMelonField[i][1] > maxLengthWidth){
       				maxLengthWidth=dataOfMelonField[i][1];
       			}
       		}	
       		else{
       			if(dataOfMelonField[i][1] > maxLengthHeight){
       				maxLengthHeight=dataOfMelonField[i][1];
       			}
       		}
       	}
       	
       	//기준점2개의 값을 설정
       	int stanardPointZero[][]=new int[1][2];     //(0,0)기준값.
       	stanardPointZero[0][0] = 0;
       	stanardPointZero[0][1] = 0;
       	
       	int stanardPointDiagonal[][]=new int[1][2]; //(0,0)기준의 대각선(Diagonal)길이
       	stanardPointDiagonal[0][0] = maxLengthWidth ;
       	stanardPointDiagonal[0][1] = maxLengthHeight;
      

       	//제공된 기존의 데이터를 (x,y)형태의 좌표(coordinate)로 변경하기.
       	
       	
       	
       	//start지점과stanardPointDiagonal간의 대각선거리와, stanardPointZero과 stanardPointDiagonal간의 대각선거리가 같은지 확인.
       	//생략 - 필요한지 고민중.
       	   
   		int areaOftotalField=0; //최종계산된 밭의 면적
       	//밭의 면적 구하기   		
       	for(int i=1;i < dataOfMelonField.length;i++){

       	}	

       	//Step.밭에서 생산예상되는 참외의 수 계산.
       	int melonPerArea = dataOfMelonField[0][0];
       	int calculateOfMelonEA = areaOftotalField*melonPerArea;
       	       	
	    //step. output.txt파일로 결과출력
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
