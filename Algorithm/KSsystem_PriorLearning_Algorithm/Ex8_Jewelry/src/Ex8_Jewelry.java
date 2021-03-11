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
    	int k =inputData.get(3);
    	
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
    	
    	
    	int[] maxJewelyData=new int[3];
    	int countJewelry=0;
		for(int y=0; y<(map[y].length-k); y++) {
			for(int x=0; x<(map.length-k);x++) {
    			for(int searchX=x; searchX<=k+x; searchX++){
    				for(int searchY=y;searchY<=k+y;searchY++){
        				if(map[searchX][searchY]==1) {
        					countJewelry++;
        				}
        			}
    			}  			

    			if(maxJewelyData[2]<countJewelry) {
    				maxJewelyData[0]=x;
    				maxJewelyData[1]=y;
    				maxJewelyData[2]=countJewelry;
    			}
    	    	countJewelry=0;  
    		}
    		
    	}
    	

		//Step5.output.txt파일로 결과출력
			File file = new File("C:\\KS_system\\output.txt"); // 대상 파일
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));

				for(int output=0; output < maxJewelyData.length;output++) {
					if(output==2) {
			        	writer.write( "\n".toString() );						
					}
		        	writer.write( Integer.toString(maxJewelyData[output]));
		        	writer.write( " ".toString() );						
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
