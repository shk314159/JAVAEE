package cn.edu.zjut.bean;

import org.springframework.beans.factory.InitializingBean;

public class ItemOrder implements IItemOrder, InitializingBean {
    private IItem item;
    private int numItems;
    public void init() {
        System.out.println("正在执行初始化方法 init...");
    }
    public void afterPropertiesSet() throws Exception {
        System.out.println("正在执行初始化方法 afterPropertiesSet...");
    }

    public void destory() {
        System.out.println("正在执行销毁方法 destory...");
    }

    public void incrementNumItems() {
        setNumItems(getNumItems() + 1);
    }

    public void cancelOrder() {
        setNumItems(0);
    }

    public double getTotalCost() {
        return (getNumItems() * item.getCost());
    }

    public IItem getItem() {
        return item;
    }

    public void setItem(IItem item) {
        this.item = item;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}
