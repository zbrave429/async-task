package cn.ygzhangmfh.util.task;

/**
 * 全局配置
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 11:58
 */
public class AsyncConfig {

    /**
     * 兜底超时时间 <=0 :无超时时间
     * 单位：秒
     */
    private int timeout;

    /**
     * 线程前缀
     */
    private String threadPrefix = "ASYNC-TASK-POOL-THREAD-";

    public AsyncConfig(int timeout, String threadPrefix) {
        this.timeout = timeout;
        this.threadPrefix = threadPrefix;
    }

    public AsyncConfig(int timeout) {
        this.timeout = timeout;
    }

    public AsyncConfig() {
    }

    public int getTimeout() {
        return timeout;
    }

    public AsyncConfig setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public String getThreadPrefix() {
        return threadPrefix;
    }

    public AsyncConfig setThreadPrefix(String threadPrefix) {
        this.threadPrefix = threadPrefix;
        return this;
    }
}
