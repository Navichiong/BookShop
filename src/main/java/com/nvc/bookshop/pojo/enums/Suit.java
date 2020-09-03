package com.nvc.bookshop.pojo.enums;

/**
 * 套装枚举
 */
public enum Suit {

    YES(1, "是"), NO(2, "否");

    private int code;
    private String desc;

    Suit(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Suit getSuitDescByCode(Integer code) {
        switch (code) {
            case 1:
                return YES;
            case 2:
                return NO;
            default:
                return NO;
        }
    }

    @Override
    public String toString() {
        return "Suit{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
