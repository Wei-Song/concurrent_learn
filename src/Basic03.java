/**
 * @ClassName Base03
 * @Description 03 互斥锁（上）：解决原子性问题
 * @Author SongWei
 * @Date 2020/4/26 9:24
 * @Version 1.0
 **/

/**
 *互斥： 同一时刻只有一个线程执行
 *
 * 临界区：一段需要互斥执行的代码称为临界区（上厕所）
 *
 * Java提供的锁技术：synchronized
 * 当修饰静态方法的时候，锁定的是当前Class对象
 * 当修饰非静态方法的时候，锁定的是当前实例对象this
 * 下面用synchronized解决base01的问题
 */

public class Basic03 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(calc());
    }

    private static long count = 0;

    synchronized long get() {
        return count;
    }

    synchronized void add() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Basic03 basic03 = new Basic03();
        //创建两个线程，执行add
        Thread th1 = new Thread(()->{
            basic03.add();
        });
        Thread th2 = new Thread(()->{
            basic03.add();
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
 *受保护资源和锁之间的关联关系是N:1的关系
 */
