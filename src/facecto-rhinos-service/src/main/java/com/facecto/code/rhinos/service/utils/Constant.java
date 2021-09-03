package com.facecto.code.rhinos.service.utils;

/**
 * @author Jon So, https://cto.pub, https://github.com/facecto
 * @version v1.0.0 (2021/08/08)
 */
public class Constant {

    public static final int SUPER_ADMIN = 1;

    public static final String PAGE = "page";

    public static final String LIMIT = "limit";

    public static final String ORDER_FIELD = "sidx";

    public static final String ORDER = "mapper/order";

    public static final String ASC = "asc";


    public enum MenuType {

        CATALOG(0),

        MENU(1),

        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}