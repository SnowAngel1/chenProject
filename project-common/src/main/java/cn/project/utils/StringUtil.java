package cn.project.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * @author cyp
 * @date 2020/8/1 16:25
 */
public class StringUtil {

    /**
     * 判断字符串是否不为空
     * @param str 要判断的字符串
     * @return 返回结果
     */
    public static Boolean isNotEmpty(String str){
        return StringUtils.isNotBlank(str);
    }

    public static String getRandom(int len) {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < len; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }
}
