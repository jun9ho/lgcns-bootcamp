package lgcns.inspire.still;

public class StaticDemo {
    
    /*
    static keyword (변수, 메서드, 내부클래스) 
    - 인스턴스의 소유가 아닌 클래스 소유 

    final  keyword (변수, 메서드, 클래스) 
    - 변수 : 상수 
    public static final int CONSTVAR = 10 ;  
    */
    public int nonStaticVar ; 
    public static int staticVar ; 

    public static final int CONSTVAR = 10 ; 

    public void nonStaticMethod() {
        System.out.println(">>> nonStaticMethod");
        nonStaticVar = 10 ; 
        staticVar = 10 ;
        int sum = nonStaticVar + staticVar ; 
        System.out.println(">>> sum : "+sum); 

    }
    public static void staticMethod() {
        System.out.println(">>> staticMethod"); 
        // 클래스 소유는 인스턴스 소유에 접근불가 
        // error 
        // nonStaticVar = 10 ; 
        staticVar = 10 ;
        // int sum = nonStaticVar + staticVar ; 
        System.out.println(">>> sum : "+staticVar); 

    } 

}
