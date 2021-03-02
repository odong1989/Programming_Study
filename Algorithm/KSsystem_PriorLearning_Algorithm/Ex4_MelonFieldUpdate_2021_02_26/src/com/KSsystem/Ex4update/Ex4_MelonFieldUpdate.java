package com.KSsystem.Ex4update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//[참고출처] 자바실행시간 측정코드 https://hijuworld.tistory.com/2

public class Ex4_MelonFieldUpdate {

	public static void main(String[] args) {

		//코드의 실행시작 (시간체크용)ㅌ
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		//Step2. 데이터 파일 로드(input.txt)
		int fieldData[][] = new int[9][2];
		String LoadlineOfTxt = "";	//txt파일의 문자 1줄씩 로드
		int cell_x =0, cell_y =0;	 //배열의 위치 선택
       	try {
	    	File file = new File("C:\\KS_system\\input.txt"); // 대상 파일
	         
	    	FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        //InputValue배열에 Input데이터 저장
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
        	
       	//Step3. drawPoint배열에 절대좌표로 변경.(이를 통해 최대 좌표값 파악.)
		int drawPoint[][] = new int[8][5]; // 현재 위치점(x1,y1), 이동 목표점(x2,y2), 방위(초기데이터의 동서남북)

	    int maxWidth=0;  //가장긴 가로길이      	
       	int maxHeight=0; //가장긴 세로길이
	
		for(int i=0;i < fieldData.length-1;i++){
			drawPoint[i][4]=fieldData[i+1][0]; //방위는 최초로드 데이터의 1번째 열에서 가져온다
			if(i != 0) { //i=0인 경우에는 아래 i-1하면 배열범주 벗어나서 에러발생.
           		drawPoint[i][0]=drawPoint[i-1][2]; //x1(현재좌표_x값)
           		drawPoint[i][1]=drawPoint[i-1][3]; //y1(현재좌표_y값)  			
       		}
       		int direction = fieldData[i+1][0];    //방위값 임시저장 변수. for내부용. 나중에 코드 관리시 fieldData[i+1][0]라고만 쓰면 헷갈려서 선언실시.
       		int tempOflength = fieldData[i+1][1]; //다음좌표의 값 임시저장 변수.for내부용. 나중에 코드 관리시 fieldData[i+1][1]라고만 쓰면 헷갈려서 선언실시.
       		switch(direction) { //앞으로그릴 x2,y2 좌표값을 계산 및 설정.
	       		case 1 : //동쪽
	           		if(i != 0) { //기본적으로 실행될 코드.
	           			drawPoint[i][2]= drawPoint[i][0]+tempOflength; //x2 
	           			drawPoint[i][3]= drawPoint[i][1]; //y2
	           		}
	           		else if(i == 0) { //최초실시(i=0)일 때 전용코드
	           			drawPoint[i][2]= tempOflength; //동쪽은 +방위처리
	       				drawPoint[i][3]= 0; //y2=0
	           		} 
	       			break;
	       			
	       		case 2 : //서쪽
	           		if(i != 0) { //기본적으로 실행될 코드.
	           			drawPoint[i][2]= drawPoint[i][0]-tempOflength; //x2
	       				drawPoint[i][3]= drawPoint[i][1]; //y2
	           		}
	           		else if(i == 0) {//최초실시(i=0)일 때 전용코드
	           			drawPoint[i][2]= -tempOflength; //서쪽은 -방위처리
	       				drawPoint[i][3]= 0; //y2=0
	           		} 
	           		break;
	           		
	       		case 3 : //남쪽
	           		if(i != 0) { //기본적으로 실행될 코드.
	           			drawPoint[i][2]= drawPoint[i][0]; //x2
	       				drawPoint[i][3]= drawPoint[i][1]-tempOflength; //y2
	           		}
	           		else if(i == 0) {//최초실시(i=0)일 때 전용코드
	           			drawPoint[i][2]= 0; //x2=0
	       				drawPoint[i][3]= -tempOflength; //남향은 -방위처리
	           		} 
	       			break;
	       			
	       		case 4 : //북쪽
	           		if(i != 0) { //기본적으로 실행될 코드.
	           			drawPoint[i][2]= drawPoint[i][0]; //x2
	       				drawPoint[i][3]= drawPoint[i][1]+tempOflength; //y2
	           		}
	           		else if(i == 0) {//최초실시(i=0)일 때 전용코드
	           			drawPoint[i][2]= 0; //x2=0
	       				drawPoint[i][3]= tempOflength; //북향은 +방위처리
	           		} 
	       			break;
	       		default :
	       			System.out.println("좌표변환 중 예상치못한 에러가 발생했습니다.");
	       	}
       		//좌표값을 기준으로 비교한다. 이동길이, 이동거리누적등으로 풀어보았지만 방향성등이 없기에 잘못된 결과들이 도출되었음.
       		if( (direction==1 ||direction==2) && maxWidth < Math.abs(drawPoint[i][0]) ){
       			maxWidth = Math.abs(drawPoint[i][0]);
       		}
       		if( (direction==3 ||direction==4) && maxHeight < Math.abs(drawPoint[i][1]) ){
       			maxHeight = Math.abs(drawPoint[i][1]);
       		}
       	}
        	       	
       	//Step4.밭의 범위에 포함되는 이동패턴들을 통해 면적 파악
   		int melonField= maxWidth*maxHeight; //아직 확정값아님. 아래의 반복문을 통하여 해당되지 않는 구간의 넓이만큼 차감.      	   		
   		int flag=0; //밭의 면적에서 제외되는 구간으로 인식될때 1로 변경, 제외영역종료시 0으로 변경 및 제외구간만큼 차감.

   		int directionPrevious=drawPoint[0][4];
   		int directionNow=drawPoint[0][4];//drawPoint의 방위값을 갖게된다.

   		int nextX=0;
   		int nextY=0;
   		
   		int tempPointStart[][] = new int [1][2];
   		int tempPointEnd[][] = new int [1][2];   		
   		int outField=0;
   		for(int i=0; i < drawPoint.length ; i++){
			if(i!=0) {
				directionPrevious=drawPoint[i-1][4]; //directionPrevious : 이전의 방향. 방향을 틀어지는 것에 따라 면적여부가 갈리기 때문.
			}
   			nextX=drawPoint[i][2];
   			nextY=drawPoint[i][3];
   			directionNow=drawPoint[i][4];

   			
   			
   			//Step4.1. 차감지역을 파악한다.
   			//진헹방향이 달라지는 시점(북→동 또는 북→서 처럼 변할때)을 밭 외의 면적의 시작으로 파악한다.
   			//차감지역 체크1. 최대지점까지 간 경우
   			if( (flag == 0) && (directionNow != directionPrevious) && (nextX!=0 && nextX!=maxWidth && nextY!=0 && nextY!=maxHeight) ){
   				flag=1;
   				//차감할 면적의 값을 계산하기위한 시작지점을 갖는다.
   				tempPointStart[0][0]=drawPoint[i][0]; //밭의 여부 갈리는 시작x점
   				tempPointStart[0][1]=drawPoint[i][1]; //밭의 여부 갈리는 시작y점
       		}
   			
   			//Step4.2. 차감지역 확정, 확정영역만큼 밭에서 차감시킨다.   			
   			//차감지역해제 여부파악. 차감지역을 밭의 면적에서 차감후, flag를 0으로 초기화시켜서 다시 파악하는데 활용한다. 
   			if(flag==1 && ( Math.abs(nextX)==0 || Math.abs(nextX)==maxWidth || Math.abs(nextY)==0 || Math.abs(nextY)==maxHeight) ){
   				//차감지역이 해제되면서 이제 밭이 아닌 구간의 좌표값들을 활용하여 면적계산, "총면적-계산한면적=파악된 밭의면적"식으로 진행한다.
   		   		tempPointEnd[0][0]=drawPoint[i][2]; 
   		   		tempPointEnd[0][1]=drawPoint[i][3];
   		   		
   		   		//차감지역을 밭의 면적에서 제외한다.
   		   		outField=(tempPointEnd[0][1]-tempPointStart[0][1])*(tempPointEnd[0][0]-tempPointStart[0][0]);
   		   		if( outField==0 ){
   		   		//ㄷ형처럼 원래와 높이/길이가 같은 경우 위의 식으로는 0이 나오게 된다. 따라서 사각형 면적 계산을 적용위해 이전점을 포인트로 하여 넣는다.
   	   		   		tempPointEnd[0][0]=drawPoint[i][0]; 
   	   		   		tempPointEnd[0][1]=drawPoint[i][1];
   		   			outField=(tempPointEnd[0][1]-tempPointStart[0][1])*(tempPointEnd[0][0]-tempPointStart[0][0]);
   		   		}

   		   		melonField=melonField-Math.abs(outField);
   		   		
   		   		//다음차감지역을 감지할 수 있도록 flag를 0으로 초기화한다.
   		   		flag=0;
   		   		tempPointStart[0][0]=0;
   		   		tempPointStart[0][1]=0;
   		   		tempPointEnd[0][0]=0; 
   		   		tempPointEnd[0][1]=0;
   			}
   			
   		}

       		  
       	//Step5.밭에서 생산예상되는 참외의 수 계산 및 출력실시.

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

	    //실행된 시간 코드 추가        
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(ms) : "+secDiffTime);
	    
	}
}
