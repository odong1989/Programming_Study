import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex8_Jewelry {
	public static void main(String[] args) {
		//Step1.
		//코드의 실행시작 (시간체크용)
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	
		//입력 데이터 저장관련
    	ArrayList<Integer> inputData = new ArrayList();  //로드 데이터 저장하는 배열
    	String line = "";								 //txt파일의 문자 1줄씩 로드
		
    //Step2.
    	try {
            //Step2.1 데이터 파일 로드(input.txt)
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
    	int k =inputData.get(4);
    	
    	int[][] map = new int[inputData.get(0)+1][inputData.get(1)+1]; 

    	
    	int i=4;
    	while(i<inputData.size()) {
	    	for(int x=0; x<=inputData.get(0) ;x++){
	        	for(int y=0;y<=inputData.get(1);y++){
		    		if(x==inputData.get(i) && y==inputData.get(i+1)){
		    			map[x][y]=1;
		    		}
		        }	
	    	}
	    	i=i+2;
    	}
    	
    	
    	ArrayList<Integer> findJewelyEA = new ArrayList();  //로드 데이터 저장하는 배열
    	//맵 반복하여 풀기 실시
    	int cell=0;
    	int countJewelry=0;
    	for(int x=0; x<(map.length-k);x++) {
    		for(int y=0; y<(map[y].length-k); y++) {

    			for(int searchX=0;searchX<=k;searchX++){
        			findJewelyEA.add(null);
    				for(int searchY=0;searchY<=k;searchY++){
        				if(map[x][y]==1) {
        		    		findJewelyEA.set(cell,++countJewelry);
        				}
        			}	
    	    	cell++;
    	    	countJewelry=0;    			
    			}
    		}

    	}
    	
	    //실행된 시간 코드 추가        
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(ms) : "+secDiffTime);

	}

}
