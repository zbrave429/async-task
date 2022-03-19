package cn.ygzhangmfh.util.task;

import cn.ygzhangmfh.util.task.support.DefaultThreadPool;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 11:20
 */
public class AsyncFactory {

    private static ThreadPoolExecutor EXECUTOR;

    private static AsyncConfig config;

    public static <V> FutureTask<V> submit(Callable<V> callable){
        return submit(callable, "");
    }

    public static <V> FutureTask<V> submit(Callable<V> callable, String taskName){

        if(EXECUTOR == null || config == null){
            throw new RuntimeException(" AsyncFactory is not init");
        }

        if (callable == null){
            throw new NullPointerException("callable is null");
        }

        AsyncFutureTask<V> asyncFutureTask = new AsyncFutureTask<>(callable, taskName);
        EXECUTOR.submit(asyncFutureTask);

        return asyncFutureTask;
    }

    public static <V> V get(FutureTask<V> task) throws ExecutionException, InterruptedException, TimeoutException {
        return get(task, 0);
    }

    public static <V> V get(FutureTask<V> task, int timeout) throws ExecutionException, InterruptedException, TimeoutException {

        if(task == null){
            return null;
        }

        if(timeout <= 0 && config.getTimeout() > 0){
            timeout = config.getTimeout();
        }

        if(timeout <= 0){
            return task.get();
        } else {
            return task.get(timeout, TimeUnit.SECONDS);
        }
    }

    public static void init(AsyncConfig asyncConfig){
        config = asyncConfig;
        EXECUTOR = DefaultThreadPool.threadPoolExecutor();
        if(config == null){
            config = new AsyncConfig();
        }
    }

    public static void init(){
        config = new AsyncConfig();
        EXECUTOR = DefaultThreadPool.threadPoolExecutor();
    }

    public static void destroy(){

        if(EXECUTOR != null && !EXECUTOR.isShutdown()){
            EXECUTOR.shutdown();
        }
    }

    public static AsyncConfig getConfig(){
        return config;
    }

}
