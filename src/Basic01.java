/**
 * @ClassName Basic01
 * @Description 缓存导致的可见性问题
 * @Author SongWei
 * @Date 2020/4/22 11:17
 * @Version 1.0
 **/
public class Basic01 {

    /**
     *最终返回的不是20000，各自CPU里都缓存了count的值
     */

    public static void main(String[] args) throws InterruptedException {
        System.out.println(calc());
    }

    private static long count = 0;
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }
    public static long calc() throws InterruptedException {
        final Basic01 theoreticalBasis = new Basic01();
        //创建两个线程，执行add
        Thread th1 = new Thread(()->{
            theoreticalBasis.add10K();
        });
        Thread th2 = new Thread(()->{
           theoreticalBasis.add10K();
        });
        //启动两个线程
        th1.start();
        th2.start();
        //等待两个线程执行结束
        th1.join();
        th2.join();
        return count;

    }
}

/**
 *CPU能保证的原子操作是指令级别的，而不是高级语言的操作符
 */

/**
 *编译优化带来的有序性问题
 */


