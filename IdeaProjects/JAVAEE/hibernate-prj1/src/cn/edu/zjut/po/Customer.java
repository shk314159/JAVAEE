package cn.edu.zjut.po;

import java.util.Date;

public class Customer implements java.io.Serializable {
    private int customerId;
    private String account;
    private String password;
    private String name;
    private int sex;
    private String birthday;
    private ContactInfo contactInfo;

    public Customer() {
    }

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public Customer(int customerId, String account, String password,
                    String name, int sex, String birthday, String phone,
                    String email, String address, String zipcode, String fax) {
        this.customerId = customerId;
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.contactInfo = new ContactInfo(phone, email, address, zipcode, fax);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}