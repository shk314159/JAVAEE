package com.mybatis.po;

public class Orders {
    private int id;
    private String ordersn;
    private int user_id;
    public String toString() {
        return "Orders [id=" + id + ",ordersn=" + ordersn + "]";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}