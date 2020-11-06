package cn.project.cache;

/**
 * @author chenyp
 * @date 2020/11/6 21:56
 */
public interface LockService {
    /**
     * 获取锁
     * @param lockId
     * @param millisecond
     * @return
     */
    boolean getLock(String lockId, long millisecond);

    /**
     * 释放锁
     * @param lockId
     */
    void releaseLock(String lockId);
}
