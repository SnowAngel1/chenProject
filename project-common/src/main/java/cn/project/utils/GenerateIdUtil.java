package cn.project.utils;

import java.util.UUID;

/**
 * @author cyp
 * @date 2020/8/4 10:03
 * ID生成类
 */
public class GenerateIdUtil {

    /**
     * 生成uuid方法
     * @return 返回uuid
     */
    public String getUuid32() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    /**
     * 生成uuid方法
     * @return 返回uuid
     */
    public String getUuid19() {
        return Numbers.uuid();
    }

    /**
     * 生成定长随机数
     * @param length
     * @return
     */
    public long buildRandom(int length) {
        long num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (long) ((random * num));
    }
}
