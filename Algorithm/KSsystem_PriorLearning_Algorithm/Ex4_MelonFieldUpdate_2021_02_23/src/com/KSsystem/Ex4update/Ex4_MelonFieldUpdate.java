package com.KSsystem.Ex4update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*ccw 알고리즘 참고 웹사이트
CCW(CounterClockWise) 알고리즘 - https://code0xff.tistory.com/40
CCW와 CCW를 이용한 선분 교차 판별 - https://jason9319.tistory.com/358
#백준_11758 CCW - Java 자바 - https://ukyonge.tistory.com/184
*/


public class Ex4_MelonFieldUpdate {

	public static void main(String[] args) {
    	//Step2. 데이터 파일 로드(input.txt)
		int fieldData[][] = new int[9][2];
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
	            	fieldData[cell_x][cell_y] = Integer.parseInt(wordEach);            			
            		cell_y++;
	        	}
    		    cell_x++;
    		    cell_y=0;
	        }    
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(0); //잘못된 output값 출력않도록 종료처리. 
	    }
        	
       	/*
       	//Step4. 가로최대값, 세로최대값 찾기 및 변수에저장 실시.
       	int maxWidth=0;  //가장긴 가로길이      	
       	int maxHeight=0; //가장긴 세로길이
       	for(int i=1;i < fieldData.length;i++){
       		//1 : 동쪽, 2 : 서쪽 
       		//조건문 통해 방위구분
       		if(fieldData[i][0] ==1){
       				maxWidth=maxWidth+fieldData[i][1];
       		}
       		else if(fieldData[i][0] ==3){
       				maxHeight=maxHeight+fieldData[i][1];
       		}
       	}*/
       	
       	//(아직Step4) 기준점2개의 값을 설정.(오버되는 값이 나오는지 체크용)
       	int stpZero[][]=new int[1][2];     //(0,0)기준값, stp : stanardPoint
       	stpZero[0][0] = 0;
       	stpZero[0][1] = 0;
       	
       	/*
       	int stpDiagonal[][]=new int[1][2]; //(0,0)기준의 대각선(Diagonal)
       	stpDiagonal[0][0] = maxWidth;
       	stpDiagonal[0][1] = maxHeight;
        */

       	//Step5.밭의 범위에 포함되는 이동패턴들을 통해 면적 파악
   		int melonField=0;       	   		
   		int areaTemp[]= new int[4];
   		int cell=0; // areaTemp[]의 배열을 1칸씩 선택위한 변수
   		
       	for(int i=1; i < fieldData.length-1 ; i=i+2){
       		//안쪽을 향하는 경우(밭의 면적에 포함)
       		if(fieldData[i][0]==2 && fieldData[i+1][0]==4 ){ //└형
       			areaTemp[cell] = fieldData[i][1]*fieldData[i+1][1];  
       		}
       		else if(fieldData[i][0]==4 && fieldData[i+1][0]==2 ){ //<┐형 
       			areaTemp[cell] = fieldData[i][1]*fieldData[i+1][1];  
       		}
       		else if(fieldData[i][0]==2 && fieldData[i+1][0]==3 ){ //┏형 
       			areaTemp[cell] = fieldData[i][1]*fieldData[i+1][1];  
       		}
       		else if(fieldData[i][0]==3 && fieldData[i+1][0]==1 ){ //└>형 
       			areaTemp[cell] = fieldData[i][1]*fieldData[i+1][1];  
       		}
       		else {
       			areaTemp[cell] = -(fieldData[i][1]*fieldData[i+1][1]);  
       		}
       		melonField = melonField+areaTemp[cell];
       		cell++;
       	}

       		  
       	//Step.밭에서 생산예상되는 참외의 수 계산.

       	int melonPerArea = fieldData[0][0];
       	int calculateOfMelonEA = melonField*melonPerArea;
       	       	
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
