package com.KSsystem.Ex4update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.Graphics;

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
	        bufferedReader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(0); //잘못된 output값 출력않도록 종료처리. 
	    }
        	
       	//절대좌표로 변경.(이를 통해 및 변동되는 거리의 길이파악)
		int drawPoint[][] = new int[8][5]; // 현지점(x1,y1), 그릴목표점(x2,y2), 방위(초기데이터의 동서남북)
		int lengthXY[][] = new int[8][2];  // 변동되는 거리의 길이

		for(int i=0;i < fieldData.length-1;i++){
			drawPoint[i][4]=fieldData[i+1][0];
			if(i != 0) {
           		drawPoint[i][0]=drawPoint[i-1][2]; //x1
           		drawPoint[i][1]=drawPoint[i-1][3]; //y1  			
       		}
       		int direction = fieldData[i+1][0];
       		int tempOflength = fieldData[i+1][1];
       		switch(direction) { //앞으로그릴 x2,y2 좌표값을 계산 및 설정.
	       		case 1 : //동쪽
	           		if(i != 0) {
	           			drawPoint[i][2]= drawPoint[i][0]+tempOflength; //x2 
	           			drawPoint[i][3]= drawPoint[i][1]; //y2
	           		}
	           		else if(i == 0) {
	           			drawPoint[i][2]= tempOflength; //동쪽은 +방위처리
	       				drawPoint[i][3]= 0; //y2=0
	           		} 
	       			break;
	       			
	       		case 2 : //서쪽
	           		if(i != 0) {
	           			drawPoint[i][2]= drawPoint[i][0]-tempOflength; //x2
	       				drawPoint[i][3]= drawPoint[i][1]; //y2
	           		}
	           		else if(i == 0) {
	           			drawPoint[i][2]= -tempOflength; //서쪽은 -방위처리
	       				drawPoint[i][3]= 0; //y2=0
	           		} 
	           		break;
	           		
	       		case 3 : //남쪽
	           		if(i != 0) {
	           			drawPoint[i][2]= drawPoint[i][0]; //x2
	       				drawPoint[i][3]= drawPoint[i][1]-tempOflength; //y2
	           		}
	           		else if(i == 0) {
	           			drawPoint[i][2]= 0; //x2=0
	       				drawPoint[i][3]= -tempOflength; //남향은 -방위처리
	           		} 
	       			break;
	       			
	       		case 4 : //북쪽
	           		if(i != 0) {
	           			drawPoint[i][2]= drawPoint[i][0]; //x2
	       				drawPoint[i][3]= drawPoint[i][1]+tempOflength; //y2
	           		}
	           		else if(i == 0) {
	           			drawPoint[i][2]= 0; //x2=0
	       				drawPoint[i][3]= tempOflength; //북향은 +방위처리
	           		} 
	       			break;
	       		default :
	       			System.out.println("좌표변환 중 예상치못한 에러가 발생했습니다.");
	       	}
       		
       		lengthXY[i][0] = drawPoint[i][2]-drawPoint[i][0]; //x(가로)길이
       		lengthXY[i][1] = drawPoint[i][3]-drawPoint[i][1]; //y(세로)길이
       	}

		
		//Step4. 가로최대값, 세로최대값 찾기 및 변수에저장 실시.
 
       	//누적된 값과 가장 긴 길이값을 비교한다.
       	//ㄷ형으로 리턴을 오는 경우 실제길이보다 더 길어나게 하는 왜곡을 할 수 있다.
       	int accumulateLengthX=0;
       	int accumulateLengthY=0;
       	int maxOnlyOneLengthX=0;
       	int maxOnlyOneLengthY=0;
       	
       	//반복문을 통해
       	for(int i=0;i<lengthXY.length;i++){
       		switch(drawPoint[i][4]) {
       			//최대가로, 최대세로 값을 구하는 것은 동쪽,북쪽만 구해도 충분함.  		
       			case 2 : //동쪽
       				accumulateLengthX=accumulateLengthX+Math.abs(lengthXY[i][0]);   	       				
       				break;       			
       			case 4 : //북쪽
       				accumulateLengthY=accumulateLengthY+Math.abs(lengthXY[i][1]);
       				break;
       			default :
	       			System.out.println("서쪽(1),남쪽(3)는 없어도 최대가로/세로 구할시에는 문제없으므로 반영않습니다.");
       		}       		
       		
       		if(maxOnlyOneLengthX<Math.abs(lengthXY[i][0]) ){
       			maxOnlyOneLengthX=Math.abs(lengthXY[i][0]);
       		}
       		if(maxOnlyOneLengthY<Math.abs(lengthXY[i][1]) ){
       			maxOnlyOneLengthY=Math.abs(lengthXY[i][1]);
       		}
       	}

       	//위의 반복문으로 누적길이와 단일최대길이를 활용하여 최대길이를 설정한다.
       	int maxWidth=0;  //가장긴 가로길이      	
       	int maxHeight=0; //가장긴 세로길이

       	if(accumulateLengthX>maxOnlyOneLengthX){//'ㄷ'자형의 왜곡일 경우 가장긴 길이로 실시.
       		maxWidth=maxOnlyOneLengthX;
       	}
       	else { //1개의 max길이가 없는 경우 누적길이로 설정
       		maxWidth=accumulateLengthX;
       	}

       	if(accumulateLengthY>maxOnlyOneLengthY){//'ㄷ'자형의 왜곡일 경우 가장긴 길이로 실시.
       		maxHeight=maxOnlyOneLengthY;
       	}
       	else { //1개의 max길이가 없는 경우 누적길이로 설정
       		maxHeight=accumulateLengthY;
       	}
       	       	
       	//Step5.밭의 범위에 포함되는 이동패턴들을 통해 면적 파악
   		int melonField= maxWidth*maxHeight; //아직 확정값아님. 아래의 반복문을 통하여 해당되지 않는 구간의 넓이만큼 차감.      	   		
   		int flag=0; //밭의 면적에서 제외되는 구간으로 인식될때 1로 변경, 제외영역종료시 0으로 변경 및 제외구간만큼 차감.

   		int directionPrevious=drawPoint[0][4];
   		int directionNow=drawPoint[0][4];//drawPoint의 방위값을 갖게된다.

   		int nextX=0;
   		int nextY=0;
   		
   		int tempPointStart[][] = new int [1][2];
   		int tempPointEnd[][] = new int [1][2];   		
   		
   		for(int i=0; i < drawPoint.length ; i++){
			if(i!=0) {
				directionPrevious=drawPoint[i-1][4];
			}
   			nextX=drawPoint[i][2];
   			nextY=drawPoint[i][3];
   			directionNow=drawPoint[i][4];

   			
   			
   			//차감지역을 파악한다.
   			//진헹방향이 달라지는 시점(북→동 또는 북→서 처럼 변할때)을 밭 외의 면적의 시작으로 파악한다.
   			if( (flag == 0) && (directionNow != directionPrevious) && (nextX!=0 && nextX!=maxWidth && nextY!=0 && nextY!=maxHeight) ){
   				flag=1;
   				//차감할 면적의 값을 계산하기위한 시작지점을 갖는다.
   				tempPointStart[0][0]=drawPoint[i][2];
   				tempPointStart[0][1]=drawPoint[i][3];
       		}
   			
   			//차감지역해제 체크
   			if(flag==1 && ( nextX==0 || nextX==maxWidth || nextY==0 || nextY==maxHeight) ){
   				//차감지역이 해제되면서 이제 밭이 아닌 구간의 좌표값들을 활용하여 면적계산, "총면적-계산한면적=파악된 밭의면적"식으로 진행한다.
   		   		tempPointEnd[0][0]=drawPoint[i][2]; 
   		   		tempPointEnd[0][1]=drawPoint[i][3];
   		   		
   		   		//차감지역을 밭의 면적에서 제외한다.
   		   		melonField=melonField-( (tempPointEnd[0][1]-tempPointStart[0][1])*(tempPointEnd[0][0]-tempPointStart[0][0]) );
   		   		
   		   		//다음차감지역을 감지할 수 있도록 flag를 0으로 초기화한다.
   		   		flag=0;
   		   		tempPointStart[0][0]=0;
   		   		tempPointStart[0][1]=0;
   		   		tempPointEnd[0][0]=0; 
   		   		tempPointEnd[0][1]=0;
   			}
   			
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
