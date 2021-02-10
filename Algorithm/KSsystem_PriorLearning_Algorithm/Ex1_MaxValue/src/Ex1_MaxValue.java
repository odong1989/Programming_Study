/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.*;

public class Ex1_MaxValue {
	public static void main(String[] args)throws IOException {
		
		//Step1. 변수선언
		String arrayInputValue[] = null;  //로드 데이터 저장
		int arrayResultvalue[][]= null; //리턴 결과값 저장
		int arrayCell=0;
		
		try {
			//Step2.데이터 파일 로드(input.txt)
			File filePath = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\input.txt"); // 대상 파일
		    FileInputStream fileStream = null; // 파일 스트림
		        
		    fileStream = new FileInputStream( filePath );// 파일 스트림 생성
		    byte[ ] readBuffer = new byte[fileStream.available()];//버퍼 선언
		    
		    
		    while (fileStream.read( readBuffer ) != -1){}
		    System.out.println(new String(readBuffer));
		    fileStream.close(); //스트림 닫기

		    System.out.println("arrayCell : " + arrayCell);
//		    arrayInputValue[arrayCell] =new String(readBuffer);
		    arrayCell++;
		    
//		    System.out.println("arrayInputValue[inputData]"+arrayInputValue[arrayCell]); //출력
		    
		} catch (Exception e) {
			e.getStackTrace();
		}
	
	}
}
	
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Ex1_MaxValue { 
    public static void main(String[] args) {
		//Step1. 변수선언
		//입력 데이터 저장관련
    	int arrayInputValue[] = new int[8];  //로드 데이터 저장
		int arrayCell =0;
		String line = "";
		
		//결과값 저장용
		int maxValueData[]= new int[2];
        maxValueData[0]= 0;
        maxValueData[1]= 0;
        

        try {
            //Step2. 데이터 파일 로드(input.txt)
        	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\input.txt"); // 대상 파일
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Step3.배열에 데이터 저장
            while( ( line = bufferedReader.readLine() )!=null ) {
    		//    System.out.println(line);
    		    arrayInputValue[arrayCell] = Integer.parseInt(line);  		    
    		    arrayCell++;
            }    
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        //step4.최대값 및 행번호 저장
        for(int i=0; i < arrayInputValue.length;i++) {
        	if(arrayInputValue[i]>maxValueData[0]){
        		maxValueData[0]=arrayInputValue[i];
        		maxValueData[1]=i+1;
        	}
        }        
        
        
        //step5. output.txt파일로 결과출력
    	File file = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\output.txt"); // 대상 파일
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(Integer.toString(maxValueData[0]) + "\n" + Integer.toString(maxValueData[1]) );
            writer.close();
            System.out.println("output.txt 파일이 출력완료되었습니다.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


// 1)txt파일 1줄씩 로드 참고 : https://breath91.tistory.com/entry/자바-텍스트-파일-한-줄씩-읽기-예제 [숨[Breath]]
// 2)txt생성,String저장 참고 : https://codechacha.com/ko/java-write-to-a-file/
