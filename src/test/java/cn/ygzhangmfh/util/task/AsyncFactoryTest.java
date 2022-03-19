package cn.ygzhangmfh.util.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 14:48
 */
public class AsyncFactoryTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AsyncFactory.init(new AsyncConfig());

        FutureTask<String> task1 = AsyncFactory.submit(AsyncFactoryTest::method1);

        System.out.println(task1.get());

    }

    public static String method1(){
        return "hello";
    }


}
