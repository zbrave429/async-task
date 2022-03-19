package cn.ygzhangmfh.util.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * AsyncFutureTask
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 11:04
 */
public class AsyncFutureTask<V> extends FutureTask<V> {

    private static final Logger logger = LoggerFactory.getLogger(AsyncFutureTask.class);

    private final String taskName;

    public AsyncFutureTask(Callable<V> callable, String taskName) {
        super(callable);
        this.taskName = taskName;
    }

    public AsyncFutureTask(Runnable runnable, V result, String taskName) {
        super(runnable, result);
        this.taskName = taskName;
    }

    @Override
    protected void done() {
        super.done();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        try{
            super.run();
        } finally {
            if (logger.isDebugEnabled()){
                logger.debug("task:{} run end, used time {} ms", taskName, (System.currentTimeMillis() - startTime));
            }
        }
    }
}
