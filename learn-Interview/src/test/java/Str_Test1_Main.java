import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Str_Test1_Main implements Runnable {

    private final Lock lock = new ReentrantLock();
    /**
     * 存放元素的队列
     */
    private Queue<String> queue;
    /**
     * 含有目标元素的记数器
     * 0 表示没有
     */
    private volatile int count = 0;
    /**
     * 队列中是否含有字符串
     */
    private String containAimSt;

    public Str_Test1_Main(Queue<String> queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {

        Queue<String> queue = new ConcurrentLinkedDeque<>();
        final int size =200000;
        //初始化测试数据
        for (int i=0;i<1500000;i++) {
            queue.offer("u51"+i);
        }
        for (int i=0;i<500000;i++) {
            queue.offer("51"+i);
        }
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str_resource = null;
        try {
            while (queue.size() < size) {
                System.out.println("请输入需要查找的源<还差" + (size - queue.size()) + " " +
                        "个字符串>：");
                str_resource = bufferedReader.readLine();
                queue.enqueque(str_resource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/
        Str_Test1_Main target = new Str_Test1_Main(queue);
        target.setContainAimSt("u51");

        //启动三个线程
        Thread t1 = new Thread(target);
        t1.start();
        Thread t2 = new Thread(target);
        t2.start();
        Thread t3 = new Thread(target);
        t3.start();

        while (true) { //三个线程执行完毕后 结束获取 总数，此处阻塞式，不用消息队列
            Thread.State t1State = t1.getState();
            Thread.State t2State = t2.getState();
            Thread.State t3State = t3.getState();
            if (t1State.compareTo(Thread.State.TERMINATED) == 0 && t2State.compareTo(Thread.State.TERMINATED) == 0 && t3State.compareTo(Thread.State.TERMINATED) == 0) {
                int count = target.getCount();
                System.out.println(count);
                break;
            }
        }
    }

    /**
     * 获取含有目标字符串的个数
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    public void setContainAimSt(String containAimSt) {
        this.containAimSt = containAimSt;
    }

    @Override
    public void run() {
        while (true) {
            if (queue != null && !(queue.isEmpty())) {  //队列中不为null 才进行 记数
                lock.lock();
                String result = queue.poll();
                if (result != null && result.indexOf(this.containAimSt) >= 0) {
                    this.count++;
                }
                lock.unlock();

                /*synchronized (this) {
                    String result = queue.poll();
                    if (result != null && result.indexOf(this.containAimSt) >= 0) {
                        this.count++;
                    }
                }*/

            } else {
                break;
            }
        }
    }
}