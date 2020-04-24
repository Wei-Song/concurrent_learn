/**
 * @ClassName Basic02
 * @Description
 * @Author SongWei
 * @Date 2020/4/22 14:33
 * @Version 1.0
 **/

/**
 *java内存模型规范了jvm如何提供按需禁用缓存和编译优化的方法
 * volatile, synchronized, final以及六项Happens-Before规则
 *
 *
 * volatile int x = 0 告诉编译器，对这个变量的读写不能使用cpu缓存，必须从内存中读取或写入
 *
 *
 * Happens-Before规则：前面一个操作的结果对后续操作是可见的
 * 1.程序的顺序性规则：在一个线程中，按照程序顺序，前面的操作Happens-Before于后续的任意操作
 * （程序前面对某个变量的修改一定是对后续操作可见的）
 *
 * 2.volatile变量规则：对一个volatile变量的写操作Happens-Before于后续对这个volatile变量的读操作
 *
 * 3.传递性：A Happens-Before B，B Happens-Before C，则A Happens-Before C （2和3合起来理解）
 *
 * 4.管程中锁的规则：对于一个锁的解锁Happens-Before于后续对这个锁的加锁
 * 管程是一种通用的同步用语，java中指的是synchronized
 *
 * 5.线程start()规则
 * 主线程A启动子线程B后，B可以看到主线程启动B前的操作
 *
 * 6.线程join()规则
 * 主线程A等待子线程B完成，B完成后，A能看到B的操作（对共享变量的操作）
 *
 *
 * final关键字
 * final修饰变量，初衷是告诉编译器：这个变量生而不变，可以可劲儿优化
 */
public class Basic02 {

    public static void main(String[] args) {

    }


}
