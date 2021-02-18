import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class diceOfThreeUpdate {
	public static void main(String[] args) {
 
    	int dice[]=new int[3];
    	int cellNum=0;
    	
    	//Step2. 데이터 파일 로드(input.txt)
       	String LoadlineOfTxt = "";					 //txt파일의 문자 1줄씩 로드
    	try {
	    	File file = new File("C:\\KS_system\\input.txt"); // 대상 파일
	        
	    	FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        //Step3.InputValue배열에 Input데이터 저장
	        while( ( LoadlineOfTxt = bufferedReader.readLine() )!=null ) {
	        	String[] words = LoadlineOfTxt.split("\\s");	//공백을 기준으로 나눠서 입력
	        	for(String wordEach : words) { //1개의 셀마다 저장
	            	dice[cellNum] = Integer.parseInt(wordEach);
	            	cellNum++;
	        	}    
	        	bufferedReader.close();	       //waring_1_버퍼리더 안 닫혀있음 경고 수정. 	
	        }    
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(0); //잘못된 output값 출력않도록 종료처리. 
	    }
    
	    
	    //Step눈이 같은 개수 체크
    	int countArrayEqualNum[]=new int[6]; //같은 눈 개수 저장
    	//int equalNumber=0;   //같은 눈 숫자._사용되지 않아서 삭제.
    	int maxNum=0;	     //가장 큰 눈의 값(주사위 눈값 모두 다를 경우)
    	
    	//각 숫자마다 나온 개수를 카운트.
        for(int i=0; i < dice.length ;i++) {
        	switch(dice[i]) {
            	case 1: 
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 2:
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 3 :
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 4: 
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 5:
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break;
            	case 6 :
            		countArrayEqualNum[ dice[i] -1 ]++;
            		break; 

            	default :
            		System.out.println("범주외의 숫자값이 확인되었습니다.");	
            		break; 
        	}        	        	
        }
        for(int i=0; i < countArrayEqualNum.length ;i++) {
        	if(countArrayEqualNum[i] >= 1) {
        		maxNum=i+1;
        	}
        }


	    //출력할 상금액 계산
        int cashPrize = 0;
        for(int i=0; i <6  ;i++) {
        	if(countArrayEqualNum[i] == dice.length ){ 
	        	//규칙(1) 같은 눈이 3개가 나오면 10,000원+(같은 눈)*1,000원의 상금을 받게 된다. 
	        	cashPrize = 10000 + (i+1)*1000;
	        }
	        else if(countArrayEqualNum[i] >=2) {
	        	//규칙(2) 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게 된다. 
	        	cashPrize = 1000+ (i+1)*100;
	        }
        }
        if(cashPrize ==0 ){
        	//규칙(3) 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다.
        	cashPrize = maxNum*100;
        }
        
	    //step5. output.txt파일로 결과출력
		File file = new File("C:\\KS_system\\output.txt"); // 대상 파일
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(Integer.toString(cashPrize) );
	        writer.close();
	        System.out.println("예제2의 output.txt 파일이 출력완료되었습니다.");
	        
	    }	 catch (IOException e) {
	        e.printStackTrace();
	    }

	}
}
