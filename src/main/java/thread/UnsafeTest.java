package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by jinxiaofei.
 * Time 16/12/30 上午9:49
 * Desc 文件描述
 */
public class UnsafeTest {
    
    public static void main(String[] args) throws InterruptedException {
        UnSafe unSafe=new UnSafe();
        Thread t1=new Thread(new RunUnsafe(unSafe));
        Thread t2=new Thread(new RunUnsafe(unSafe));
        Thread t3=new Thread(new RunUnsafe(unSafe));
        Thread t4=new Thread(new RunUnsafe(unSafe));
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.submit(t4);
        executorService.shutdown();
    
    
    
        System.out.println("the final result is :"+unSafe.getValue());
    }
}


class RunUnsafe implements Runnable{
    private UnSafe unSafe;
    
    
    RunUnsafe(UnSafe unSafe) {
        
        this.unSafe = unSafe;
    }
    
    
    public void run() {
        for (int  i = 0; i < 50; i++) {
            unSafe.getNext();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}


class UnSafe {
    
    private int value;
    
    
    int getValue() {
        
        return value;
    }
    
    
    int getNext() {
        
        System.out.println("the value is :" + value);
        return value++;
        
    }
}
