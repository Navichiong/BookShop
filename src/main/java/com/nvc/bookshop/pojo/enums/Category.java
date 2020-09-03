package com.nvc.bookshop.pojo.enums;

/**
 * 图书类型枚举类
 */
public enum Category {

    SELECTED(1, "精选图书"), RECOMMEND(2, "推荐图书"), BARGAIN(3, "特价图书");
    private int code;
    private String desc;

    Category(int code, String desc) {
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

    public static Category getCategoryDescByCode(Integer code) {
        switch (code) {
            case 1:
                return SELECTED;
            case 2:
                return RECOMMEND;
            case 3:
                return BARGAIN;
            default:
                return SELECTED;
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
