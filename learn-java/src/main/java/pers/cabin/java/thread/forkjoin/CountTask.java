package pers.cabin.java.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 从开始连续相加的和
 * start+ ……+end
 *
 * @author caiping
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRES_HOLD = 2;
    /**
     * 开始值
     */
    private int start;
    /**
     * 结束值
     */
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRES_HOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
