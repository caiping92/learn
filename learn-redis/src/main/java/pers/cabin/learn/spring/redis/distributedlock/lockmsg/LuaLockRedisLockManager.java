package pers.cabin.learn.spring.redis.distributedlock.lockmsg;

import org.springframework.stereotype.Component;
import pers.cabin.learn.spring.redis.distributedlock.lock.LuaDistributeLock;

import javax.annotation.PostConstruct;


@Component
public class LuaLockRedisLockManager extends SimpleRedisLockManager {
	@PostConstruct
	public void init(){
		// 初始化锁
		distributeLock = new LuaDistributeLock(redisTemplate, "mylock_", 5);
	}
}
