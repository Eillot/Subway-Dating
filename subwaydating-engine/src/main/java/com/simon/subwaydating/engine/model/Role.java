package com.simon.subwaydating.engine.model;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/9 15:39
 * @File : Role
 * @Software: IntelliJ IDEA 2017.3.2
 */
public enum Role {

    ADMIN, MEMBER;

    public String authority(){
        return "ROLE_" + this.name();
    }

    @Override
    public String toString(){
        return this.name();
    }
}
