import java.io.File;

public class FileCheckInHDD {
	public static void main(String[] args){
    // 참고링크 : https://m.blog.naver.com/PostView.nhn?blogId=tkddlf4209&logNo=220486718205&proxyReferer=https:%2F%2Fwww.google.com%2F

	    File f = new File("C:\\sourceTree\\Programming_Study\\Algorithm\\KSsystem_PriorLearning_Algorithm\\Ex1_MaxValue\\bin\\input.txt");
	        
	    //파일의 존재 여부
        System.out.println("파일의 존재 여부 " + f.exists());
        System.out.println("파일의 크기 " + f.length());
        System.out.println("파일의 마지막 수정날짜 " + f.lastModified()/1000/86400);     
    }
}