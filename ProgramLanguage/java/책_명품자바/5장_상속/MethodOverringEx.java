import jdk.javadoc.internal.doclets.toolkit.CommentUtils.DocCommentInfo;

class DObject{
    public DObject next;
    
    public DObject(){
        next = null;
    }

    public void draw(){
        System.out.println("DObject draw");
    }
}

class Line extends DObject{
    public void draw(){
        System.out.println("Line");
    }
}

class Rect extends DObject{
    public void draw(){
        System.out.println("Rect");
    }
}

public class MethodOverringEx {
    
}
