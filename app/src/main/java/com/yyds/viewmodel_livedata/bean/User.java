package com.yyds.viewmodel_livedata.bean;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/9
 * Describe:
 */
public class User {
    private Integer id;
    private String userName;
    private String sex;
    private String age;
    private String address;
    private String personalNum;
    private String tel;

    public User(){}

    public User(Integer id, String userName, String sex, String age, String address, String personalNum, String tel) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.personalNum = personalNum;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(String personalNum) {
        this.personalNum = personalNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
