import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex6_electricWire {
	public static void main(String[] args){
		
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
		int compareChart[][] = new int [InputValue.length-1][3]; //x,y,겹침횟수
		for(int i=0; i <compareChart.length ; i++) {
			//x,y데이터 로드
			compareChart[i][0] = InputValue[i+1][0];
			compareChart[i][1] = InputValue[i+1][1];

			//겹침횟수 카운팅 실시.
			for(int j=1; j<InputValue.length;j++){
				//같은 출발번지인 경우 실시않도록 제한
				if(compareChart[i][0] != InputValue[j][0]){
					//1.↗(3시)방향으로 충돌 발생시 카운트증가

					 if(compareChart[i][0] >InputValue[j][0] && compareChart[i][1]> InputValue[j][1]) {
						 compareChart[i][2]++;
					 }

					//2.↘(5시)방향으로 충돌 발생시 카운트증가 
					 else if(compareChart[i][0] < InputValue[j][0] && compareChart[i][1]> InputValue[j][1]) {
						 compareChart[i][2]++;
					 }
				}
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
