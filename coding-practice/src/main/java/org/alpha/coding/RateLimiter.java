package org.alpha.coding;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 限流算法
 *
 * 评测题目:实现一个本地滑动窗口流控算法，用于限制某一类请求（keys）在一段时间（duration）之内只能请求N次（times），
 * 保证线程安全
 * duration时间段N次内的请求接口返回true, 超出N次的请求返回false。
 * 样例输入:
 * "query", 20, 100000
 * "update", 10, 100
 * "insert", 10, 10000
 *
 * public boolean isLimit(String key, int duration, int times) {}
 *
 * @author liyazhou
 * @date   2020/7/7
 */

public class RateLimiter {

    private final Map<String, Long> counter = new ConcurrentHashMap<>();

    public boolean isLimit(String key, int duration, int times) {

        long currTimeSeconds = System.currentTimeMillis() / 1000;

        String k = key + "-" + currTimeSeconds;

        if (!counter.containsKey(k)) {
            counter.put(k, 1L);
        } else {
            counter.put(k, counter.get(k)+1);
        }

        // 删除超时的key，如果一个窗口很久没有请求，还是会造成内存泄漏问题，需要定时删除过期的entry
        counter.remove(key + '-' + (currTimeSeconds-duration-1));

        long cnt = 0;
        for (long i = currTimeSeconds-duration; i < currTimeSeconds; i ++) {
            String currKey = key + "-" + i;
            if (counter.containsKey(currKey)) {
                cnt += counter.get(currKey);
            }
        }

        return cnt > times;
    }
}