package com.miaoshaproject.controller.viewobject;

public class UserVO {
    private Integer id;
    private String name;
    private Byte gener;
    private Integer age;
    private String telephone;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGener() {
        return gener;
    }

    public void setGener(Byte gener) {
        this.gener = gener;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
