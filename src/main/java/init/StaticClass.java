package init;

/**
 * Created by jinxiaofei.
 * Time 17/1/3 下午12:56
 * Desc 文件描述
 */
public class StaticClass {
    
    static int filed = initfield();
    
    static {
        System.out.println("static block");
    }
    
    public static void method1() {
        
        System.out.println("this is a method");
    }
    
    
    private static int initfield() {
        
        System.out.println("init method");
        return 0;
        
    }
    
}
