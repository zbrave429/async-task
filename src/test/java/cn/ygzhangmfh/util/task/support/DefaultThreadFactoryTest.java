package cn.ygzhangmfh.util.task.support;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 10:48
 */
public class DefaultThreadFactoryTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = DefaultThreadPool.threadPoolExecutor();

        List<FutureTask<Integer>> taskList = new ArrayList<>();
        for(int i = 0;i < 100; i++){
            int finalI = i;
            FutureTask<Integer> task = new FutureTask<>(() -> {
                System.out.println(Thread.currentThread().getName());
                return finalI;
            });
            taskList.add(task);
        }

        for(FutureTask<Integer> task: taskList){
            threadPoolExecutor.execute(task);
        }

        for(FutureTask<Integer> task: taskList){
            System.out.println(task.get());
        }
        threadPoolExecutor.shutdown();
    }
}
