package com.nvc.bookshop.pojo;

public class Address {
    private Integer id;
    private Integer user_id;
    private String area;
    private String province;
    private String city;
    private String email_code;
    private String receiver;
    private String tel;
    private boolean is_default;
    private String detail_address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail_code() {
        return email_code;
    }

    public void setEmail_code(String email_code) {
        this.email_code = email_code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", area='" + area + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", email_code='" + email_code + '\'' +
                ", receiver='" + receiver + '\'' +
                ", tel='" + tel + '\'' +
                ", is_default=" + is_default +
                ", detail_address='" + detail_address + '\'' +
                '}';
    }
}
