package cn.project.service.lock;

import cn.project.cache.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyp
 * @date 2020/11/6 22:01
 */
@Component
public class LockServiceImpl implements LockService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean getLock(String lockId, long millisecond) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success != null && success;
    }

    @Override
    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }
}
