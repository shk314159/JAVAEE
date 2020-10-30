package cn.edu.zjut.bean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List itemsOrdered;

    public ShoppingCart() {
        itemsOrdered = new ArrayList();
        Item item = new Item("book001", "JAVAEE 技术实验指导教程",
                "WEB 程序设计知识回顾、" + "轻量级 JAVAEE 应用框架、"
                        + "企业级 EJB 组件编程技术、" + "JAVAEE 综合应用开发.", 19.95);
        ItemOrder itemorder = new ItemOrder(item);
        itemorder.setNumItems(2);
        itemsOrdered.add(itemorder);
    }

    public List getItemsOrdered() {
        return (itemsOrdered);
    }

    public synchronized void addItem(String itemID) {
    }

    public synchronized void setNumOrdered(String itemID,
                                           int numOrdered) {
    }
}
