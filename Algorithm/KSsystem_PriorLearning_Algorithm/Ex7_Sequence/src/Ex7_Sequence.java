import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex7_Sequence {
	public static void main(String[] args) {
	//Step1.코드의 실행시작 (시간체크용)
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	
		//입력 데이터 저장관련
    	ArrayList<Integer> inputData = new ArrayList();  //로드 데이터 저장하는 배열
    	String line = "";								 //txt파일의 문자 1줄씩 로드
		
    	
    //Step2.데이터 파일 로드 저장관련
    	try {
            //Step2.1 데이터 파일 로드(input.txt)
        	//File file = new File("C:\\KS_system\\Ex2_SecurityUpdate_2021_02_16\\bin\\input.txt"); // 대상 파일
        	
        	File file = new File("C:\\KS_system\\input.txt"); // 대상 파일
            
        	FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step2.2 InputValue배열에 Input데이터 저장
            while( ( line = bufferedReader.readLine() )!=null ) {
            	String[] words = line.split("\\s");	//공백을 기준으로 나눠서 입력
            	for(String wordEach : words) { //1개의 셀마다 저장
            		inputData.add(Integer.parseInt(wordEach));            			
            	}            	
            }
            
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); //잘못된 output값 출력않도록 종료처리. 
        }
		
    	//Step3.증감의 연속 여부를 저장해갈 변수 선언 및 수열의 길이 카운트
    	//Step3.1.증감의 연속 여부를 저장해갈 변수 선언
		ArrayList<Integer> saveIncreaseSequence = new ArrayList();
		ArrayList<Integer> saveDecreaseSequence = new ArrayList();
		saveIncreaseSequence.add(0);
		saveDecreaseSequence.add(0);

    	//ArrayList가 0번째부터 시작하도록 사용하는 변수.(저장위치 설정용)
		int cellNumberIncreaseArray =0;
    	int cellNumberDecreaseArray =0;
    	
    	//수열의 연속개수 카운트(기본값을 0으로 하면 최초시 2로 시작하도록 별도 설정이 필요하게 되므로 1으로 실시.)
		int lengthIncreaseSequence =1; 
    	int lengthDecreaseSequence =1;    	
    	
    	//Step3.2.수열의 길이 카운트
		for(int i=1; i<inputData.get(0);i++ ) {	
	    	if(inputData.get(i) <= inputData.get(i+1)) {
				saveIncreaseSequence.set(cellNumberIncreaseArray, ++lengthIncreaseSequence);
			}
	    	else {
	    		lengthIncreaseSequence=1; //수열에 해당되지 않으므로 새로운 수열을 카운트 할 수 있도록 1으로 초기화.
				++cellNumberIncreaseArray; //새로 길이를 카운트할 셀을 재설정
				saveIncreaseSequence.add(cellNumberIncreaseArray, 0); //이전의 수열데이터 수정 않도록 다음셀을 미리 생성.
	    		
	    	}
						
	    	
			if(inputData.get(i) >= inputData.get(i+1)) {
				saveDecreaseSequence.set(cellNumberDecreaseArray, ++lengthDecreaseSequence);
			}
			else {
				lengthDecreaseSequence=1; //수열에 해당되지 않으므로 새로운 수열을 카운트 할 수 있도록 1으로 초기화.
				++cellNumberDecreaseArray;//새로 길이를 카운트할 셀을 재설정				
				saveDecreaseSequence.add(cellNumberDecreaseArray, 0);//이전의 수열데이터 수정 않도록 다음셀을 미리 생성.
	    	}			

		}
		
    	//Step4. 각 수열(증가세 수열과 감소세 수열 총2종류)의 최대 수열길이를 찾는다.(Step5에서 최종출력시 활용) 
   		int maxIncreaseSequence=0;
		for(int j=0; j<saveIncreaseSequence.size();j++) {
			if(maxIncreaseSequence <saveIncreaseSequence.get(j)){
				maxIncreaseSequence=saveIncreaseSequence.get(j);
			}
		}

		int maxDecreaseSequence=0;
		for(int k=0; k<saveDecreaseSequence.size();k++) {
			if(maxDecreaseSequence <saveDecreaseSequence.get(k)){
				maxDecreaseSequence=saveDecreaseSequence.get(k);
			}
		}
		
		
		
		
		//Step5. output.txt파일로 결과출력
		File file = new File("C:\\KS_system\\output.txt"); // 대상 파일
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

	        //최종적으로 출력할 가장 긴 수열의 값은 마지막 출력문에서 판정후 출력 실시.
	        if(maxIncreaseSequence>=maxDecreaseSequence) {
		        writer.write(Integer.toString(maxIncreaseSequence));	        	
	        }
	        else if(maxIncreaseSequence<=maxDecreaseSequence) {
		        writer.write(Integer.toString(maxDecreaseSequence));	        	
	        }

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
