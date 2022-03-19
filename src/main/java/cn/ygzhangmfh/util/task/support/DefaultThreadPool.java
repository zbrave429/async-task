package cn.ygzhangmfh.util.task.support;

import cn.ygzhangmfh.util.task.AsyncFutureTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DefaultThreadPool
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 10:15
 */
public class DefaultThreadPool{

	private static final Logger logger = LoggerFactory.getLogger(AsyncFutureTask.class);

	public static ThreadPoolExecutor threadPoolExecutor(){

		int processors = Runtime.getRuntime().availableProcessors();

		int max = 5 * processors;
		long keepAliveTime = 3600L;
		int blockSize = 200;

		logger.info("ASYNC-TASK-POOL-THREAD init ：corePoolSize={},\nmaximumPoolSize={},\nkeepAliveTime={},\nblockSize={}"
				, processors ,max ,keepAliveTime , blockSize);
		
		return new ThreadPoolExecutor(
				processors, max, 3600L, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(200),
				new DefaultThreadFactory(),
				new DefaultPolicy());
	}

	public static class DefaultPolicy implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			logger.warn("queue full, " + executor.toString());
			if (!executor.isShutdown()) {
				r.run();
			}
		}
	}
}
