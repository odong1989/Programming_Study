import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex6_electricWire {
	public static void main(String[] args){
		//코드의 실행시작 (시간체크용)
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
				
		//입력 데이터 저장관련
    	int InputValue[][] = new int[9][2];  //로드 데이터 저장하는 배열
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
		
		//겹침 횟수를 카운팅할 배열 생성 및 카운팅 실시.
		//데이터를 정렬하여 로드한다.
		int compareChart[][] = new int [InputValue.length-1][3]; //총 3열의 데이터(출발번호, 도착번호 ,겹침횟수)
		int numberOfStart=1;
		boolean flag=false;

		for(int i=0; i < compareChart.length ;) {
			for(int j=1; j < InputValue.length ; j++) {
				if(flag==false && numberOfStart==InputValue[j][0]){
					//x,y데이터 삽입
					compareChart[i][0] = InputValue[j][0];
					compareChart[i][1] = InputValue[j][1];
					flag=true;//해당번호가 없어서 데이터 삽입없는데도 증가되는 것 방지용.
				}
			}
			//정상적으로 증가하는 경우
			if(flag) {
				i++;
				numberOfStart++;		
				flag=false;
			}
			//해당번호가 없어서 데이터 삽입없는데도 증가되는 것 방지용.		
			else{
				numberOfStart++;  //비교할 숫자만 증가. 저장할 배열의 셀번호(i)는 증가않도록 실시.
			}			
		}

		int countOfCrash=0;
		int maxChash = 0;
		int deleteKey =0;
		int countOfDeleteLines=0;
		ArrayList resultPrint = new ArrayList();
		resultPrint.add(0);
		
		do{
			countOfCrash=0;
			maxChash = 0;
			deleteKey=0;
			
			//정렬된 데이터배열을 활용하여 겹침횟수 체크
			for(int i=0; i < compareChart.length-countOfDeleteLines;i++) {
				//겹침횟수 카운팅 실시.
				for(int j=0; j<compareChart.length;j++){
					//같은 출발번지인 경우 실시않도록 제한
					int standStart = compareChart[i][0];
					int standEnd = compareChart[i][1];
					int compareStart = compareChart[j][0];
					int compareEnd = compareChart[j][1];
					
					if(standStart != compareStart){
						//1.↗(3시)방향으로 충돌 발생시 카운트증가
						 if(standStart > compareStart && standEnd< compareEnd) {
							 compareChart[i][2]++;
						 }
	
						//2.↘(5시)방향으로 충돌 발생시 카운트증가 
						 else if(standStart < compareStart && standEnd > compareEnd) {
							 compareChart[i][2]++;
						 }
					}
				}				
			}
			
			//겹침횟수 체크 후 최대충돌횟수를 찾는 반복문 실시
			for(int k=0; k < compareChart.length-countOfDeleteLines ;k++) {
				//총 겹침횟수 합계
				countOfCrash=countOfCrash+compareChart[k][2];
				
				//충돌이 가장많이 발생한 전깃줄 찾기
				if(compareChart[k][2] >maxChash){
					maxChash=compareChart[k][2];
					deleteKey=k;
				}
				//마지막에 2->2, 4->1처럼 선이 겹치는 선의 개수가 같은 경우가 있을 수 있다.
				//이러한 경우에는 차지하는 대각선의 값이 큰 것을 삭제하도록한다.
				else if(maxChash <=compareChart[k][2] && Math.abs(compareChart[k][0]-compareChart[k][1]) > Math.abs(compareChart[deleteKey][0]-compareChart[deleteKey][1])) 
				{
					maxChash=compareChart[k][2];
					deleteKey=k;
				}
			}
			
			//결과출력용 ArrayList resultPrint에 데이터 저장
			if(countOfCrash!=0) {
				resultPrint.set(0,++countOfDeleteLines);//삭제할 선의개수 +1개를 배열에 반영
				resultPrint.add(compareChart[deleteKey][0]);//삭제할 선의 번호를 저장			
				//compareChart배열에서 많이 겹치는 선의 정보 삭제및 배열 재정렬 
				for(int l=0; l < compareChart.length-countOfDeleteLines ;l++) {
				     if(l==deleteKey){
				           for(int m=l; m<compareChart.length-1; m++){
				        	   compareChart[m][0] =compareChart[m+1][0];
				        	   compareChart[m][1] =compareChart[m+1][1];
				        	   compareChart[m][2] =0;//전깃줄 카윤트 초기화
				           }
				           //맨끝의 배열은 더이상 사용않으므로 0으로 초기화
				           compareChart[compareChart.length-countOfDeleteLines][0]=0;
				           compareChart[compareChart.length-countOfDeleteLines][1]=0;
				           compareChart[compareChart.length-countOfDeleteLines][2]=0;
				        break;
				     }
				     else {
			        	   compareChart[l][2] =0;//전깃줄 카윤트 초기화
				     }
				}
			}		
		}while(countOfCrash >0);
		
	    //step. output.txt파일로 결과출력
		File file = new File("C:\\KS_system\\output.txt"); // 대상 파일
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        
	        for(int i=0; i<resultPrint.size();i++ ){
	        	writer.write( resultPrint.get(i).toString() );
	        	writer.write( "\n".toString() );
	        }
	        writer.close();
	        System.out.println("예제6의 output.txt 파일이 출력완료되었습니다.");	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }		
	    
	    //실행된 시간 코드 추가        
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(ms) : "+secDiffTime);
	    
	}
}
