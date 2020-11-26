package com.mybatis.po;

import java.util.List;

public class  MyUser {
    private int uid;
    private String uname;
    private  String usex;
    private List<Orders> ordersList;
    public MyUser(){}
    public MyUser(int uid, String uname, String usex){
        this.uid = uid;
        this.uname = uname;
        this.usex = usex;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }
    public String toString() {
        return (uid + " " + uname + " " + usex);
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
