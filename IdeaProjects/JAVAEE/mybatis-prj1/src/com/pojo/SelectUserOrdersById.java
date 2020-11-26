package com.pojo;

public class SelectUserOrdersById {
    private int uid;
    private String uname;
    private String usex;
    private int id;
    private String ordersn;

    public String toString(){
        return "User [uid=" + uid + ", uname=" + uname +
                ", usex=" + usex + ", oid=" + id + ", ordersn=" +ordersn+"]";
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

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }
}