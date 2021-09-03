package com.facecto.code.rhinos.service.utils;

import com.facecto.code.base.CodeException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Jon So, https://cto.pub, https://github.com/facecto
 * @version v1.0.0 (2021/08/08)
 */
public class SQLFilter {


    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        str = str.toLowerCase();

        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                throw new CodeException("Contains illegal characters!");
            }
        }
        return str;
    }
}