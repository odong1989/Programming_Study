/*
예제5-1 클래수 상속 만들어보기 - Point와 ColorPoint 클래스
책 239~240페이지

목표 : (x,y)의 한 점을 표현하는 Point 클래스와 이를 상속받아 컬러 점을 표현하는 ColorPoint 클래스를 만들어보자.
*/


//class Point : (x,y)의 한 점을 표현하는 Point 클래스
class Point {
    int x,y; //한 점을 구성하는 x,y좌표
    void set(int x, int y){
        this.x =x; this.y = y;
    }

    void showPoint(){ //점의 좌표 출력
        System.out.println("("+ x + "," + y +")");
    }
}

//public class ColorPoint extends Point : Point 클래스와 이를 상속받아 컬러 점을 표현하는 ColorPoint 클래스.
public class ColorPoint extends Point{
        String color;
        
        void setColor(String color){ //점의 색 설정
            this.color = color;
        }

        void showColorPoint(){
            System.out.print(color);
            showPoint();
        }

        public static void main (String[] args){
            ColorPoint cp =new ColorPoint();

            cp.set(3,4); //한 점을 구성하는 x,y좌표 설정(Class Point- set메소드)
            cp.setColor("red"); //점의 색설정(Class ColorPoint - setColor 메소드)
            cp.showColorPoint(); //
        } 
    }