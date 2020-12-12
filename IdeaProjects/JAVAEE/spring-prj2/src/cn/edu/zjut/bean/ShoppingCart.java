package cn.edu.zjut.bean;
import java.util.*;
public class ShoppingCart {
    private Map<Integer, IItemOrder> itemsOrdered;
    public Map<Integer, IItemOrder> getItemsOrdered() {
        return (itemsOrdered);
    }
    public void setItemsOrdered(Map<Integer, IItemOrder> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }
}