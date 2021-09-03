package com.facecto.code.rhinos.service.utils;

import com.facecto.code.base.CodeException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Jon So, https://cto.pub, https://github.com/facecto
 * @version v1.0.0 (2021/08/08)
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     *
     * @param str 待验证的字符串
     */
    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                throw new CodeException("包含非法字符");
            }
        }

        return str;
    }
}