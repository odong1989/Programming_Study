import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* [예제2 힌트]
 * 힌트1) 경비원 위치를 중심으로 보세요.
 * 힌트2) 좌표의 표현방법은 다양합니다.
 * 	     지도를 돌려보기도 하고, 1차원 거리로도 표현해보기도 하고,2차원 좌표로 표현하는 방법도 있습니다.
 * */

public class Ex2_Security {
    public static void main(String[] args) {
		//Step1. 변수선언
		//입력 데이터 저장관련
    	int InputValue[][] = new int[6][2];  //로드 데이터 저장
		int Cell_x =0, Cell_y =0;
		String line = "";
		
		//결과값 저장용
		int distanceCalculate[][]= new int[3][2];
        

        try {
            //Step2. 데이터 파일 로드(input.txt)
        	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex2_Security\\bin\\input.txt"); // 대상 파일
        						  
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step3.InputValue배열에 Input데이터 저장
            while( ( line = bufferedReader.readLine() )!=null ) {
            	String[] words = line.split("\\s");	//공백을 기준으로 나눠서 입력
            	for(String wordEach : words) {
                	InputValue[Cell_x][Cell_y] = Integer.parseInt(wordEach);            			
            		Cell_y++;
            	}            	
    		    Cell_x++;
    		    Cell_y=0;
            }    
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); //잘못된 output값 출력않도록 종료처리. 
        }

        
        //Step4.경비원 위치 기준으로 각 상점별 거리 계산
		for(int i=2; i <= (InputValue.length-2) ;i++) {
			// 4.1.경비원과 상점이 같은 방향에 위치여부 확인
			if( InputValue[i][0] == InputValue[5][0] ){ 

				//4.1.1. 상점이 경비원의 좌측에 있는가?
				if(InputValue[i][1] < InputValue[5][1] ){  
					//4.1.1.1. 동일방향-상점이 경비원 좌측에 상점있음
					distanceCalculate[i-2][0]= InputValue[5][1]-InputValue[i][1] ; //시계방향 거리값 = 경비원y값-상점y값
					distanceCalculate[i-2][1]= (InputValue[0][0]-InputValue[5][1]) + InputValue[0][0] + (2*InputValue[0][1]) + InputValue[i][1]; // 반시계방향 거리값 = (가로블럭길이-경비원y값) + 가로블럭길이 + (2*세로블럭길이) + 상점y값
				}
				else {
					//4.1.1.2. 동일방향-상점이  경비원 우측에 상점있음
					distanceCalculate[i-2][0]= InputValue[i][1]-InputValue[5][1]+ ( InputValue[0][0]+(2*InputValue[0][1]) ); //반시계방향
					distanceCalculate[i-2][1]= InputValue[i][1]-InputValue[5][1] ; //시계방향 거리값 = 상점y값-경비원y값
				}	
			}
			
			
			// 4.2.상점과 경비원의 기준 경계점이 동일한가?
			else if( InputValue[i][0] <=2 && InputValue[5][0]<=2 ){ 
				distanceCalculate[i-2][0]= InputValue[i][1]+InputValue[5][1] + InputValue[0][1]; //시계방향  : 상점x값+경비원x값+세로블럭길이
				distanceCalculate[i-2][1]= (InputValue[0][0]-InputValue[i][1]) + (InputValue[0][0]-InputValue[5][1]) + InputValue[0][1];  //반시계방향 : (가로블럭길이-경비원x값)+(가로블럭길이-상점x값)+세로블럭길이
			}	


			// 4.3. 상점과 경비원의 기준 경계점이 다른경우
			else {			
				if(InputValue[i][1] < InputValue[5][1] ){ 
					//4.3.1. 상점이 경비원 좌측에 있음
					distanceCalculate[i-2][0]= InputValue[5][1] + (InputValue[0][1]-InputValue[i][1]); //시계방향 거리값 = 경비원y값+(세로블럭길이-상점y값)
					distanceCalculate[i-2][1]= (InputValue[0][0]-InputValue[5][1]) + InputValue[0][1]+ InputValue[0][0] +InputValue[i][1]; 
					        // 반시계방향 거리값 = (가로블럭길이-경비원y값) +세로블럭길이+ 가로블럭길이+상점y값
				}
				
				else {
					//4.3.2.  상점이 경비원 우측에 있음
					distanceCalculate[i-2][0] = InputValue[5][1]+InputValue[0][1] +InputValue[0][0] +(InputValue[0][1]-InputValue[i][1]) ; //시계방향 거리값 = 경비원y값         +세로블럭길이         +가로블럭길이        +(세로블럭길이-상점y값)
					distanceCalculate[i-2][1] = (InputValue[0][0]-InputValue[5][1]) + InputValue[i][1]; //반시계방향 거리값 = (가로블럭길이-경비원y값)+상점y값
				}	
			}
		}
        
		
		
		
		
		
		
        //step5. output.txt파일로 결과출력
    	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex2_Security\\bin\\output.txt"); // 대상 파일
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        	int temp=0;
        	
            for(int i=0; i < distanceCalculate.length ;i++) {
            	if(distanceCalculate[i][0]<distanceCalculate[i][1]){
            		temp=temp+distanceCalculate[i][0];
            	}
            	else {
            		temp=temp+distanceCalculate[i][1];
            	}
            }
            
            writer.write(Integer.toString(temp) );
            writer.close();
            System.out.println("예제2의 output.txt 파일이 출력완료되었습니다.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//[참고] split통한 String 컷 https://mainia.tistory.com/3950
//[참고] 자바-2차원 배열의 길이 출력 https://marvell.tistory.com/entry/Java-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%EA%B8%B8%EC%9D%B4

/*
//[참고]2차원 배열 반복문
for(int i=0; i < InputValue.length;i++) {	//2차원 배열 행의 길이만큼 반복.
	for(int j=0; j < InputValue[i].length; j++) {							//2차원 배열 열의 길이만큼 반복.
	//	System.out.println("InputValue["+i+"]["+j+"] : " + InputValue[i][j]); //분산입력 체크           		
	}        
}
*/