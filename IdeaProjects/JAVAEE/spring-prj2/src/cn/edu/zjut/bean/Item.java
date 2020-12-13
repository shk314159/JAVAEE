package cn.edu.zjut.bean;

public class Item implements IItem {
    private String itemID;
    private String title;
    private String description;
    private double cost;

    public Item(String itemID, String title,
                String description, double cost) {
        this.itemID = itemID;
        this.title = title;
        this.description = description;
        this.cost = cost;
        System.out.println("create Item.");
    }

    public Item(String s) {
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}